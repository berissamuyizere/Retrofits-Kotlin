package com.views.recyclables.api

import com.views.recyclables.model.Comment
import com.views.recyclables.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/posts")
    suspend fun getPosts(): Response<List<Post>>

    @GET("/posts/{postId}")
    suspend fun getPostById(@Path("postId") postId: Int): Response<Post>

    @GET("/posts/{postId}/comments")
    suspend fun getCommentsByPostId(@Path("postId") postId: Int): Response<List<Comment>>
}