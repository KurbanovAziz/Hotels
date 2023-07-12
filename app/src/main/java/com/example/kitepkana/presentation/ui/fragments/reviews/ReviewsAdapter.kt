package com.example.kitepkana.presentation.ui.fragments.reviews

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.kitepkana.R
import com.example.kitepkana.databinding.ItemReviewsBinding
import com.example.kitepkana.domain.model.Reviews
import com.example.kitepkana.presentation.utils.loadImage

class ReviewsAdapter(
) :
    ListAdapter<com.example.kitepkana.domain.model.Reviews, ReviewsAdapter.ReviewsViewHolder>(DiffUtilNoteItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewsViewHolder {
        return ReviewsViewHolder(
            ItemReviewsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ReviewsViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class ReviewsViewHolder(private val binding: ItemReviewsBinding) :
        ViewHolder(binding.root) {

        fun onBind(reviews: com.example.kitepkana.domain.model.Reviews) {
            binding.tvFullName.text = reviews.username
            binding.ivPhoto.loadImage(reviews.user_photo)
            binding.tvDate.text = reviews.created_date
            binding.tvRating.text = reviews.user_stars
            binding.tvReviews.text = reviews.text
            when (reviews.user_stars.toInt()) {
                0 -> {
                    binding.ivStar1.setImageResource(R.drawable.ic_star_outline)
                    binding.ivStar2.setImageResource(R.drawable.ic_star_outline)
                    binding.ivStar3.setImageResource(R.drawable.ic_star_outline)
                    binding.ivStar4.setImageResource(R.drawable.ic_star_outline)
                    binding.ivStar5.setImageResource(R.drawable.ic_star_outline)
                }
                1 -> {
                    binding.ivStar1.setImageResource(R.drawable.ic_star)
                    binding.ivStar2.setImageResource(R.drawable.ic_star_outline)
                    binding.ivStar3.setImageResource(R.drawable.ic_star_outline)
                    binding.ivStar4.setImageResource(R.drawable.ic_star_outline)
                    binding.ivStar5.setImageResource(R.drawable.ic_star_outline)
                }
                2 -> {
                    binding.ivStar1.setImageResource(R.drawable.ic_star)
                    binding.ivStar2.setImageResource(R.drawable.ic_star)
                    binding.ivStar3.setImageResource(R.drawable.ic_star_outline)
                    binding.ivStar4.setImageResource(R.drawable.ic_star_outline)
                    binding.ivStar5.setImageResource(R.drawable.ic_star_outline)
                }
                3 -> {
                    binding.ivStar1.setImageResource(R.drawable.ic_star)
                    binding.ivStar2.setImageResource(R.drawable.ic_star)
                    binding.ivStar3.setImageResource(R.drawable.ic_star)
                    binding.ivStar4.setImageResource(R.drawable.ic_star_outline)
                    binding.ivStar5.setImageResource(R.drawable.ic_star_outline)
                }
                4 -> {
                    binding.ivStar1.setImageResource(R.drawable.ic_star)
                    binding.ivStar2.setImageResource(R.drawable.ic_star)
                    binding.ivStar3.setImageResource(R.drawable.ic_star)
                    binding.ivStar4.setImageResource(R.drawable.ic_star)
                    binding.ivStar5.setImageResource(R.drawable.ic_star_outline)
                }
                5 -> {
                    binding.ivStar1.setImageResource(R.drawable.ic_star)
                    binding.ivStar2.setImageResource(R.drawable.ic_star)
                    binding.ivStar3.setImageResource(R.drawable.ic_star)
                    binding.ivStar4.setImageResource(R.drawable.ic_star)
                    binding.ivStar5.setImageResource(R.drawable.ic_star)
                }
            }
        }
    }

    private class DiffUtilNoteItemCallback : DiffUtil.ItemCallback<com.example.kitepkana.domain.model.Reviews>() {
        override fun areItemsTheSame(oldItem: com.example.kitepkana.domain.model.Reviews, newItem: com.example.kitepkana.domain.model.Reviews): Boolean {
            return oldItem.id == newItem.id
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: com.example.kitepkana.domain.model.Reviews, newItem: com.example.kitepkana.domain.model.Reviews): Boolean {
            return oldItem == newItem
        }
    }
}