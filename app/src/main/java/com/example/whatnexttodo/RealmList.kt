package com.example.whatnexttodo

import io.realm.RealmList
import io.realm.RealmObject

//class RealmDataBase : RealmList<RealmList<String>>() {
open class RealmList : RealmObject() {
    var list :RealmList<String> = RealmList()
}