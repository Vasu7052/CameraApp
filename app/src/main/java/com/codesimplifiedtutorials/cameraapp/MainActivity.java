package com.codesimplifiedtutorials.cameraapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    Button btn,btn1;
    ImageView iv;
    VideoView vv;
    int camrequest=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.button);

        iv = (ImageView) findViewById(R.id.imageView);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(i,camrequest);


            }

        });


    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==camrequest && resultCode==RESULT_OK){


            Bundle camdata = (Bundle)data.getExtras();
           Bitmap mp =  (Bitmap)camdata.get("data");

            iv.setImageBitmap(mp);


        }

        else if(resultCode==RESULT_OK){

            Uri viddata = data.getData();

            vv.setVideoURI(viddata);



        }
    }
}
