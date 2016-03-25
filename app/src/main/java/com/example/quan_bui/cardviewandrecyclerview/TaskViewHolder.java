package com.example.quan_bui.cardviewandrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Quan Bui on 3/25/16.
 */
public class TaskViewHolder
    extends RecyclerView.ViewHolder {

    TextView tvTitle;
    TextView tvDetails;
    ImageButton imgBtnDelete;

    public TaskViewHolder(View itemView) {
        super(itemView);
        tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
        tvDetails = (TextView) itemView.findViewById(R.id.tvDetails);

        imgBtnDelete = (ImageButton) itemView.findViewById(R.id.imgBtnDelete);

        imgBtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Delete", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

