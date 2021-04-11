package com.example.securitycamera;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper{
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceVisitior;
    private List<Visitor> visitors = new ArrayList<>();

    public interface DataStatus {
        void DataIsLoaded(List<Visitor> visitors, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public FirebaseDatabaseHelper() {
        mDatabase = FirebaseDatabase.getInstance();
        mReferenceVisitior = mDatabase.getReference("visitors"); //firebase database name (visitors)
    }


    public void readVisitor(final DataStatus dataStatus){

        mReferenceVisitior.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                visitors.clear();
                List<String> keys = new ArrayList<>();
                for (DataSnapshot keyNode : dataSnapshot.getChildren()) {
                    keys.add(keyNode.getKey());
                    Visitor visitor = keyNode.getValue(Visitor.class);
                    visitors.add(visitor);
                }
                dataStatus.DataIsLoaded(visitors, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error){

            }

        });
    }


}
