package com.example.whatnexttodo

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private val texts: MutableList<String> = mutableListOf("334","My test", "text", "Work", " HOW", " Toast", "ViewHolder")


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView = parent.inflate(R.layout.recyclerview_item_row, false)
        return ViewHolder(inflatedView)
    }

    override fun getItemCount(): Int = texts.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text.text= texts[position]




    }
    class ViewHolder(v: View): RecyclerView.ViewHolder(v), View.OnClickListener {

        private var view: View = v
        var text = v.findViewById<TextView>(R.id.text)

        init {
            v.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            Log.d("Click", "tes")
        }

    }


}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}
