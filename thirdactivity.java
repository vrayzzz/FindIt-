package com.example.vrayz.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Vrayz on 22-07-2015.
 */
public class thirdactivity extends Activity  {
    Button b1,b2;
   // TextView pc;
    //TextView tv7,tv8;
    Spinner spinner;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.thirdscreen);
        super.onCreate(savedInstanceState);
        b1=(Button)findViewById(R.id.button2);
        b2=(Button)findViewById(R.id.button3);

       /* pc=(TextView)findViewById(R.id.textView6);
        spinner=(Spinner)findViewById(R.id.spinner);*/
       // ArrayAdapter arrayAdapter=ArrayAdapter.createFromResource(this,R.array.songslist,android.R.layout.simple_spinner_item);
//        spinner.setAdapter(arrayAdapter);6
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "service started", Toast.LENGTH_SHORT).show();
                startService(new Intent(getApplicationContext(), BackgroundService.class));//error
                startService(new Intent(getApplicationContext(),Myservice.class));//gps location
                BackgroundService bs=new BackgroundService();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"service stopped" , Toast.LENGTH_SHORT).show();
                stopService(new Intent(getApplicationContext(), BackgroundService.class));
                stopService(new Intent(getApplicationContext(), Myservice.class));
            }
        });

        /*b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Myservice.class);
                i.getExtras("user");

            }
        });*///srishti

    }

        /*pc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), fourthactivity.class));
            }
        });*/
       /* tv7= (TextView) findViewById(R.id.textView7);
        tv8= (TextView) findViewById(R.id.textView8);
        tv8.setVisibility(View.INVISIBLE);
        tv7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp=getSharedPreferences("users",MODE_PRIVATE);
                String pass=sp.getString("password","");
                tv8.setVisibility(View.VISIBLE);
                tv8.setText(pass);

            }
        });
        tv8.setVisibility(View.INVISIBLE);*/

    }

    /*@Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        SharedPreferences sp=getSharedPreferences("song",MODE_PRIVATE);
        SharedPreferences.Editor speditor=sp.edit();
        TextView text=(TextView) view;
        switch (i)

      {
          case 1:
              speditor.putInt("song",1);
              Toast.makeText(getApplicationContext(),text.getText()+"",Toast.LENGTH_SHORT).show();
             // mediaPlayer = MediaPlayer.create(this,R.raw.song1);
              mediaPlayer.start();
              mediaPlayer.setVolume(1,1);
              break;
          case 2:
              //mediaPlayer.stop();
              speditor.putInt("song",2);
              Toast.makeText(getApplicationContext(),text.getText()+"",Toast.LENGTH_SHORT).show();
              mediaPlayer = MediaPlayer.create(this,R.raw.song2);
              mediaPlayer.start();
              mediaPlayer.setVolume(1,1);
              break;
          case 3:
              //mediaPlayer.stop();
              speditor.putInt("song",3);
              Toast.makeText(getApplicationContext(),text.getText()+"",Toast.LENGTH_SHORT).show();
              mediaPlayer = MediaPlayer.create(this,R.raw.song3);
              mediaPlayer.start();
              mediaPlayer.setVolume(1,1);
              break;
          case 4:
              //mediaPlayer.stop();
              Toast.makeText(getApplicationContext(),text.getText()+"",Toast.LENGTH_SHORT).show();
              speditor.putInt("song",4);
              mediaPlayer = MediaPlayer.create(this,R.raw.song4);
              mediaPlayer.start();
              mediaPlayer.setVolume(1,1);
              break;
      }
    }*/

    /*@Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }*/
