package com.example.whatnexttodo

import io.realm.RealmList
import io.realm.RealmObject

//class RealmDataBase : RealmList<RealmList<String>>() {
open class RealmDataBase(var name: String = "0") : RealmObject() {
}