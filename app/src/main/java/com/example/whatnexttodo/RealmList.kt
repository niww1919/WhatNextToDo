package com.example.whatnexttodo

import io.realm.RealmList
import io.realm.RealmObject

//class RealmDataBase : RealmList<RealmList<String>>() {
open class RealmList : RealmObject() {
//    var dataList: RealmList<RealmList<String>> = RealmList()
    var firstNote: String? = null
    var listNote :RealmList<String> = RealmList()

}