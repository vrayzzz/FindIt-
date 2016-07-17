package com.example.vrayz.finalproject;

import android.app.Service;
import java.io.IOException;
import java.util.ArrayList;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.telephony.SmsManager;
import android.widget.Toast;
/**
 * Created by Vrayz on 24-04-2016.
 */

public class Myservice extends Service{

    LocationListener loc;
    LocationManager locMgr;
    Geocoder gc;
    ArrayList<Address> addressList;
    public static String coord;
    Location location;

    public static String addressString;
    public static double lati,longi;
    Intent intent;
    boolean isGPS,isNetwork;
    public static String provider;



    @Override
    public IBinder onBind(Intent arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub

        locMgr=(LocationManager)getSystemService(LOCATION_SERVICE);
        gc=new  Geocoder(getApplicationContext());
        addressList=new ArrayList<Address>();

        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO Auto-generated method stub

        isGPS=locMgr.isProviderEnabled(LocationManager.GPS_PROVIDER);
        isNetwork=locMgr.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

        loc=new LocationListener() {

            @Override
            public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
                // TODO Auto-generated method stub

            }
            @Override
            public void onProviderEnabled(String agr0) {
//
            }
            @Override
            public void onProviderDisabled(String arg0) {
              //commented by srishti  //Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
              // commented by srishti// startActivity(intent);
            }
            @Override
            public void onLocationChanged(Location location) {
                if(location !=  null)
                {
                    lati=location.getLatitude();
                    longi=location.getLongitude();
                    Toast.makeText(getApplicationContext(),"Lati: "+lati+"Longi: " +longi,Toast.LENGTH_LONG ).show();
                }
                SmsManager smsManager=SmsManager.getDefault();
                smsManager.sendTextMessage("9811978871", null , String.valueOf("lati : "+lati+" & Longi : "+longi), null , null);
            }

        };

        if(isGPS)
        {

            locMgr.requestLocationUpdates(LocationManager.GPS_PROVIDER,10000,0,loc);
            Toast.makeText(getApplicationContext(),"GPS Available !!!",Toast.LENGTH_LONG).show();
           // Toast.makeText(getApplicationContext(),"Lati: "+lati+"Longi: " +longi,Toast.LENGTH_LONG ).show();
        }
        else if(isNetwork)
        {
            Toast.makeText(getApplicationContext(),"NETWORK Available !!!",Toast.LENGTH_LONG).show();
            locMgr.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,10000,0,loc);
        }
        /*else
        {
            Toast.makeText(getApplicationContext(),"Neither GPS nor NETWORK Available !!!",Toast.LENGTH_LONG).show();
            Intent intent1 = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(intent1);
        }*///commented by srishti

        coord="Latitude: "+lati+" Longitude: "+longi;
       //srishti// Toast.makeText(getApplicationContext(), (int) lati,Toast.LENGTH_LONG).show();
        try {
            addressList=(ArrayList<Address>) gc.getFromLocation(lati, longi,1);

            if(addressList.size()>0)
            {
                Address a=addressList.get(0);

                for(int i=0;i<a.getMaxAddressLineIndex();i++)
                {
                    addressString+=a.getAddressLine(i);
                    Toast.makeText(getApplicationContext(),"Location"+ addressString, Toast.LENGTH_LONG).show();

                }
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();

        locMgr.removeUpdates(loc);
    }



}
