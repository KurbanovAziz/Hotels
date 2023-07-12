package com.example.kitepkana.presentation.ui.fragments.library

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.kitepkana.databinding.ItemBooksHorizontalBinding
import com.example.kitepkana.domain.model.Books
import com.example.kitepkana.presentation.utils.loadImage

class ListHorizontalBooksAdapter(val onClick: (position: Int) -> Unit) :
    ListAdapter<Books, ListHorizontalBooksAdapter.ListHorizontalBooksViewHolder>(
        DiffUtilItemCallback()
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListHorizontalBooksViewHolder {
        return ListHorizontalBooksViewHolder(
            ItemBooksHorizontalBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ListHorizontalBooksViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class ListHorizontalBooksViewHolder(private val binding: ItemBooksHorizontalBinding) :
        ViewHolder(binding.root) {
        fun onBind(book: Books) {
            binding.ivBook.loadImage(book.cover)
            binding.tvNameBook.text = book.title
            binding.tvAuthorBook.text = book.author_name

            itemView.setOnClickListener {
                onClick(book.id)
            }
        }
    }

    private class DiffUtilItemCallback : DiffUtil.ItemCallback<Books>() {
        override fun areItemsTheSame(oldItem: Books, newItem: Books): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Books, newItem: Books): Boolean {
            return oldItem == newItem
        }
    }
}
