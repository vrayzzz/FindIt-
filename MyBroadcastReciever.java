package com.example.vrayz.finalproject;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.view.View;
import android.widget.Toast;



/**
 * Created by Vrayz on 22-07-2015.
 */
public class MyBroadcastReciever extends BroadcastReceiver {
    SmsMessage[] smsMessage;
    String modeChange;
    String pwd,phnno,senderNum,message;
    MediaPlayer mediaPlayer;
    String msg;
        @Override
        public void onReceive(Context context, Intent intent) {

            //Toast.makeText(context, "onReceive of BroadcastReceiver", Toast.LENGTH_SHORT).show();
            Bundle b = intent.getExtras();
            SharedPreferences sp=context.getSharedPreferences("users",Context.MODE_PRIVATE);
            pwd=sp.getString("password","1234");

            modeChange="general"+pwd;
            //Toast.makeText(context,modeChange+" ",Toast.LENGTH_SHORT).show();
            if(b!=null)
            {
                //Toast.makeText(context,"Enter In If Loop",Toast.LENGTH_SHORT).show();
                Object[] pdus=(Object[])b.get("pdus");
                smsMessage = new SmsMessage[pdus.length];
                for(int j=0;j<pdus.length; j++) {
                    SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pdus[j]);
                    phnno = smsMessage.getDisplayOriginatingAddress();
                    senderNum =phnno;
                    message=smsMessage.getDisplayMessageBody();
                   Toast.makeText(context,"Phone NO :"+senderNum+" message "+ message,Toast.LENGTH_SHORT).show();//Bilkul thik run hora h
                    if(message.equals(modeChange))
                    {
                        //thirdactivity third=new thirdactivity();
                        //Myservice myservice = new Myservice() ;
                       // double coord=myservice.get_coord(0);

                        //msg=Myservice.addressString;

                        SmsManager smsManager=SmsManager.getDefault();
                        smsManager.sendTextMessage(senderNum , null , "msg" , null , null);
                       //Toast.makeText(context,"Boadcast wala"+coord,Toast.LENGTH_LONG).show();//location not detected

                        AudioManager am=(AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
                        am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                        mediaPlayer = MediaPlayer.create(context,R.raw.song1);
                        mediaPlayer.start();
                        mediaPlayer.setVolume(1, 1);
                        //Toast.makeText(context,"RINGER MODE NORMAL", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        }

    }

