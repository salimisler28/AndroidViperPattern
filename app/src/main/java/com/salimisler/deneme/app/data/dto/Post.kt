package com.salimisler.deneme.app.data.dto

import com.google.gson.annotations.SerializedName

class Post {
    @SerializedName("userId")
    var userId: Int? = null

    @SerializedName("id")
    var id: Int? = null

    @SerializedName("title")
    var title: String? = null

    @SerializedName("body")
    var body: String? = null
}