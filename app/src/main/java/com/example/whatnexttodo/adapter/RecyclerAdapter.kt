package com.example.whatnexttodo.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.whatnexttodo.R

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private val innerTexts: MutableList<MutableList<String>> =
        mutableListOf(
            mutableListOf("1", "2", "3"),
            mutableListOf("11", "22", "33"),
            mutableListOf("111", "222", "333"),
            mutableListOf("1111", "2222", "3333"),
            mutableListOf("11111", "22222", "33333")
        )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView = parent.inflate(R.layout.recyclerview_item_row, false)
        return ViewHolder(
            inflatedView
        )
    }

    override fun getItemCount(): Int = innerTexts.size
//    override fun getItemCount(): Int = innerTexts.count { it.size > 1 }
//    override fun getItemCount(): Int = 9


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("size", "${innerTexts.count { it.size > 0 }}")

        holder.textView.text = innerTexts[position][0]
        for (i in 1 until innerTexts[position].size) {
            val tv = TextView(holder.view.context)
            tv.text = innerTexts[position][i]
            holder.linearLayout.addView(tv)
        }

        holder.textView.setOnClickListener {
            holder.icon.visibility = View.VISIBLE
        }
    }

    open class ViewHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

        var view: View = v //todo what is is
        val linearLayout = v.findViewById<LinearLayoutCompat>(R.id.ll)
        var textView = v.findViewById<TextView>(R.id.text)
        val icon = v.findViewById<ImageView>(R.id.icon)

        init {
            v.setOnClickListener(this)//todo what is is
        }

        override fun onClick(v: View?) {
//            Log.d("Click", "yes")
//            Toast.makeText(v?.context, "click", Toast.LENGTH_SHORT).show()
//            icon.visibility = View.VISIBLE

        }
    }
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}
