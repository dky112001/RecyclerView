package com.example.listjson

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toolbar
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: MyAdapter
    var data = ArrayList<MyData>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        var addButton: FloatingActionButton = findViewById(R.id.addbtn)

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

         data = mutableListOf(
             MyData("Deepak Kumar", R.drawable.dsc, "seen 4h ago"),
             MyData("Deepak Kumar", R.drawable.dsc, "seen 4h ago"),
             MyData("Deepak Kumar", R.drawable.dsc, "seen 4h ago"),
             MyData("Deepak Kumar", R.drawable.dsc, "seen 4h ago"),
             MyData("Deepak Kumar", R.drawable.dsc, "seen 4h ago"),
             MyData("Deepak Kumar", R.drawable.dsc, "seen 4h ago"),
             MyData("Deepak Kumar", R.drawable.dsc, "seen 4h ago"),
             MyData("Deepak Kumar", R.drawable.dsc, "seen 4h ago"),
             MyData("Deepak Kumar", R.drawable.dsc, "seen 4h ago"),
             MyData("Deepak Kumar", R.drawable.dsc, "seen 4h ago"),
             MyData("Deepak Kumar", R.drawable.dsc, "seen 4h ago"),
             MyData("Deepak Kumar", R.drawable.dsc, "seen 4h ago"),
             MyData("Deepak Kumar", R.drawable.dsc, "seen 4h ago"),
             MyData("Deepak Kumar", R.drawable.dsc, "seen 4h ago"),
             MyData("Deepak Kumar", R.drawable.dsc, "seen 4h ago"),
             MyData("Deepak Kumar", R.drawable.dsc, "seen 4h ago"),
             MyData("Deepak Kumar", R.drawable.dsc, "seen 4h ago"),
             MyData("Deepak Kumar", R.drawable.dsc, "seen 4h ago"),
             MyData("Deepak Kumar", R.drawable.dsc, "seen 4h ago"),
             MyData("Deepak Kumar", R.drawable.dsc, "seen 4h ago"),
             MyData("Deepak Kumar", R.drawable.dsc, "seen 4h ago"),
         ) as ArrayList<MyData>
        adapter = MyAdapter(this, data,this)
        recyclerView.adapter = adapter

        addButton.setOnClickListener {
            var alertDialog = AlertDialog.Builder(this)
            val layout = LayoutInflater.from(this).inflate(R.layout.addlist, null, false)
            val name = layout.findViewById<EditText>(R.id.name)
            val subtitle = layout.findViewById<EditText>(R.id.subtitle)
            val getButton = layout.findViewById<Button>(R.id.getbutton)
            val alert = alertDialog.create()
            alert.setView(layout)
            alert.show()
            getButton.setOnClickListener {
                val newData = MyData(name.text.toString(), R.drawable.dsc, subtitle.text.toString())
                adapter.addData(newData)
                alert.dismiss()
            }
        }


    }

    fun onUpdate(subtitle: String, position: Int) {

        var alertDialog = AlertDialog.Builder(this)
        val layout = LayoutInflater.from(this).inflate(R.layout.addlist, null, false)
        val names = layout.findViewById<EditText>(R.id.name)
        val subtitles = layout.findViewById<EditText>(R.id.subtitle)
        val getButtons = layout.findViewById<Button>(R.id.getbutton)
        val alert = alertDialog.create()
        alert.setView(layout)
        alert.show()
        getButtons.setOnClickListener {
           data[position]  = MyData(names.text.toString(), R.drawable.dsc, subtitles.text.toString())

            alert.dismiss()
            adapter.notifyDataSetChanged()
        }
    }


}
