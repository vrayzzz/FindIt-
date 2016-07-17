package com.example.vrayz.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Vrayz on 22-07-2015.
 */
public class secondactivity extends Activity {
    boolean act;
    Button b1,b2;
    EditText ed1,ed2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondscreen);
        ed1=(EditText)findViewById(R.id.editText);
        ed2=(EditText)findViewById(R.id.editText2);
        TextView tv12=(TextView)findViewById(R.id.textView12);

        //b1=login
        b1= (Button) findViewById(R.id.signin);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=ed1.getText().toString();
                String p=ed2.getText().toString();

               //Toast.makeText(getApplicationContext(), "EditText -> " + n + " " + p, Toast.LENGTH_SHORT).show();

               SharedPreferences spp=getSharedPreferences("users", MODE_PRIVATE);
                String name=spp.getString("username","");
                String password=spp.getString("password","");

                //Toast.makeText(getApplicationContext(),"sp.getString-> "+name+" "+password,Toast.LENGTH_SHORT).show();

                if(n!=null && p!=null && name.equals(n) && password.equals(p))
                {
                    Toast.makeText(getApplicationContext(),"Logged in Succesfully",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), thirdactivity.class));


                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Wrong Username & Password ",Toast.LENGTH_SHORT).show();
                }
            }
        });
        tv12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.forgetpas);

            }
        });


        //b2=signup
        b2= (Button) findViewById(R.id.signup);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=ed1.getText().toString();
                String p=ed2.getText().toString();
                SharedPreferences sp=getSharedPreferences("users", MODE_PRIVATE);
                SharedPreferences.Editor speditor=sp.edit();
                speditor.putString("username", n);
                speditor.putString("password", p);
                speditor.commit();
               // Toast.makeText(getApplicationContext(),"Values Entered ",Toast.LENGTH_SHORT).show();
            }
        });
        SharedPreferences sp=getSharedPreferences("prefs",MODE_PRIVATE);
        act=sp.getBoolean("activate",false);
        //Toast.makeText(getApplicationContext(),""+act,Toast.LENGTH_SHORT).show();
    }

}
