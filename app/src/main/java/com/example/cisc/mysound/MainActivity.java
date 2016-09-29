package com.example.cisc.mysound;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SoundPool soundPool;
    int sample1 = -1;
    int sample2 = -1;
    int sample3 = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC,0);
        try {
            //Create objects of the 2 required classes
            AssetManager assetManager = getAssets();
            AssetFileDescriptor descriptor;

            //Create our three fx in memory read for use
            descriptor = assetManager.openFd("Jump2.wav");
            sample1 = soundPool.load(descriptor, 0);

            descriptor = assetManager.openFd("Pickup_Coin2.wav");
            sample2 = soundPool.load(descriptor, 0);

            descriptor = assetManager.openFd("Powerup.wav");
            sample3 = soundPool.load(descriptor, 0);
        } catch (IOException e){
            // catch exception
            Log.e("ERROR: ", "There was an error");
        }

        Button oneButton = (Button)findViewById(R.id.oneButton);
        Button twoButton = (Button)findViewById(R.id.button2);
        Button threeButton = (Button)findViewById(R.id.threeButton);

        oneButton.setOnClickListener(this);
        twoButton.setOnClickListener(this);
        threeButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.oneButton:
                soundPool.play(sample1, 1, 1, 0,0,1);
                break;
            case R.id.button2:
                soundPool.play(sample2, 1,1,0,0,1);
                break;
            case R.id.threeButton:
                soundPool.play(sample3, 1,1,0,0,1);
                break;
        }

    }
}
