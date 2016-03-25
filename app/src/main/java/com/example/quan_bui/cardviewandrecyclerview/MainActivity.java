package com.example.quan_bui.cardviewandrecyclerview;

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

    //define SwipeLayout instance
    SwipeLayout swipeLayout;

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

        //setup swipeLayout
        swipeLayout = (SwipeLayout) findViewById(R.id.swipe);

        //set show mode
        swipeLayout.setShowMode(SwipeLayout.ShowMode.LayDown);

        //add drag edge
        swipeLayout.addDrag(SwipeLayout.DragEdge.Left, findViewById(R.id.bottom_wrapper));

        swipeLayout.addSwipeListener(new SwipeLayout.SwipeListener() {
            @Override
            public void onStartOpen(SwipeLayout layout) {

            }

            @Override
            public void onOpen(SwipeLayout layout) {
                //when the BottomView totally show
            }

            @Override
            public void onStartClose(SwipeLayout layout) {

            }

            @Override
            public void onClose(SwipeLayout layout) {
                //when the SurfaceView totally cover the BottomView
            }

            @Override
            public void onUpdate(SwipeLayout layout, int leftOffset, int topOffset) {
                //you are swiping
            }

            @Override
            public void onHandRelease(SwipeLayout layout, float xvel, float yvel) {
                //when user's hands released
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.cleanup();
    }
}
