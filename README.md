# circularProgress
This library is used to do circular loading with progress, it is best suitable where you want to show some progress with circular loading like while downloading files.This library is written in kotlin and can also be used in java file as well.
<h2>Have a look to the demonstration</h2>
        
<img src="https://img.techpowerup.org/200605/screenshot-20200604-164241.jpg" width="400">

<h3>To include:</h3>

implementation 'com.example.circleprog:circleprogress:1.0.0'

<h2>How to use:</h2>

<h3>Simply Define in your xml file</h3>

          <com.example.circleprogress.CircleProgressBar
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:id="@+id/circle_progress"
          app:max="100"
          app:progress="60"
          app:color="@color/color6"
          app:progressBarThickness="80dp"
          app:strokeCap="round" />

<h3>Also you can do the modifications in run time, by following functions: </h3>

 setProgress(progress:Int)
 setMax(max:Int)
 setColor(color:Int)
 setThickness(strWidth:Float)
 setRoundCap()
 setSquareCap()

    



