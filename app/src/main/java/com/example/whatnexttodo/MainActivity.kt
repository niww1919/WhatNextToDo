package com.example.whatnexttodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.whatnexttodo.adapter.RecyclerAdapter
import com.example.whatnexttodo.data.Data
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: RecyclerAdapter
    val innerTexts: MutableList<MutableList<String>> =
        mutableListOf(
            mutableListOf("1", "2", "3"),
            mutableListOf("11", "22", "33"),
            mutableListOf("111", "222", "333")
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayoutManager = LinearLayoutManager(this)
        rv.layoutManager = linearLayoutManager
        adapter = RecyclerAdapter(innerTexts)
        rv.adapter = adapter

        val db = Data()
        db.jsonObject.put("2","2323")
        Log.i("JObject",db.jsonObject.toString())
        Log.i("JObject","${db.jsonObject.length()}")
        Log.i("JObject","${db.jsonObject}")

        Log.i("JObject","${db.list}")
        Log.i("JObject", db.list[0][0])

        Log.i("JObject","${db.map}")
        Log.i("JObject","${db.map}")
        Log.i("JObject","${db.map.size}")




        val itemSwipe = ItemTouchHelper(
            object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return true
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    if (direction == ItemTouchHelper.LEFT) {

//                        (rv.adapter as RecyclerAdapter).notifyItemRangeInserted(viewHolder.itemId.toInt(),1)

                        Toast.makeText(this@MainActivity, "Left", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this@MainActivity, "Right", Toast.LENGTH_SHORT).show()
                    }
                }

            })

        itemSwipe.attachToRecyclerView(rv)

    }

    fun addNewToDo(view: View) {
//        innerTexts.add(mutableListOf("Ok"))
        innerTexts.add(0, mutableListOf("Test","test","test"))
//        rv.adapter?.notifyItemRangeInserted(0,1)
        rv.adapter?.notifyItemInserted(0)
//        rv.adapter?.notifyDataSetChanged()

    }

    fun addTask(view: View){
//        innerTexts[adapter.itemCount].add("work")
//        innerTexts[linearLayoutManager.getPosition(view)].add(1,"work")
        innerTexts[1].add(1,"work")
        rv.adapter?.notifyDataSetChanged()


    }


}
