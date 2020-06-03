package com.example.circleloader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.CompoundButton
import android.widget.RadioGroup
import android.widget.SeekBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),SeekBar.OnSeekBarChangeListener {

        lateinit var colorAdapter: ColorAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        proSeek.setOnSeekBarChangeListener(this)
        thickSeek.setOnSeekBarChangeListener(this)
        thickSeek.setProgress(30)

        colorAdapter= ColorAdapter(this,object:Second<Int>{
            override fun execute(value: Int) {
                circle_progress.setColor(value)
            }
        })
        colorRecycle.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        colorRecycle.adapter=colorAdapter
        edgeSwitch.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(p0: CompoundButton?, isChecked: Boolean) {
                if (isChecked){
                    circle_progress.setRoundCap()

                }else{
                    circle_progress.setSquareCap()

                }
            }
        })
    }

    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
         when(p0){
             proSeek->{
                 circle_progress.setProgress(p1)
                 progressVal.setText(""+p1)
             }
             thickSeek->circle_progress.setThickness(p1.toFloat())
         }
    }

    override fun onStartTrackingTouch(p0: SeekBar?) {

    }

    override fun onStopTrackingTouch(p0: SeekBar?) {

    }


}
