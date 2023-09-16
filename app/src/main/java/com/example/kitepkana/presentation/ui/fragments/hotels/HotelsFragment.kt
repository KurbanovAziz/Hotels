package com.example.kitepkana.presentation.ui.fragments.hotels

import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitepkana.R
import com.example.kitepkana.databinding.FragmentHotelsBinding
import com.example.kitepkana.presentation.base.BaseFragment
import com.example.kitepkana.presentation.ui.fragments.hotels.adapter.HotelSliderAdapter
import com.example.kitepkana.presentation.ui.fragments.hotels.viewmodel.HotelsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HotelsFragment : BaseFragment(R.layout.fragment_hotels) {
    private val binding by viewBinding(FragmentHotelsBinding::bind)
    private val hotelsViewModel by lazy {
        ViewModelProvider(this)[HotelsViewModel::class.java]
    }
    private val adapter by lazy { HotelSliderAdapter() }


    override fun initialize() {
        binding.imageHotelPager.adapter = adapter
    }

    override fun setupRequests() {
        hotelsViewModel.getHotels()
    }

    override fun setupSubscribers() {
        hotelsViewModel.getHotelsState.collectUIState(
            state = {},
            onSuccess = {
                adapter.addData(it)
                binding.tvTitle.text = it.name
                binding.tvLocation.text = it.adress
                binding.tvPrice.text = "от ${it.minimal_price} ₽"
                binding.tvPriceForIt.text = it.price_for_it
                binding.tvRating.text = it.rating.toString()
                binding.tvRatingName.text = it.rating_name
                binding.tvDesc.text = it.about_the_hotel.description
            }
        )
    }

    override fun setupListeners() {
        binding.indicator.setViewPager(binding.imageHotelPager)
    }

    override fun initSubscribers() {
    }
}