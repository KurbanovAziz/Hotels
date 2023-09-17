package com.example.kitepkana.presentation.ui.fragments.authorization.register

import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitepkana.R
import com.example.kitepkana.databinding.FragmentRegisterBinding
import com.example.kitepkana.presentation.base.BaseFragment
import com.example.kitepkana.presentation.ui.fragments.authorization.AuthorizationTwoFragment.Companion.ARGS_AUTH
import kotlin.properties.Delegates

class RegisterFragment : BaseFragment(R.layout.fragment_register) {

    private val binding by viewBinding(FragmentRegisterBinding::bind)
    private var auth by Delegates.notNull<String>()
    override fun initialize() {
        auth = arguments?.getString(ARGS_AUTH)!!
    }

    override fun setupListeners() {
        if (auth == "phone") {
            binding.tvPhoneAndEmail.text = getString(R.string.number_phone)
        } else {
            binding.tvPhoneAndEmail.text = getString(R.string.email)
        }
    }

}