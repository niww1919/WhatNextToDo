package com.example.whatnexttodo

import io.realm.RealmObject

open class Note(
    var title: String? = null,
    var textOfNote: String? = null

):RealmObject(){}