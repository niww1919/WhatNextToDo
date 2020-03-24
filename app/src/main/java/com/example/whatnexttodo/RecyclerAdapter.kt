package com.example.whatnexttodo

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.PhotoHolder>() {

    private val texts: Array<String> = arrayOf("334","dfdf", "text")


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.PhotoHolder {
        val inflatedView = parent.inflate(R.layout.recyclerview_item_row, false)
        return PhotoHolder(inflatedView)
    }

    override fun getItemCount(): Int = texts.size


    override fun onBindViewHolder(holder: RecyclerAdapter.PhotoHolder, position: Int) {


    }
    class PhotoHolder(v: View): RecyclerView.ViewHolder(v), View.OnClickListener {

        private var view: View = v

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
