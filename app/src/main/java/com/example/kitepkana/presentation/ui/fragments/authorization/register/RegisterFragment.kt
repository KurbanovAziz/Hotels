package com.example.kitepkana.presentation.ui.fragments.authorization.register

import android.text.InputType
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitepkana.R
import com.example.kitepkana.databinding.FragmentRegisterBinding
import com.example.kitepkana.domain.model.authorization.RegisterUsers
import com.example.kitepkana.presentation.base.BaseFragment
import com.example.kitepkana.presentation.utils.showToast
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RegisterFragment : BaseFragment(R.layout.fragment_register) {

    private val binding by viewBinding(FragmentRegisterBinding::bind)
    private val profileViewModel by lazy {
        ViewModelProvider(this)[RegisterViewModel::class.java]
    }

    override fun initialize() {

    }

    override fun setupSubscribers() {
        profileViewModel.registerUsersState.collectUIState(
            onSuccess = {
                findNavController().navigate(
                    R.id.activationFragment,
                    bundleOf(ARGS_EMAIL to binding.edEmail.text.toString())
                )
                requireContext().showToast(getString(R.string.code_send_to_you_email))
            }
        )
    }

    override fun setupListeners() {
        binding.btnRegister.setOnClickListener {
            if (!binding.checkboxOption1.isChecked) {
                requireActivity().showToast(getString(R.string.please_accept_the_terms_and_privacy_policy))
                return@setOnClickListener
            } else {
                profileViewModel.registerUsers(
                    RegisterUsers(
                        username = getString(R.string.user),
                        email = binding.edEmail.text.toString(),
                        password = binding.edPassword.text.toString(),
                        re_password = binding.edRePassword.text.toString()
                    )

                )
            }
        }
        binding.btnAuth.setOnClickListener {
            findNavController().navigate(R.id.authFragment)
        }

        binding.passwordVisibility.setOnClickListener {
            if (binding.edPassword.inputType == (InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)) {
                binding.edPassword.inputType = InputType.TYPE_CLASS_TEXT
                binding.passwordVisibility.setImageResource(R.drawable.ic_visibility_off)
            } else {
                binding.edPassword.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                binding.passwordVisibility.setImageResource(R.drawable.ic_visibility)
            }

            binding.edPassword.text?.let { binding.edPassword.setSelection(it.length) }
        }
        binding.rePasswordVisibility.setOnClickListener {
            if (binding.edRePassword.inputType == (InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)) {
                binding.edRePassword.inputType = InputType.TYPE_CLASS_TEXT
                binding.rePasswordVisibility.setImageResource(R.drawable.ic_visibility_off)
            } else {
                binding.edRePassword.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                binding.rePasswordVisibility.setImageResource(R.drawable.ic_visibility)
            }

            binding.edRePassword.text?.let { binding.edRePassword.setSelection(it.length) }
        }
    }
    companion object{
        const val ARGS_EMAIL = "email"
    }
}