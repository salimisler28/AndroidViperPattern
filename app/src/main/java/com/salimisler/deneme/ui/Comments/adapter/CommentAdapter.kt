package com.salimisler.deneme.ui.Comments.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.salimisler.deneme.R
import com.salimisler.deneme.app.data.dto.Comment
import com.salimisler.deneme.app.data.dto.Post
import com.salimisler.deneme.ui.Main.MainActivity
import kotlinx.android.synthetic.main.item_post.view.*

class CommentAdapter(val data : List<Comment>) : RecyclerView.Adapter<CommentAdapter.ViewHoldet>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoldet {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_comment, parent, false)
        return ViewHoldet(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHoldet, position: Int) {
        holder.txCommentId.text = data[position].id.toString()
        holder.txCommentName.text = data[position].name
        holder.txCommentBody.text = data[position].body
    }

    class ViewHoldet(itemiView : View) : RecyclerView.ViewHolder(itemiView) {
        val txCommentId = itemiView.txCommentId
        val txCommentName = itemiView.txCommentName
        val txCommentBody = itemiView.txCommentBody
    }
}