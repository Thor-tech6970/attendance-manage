package com.example.myattendancemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int mPresent = 0;

    int mTotal = 0;

    TextView mscoreTextView , mPercentageTextView;

    SharedPreferences sharedPreferences;



    public void mPresent(View view){

        mPresent++;
        mTotal++;

        mscoreTextView.setText(mPresent + "/" + mTotal);

        float percentage = ((float)mPresent/ (float)mTotal)*100;

        String finalPercentage =  String.format("%.2f" , percentage);

        mPercentageTextView.setText(finalPercentage+"%");

        save();
    }

    public  void mAbsent(View view){

        mTotal++;

        mscoreTextView.setText(mPresent+"/"+mTotal);

        float percentage = ((float)mPresent/ (float)mTotal)*100;

        String finalPercentage =  String.format("%.2f" , percentage);

        mPercentageTextView.setText(finalPercentage+"%");

        save();
    }




    public  void reset(View view){

        mTotal = 0;

        mPresent = 0 ;

        mscoreTextView.setText(mPresent+"/"+mTotal);

        float percentage = ((float)mPresent/ (float)mTotal)*100;

        String finalPercentage =  String.format("%.2f" , percentage);

        mPercentageTextView.setText(finalPercentage+"%");

        save();





    }

    public void save(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("mTotal",mTotal);
        editor.putInt("mPresent",mPresent);
        editor.apply();
    }

    public void load(){
        mTotal = sharedPreferences.getInt("mTotal",0);
        mPresent = sharedPreferences.getInt("mPresent",0);

        mscoreTextView.setText(mPresent + "/" + mTotal);

        float percentage = ((float)mPresent/ (float)mTotal)*100;

        String finalPercentage =  String.format("%.2f" , percentage);

        mPercentageTextView.setText(finalPercentage+"%");

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mscoreTextView = (TextView) findViewById(R.id.mscoreTextView);

        mPercentageTextView = (TextView) findViewById(R.id.mPercentageTextView);

        sharedPreferences = getSharedPreferences("attendance",MODE_PRIVATE);

        load();
    }
}
