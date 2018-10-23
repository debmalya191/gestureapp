package com.example.mahe.gestureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.nisrulz.sensey.Sensey;
import com.github.nisrulz.sensey.ShakeDetector;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Sensey.getInstance().init(this);

        ShakeDetector.ShakeListener shakeListener=new ShakeDetector.ShakeListener() {
            @Override public void onShakeDetected() {
                // Shake detected, do something
                Intent myIntent = new Intent(MainActivity.this, message.class);
                //myIntent.putExtra("key", value); //Optional parameters
                MainActivity.this.startActivity(myIntent);
            }

            @Override public void onShakeStopped() {
                // Shake stopped, do something
            }
        };


        Sensey.getInstance().startShakeDetection(shakeListener);

        Sensey.getInstance().stopShakeDetection(shakeListener);


    }
    public void onDestroy() {

        super.onDestroy();
        Sensey.getInstance().stop();

    }
}
