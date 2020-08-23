package com.example.whatnexttodo.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.LayoutRes
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.whatnexttodo.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*

class RecyclerAdapter(val dataList: MutableList<MutableList<String>>, val recyclerView: RecyclerView) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView = parent.inflate(R.layout.recyclerview_item_row, false)
        return ViewHolder(
            inflatedView
        )
    }

    override fun getItemCount(): Int = dataList.size
//    override fun getItemCount(): Int = data.count { it.size > 1 }
//    override fun getItemCount(): Int = 9


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.textView.text = dataList[position][0]
//        holder.linearLayout.removeAllViews()
        holder.linearLayout.removeAllViewsInLayout()


        for (i in 1 until dataList[position].size) {
            val ll = LinearLayoutCompat(holder.view.context)
            val tv = TextView(holder.view.context)
            val checkBox = CheckBox(holder.view.context)
            tv.text = dataList[position][i]
            ll.addView(checkBox)
            ll.addView(tv)
//            holder.linearLayout.addView(checkBox)
            holder.linearLayout.addView(ll) //fixme похоже что старые элементы остаются
        }

        holder.textView.setOnClickListener {
            holder.icon.visibility = View.VISIBLE
            holder.adapterPosition
        }
        holder.icon.setOnClickListener {
            val editText = EditText(holder.view.context)

            MaterialAlertDialogBuilder(holder.view.context)
                .setTitle("New task")
                .setView(editText)
                .setNegativeButton("Cancel", { dialog, which -> "ok" })
                .setPositiveButton("Ok") { dialog, which ->
                    dataList[position].add(1, editText.text.toString())
                    recyclerView.adapter?.notifyDataSetChanged()
                }
                .show()
        }
        holder.textView.setOnLongClickListener {
            MaterialAlertDialogBuilder(holder.view.context)
                .setTitle("Delete")
                .setNegativeButton("Cancel", { dialog, which -> "ok" })
                .setPositiveButton("Ok") { dialog, which ->
                    dataList[position].removeAt(dataList[position].size-1)
                    recyclerView.adapter?.notifyDataSetChanged()
                }
                .show()
            return@setOnLongClickListener true
        }
    }

    open class ViewHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

        var view: View = v //todo what is is
        val linearLayout = v.findViewById<LinearLayoutCompat>(R.id.ll)
        var textView = v.findViewById<TextView>(R.id.text)
        val icon = v.findViewById<ImageView>(R.id.iconAddTask)

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


