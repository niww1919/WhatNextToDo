package com.example.whatnexttodo

import android.content.Context
import android.inputmethodservice.InputMethodService
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.whatnexttodo.adapter.RecyclerAdapter
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: RecyclerAdapter
    private lateinit var listDB: MutableList<MutableList<String>>


    private val TAG = "TAGG"

    //        val listDataBase: MutableList<MutableList<String>>
    var listDataBase: MutableList<MutableList<String>> =
        mutableListOf()
    val database = Firebase.database
    val myDB = database.getReference("DB")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myDB.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value: MutableList<MutableList<String>>? =
                    dataSnapshot.getValue<MutableList<MutableList<String>>>()
                listDataBase.clear()
                rv.adapter?.notifyDataSetChanged()

                value?.let { listDataBase.addAll(it) }
                Log.d(TAG, "Value is: $value" + "\n$listDataBase ")
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })


        val fb = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fb.setOnClickListener {
            addNewToDo()
        }

        linearLayoutManager = LinearLayoutManager(this)
        rv.layoutManager = linearLayoutManager
        adapter = RecyclerAdapter(listDataBase, rv)
        rv.adapter = adapter
    }

    override fun onPause() {
        super.onPause()
        if (listDataBase.size != 0) {
            myDB.setValue(listDataBase)

        }
    }

    private fun addNewToDo() {
        val editText = EditText(this)
        MaterialAlertDialogBuilder(this)
            .setTitle("New ToDo")
            .setView(editText)
            .setNegativeButton("Cancel") { dialog, which -> "ok" }
            .setPositiveButton("Ok") { dialog, which ->
                listDataBase.add(0, mutableListOf(editText.text.toString()))
                rv.adapter?.notifyDataSetChanged()
            }
            .show()
    }

}
