package com.example.hotel.presentation.ui.fragments.paid

import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.hotel.R
import com.example.hotel.databinding.FragmentPaidBinding
import com.example.hotel.presentation.base.BaseFragment

class PaidFragment : BaseFragment(R.layout.fragment_paid) {

    private val binding by viewBinding(FragmentPaidBinding::bind)

    override fun initialize() {
        binding.tvConfirm.text =
            getString(R.string.confirmation_of_an_order, (1000..1000000).random())
        binding.includeCustomAppBar.tvName.text = getString(R.string.order_has_been_paid)
    }

    override fun setupListeners() {
        binding.btnSuper.setOnClickListener {
            findNavController().popBackStack(R.id.hotelsFragment, false)
        }
        binding.includeCustomAppBar.ibBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

}