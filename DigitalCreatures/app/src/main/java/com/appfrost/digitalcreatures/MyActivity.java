package com.appfrost.digitalcreatures;
import android.app.Activity;import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;import android.view.Window;
import android.widget.TextView;
import com.google.gson.Gson;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class MyActivity extends Activity {
    Timer AllTimer;
    Timer AllTimer2;
    Player player;
    boolean isPaused;
    TextView saveText;
    TextView numCoinsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Intent i = getIntent();
        player = (Player)i.getSerializableExtra("player");
        isPaused = false;

        AllTimer=new Timer();
        AllTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run()
                    {

                    }
                });
            }
        }, 1000, 1000);

        AllTimer2=new Timer();
        AllTimer2.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run()
                    {

                    }
                });
            }
        }, 1000, 1000);

    }

    public void saveOnClick(View v){
        save();
        saveText.setText("Saving...");
        saveText.setTextColor(0xFF000000);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                saveText.setText("Save");
                saveText.setTextColor(0xFF0000EE);//blue
            }
        }, 1000);
    }

    @Override
    public void onPause(){
        super.onPause();
        isPaused = true;
    }

    @Override
    public void onResume(){
        super.onResume();
        isPaused = false;
    }

    public void save()
    {

    }
}
