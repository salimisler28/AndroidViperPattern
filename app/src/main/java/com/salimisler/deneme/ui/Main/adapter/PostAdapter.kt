package com.salimisler.deneme.ui.Main.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.salimisler.deneme.R
import com.salimisler.deneme.app.data.dto.Post
import com.salimisler.deneme.ui.Main.MainActivity
import kotlinx.android.synthetic.main.item_post.view.*

class PostAdapter(val data : List<Post>, val activity: Activity) : RecyclerView.Adapter<PostAdapter.ViewHoldet>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoldet {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return ViewHoldet(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHoldet, position: Int) {
        val values = data[position]

        holder.title.text = values.title
        holder.id.text = values.userId.toString()
        holder.post.text = values.body

        holder.llPost.setOnClickListener {
            sendData(values)
        }
    }

    private fun sendData(data: Post) {
        val activity = activity as MainActivity
        activity.getClickedPost(data)
    }

    class ViewHoldet(itemiView : View) : RecyclerView.ViewHolder(itemiView) {
        val title = itemView.txCommentId
        val id = itemView.txCommentName
        val post = itemiView.txCommentBody
        val llPost = itemiView.llPost
    }
}