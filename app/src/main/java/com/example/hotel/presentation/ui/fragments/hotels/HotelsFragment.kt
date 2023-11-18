package com.example.hotel.presentation.ui.fragments.hotels

import android.view.View
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.hotel.R
import com.example.hotel.databinding.FragmentHotelsBinding
import com.example.hotel.presentation.base.BaseFragment
import com.example.hotel.presentation.ui.fragments.hotels.adapter.HotelsAdapter
import com.example.hotel.presentation.ui.fragments.hotels.viewmodel.HotelsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HotelsFragment : BaseFragment(R.layout.fragment_hotels) {

    private val binding by viewBinding(FragmentHotelsBinding::bind)
    private val hotelsViewModel by lazy {
        ViewModelProvider(this)[HotelsViewModel::class.java]
    }
    private val adapter by lazy { HotelsAdapter(requireContext()) }
    private var selectedHotelName: String? = null


    override fun initialize() {
        binding.rvHotels.adapter = adapter
        binding.includeCustomAppBar.ibBack.visibility = View.GONE
        binding.includeCustomAppBar.tvName.text = getString(R.string.hotel)
    }

    override fun setupRequests() {
        hotelsViewModel.getHotels()
    }

    override fun setupSubscribers() {
    }

    override fun setupListeners() {
        binding.btnToChooseNumber.setOnClickListener {
            selectedHotelName?.let { name ->
                findNavController().navigate(R.id.roomsFragment, bundleOf(ARGS_HOTEL_NAME to name))
            }
        }
    }

    override fun initSubscribers() {
        hotelsViewModel.getHotelsState.collectUIState(
            state = {
                binding.progressBar.isVisible = true
                binding.rvHotels.isVisible = false
                binding.flBtn.isVisible = false
            },
            onSuccess = {
                adapter.submitList(listOf(it))
                selectedHotelName = it.name
                binding.progressBar.isVisible = false
                binding.rvHotels.isVisible = true
                binding.flBtn.isVisible = true
            }
        )
    }

    companion object {
        const val ARGS_HOTEL_NAME = "hotel_name"
    }
}