package com.google.budyester.com.google.budyester.interfaces;

import java.io.UnsupportedEncodingException;

/**
 * Created by Ideapad on 06-08-2017.
 */

public interface manager {

    public String getusername();
    public String SendMessage(String username,String tousername,String message) throws UnsupportedEncodingException;
    public String AuthenticateUser(String usernameText,String passwordText) throws UnsupportedEncodingException;
    public void messageRecieved(String username,String message);
    public boolean isNetworkConnected();
    public boolean isUserAuthenticated();
    public String getLastRawFriendList();
    public void exit();
    public String signUpUser(String usernameText,String passwordText,String email);
    public String addNewFriendRequest(String friendUsername);
    public String sendFriendRequest(String friendusername);
    public String sendFriendRequestResponse(String approvedfriendname,String discardedfriendname);



}


