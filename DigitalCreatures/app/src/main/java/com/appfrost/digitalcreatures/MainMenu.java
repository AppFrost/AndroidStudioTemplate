package com.appfrost.digitalcreatures;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.google.gson.Gson;
import java.util.StringTokenizer;
import java.util.Timer;
import java.util.TimerTask;

public class MainMenu extends Activity {
    Timer T;
    String preferences_name = "isFirstTime";
    Player player;
    TextView titleText;
    TextView secondaryTitleText;
    TextView startText;
    TextView bottomText1;
    int count1;
    int count2;

    public void allMonospace() {
        titleText            = (TextView) findViewById(R.id.titleText);
        secondaryTitleText   = (TextView) findViewById(R.id.secondaryTitleText);
        startText                = (TextView) findViewById(R.id.startText);
        bottomText1                = (TextView) findViewById(R.id.bottomText1);
        //Setting to MONOSPACE//////////////////////////////////////////////////////////////////////
        titleText.setTypeface(Typeface.MONOSPACE);
        secondaryTitleText.setTypeface(Typeface.MONOSPACE);
        startText.setTypeface(Typeface.MONOSPACE);
        bottomText1    .setTypeface(Typeface.MONOSPACE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main_menu);
        firstTime();
        allMonospace();
        count1 = 0;
        count2 = 0;
    }

    public void startButtonOnClick(View v){
        T.cancel();
        save();
        Intent i = new Intent(this, Home.class);
        i.putExtra("player", player);
        startActivity(i);
        finish();
    }


    public void toDevOnClick(View v){

        if (count1 == 8 && count2 == 8)
        {
//            T.cancel();
//            save();
//            Intent i = new Intent(this, Dev1.class);
//            i.putExtra("player", player);
//            //i.putExtra("playerObject", player);
//            startActivity(i);
//            finish();
        }
    }


    public void firstTime() {
        SharedPreferences sharedTime = getSharedPreferences(preferences_name, 0);
        if ( sharedTime.getBoolean("firstTime",true) )
        {
            player = new Player();
            sharedTime.edit().putBoolean("firstTime",false).apply();
            save();
        }
        else {
            getPlayerData();
        }
    }

    public void getPlayerData()
    {
        //SharedPreferences mPrefs = getPreferences(MODE_PRIVATE);
        SharedPreferences sharedPref = getSharedPreferences("playerinfo", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        //------------------------------------------------------------------------------------------
        int numECoins = sharedPref.getInt("numECoins", 0);
        //------------------------------------------------------------------------------------------
        String savedString = sharedPref.getString("cFiles", "");
        StringTokenizer st = new StringTokenizer(savedString, ",");
        int[] cFiles = new int[player.MAX_FILE_STORAGE_SIZE];
        for (int i = 0; i < player.MAX_FILE_STORAGE_SIZE; i++) {
            cFiles[i] = Integer.parseInt(st.nextToken());
        }
        //------------------------------------------------------------------------------------------

        ////////////////////////////////////////////////////////////////////////////////////////////

        player = new Player(numECoins,
                cFiles
        );
        save();
    }


    public void save()
    {
        SharedPreferences sharedPref = getSharedPreferences("playerinfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        Gson gson = new Gson();
        //------------------------------------------------------------------------------------------
        editor.putInt("numECoins", player.numECoins);
        //------------------------------------------------------------------------------------------
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < player.cFiles.length; i++) {
            str.append(player.cFiles[i]).append(",");
        }
        editor.putString("cFiles", str.toString());

        editor.apply();
    }

}
