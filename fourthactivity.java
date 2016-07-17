package com.example.vrayz.finalproject;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Vrayz on 25-07-2015.
 */
public class fourthactivity extends Activity {
    //Toast.makeText(context,"Fourth Activity started : ", Toast.LENGTH_SHORT).show();

    EditText edt4,edt5;
    Button b1;
    String oldshared ,latestshared,newpass,oldpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences sp=getSharedPreferences("users",MODE_PRIVATE);
        SharedPreferences.Editor speditor=sp.edit();
        Toast.makeText(getApplicationContext(),"Fourth Activity started : ", Toast.LENGTH_SHORT).show();
        b1=(Button)findViewById(R.id.button);
        oldshared=sp.getString("password",null);

        edt5=(EditText)findViewById(R.id.editText5);
        edt4=(EditText)findViewById(R.id.editText4);
        oldpass=edt4.getText().toString();
        newpass=edt5.getText().toString();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(oldpass.equals(oldshared)) {
                    SharedPreferences sp=getSharedPreferences("users",MODE_PRIVATE);
                    SharedPreferences.Editor speditor=sp.edit();
                    speditor.putString("password",newpass);
                    Toast.makeText(getApplicationContext(),"new pass saved i.e. : "+newpass,Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getApplicationContext(),"old pass is wrong"+newpass,Toast.LENGTH_SHORT).show();

            }
        });

        super.onCreate(savedInstanceState);
    }
}
