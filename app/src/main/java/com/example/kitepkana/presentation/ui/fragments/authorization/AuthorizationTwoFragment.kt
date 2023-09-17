package com.example.kitepkana.presentation.ui.fragments.authorization

import android.os.Build
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitepkana.R
import com.example.kitepkana.databinding.FragmentAuthorizationTwoBinding
import com.example.kitepkana.presentation.base.BaseFragment
import com.example.kitepkana.presentation.ui.fragments.authorization.MainAuthorizationFragment.Companion.ARGS_WAY_AUTH
import kotlin.properties.Delegates


class AuthorizationTwoFragment : BaseFragment(R.layout.fragment_authorization_two) {

    private val binding by viewBinding(FragmentAuthorizationTwoBinding::bind)
    private var wayAuth by Delegates.notNull<String>()


    override fun initialize() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            requireActivity().window.statusBarColor = resources.getColor(R.color.dark_green)
        }
        wayAuth = arguments?.getString(ARGS_WAY_AUTH)!!
    }

    override fun setupListeners() {
        binding.btnAuthPhone.setOnClickListener {
            if (wayAuth == "auth") {
                findNavController().navigate(R.id.authFragment, bundleOf(ARGS_AUTH to "phone"))
            } else {
                findNavController().navigate(R.id.registerFragment, bundleOf(ARGS_AUTH to "phone"))
            }
        }
        binding.btnEmail.setOnClickListener {
            if (wayAuth == "auth") {
                findNavController().navigate(R.id.authFragment, bundleOf(ARGS_AUTH to "email"))
            } else {
                findNavController().navigate(R.id.registerFragment, bundleOf(ARGS_AUTH to "email"))
            }
        }
    }

    companion object {
        const val ARGS_AUTH = "auth"
    }
}