package com.views.recyclables.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.views.recyclables.R
import com.views.recyclables.api.ApiClient
import com.views.recyclables.api.ApiInterface
import com.views.recyclables.model.Post
import com.views.recyclables.viewmodel.PostsViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class PostActivity : AppCompatActivity() {
    lateinit var rvPosts: RecyclerView

    val postsViewModel: PostsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_post)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onResume() {
        super.onResume()
        rvPosts = findViewById(R.id.rvPosts)
        rvPosts.layoutManager = LinearLayoutManager(this)
        postsViewModel.fetchPosts()
        postsViewModel.fetchPostById(1)
        postsViewModel.postsLiveData.observe(this, { posts ->
            displayPosts(posts)
        })
        postsViewModel.errorLiveDta.observe(this, { err ->
            Toast.makeText(this, err, Toast.LENGTH_SHORT).show()
        })
    }
        fun displayPosts (posts: List<Post>){
            val postsAdapter = PostRvAdapter(this, posts)
            rvPosts.adapter = postsAdapter
        }
    }

