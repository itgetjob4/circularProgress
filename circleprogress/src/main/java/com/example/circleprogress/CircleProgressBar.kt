package com.example.circleprogress

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.graphics.RectF
import android.graphics.Color.DKGRAY
import android.graphics.Paint
import android.R.attr.factor
import android.graphics.Canvas


class CircleProgressBar : View {

    /**
     * ProgressBar's line thickness
     */
    private var strokeWidth = 4f
    private var progress = 0
    private var min = 0
    private var max = 100
    private var strokeCap=0
    private var paintCap=Paint.Cap.ROUND
    /**
     * Start the progress at 12 o'clock
     */
    private var startAngle = -90
    private var color = Color.DKGRAY
    private var rectF: RectF? = null
    private var backgroundPaint: Paint? = null
    private var foregroundPaint: Paint? = null

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        init(context,attrs)

    }

    private fun init(context: Context?,attrs: AttributeSet?){
        rectF= RectF()
        val typedArray=context!!.theme.obtainStyledAttributes(attrs, R.styleable.CircleProgressBar,0,0)
        //Reading values from the XML layout
        try {
            strokeWidth = typedArray.getDimension(R.styleable.CircleProgressBar_progressBarThickness, strokeWidth)
            progress = typedArray.getInt(R.styleable.CircleProgressBar_progress, progress)
            color = typedArray.getInt(R.styleable.CircleProgressBar_color, color)
            min = typedArray.getInt(R.styleable.CircleProgressBar_min, min)
            max = typedArray.getInt(R.styleable.CircleProgressBar_max, max)
            strokeCap=typedArray.getInt(R.styleable.CircleProgressBar_strokeCap,strokeCap)
            if(strokeCap==0){
                paintCap=Paint.Cap.ROUND
            }else{
                paintCap=Paint.Cap.SQUARE
            }
        } finally {
            typedArray.recycle()
        }

        toChangeColor()
    }

    private fun adjustAlpha(color:Int,factor:Float):Int{
        val alpha = Math.round(Color.alpha(color) * factor)
        val red = Color.red(color)
        val green = Color.green(color)
        val blue = Color.blue(color)
        return Color.argb(alpha, red, green, blue)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
         val height = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);
         val width = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);
         val min = Math.min(width, height);
        setMeasuredDimension(min, min);
        rectF!!.set(0 + strokeWidth / 2, 0 + strokeWidth / 2, min - strokeWidth / 2, min - strokeWidth / 2);
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas!!.drawOval(rectF!!,backgroundPaint!!)
        val angle=360*progress/max
        canvas.drawArc(rectF!!,startAngle.toFloat(),angle.toFloat(),false,foregroundPaint!!)
    }


    fun setProgress(progress:Int){
        this.progress=progress
        invalidate()
    }


    fun setMax(max:Int){
        this.max=max
        invalidate()
    }

    fun setColor(color:Int){
        this.color=color
        backgroundPaint!!.setColor(adjustAlpha(color, 0.3f))
        foregroundPaint!!.setColor(color)
        invalidate()
    }

    private fun toChangeColor(){
        backgroundPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        backgroundPaint!!.setColor(adjustAlpha(color, 0.3f))
        backgroundPaint!!.setStyle(Paint.Style.STROKE)
        backgroundPaint!!.setStrokeWidth(strokeWidth)

        foregroundPaint =Paint(Paint.ANTI_ALIAS_FLAG)
        foregroundPaint!!.setColor(color)
        foregroundPaint!!.setStyle(Paint.Style.STROKE)
        foregroundPaint!!.setStrokeWidth(strokeWidth)
        foregroundPaint!!.strokeCap=paintCap
    }


    fun setThickness(strWidth:Float){
        strokeWidth=strWidth
        backgroundPaint!!.setStrokeWidth(strWidth)
        foregroundPaint!!.setStrokeWidth(strWidth)
        invalidate()
    }

    fun setRoundCap(){
        paintCap=Paint.Cap.ROUND
        foregroundPaint!!.strokeCap=paintCap
        invalidate()
    }

    fun setSquareCap(){
        paintCap=Paint.Cap.SQUARE
        foregroundPaint!!.strokeCap=paintCap
        invalidate()
    }


}