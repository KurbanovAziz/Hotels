package com.example.kitepkana.presentation.ui.fragments.authorization

import android.os.Build
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitepkana.R
import com.example.kitepkana.databinding.FragmentMainAuthorizationBinding
import com.example.kitepkana.presentation.base.BaseFragment

class MainAuthorizationFragment : BaseFragment(R.layout.fragment_main_authorization) {

    private val binding by viewBinding (FragmentMainAuthorizationBinding::bind)

    override fun initialize() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            requireActivity().window.statusBarColor = resources.getColor(R.color.dark_green)
        }
    }

    override fun setupListeners() {
        binding.btnAuth.setOnClickListener {
            findNavController().navigate(R.id.authorizationTwoFragment2, bundleOf(ARGS_WAY_AUTH to "auth"))
        }
        binding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.authorizationTwoFragment2, bundleOf(ARGS_WAY_AUTH to "register"))
        }
    }

    companion object{
        const val ARGS_WAY_AUTH = "way_auth"
    }

}