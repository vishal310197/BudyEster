package com.google.budyester.com.google.budyester.toolbox;

import com.google.budyester.com.google.budyester.typo.InfoOfFriends;
import com.google.budyester.com.google.budyester.typo.InfoOfMessage;

/**
 * Created by Ideapad on 06-08-2017.
 */

public class ControllerOfMessage {

    public static final String taken = "taken";
    public static InfoOfMessage[] infoOfMessages = null;
    public static void setMessageInfo(InfoOfMessage[] infoOfMessages)
    {
       InfoOfMessage.infoOfMessages = infoOfMessages;

    }
    public static InfoOfMessage checkMessage(String username)
    {
        InfoOfMessage result = null;
        for(int i = 0;i<infoOfMessages.length;i++)
        {
            result = infoOfMessages[i];
            break;
        }
        return result;
    }
    public  static InfoOfMessage[] getMessage()
    {
        return  infoOfMessages;
    }
}
