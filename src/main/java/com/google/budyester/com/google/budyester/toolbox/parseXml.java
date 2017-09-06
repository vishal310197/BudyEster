package com.google.budyester.com.google.budyester.toolbox;



import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.ext.DefaultHandler2;
import org.xml.sax.helpers.DefaultHandler;
import com.google.budyester.com.google.budyester.interfaces.updater;
import com.google.budyester.*;
import com.google.budyester.com.google.budyester.typo.InfoOfFriends;
import com.google.budyester.com.google.budyester.typo.InfoOfMessage;
import com.google.budyester.com.google.budyester.typo.InfoOfStatus;

import java.util.Vector;

/**
 * Created by Ideapad on 06-08-2017.
 */

public class parseXml extends DefaultHandler {

    public String userkey = new String();
public updater Updater;

    public parseXml(updater Updater){

        this.Updater = Updater;
    }

    //vectors to store information

    private Vector<InfoOfFriends> mFriends = new Vector<InfoOfFriends>();
    private Vector<InfoOfFriends> mOnlineFriends = new Vector<InfoOfFriends>();
    private Vector<InfoOfFriends> mUnapprovedFriends = new Vector<InfoOfFriends>();

    private Vector<updater> munreadmessages = new Vector<updater>();



    public void endDocument() throws SAXException{

        InfoOfFriends[] friends = new InfoOfFriends[mFriends.size() + mOnlineFriends.size()];
        updater[] messages = new updater[munreadmessages.size()];

        int onlineFriendCount = mOnlineFriends.size();
        for(int i=0; i<onlineFriendCount; i++)

        {

            friends[i] = mOnlineFriends.get(i);
        }

        int unApprovedFriendCount = mUnapprovedFriends.size();
        InfoOfFriends[] unApprovedFriends = new InfoOfFriends[unApprovedFriendCount];
        for(int i = 0;i<unApprovedFriends.length;i++)
        {
            unApprovedFriends[i] = mUnapprovedFriends.get(i);
        }

        int unreadMessageCount = munreadmessages.size();
        for(int i=0;i<unreadMessageCount;i++)
        {
            messages[i] = munreadmessages.get(i);
            Log.i("Message LOG","i=" +i);
        }

        this.Updater.updateData((InfoOfMessage[]) messages,friends,unApprovedFriends,userkey);
        super.endDocument();
    }



    public void startElement(String url, String localName, String name, Attributes attributes) throws SAXException
    {
        if(localName == "friend")
        {
            InfoOfFriends friend = new InfoOfFriends();
            friend.username = attributes.getValue(InfoOfFriends.username);
            String status = attributes.getValue(String.valueOf(InfoOfFriends.status));
            friend.port = attributes.getValue(InfoOfFriends.port);

            //friend.expire = attributesd.getValue("expire")


            if(status!=null && status.equals("online"))
            {
                friend.status = String.valueOf(InfoOfStatus.ONLINE);

                mOnlineFriends.add(friend);
            }
            else{
                friend.status = String.valueOf(InfoOfStatus.OFFLINE);
                mFriends.add(friend);
            }

         }
         else if(localName == "user"){

            this.userkey = attributes.getValue(InfoOfFriends.userkey);
            super.startElement(url,localName,name,attributes);

        }
    }

    @Override
    public void startDocument() throws SAXException{
        this.mFriends.clone();
        this.mOnlineFriends.clone();
        this.munreadmessages.clone();
        super.startDocument();
    }
}
