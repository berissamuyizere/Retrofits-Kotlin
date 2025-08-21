package com.views.recyclables.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.views.recyclables.model.Post
import com.views.recyclables.repository.PostRepository
import kotlinx.coroutines.launch

class PostsViewModel : ViewModel() {

    val postsLiveData = MutableLiveData<List<Post>>()

    val postLiveData = MutableLiveData<Post>()

    val errorLiveDta = MutableLiveData<String>()

    val postsRepository = PostRepository()

    fun fetchPosts() {
        viewModelScope.launch {
            val response = postsRepository.fetchPosts()
            if (response.isSuccessful) {
                postsLiveData.postValue(response.body())
            } else {
                errorLiveDta.postValue(response.errorBody()?.string())
            }
        }
    }

    fun fetchPostById(postId: Int) {
        viewModelScope.launch {
            val response = postsRepository.fetchPostById(postId)
            if (response.isSuccessful) {
                postLiveData.postValue(response.body())
            } else {
                errorLiveDta.postValue(response.errorBody()?.string())
            }
        }
    }
}