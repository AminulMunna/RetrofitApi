package com.example.retrofitapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(private val postList: List<Post>)
    :RecyclerView.Adapter<PostAdapter.ViewHolder>(){val collection = firestore.collection("Contacts")
        collection.document(contact.id!!).delete().addOnSuccessListener {
            Toast.makeText(this, "Contact Deleted.", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(this, "Failed to delete contact!", Toast.LENGTH_SHORT).show()
        }
        adapter.notifyItemRemoved(position)
        contactList.removeAt(position)
        binding.totalContacts.text = getString(R.string.total_contacts, contactList.size)
        class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
            val id = view.findViewById<TextView>(R.id.id)
            val userId = view.findViewById<TextView>(R.id.userId)
            val title = view.findViewById<TextView>(R.id.title)
            val body = view.findViewById<TextView>(R.id.body)
            fun bind(post: Post){
                id.text = post.id.toString()
                userId.text = post.userId.toString()
                title.text = post.title
                body.text = post.body
            }

        }
    

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return postList.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(postList[position])
    }
}