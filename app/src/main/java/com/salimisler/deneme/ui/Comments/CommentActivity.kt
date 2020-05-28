package com.salimisler.deneme.ui.Comments

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.salimisler.deneme.R
import com.salimisler.deneme.app.App
import com.salimisler.deneme.app.data.dto.Comment
import com.salimisler.deneme.app.data.dto.Post
import com.salimisler.deneme.ui.Comments.adapter.CommentAdapter
import com.salimisler.deneme.ui.Comments.di.CommentComponent
import com.salimisler.deneme.ui.Comments.di.CommentModule
import com.salimisler.deneme.ui.Comments.di.DaggerCommentComponent
import kotlinx.android.synthetic.main.activity_comment.*
import javax.inject.Inject

class CommentActivity : AppCompatActivity(), CommentContract.View {

    @Inject
    lateinit var mPresenter: CommentPresenter

    val component: CommentComponent by lazy {
        DaggerCommentComponent.builder()
            .appComponent((application as App).component)
            .activity(this)
            .plus(CommentModule())
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)

        component.inject(this)
        this.mPresenter.bindView(this)

        val bundle = intent.extras
        val body = bundle!!.getString("body")
        val id = bundle.getInt("id")
        txBody.text = body;

        this.mPresenter.onViewCreated(id)

    }

    override fun showLoading() {
        progressBarComment.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBarComment.visibility = View.GONE
    }

    override fun publishData(data: List<Comment>) {
        rvComment.layoutManager = LinearLayoutManager(this)
        rvComment.adapter = CommentAdapter(data)
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        hideLoading()
    }


}
