package com.example.circleloader;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import com.example.circleprogress.CircleProgressBar;

public class Main2Activity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {


    ColorAdapter colorAdapter;
    SeekBar proSeek,thickSeek;
    CircleProgressBar circle_progress;
    RecyclerView colorRecycle;
    Switch edgeSwitch;
    TextView progressVal;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        proSeek=findViewById(R.id.proSeek);
        thickSeek=findViewById(R.id.thickSeek);
        circle_progress=findViewById(R.id.circle_progress);
        colorRecycle=findViewById(R.id.colorRecycle);
        edgeSwitch=findViewById(R.id.edgeSwitch);
        progressVal=findViewById(R.id.progressVal);


        proSeek.setOnSeekBarChangeListener(this);
        thickSeek.setOnSeekBarChangeListener(this);
        thickSeek.setProgress(30);


        colorAdapter=new ColorAdapter(this, new Second<Integer>() {
            @Override
            public void execute(Integer value) {
                circle_progress.setColor(value);
            }
        });

        colorRecycle.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        colorRecycle.setAdapter(colorAdapter);

        edgeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                                if (isChecked){
                    circle_progress.setRoundCap();

                }else{
                    circle_progress.setSquareCap();

                }
            }
        });

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        switch (seekBar.getId()){
            case R.id.proSeek:
                circle_progress.setProgress(i);
                progressVal.setText(""+i);
                break;
            case R.id.thickSeek:
                circle_progress.setThickness(i);
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }



}
