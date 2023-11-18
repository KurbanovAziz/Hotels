package com.example.hotel.presentation.ui.fragments.reservations


import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.hotel.R
import com.example.hotel.databinding.FragmentReservationBinding
import com.example.hotel.presentation.base.BaseFragment
import com.example.hotel.presentation.ui.fragments.reservations.adapter.ReservationAdapter
import com.example.hotel.presentation.ui.fragments.reservations.viewmodel.ReservationViewModel
import com.example.hotel.presentation.utils.showToast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReservationsFragment : BaseFragment(R.layout.fragment_reservation) {

    private val binding by viewBinding(FragmentReservationBinding::bind)
    private val adapter by lazy {
        ReservationAdapter(
            binding.btnPay,
            findNavController(),
            requireContext()
        )
    }
    private val viewModel by lazy {
        ViewModelProvider(this)[ReservationViewModel::class.java]
    }

    override fun initialize() {
        binding.rvReservation.adapter = adapter
        binding.includeCustomAppBar.tvName.text = getString(R.string.reservation)
    }

    override fun setupRequests() {
        viewModel.getReservation()
    }

    override fun initSubscribers() {
        viewModel.getReservationState.collectUIState(
            state = {
                binding.progressBar.isVisible = true
                binding.rvReservation.isVisible = false
                binding.flBtn.isVisible = false
            },
            onSuccess = {
                binding.progressBar.isVisible = false
                binding.rvReservation.isVisible = true
                binding.flBtn.isVisible = true
                adapter.submitList(listOf(it))
                binding.btnPay.text =
                    getString(
                        R.string.paid_price,
                        it.tour_price + it.fuel_charge + it.service_charge
                    )
            }
        )
    }

    override fun setupListeners() {
        binding.includeCustomAppBar.ibBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}