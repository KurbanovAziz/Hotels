package com.example.kitepkana.presentation.ui.fragments.book.open

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kitepkana.databinding.ItemReadBookBinding
import com.example.kitepkana.domain.model.ResultD2

class ReadBookAdapter(private val data: MutableList<ResultD2>) :
    RecyclerView.Adapter<ReadBookAdapter.ReviewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewsViewHolder {
        val binding = ItemReadBookBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ReviewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReviewsViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun addData(newData: List<ResultD2>) {
        data.addAll(newData)
        notifyDataSetChanged()
    }

    inner class ReviewsViewHolder(private val binding: ItemReadBookBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(resultD: ResultD2) {
            binding.tvBookText.text = resultD.text
        }
    }
}
