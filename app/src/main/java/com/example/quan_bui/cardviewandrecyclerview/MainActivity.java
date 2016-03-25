package com.example.quan_bui.cardviewandrecyclerview;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.daimajia.swipe.SwipeLayout;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.ui.FirebaseListAdapter;
import com.firebase.ui.FirebaseRecyclerAdapter;

public class MainActivity
    extends AppCompatActivity {

    Firebase mRef;
    FirebaseRecyclerAdapter<Task, TaskViewHolder> mFirebaseAdapter;
    TextView tvTitle;
    TextView tvDetails;

    private FloatingActionButton fabAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_main);

        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvDetails = (TextView) findViewById(R.id.tvDetails);

        RecyclerView rvList = (RecyclerView) findViewById(R.id.rvList);
        rvList.setHasFixedSize(true);

        mRef = new Firebase("https://cloud-note.firebaseio.com/");

        mFirebaseAdapter = new FirebaseRecyclerAdapter<Task, TaskViewHolder>(Task.class,
                                                                             R.layout.card_task_item,
                                                                             TaskViewHolder.class,
                                                                             mRef) {
            @Override
            protected void populateViewHolder(TaskViewHolder taskViewHolder, Task task, int i) {
                taskViewHolder.tvTitle.setText(task.getTitle());
                taskViewHolder.tvDetails.setText(task.getDetails());
            }
        };

        rvList.setAdapter(mFirebaseAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvList.setLayoutManager(layoutManager);

        fabAdd = (FloatingActionButton) findViewById(R.id.fabAdd);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddNewTaskActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.cleanup();
    }
}
