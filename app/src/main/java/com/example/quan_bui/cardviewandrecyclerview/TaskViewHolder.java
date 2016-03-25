package com.example.quan_bui.cardviewandrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

/**
 * Created by Quan Bui on 3/25/16.
 */
public class TaskViewHolder
    extends RecyclerView.ViewHolder {

    Firebase mRef;
    TextView tvTitle;
    TextView tvDetails;

    public TaskViewHolder(View itemView) {
        super(itemView);

        Firebase.setAndroidContext(itemView.getContext());
        mRef = new Firebase("https://cloud-note.firebaseio.com");

        tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
        tvDetails = (TextView) itemView.findViewById(R.id.tvDetails);
    }
}

