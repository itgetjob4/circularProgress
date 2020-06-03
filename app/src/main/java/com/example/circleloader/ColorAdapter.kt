package com.example.circleloader

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class ColorAdapter(var activity: Activity,var callBack:Second<Int>) : RecyclerView.Adapter<ColorAdapter.ViewHolder>() {

    var list=ArrayList<Int>()
init {
    list=getColors()
}





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
     var inflater=LayoutInflater.from(parent.context)
     var view=inflater.inflate(R.layout.color_lay,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      holder.circleImage.setBackgroundColor(list.get(position))
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var circleImage:ImageView
        init {
            circleImage=itemView.findViewById(R.id.circleColor)
            itemView.setOnClickListener{
                callBack.execute(list.get(adapterPosition))
            }

        }
    }


    fun getColors():ArrayList<Int>{
        var colorList=ArrayList<Int>()
        colorList.add(ContextCompat.getColor(activity,R.color.color1))
        colorList.add(ContextCompat.getColor(activity,R.color.color2))
        colorList.add(ContextCompat.getColor(activity,R.color.color3))
        colorList.add(ContextCompat.getColor(activity,R.color.color4))
        colorList.add(ContextCompat.getColor(activity,R.color.color5))
        colorList.add(ContextCompat.getColor(activity,R.color.color6))
        colorList.add(ContextCompat.getColor(activity,R.color.color7))
        colorList.add(ContextCompat.getColor(activity,R.color.color8))
        colorList.add(ContextCompat.getColor(activity,R.color.color9))
        colorList.add(ContextCompat.getColor(activity,R.color.color10))
        colorList.add(ContextCompat.getColor(activity,R.color.color11))
        colorList.add(ContextCompat.getColor(activity,R.color.color12))
        colorList.add(ContextCompat.getColor(activity,R.color.color13))
        return colorList
    }
}


