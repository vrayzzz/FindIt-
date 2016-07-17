package com.example.vrayz.finalproject;
//prefs , activation , song->shared prefs files
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;




public class
        MainActivity extends Activity {
    //Button b1;
    ImageButton b1;
    Boolean act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences sp=getSharedPreferences("prefs",MODE_PRIVATE);
        SharedPreferences.Editor speditor=sp.edit();
        Boolean earlier_activation =sp.getBoolean("activate",false);
        // Toast.makeText(getApplicationContext(),"Earlier Activation was : " +earlier_activation+ act, Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);

        setContentView(R.layout.firstscreen);
        b1=(ImageButton)findViewById(R.id.imageButton);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), secondactivity.class));
            }
        });

        // speditor.putBoolean("activate", true);
        // speditor.commit();
        act=sp.getBoolean("activate",false);
        //Toast.makeText(getApplicationContext(), "Key saved " + act, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
