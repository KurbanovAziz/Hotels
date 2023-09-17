package com.example.kitepkana.presentation.ui.fragments.tours

import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitepkana.R
import com.example.kitepkana.databinding.FragmentHotelsBinding
import com.example.kitepkana.presentation.base.BaseFragment
import com.example.kitepkana.presentation.ui.fragments.tours.adapter.HotelSliderAdapter
import com.example.kitepkana.presentation.ui.fragments.tours.viewmodel.HotelsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HotelsFragment : BaseFragment(R.layout.fragment_hotels) {

    private val binding by viewBinding(FragmentHotelsBinding::bind)
    private val hotelsViewModel by lazy {
        ViewModelProvider(this)[HotelsViewModel::class.java]
    }
    private val adapter by lazy { HotelSliderAdapter() }


    override fun initialize() {
       // binding.imageHotelPager.adapter = adapter
    }

    override fun setupRequests() {
    }

    override fun setupSubscribers() {
    }

    override fun setupListeners() {
      //  binding.indicator.setViewPager(binding.imageHotelPager)
    }

    override fun initSubscribers() {
    }
}