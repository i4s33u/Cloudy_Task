package com.example.quan_bui.cardviewandrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Quan Bui on 3/25/16.
 */
public class TaskViewHolder extends RecyclerView.ViewHolder {
    TextView tvTitle;
    TextView tvDetails;

    public TaskViewHolder(View itemView) {
        super(itemView);
        tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
        tvDetails = (TextView) itemView.findViewById(R.id.tvDetails);
    }
}
