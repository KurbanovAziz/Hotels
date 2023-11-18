package com.example.hotel.presentation.ui.fragments.rooms

import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.hotel.R
import com.example.hotel.databinding.FragmentRoomsBinding
import com.example.hotel.presentation.base.BaseFragment
import com.example.hotel.presentation.ui.fragments.hotels.HotelsFragment.Companion.ARGS_HOTEL_NAME
import com.example.hotel.presentation.ui.fragments.rooms.adapter.RoomsAdapter
import com.example.hotel.presentation.ui.fragments.rooms.viewmodel.RoomsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RoomsFragment : BaseFragment(R.layout.fragment_rooms) {

    private val binding by viewBinding(FragmentRoomsBinding::bind)
    private val viewModel by lazy {
        ViewModelProvider(this)[RoomsViewModel::class.java]
    }
    private val adapter by lazy { RoomsAdapter(this::onClick, requireContext()) }

    override fun initialize() {
        binding.rvRooms.adapter = adapter
        binding.includeCustomAppBar.tvName.text = arguments?.getString(ARGS_HOTEL_NAME)
    }

    private fun onClick(){
        findNavController().navigate(R.id.reservationFragment)
    }
    override fun setupListeners() {
        binding.includeCustomAppBar.ibBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun setupRequests() {
        viewModel.getRooms()
    }

    override fun initSubscribers() {
        viewModel.getRoomsState.collectUIState(
            state = {
                binding.progressBar.isVisible = true
                binding.rvRooms.isVisible = false
            },
            onSuccess = {
                binding.progressBar.isVisible = false
                binding.rvRooms.isVisible = true
                adapter.submitList(it.rooms)
            }
        )
    }

}