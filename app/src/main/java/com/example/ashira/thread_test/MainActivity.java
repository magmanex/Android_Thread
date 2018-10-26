package com.example.ashira.thread_test;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    TextView tvYourText;
    ImageView img_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        tvYourText = findViewById(R.id.tv_text);
        img_view = findViewById(R.id.imageView);
    }

    public void onClick(View view) {
        //tvYourText.setText("Loading...");
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                URL url = null;
//                try {
//                    url = new URL("https://www.yogajournal.com/.image/c_limit%2Ccs_srgb%2Cfl_progressive%2Cq_auto:good%2Cw_800/MTQ2MTgwNzE5NDUzNTQ2MDE2/goddess-kali.jpg");
//                } catch (MalformedURLException e) {
//                    e.printStackTrace();
//                }
//
//                Bitmap bmp = null;
//                try {
//                    bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
//
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//                final Bitmap tmp = bmp;
//
//                img_view.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        img_view.setImageBitmap(tmp);
//                    }
//                });
//
//            }
//        }).start();













        //tvYourText.setText("Loaded");

        tvYourText.setText("Loading...");
        URL url = null;
        try {
            url = new URL("https://www.yogajournal.com/.image/c_limit%2Ccs_srgb%2Cfl_progressive%2Cq_auto:good%2Cw_800/MTQ2MTgwNzE5NDUzNTQ2MDE2/goddess-kali.jpg");
            url.openConnection();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeStream(url.openStream());
            img_view.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }
        tvYourText.setText("Loaded");
    }
}
