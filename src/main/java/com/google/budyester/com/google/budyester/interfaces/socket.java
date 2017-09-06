package com.google.budyester.com.google.budyester.interfaces;

/**
 * Created by Ideapad on 06-08-2017.
 */

public interface socket {
    public String sendHTTPRequest(String Params);
    public int StartListening(int port);

    public void StopListening();
    public void exit();
}
