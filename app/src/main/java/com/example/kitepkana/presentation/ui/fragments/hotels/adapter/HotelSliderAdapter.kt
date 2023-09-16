package com.example.kitepkana.presentation.ui.fragments.hotels.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.kitepkana.databinding.ItemSliderImageBinding
import com.example.kitepkana.domain.entities.Hotels
import com.example.kitepkana.presentation.utils.loadImage

class HotelSliderAdapter() : RecyclerView.Adapter<HotelSliderAdapter.OnBoardingViewHolder>() {

    private val data = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemSliderImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    fun addData(dat: Hotels) {
        this.data.clear()
        this.data.addAll(dat.image_urls)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class OnBoardingViewHolder(private val binding: ItemSliderImageBinding) :
        ViewHolder(binding.root) {
        fun bind(hotels: String) {
            binding.ivHotel.loadImage(hotels)
            Log.e("ololo", "bind: ${hotels}", )
        }
    }
}