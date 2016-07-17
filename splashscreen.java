package com.example.vrayz.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by Vrayz on 25-07-2015.
 */
public class splashscreen extends Activity  {
    ImageButton imageButton;
    Boolean earlier_activation;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.splashwindow);
        sp=getSharedPreferences("activate",MODE_PRIVATE);
        SharedPreferences.Editor speditor=sp.edit();
        earlier_activation =sp.getBoolean("activate",false);
       // Toast.makeText(this, "Activate -> "+earlier_activation, Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);
        String act="" , deact;
        //final Intent i=new Intent(getApplicationContext(),MainActivity.class);

        new Thread(new Runnable(){
            @Override
            public void run()
            {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                /*earlier_activation =sp.getBoolean("activate",false);
                Toast.makeText(getApplicationContext(),earlier_activation+"",Toast.LENGTH_SHORT).show();*/
               /* if(earlier_activation=true)
                    startActivity(new Intent(getApplicationContext(),thirdactivity.class));
                else
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));*/

            }

        }).start();
    }
}

