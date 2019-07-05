package com.staff.staffapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.github.abdularis.civ.AvatarImageView;
import com.staff.staffapp.R;
import com.staff.staffapp.databinding.ActivityListBinding;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityListBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_list);
        binding.setMyName("Mikey");
        binding.setBgColor(Color.BLUE);
    }
    public void onCircleImageClick(View view){
        Toast.makeText(this,"Hi Mykii",Toast.LENGTH_SHORT).show();
        Intent group = new Intent(this, ChatActivity.class);
        startActivity(group);
    }
    public void onAClick(View view){
        AvatarImageView a = (AvatarImageView) view;
        if(a.getState() == AvatarImageView.SHOW_INITIAL){
            a.setState(AvatarImageView.SHOW_IMAGE);
        }else {
            a.setState(AvatarImageView.SHOW_IMAGE);
        }

    }

    public void onGotoListSampleClick(View view){
        //Modified
        Intent i = new Intent(this, ChatJoinActivity.class);
        startActivity(i);
    }
}
