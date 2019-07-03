package com.staff.staffapp.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.staff.staffapp.R;
import com.staff.staffapp.adapter.ChatListAdapter;
import com.staff.staffapp.adapter.ChatTabsAccessorAdapter;
import com.staff.staffapp.model.InstantMessage;


public class ChatActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private ViewPager myViewPager;
    private TabLayout myTabLayout;
    private ChatTabsAccessorAdapter mTabsAccessorAdapter;

    // Add member variables here:
    private String mDisplayName;
    private ListView mChatListView;
    private EditText mInputText;
    private ImageButton mSendButton;
    private DatabaseReference mDatabaseReference;
    private ChatListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);


        // TODO: List page header fragment

        mToolbar = findViewById(R.id.main_page_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Chat");

        myViewPager = findViewById(R.id.main_tabs_pager);
        mTabsAccessorAdapter = new ChatTabsAccessorAdapter(getSupportFragmentManager());
        myViewPager.setAdapter(mTabsAccessorAdapter);

        myTabLayout = findViewById(R.id.main_tabs);
        myTabLayout.setupWithViewPager(myViewPager);

        // Set up the display name and get the Firebase reference

        setupDisplayName();
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        UserInfo profile = user.getProviderData().get(0); // getting the first one bc this is a list
        String uid = profile.getUid();
        Log.d("StaffChat", "User id is: " + uid);

        // Link the Views in the layout to the Java code
        mInputText = findViewById(R.id.messageInput);
        mSendButton = findViewById(R.id.sendButton);
        mChatListView = findViewById(R.id.chat_list_view);

        //  Send the message when the "enter" button is pressed

        mInputText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                sendMessage();
                return true;
            }
        });


        // Add an OnClickListener to the sendButton to send a message

        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });

    }

    // Retrieve the display name from the Shared Preferences

    private void setupDisplayName() {

        SharedPreferences prefs = getSharedPreferences(ChatRegisterActivity.CHAT_PREFS, MODE_PRIVATE);

        mDisplayName = prefs.getString(ChatRegisterActivity.DISPLAY_NAME_KEY, null);

        if (mDisplayName == null) mDisplayName = "Anonymous";
    }


    private void sendMessage() {

        Log.d("StaffChat", "I sent something");

        //  Grab the text the user typed in and push the message to Firebase

        String input = mInputText.getText().toString();
        if (!input.equals("")) {
            InstantMessage chat = new InstantMessage(input, mDisplayName);
            mDatabaseReference.child("messages").push().setValue(chat);
            mInputText.setText("");
        }


    }

    //  Override the onStart() lifecycle method. Setup the adapter here.

    @Override
    public void onStart() {
        super.onStart();
        mAdapter = new ChatListAdapter(this, mDatabaseReference, mDisplayName);
        mChatListView.setAdapter(mAdapter);
    }


    @Override
    public void onStop() {
        super.onStop();

        // Remove the Firebase event listener on the adapter.

        mAdapter.cleanup();


    }

}
