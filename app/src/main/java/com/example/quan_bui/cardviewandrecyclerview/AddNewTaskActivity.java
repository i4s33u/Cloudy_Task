package com.example.quan_bui.cardviewandrecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.firebase.client.Firebase;

public class AddNewTaskActivity
    extends AppCompatActivity {

    private EditText edtTitle;
    private EditText edtDetails;
    private Button btnCreate;
    private Firebase mFirebaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        Firebase.setAndroidContext(this);

        mFirebaseRef = new Firebase("https://cloud-note.firebaseio.com");

        edtTitle = (EditText) findViewById(R.id.edit_title);
        edtDetails = (EditText) findViewById(R.id.edit_details);
        btnCreate = (Button) findViewById(R.id.btnCreate);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Task newTask =
                    new Task(edtTitle.getText().toString(), edtDetails.getText().toString());
                mFirebaseRef.push().setValue(newTask);

                Intent intent = new Intent(AddNewTaskActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}
