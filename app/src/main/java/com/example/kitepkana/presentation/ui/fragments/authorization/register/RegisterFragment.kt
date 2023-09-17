package com.example.kitepkana.presentation.ui.fragments.authorization.register

import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitepkana.R
import com.example.kitepkana.databinding.FragmentRegisterBinding
import com.example.kitepkana.domain.entities.Registration
import com.example.kitepkana.domain.entities.Users
import com.example.kitepkana.presentation.base.BaseFragment
import com.example.kitepkana.presentation.ui.fragments.authorization.AuthorizationTwoFragment.Companion.ARGS_AUTH
import dagger.hilt.android.AndroidEntryPoint
import kotlin.properties.Delegates

@AndroidEntryPoint
class RegisterFragment : BaseFragment(R.layout.fragment_register) {

    private val binding by viewBinding(FragmentRegisterBinding::bind)
    private val viewModel by lazy { ViewModelProvider(this)[RegisterViewModel::class.java] }
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

    override fun setupRequests() {
        binding.btnRegister.setOnClickListener {
            viewModel.registrationUsers(
                Registration(
                    first_name = Users(
                        title = binding.edName.text.toString()
                    ),
                    last_name = Users(
                        title = binding.edLast.text.toString()
                    ),
                    email = Users(
                        title = binding.edPhoneAndEmail.text.toString()
                    )
                )
            )
        }
    }

    override fun initSubscribers() {
        viewModel.registrationUsersState.collectUIState(
            state = {},
            onSuccess = {
                Toast.makeText(requireContext(), "ffkf", Toast.LENGTH_SHORT).show()
            }
        )
    }


}