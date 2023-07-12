package com.example.kitepkana.presentation.ui.fragments.library

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kitepkana.databinding.ItemLibraryBinding

class LibraryAdapter(
    private val onClick: (position: Int) -> Unit
) : ListAdapter<Filter, LibraryAdapter.ViewHolder>(
    DiffUtilItemCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLibraryBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: LibraryAdapter.ViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemLibraryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(filter: Filter) {
            val adapter = ListHorizontalBooksAdapter(onClick)
            binding.rvBooks.adapter = adapter
            adapter.submitList(filter.books)

            binding.tvTitle.text = filter.title
        }
    }

    private class DiffUtilItemCallback : DiffUtil.ItemCallback<Filter>() {

        override fun areItemsTheSame(oldItem: Filter, newItem: Filter): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Filter, newItem: Filter): Boolean {
            return oldItem == newItem
        }
    }
}

