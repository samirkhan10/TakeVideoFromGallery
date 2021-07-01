package com.example.takevideofg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity
{
    VideoView gallery;
    Button selectfromgallery;
    MediaController mc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gallery=findViewById(R.id.gallery);
        selectfromgallery=findViewById(R.id.selectfromgallerybutton);
        mc= new MediaController(RegisterActivity.this);
        gallery.setMediaController(mc);

        selectfromgallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_PICK);
                intent.setType("video/");
                startActivityForResult(intent,1);
            }
        }  );


    }

    public void onActivityResult(int requestcode, int resultcode, Intent data){
        super.onActivityResult(requestcode,resultcode,data);
        if (requestcode == 1){
            Uri uri=data.getData();
            gallery.setVideoURI(uri);
            gallery.start();
        }

    }

    public void signuphere(View view) {

    }
}