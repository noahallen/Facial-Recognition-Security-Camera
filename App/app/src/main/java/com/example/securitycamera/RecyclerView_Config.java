package com.example.securitycamera;

import android.content.Context;
import android.speech.SpeechRecognizer;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
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

        private String key;

        public VisitorItemView(ViewGroup parent){
            super (LayoutInflater.from(mContext).inflate(R.layout.item_visitor, parent, false));

            mName = (TextView) itemView.findViewById(R.id.tvName);
            mTime = (TextView) itemView.findViewById(R.id.tvTime);
        }

        public void bind (Visitor visitor, String key){
            mName.setText(visitor.getName());
            mTime.setText(visitor.getTime());
            this.key = key;
        }
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
