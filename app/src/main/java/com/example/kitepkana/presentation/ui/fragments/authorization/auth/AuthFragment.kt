package com.example.kitepkana.presentation.ui.fragments.authorization.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitepkana.R
import com.example.kitepkana.databinding.FragmentAuthBinding
import com.example.kitepkana.databinding.FragmentRegisterBinding
import com.example.kitepkana.presentation.base.BaseFragment
import com.example.kitepkana.presentation.ui.fragments.authorization.AuthorizationTwoFragment
import kotlin.properties.Delegates


class AuthFragment : BaseFragment(R.layout.fragment_auth) {

    private val binding by viewBinding(FragmentAuthBinding::bind)
    private var auth by Delegates.notNull<String>()
    override fun initialize() {
        auth = arguments?.getString(AuthorizationTwoFragment.ARGS_AUTH)!!
    }

    override fun setupListeners() {
        if (auth == "phone") {
            binding.tvPhoneAndEmail.text = getString(R.string.number_phone)
        } else {
            binding.tvPhoneAndEmail.text = getString(R.string.email)
        }
    }

}