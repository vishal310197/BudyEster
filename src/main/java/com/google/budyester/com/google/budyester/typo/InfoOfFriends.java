package com.google.budyester.com.google.budyester.typo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.budyester.R;

public class InfoOfFriends extends AppCompatActivity {

    public static final String friend_list = "friends_list";
    public static String username = "username";
    public static String status = "status" ;
    public static String port = "port";
    public static final String Ip = "Ip";
    public static final String userkey = "userkey";
    public static final String message = "message";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_of_friends);
    }
}
