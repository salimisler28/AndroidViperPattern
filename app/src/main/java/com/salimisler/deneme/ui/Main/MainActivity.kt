package com.salimisler.deneme.ui.Main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.salimisler.deneme.R
import com.salimisler.deneme.app.App
import com.salimisler.deneme.app.data.dto.Post
import com.salimisler.deneme.ui.Main.adapter.PostAdapter
import com.salimisler.deneme.ui.Main.di.DaggerMainComponent
import com.salimisler.deneme.ui.Main.di.MainComponent
import com.salimisler.deneme.ui.Main.di.MainModule
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {
    @Inject
    lateinit var mPresenter : MainPresenter

    val component: MainComponent by lazy {
        DaggerMainComponent.builder()
            .appComponent((application as App).component)
            .activity(this)
            .plus(MainModule())
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        component.inject(this)
        mPresenter.bindView(this)
        mPresenter.onViewCreated()
    }

    override fun showLoading() {
        rvPost.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        rvPost.visibility = View.VISIBLE
        progressBar.visibility = View.GONE
    }

    override fun publishData(data: List<Post>) {
        rvPost.layoutManager = LinearLayoutManager(this)
        rvPost.adapter = PostAdapter(data, this)
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    override fun getClickedPost(data: Post) {
        mPresenter.postClicked(data)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.unBindView()
    }
}
