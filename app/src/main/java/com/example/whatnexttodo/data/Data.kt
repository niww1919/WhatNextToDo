package com.example.whatnexttodo.data

import android.util.Log
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONStringer

class Data {
    val jsonObject = JSONObject()
    val list = mutableListOf<MutableList<String>>()
    val map = mutableMapOf<String,MutableList<String>>()
    init {
        jsonObject.put("Name","1")
        jsonObject.put("Name","2")
        jsonObject.put("Name1","3")
        jsonObject.toString()

        list.add(mutableListOf("1"))
        list.add(mutableListOf("1","2"))
        list.add(mutableListOf("1","2","3"))


        //не упорядочная коллекция
        map.put("1", mutableListOf("df","sdsd"))
        map["2"] = mutableListOf("dsfdsf","ssdfdsffddsd")
    }


}