package com.salimisler.deneme.ui.Main

import android.app.Activity
import android.content.Intent
import com.salimisler.deneme.app.data.dto.Post
import com.salimisler.deneme.ui.Comments.CommentActivity

class MainRouter(private val activity: MainActivity) : MainContract.Router {
    override fun finish() {
        activity.finish()
    }

    override fun startCommentActivity(data: Post) {
        val intent = Intent(activity, CommentActivity::class.java)
        intent.putExtra("body", data.body)
        intent.putExtra("id", data.id)
        activity.startActivity(intent)
    }
}