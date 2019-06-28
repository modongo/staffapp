package com.staff.staffapp.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.staff.staffapp.R;


public class ChatActivity extends AppCompatActivity {

    private DatabaseReference myDatabase;
//    private Button mSendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        myDatabase = FirebaseDatabase.getInstance().getReference("Message");

        final TextView myText = findViewById(R.id.editText);

        myDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                myText.setText(dataSnapshot.getValue().toString());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                myText.setText("CANCELLED");

            }
        });



//        mSendButton = (Button) findViewById(R.id.sendButton);
//        mSendButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(ChatActivity.this, "Message Sent", Toast.LENGTH_LONG).show();
//
//            }
//        });
    }

    public void sendButton(View view) {
        EditText myEditText = findViewById(R.id.editText);
        myDatabase.push().setValue(myEditText.getText().toString());
        myEditText.setText("");
    }



}
