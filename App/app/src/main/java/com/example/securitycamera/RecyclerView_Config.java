package com.example.securitycamera;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.speech.SpeechRecognizer;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerView_Config {
    private Context mContext;

    private VisitorAdapter mVisitorAdapter;

    public void setConfig(RecyclerView recyclerView, Context context, List<Visitor> visitors, List<String> keys){
        mContext = context;
        mVisitorAdapter = new VisitorAdapter(visitors, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mVisitorAdapter);
    }

    class VisitorItemView extends RecyclerView.ViewHolder{
        private TextView mName;
        private TextView mTime;
        //private TextView mImg;

        private String key;

        public VisitorItemView(ViewGroup parent){
            super (LayoutInflater.from(mContext).inflate(R.layout.item_visitor, parent, false));

            mName = (TextView) itemView.findViewById(R.id.tvName);
            mTime = (TextView) itemView.findViewById(R.id.tvTime);
            //mImg = (TextView) itemView.findViewById(R.id.tvImg);
        }

        public void bind (Visitor visitor, String key){
            mName.setText(visitor.getName());
            mTime.setText(visitor.getTime());
            //mImg.setText(visitor.getImg());
            this.key = key;
            //addNotification();
        }
//        public void addNotification(){
//            NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
//                    .setSmallIcon(R.mipmap.logocam1_circ_round)
//                    .setContentTitle("hey boiii")
//                    .setContentText("this is a test notification");
//
//            Intent notificationIntent =new Intent(this, RecyclerView_Config.class);
//            PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
//            builder.setContentIntent(contentIntent);
//
//            NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//            manager.notify(0, builder.build());
//        }

    }

    class VisitorAdapter extends RecyclerView.Adapter<VisitorItemView>{
        private List<Visitor> mVisitorList;
        private List<String> mKeys;

        public VisitorAdapter(List<Visitor> mVisitorList, List<String> mKeys){
            this.mKeys = mKeys;
            this.mVisitorList = mVisitorList;
        }

        @NonNull
        @Override
        public VisitorItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new VisitorItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull VisitorItemView holder, int position) {
            holder.bind(mVisitorList.get(position), mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mVisitorList.size();
        }

    }
}
