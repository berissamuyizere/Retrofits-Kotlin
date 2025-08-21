package com.views.recyclables.repository

import com.views.recyclables.api.ApiClient
import com.views.recyclables.api.ApiInterface
import com.views.recyclables.model.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class PostRepository {
    val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun fetchPosts(): Response<List<Post>>{
        return  withContext(Dispatchers.IO){
            retrofit.getPosts()
        }
    }

    suspend fun fetchPostById(postId: Int): Response<Post>{
        return withContext(Dispatchers.IO){
            retrofit.getPostById(postId)
        }
    }
}