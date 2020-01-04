package com.hardik.repository.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "heroes")
data class User(

    @PrimaryKey
    var id: String,

    var first_name: String,
    var last_name: String,
    var email: String
    /*var createdby: String,
    var publisher: String,
    var imageurl: String,
    var bio: String*/
)