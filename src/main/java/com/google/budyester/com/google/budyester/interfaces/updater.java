package com.google.budyester.com.google.budyester.interfaces;

import com.google.budyester.com.google.budyester.typo.InfoOfFriends;
import com.google.budyester.com.google.budyester.typo.InfoOfMessage;

/**
 * Created by Ideapad on 06-08-2017.
 */

public interface updater {

    public void updateData(InfoOfMessage[] message, InfoOfFriends unApprovedFriends,String userkey);

    void updateData(InfoOfMessage[] messages, InfoOfFriends[] friends, InfoOfFriends[] unApprovedFriends, String userkey);
}

//import classses which giving errors