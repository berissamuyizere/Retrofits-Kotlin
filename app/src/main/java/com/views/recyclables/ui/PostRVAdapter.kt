package com.views.recyclables.ui
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.views.recyclables.model.Post
import com.views.recyclables.R
import com.views.recyclables.ui.CommentsRvAdapter

class PostRvAdapter(val context: Context, val posts: List<Post>):RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.post_list_item, parent, false)
        return PostViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return posts.size
    }
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val currentPost = posts[position]
        holder.tvTitle.text = currentPost.title
        holder.tvBody.text = currentPost.body
        holder.tvUserID.text = currentPost.userid.toString()
        holder.cvPosts.setOnClickListener {
            val intent= Intent(context, ViewPostActivity::class.java)
            intent.putExtra("POST_ID", currentPost.id)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }
}
class PostViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
    val tvBody = itemView.findViewById<TextView>(R.id.tvBody)
    val tvUserID = itemView.findViewById<TextView>(R.id.tvUserId)
    val cvPosts = itemView.findViewById<CardView>(R.id.cvPosts)
}