package com.example.kitepkana.presentation.ui.fragments.profile.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.kitepkana.R
import com.example.kitepkana.databinding.ItemFinishBinding
import com.example.kitepkana.domain.model.Books
import com.example.kitepkana.presentation.utils.loadImage

class FinishAdapter(val onClick: (position: Int) -> Unit) :
    ListAdapter<com.example.kitepkana.domain.model.Books, FinishAdapter.FavoritesViewHolder>(DiffUtilNoteItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        return FavoritesViewHolder(
            ItemFinishBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class FavoritesViewHolder(private val binding: ItemFinishBinding) :
        ViewHolder(binding.root) {
        fun onBind(books: com.example.kitepkana.domain.model.Books) {
            binding.ivBook.loadImage(books.cover)
            binding.tvNameBook.text = books.title
            binding.tvAuthorBook.text = books.author_name
            binding.tvRating.text = books.middle_star.toString()

            itemView.setOnClickListener {
                onClick(books.id)
            }
            when (books.middle_star) {
                0.0 -> {
                    binding.ivStar1.setImageResource(R.drawable.ic_star_outline)
                    binding.ivStar2.setImageResource(R.drawable.ic_star_outline)
                    binding.ivStar3.setImageResource(R.drawable.ic_star_outline)
                    binding.ivStar4.setImageResource(R.drawable.ic_star_outline)
                    binding.ivStar5.setImageResource(R.drawable.ic_star_outline)
                }
                1.0 -> {
                    binding.ivStar1.setImageResource(R.drawable.ic_star)
                    binding.ivStar2.setImageResource(R.drawable.ic_star_outline)
                    binding.ivStar3.setImageResource(R.drawable.ic_star_outline)
                    binding.ivStar4.setImageResource(R.drawable.ic_star_outline)
                    binding.ivStar5.setImageResource(R.drawable.ic_star_outline)
                }
                2.0 -> {
                    binding.ivStar1.setImageResource(R.drawable.ic_star)
                    binding.ivStar2.setImageResource(R.drawable.ic_star)
                    binding.ivStar3.setImageResource(R.drawable.ic_star_outline)
                    binding.ivStar4.setImageResource(R.drawable.ic_star_outline)
                    binding.ivStar5.setImageResource(R.drawable.ic_star_outline)
                }
                3.0 -> {
                    binding.ivStar1.setImageResource(R.drawable.ic_star)
                    binding.ivStar2.setImageResource(R.drawable.ic_star)
                    binding.ivStar3.setImageResource(R.drawable.ic_star)
                    binding.ivStar4.setImageResource(R.drawable.ic_star_outline)
                    binding.ivStar5.setImageResource(R.drawable.ic_star_outline)
                }
                4.0 -> {
                    binding.ivStar1.setImageResource(R.drawable.ic_star)
                    binding.ivStar2.setImageResource(R.drawable.ic_star)
                    binding.ivStar3.setImageResource(R.drawable.ic_star)
                    binding.ivStar4.setImageResource(R.drawable.ic_star)
                    binding.ivStar5.setImageResource(R.drawable.ic_star_outline)
                }
                5.0 -> {
                    binding.ivStar1.setImageResource(R.drawable.ic_star)
                    binding.ivStar2.setImageResource(R.drawable.ic_star)
                    binding.ivStar3.setImageResource(R.drawable.ic_star)
                    binding.ivStar4.setImageResource(R.drawable.ic_star)
                    binding.ivStar5.setImageResource(R.drawable.ic_star)
                }
            }
        }
    }

    private class DiffUtilNoteItemCallback : DiffUtil.ItemCallback<com.example.kitepkana.domain.model.Books>() {
        override fun areItemsTheSame(oldItem: com.example.kitepkana.domain.model.Books, newItem: com.example.kitepkana.domain.model.Books): Boolean {
            return oldItem.id == newItem.id
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: com.example.kitepkana.domain.model.Books, newItem: com.example.kitepkana.domain.model.Books): Boolean {
            return oldItem == newItem
        }
    }
}