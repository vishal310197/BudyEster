package com.google.budyester;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread Mythread = new Thread(){

            @Override
            public void run(){
                try {
                    sleep(6000);
                    Intent intent = new Intent(getApplicationContext(),Login.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Mythread.start();

    }
}
