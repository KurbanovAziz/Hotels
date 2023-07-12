package com.example.kitepkana.presentation.ui.fragments.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.kitepkana.databinding.ItemRecentRequestBinding

class RecentRequestAdapter(
    val onClick: (name: String) -> Unit,
    val onClickRemove: (pos: Int) -> Unit
) :
    ListAdapter<String, RecentRequestAdapter.SearchViewHolder>(
        DiffUtilItemCallback()
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchViewHolder {
        return SearchViewHolder(
            ItemRecentRequestBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class SearchViewHolder(private val binding: ItemRecentRequestBinding) :
        ViewHolder(binding.root) {
        fun onBind(book: String) {
            binding.tvNameBook.text = book
            binding.ivRemove.setOnClickListener {
                onClickRemove(adapterPosition)
                notifyItemChanged(adapterPosition)
            }
            itemView.setOnClickListener {
                onClick(book)
            }
        }
    }

    private class DiffUtilItemCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem.length == newItem.length
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }
}
