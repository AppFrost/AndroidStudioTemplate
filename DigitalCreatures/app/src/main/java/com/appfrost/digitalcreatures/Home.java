package com.appfrost.digitalcreatures;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.io.Serializable;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Home extends MyActivity implements Serializable {
    Timer T;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent i = getIntent(); // don't think I need.
        player = (Player)i.getSerializableExtra("player");


        T=new Timer();
        T.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }
        }, 1000, 1000);
    }



    public void stopTimer() {T.cancel();}
    public void back() {
        stopTimer();
        save();
        Intent i = new Intent(this, MainMenu.class);
        i.putExtra("player", player);
        //i.putExtra("playerObject", player);
        startActivity(i);
        finish();
    }
    @Override
    public void onBackPressed() {
        back();
    }
}
