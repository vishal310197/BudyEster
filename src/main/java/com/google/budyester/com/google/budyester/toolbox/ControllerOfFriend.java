package com.google.budyester.com.google.budyester.toolbox;

import com.google.budyester.com.google.budyester.typo.InfoOfFriends;

/**
 * Created by Ideapad on 06-08-2017.
 */

public class ControllerOfFriend {

    public static InfoOfFriends[] friendsinfo = null;
    public static InfoOfFriends[] unapprovedfriends = null;
    public String activefriends;

    public static void setFriendsInfo(InfoOfFriends[] friends){
        ControllerOfFriend.friendsinfo = friends;
    }

    public static InfoOfFriends checkFriends(String username,String userkey){

        InfoOfFriends result = null;
        if(friendsinfo!=null){

            for(int i = 0;i<friendsinfo.length;i++)
            {
                if(friendsinfo[i].username.equals(username)&&friendsinfo[i].userkey.equals(userkey))
                {
                    result = friendsinfo[i];
                    break;
                }
            }
        }
        return result;
    }

    public static InfoOfFriends getFriendsLisr(String username)
    {
        InfoOfFriends result = null;
        if(friendsinfo!=null){

            for(int i = 0;i<friendsinfo.length;i++)
            {
                if(friendsinfo[i].username.equals(username))
                {
                    result = friendsinfo[i];
                    break;
                }
            }
        }
        return result;

    }
}
