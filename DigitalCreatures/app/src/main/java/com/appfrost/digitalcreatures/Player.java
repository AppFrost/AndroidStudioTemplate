package com.appfrost.digitalcreatures;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

//Created by Lance on 7/05/2018.
public class Player implements Serializable  {
    int numECoins;
    int [] cFiles;
    public static final int MAX_FILE_STORAGE_SIZE = 128;

    Player()
    {
        defaultCreate();
    }

    public void defaultCreate(){
        numECoins = 0;
        cFiles = new int[MAX_FILE_STORAGE_SIZE];
        Arrays.fill(cFiles, 0);
    }

    public void reset() {
        //numResets++;
        defaultCreate();
    }

    Player(int numECoins,
           int cFiles []
    )
    {
        this.numECoins = numECoins;
        this.cFiles = new int[MAX_FILE_STORAGE_SIZE];
        for ( int i = 0; i < cFiles.length; i++) {
            this.cFiles[i] = cFiles[i];
        }

    }

}

