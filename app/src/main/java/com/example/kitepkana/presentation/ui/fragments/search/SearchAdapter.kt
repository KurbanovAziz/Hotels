package com.example.kitepkana.presentation.ui.fragments.search

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.kitepkana.databinding.ItemBooksHorizontalBinding
import com.example.kitepkana.databinding.ItemSearchBinding
import com.example.kitepkana.domain.model.Books
import com.example.kitepkana.presentation.utils.loadImage

class SearchAdapter(val onClick: (position: Int) -> Unit) :
    ListAdapter<com.example.kitepkana.domain.model.Books, SearchAdapter.SearchViewHolder>(
        DiffUtilItemCallback()
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchViewHolder {
        return SearchViewHolder(
            ItemSearchBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class SearchViewHolder(private val binding: ItemSearchBinding) :
        ViewHolder(binding.root) {
        fun onBind(book: com.example.kitepkana.domain.model.Books) {
            Log.d("ololo", "onBind() called for book: ${book.title}")
            binding.ivBook.loadImage(book.cover)
            binding.tvNameBook.text = book.title
            binding.tvAuthorBook.text = book.author_name

            itemView.setOnClickListener {
                onClick(book.id)
            }
        }
    }

    private class DiffUtilItemCallback : DiffUtil.ItemCallback<com.example.kitepkana.domain.model.Books>() {
        override fun areItemsTheSame(oldItem: com.example.kitepkana.domain.model.Books, newItem: com.example.kitepkana.domain.model.Books): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: com.example.kitepkana.domain.model.Books, newItem: com.example.kitepkana.domain.model.Books): Boolean {
            return oldItem == newItem
        }
    }
}
