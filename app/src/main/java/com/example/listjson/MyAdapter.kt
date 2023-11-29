package com.example.listjson

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter( var context: Context, val datalist : MutableList<MyData>,val userClick : MainActivity ) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

  @SuppressLint("SuspiciousIndentation")
  inner  class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var textview: TextView = itemView.findViewById(R.id.textView)
        var imageView: ImageView = itemView.findViewById(R.id.image1)
        var subtitle: TextView = itemView.findViewById(R.id.subtitle2)

        init {
            textview.setOnClickListener {
                val alertDialog = AlertDialog.Builder(context)
                alertDialog.setTitle("warning")
                alertDialog.setMessage("Are you sure want to delete")
                alertDialog.setPositiveButton("ok"){dialog, which ->
                    val position = adapterPosition
                        if (position!=RecyclerView.NO_POSITION)
                        removeData(position)
                }
                alertDialog.setNegativeButton("no"){dialog, which ->


                }
                alertDialog.show()
            }

            subtitle.setOnClickListener {
                userClick.onUpdate(datalist[position].Subtitle,position)
            }

           imageView.setOnClickListener {
               val intent = Intent(context,MainActivity2::class.java)
               datalist[position].text
               datalist[position].image
               datalist[position].Subtitle

               context.startActivity(intent)

           }


        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,null,false)


        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
       return datalist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val dataitem = datalist[position]
        holder.textview.text=dataitem.text
        holder.imageView.setImageResource(dataitem.image)
        holder.subtitle.text=dataitem.Subtitle
    }

    fun addData(newData : MyData){
        datalist.add(newData)
        notifyItemInserted(datalist.size-1)
    }

    fun  removeData(position: Int){
        datalist.removeAt(position)
        notifyItemRemoved(position)

    }



}