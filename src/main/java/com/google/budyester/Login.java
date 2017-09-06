package com.google.budyester;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.service.carrier.CarrierMessagingService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.budyester.com.google.budyester.interfaces.manager;
import com.google.budyester.com.google.budyester.serve.MessagingService;

public class Login extends AppCompatActivity {

    public static final  int CONNECTED_TO_SERVICE = 0;
    public static final  int FILL_BOTH_USERNAME_PASSWORD = 1;
    public static final  String AUTHENTICATION_FAILED = "failed";
    public static final  String FRIEND_LIST = "friend_list";
    public static final  int MAKE_SURE_USERNAME_PASSWORD = 2;
    public static final  int CONNECTED_TO_NETWORK = 3;
    public EditText username;
    public EditText password;

    public manager serviceProvider;

    public static final int SIGN_UP = Menu.FIRST;
    public static final int EXIT = Menu.FIRST + 1;


    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            serviceProvider = ((MessagingService.IMBinder)service).getService();
            if(serviceProvider.isUserAuthenticated()==true)
            {
                Intent i = new Intent(Login.this,FriendList.class);
                startActivity(i);
                Login.this.finish();
            }

        }


        @Override
        public void onServiceDisconnected(ComponentName name) {

            serviceProvider = null;
            Toast.makeText(Login.this,R.string.local_service_stopped,Toast.LENGTH_SHORT).show();

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void signup(View view) {
        Intent i = new Intent(this,Signup.class);
        startActivity(i);

    }
}
