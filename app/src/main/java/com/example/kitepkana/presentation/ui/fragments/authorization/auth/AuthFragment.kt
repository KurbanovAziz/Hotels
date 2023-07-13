package com.example.kitepkana.presentation.ui.fragments.authorization.auth

import android.text.InputType
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitepkana.R
import com.example.kitepkana.data.local.AppPrefs
import com.example.kitepkana.databinding.FragmentAuthBinding
import com.example.kitepkana.presentation.base.BaseFragment
import com.example.kitepkana.presentation.utils.showToast
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AuthFragment : BaseFragment(R.layout.fragment_auth) {

    private val binding by viewBinding(FragmentAuthBinding::bind)
    private val authViewModel by lazy {
        ViewModelProvider(this)[AuthViewModel::class.java]
    }

    @Inject
    lateinit var appPrefs: AppPrefs

    override fun initialize() {
    }

    override fun setupSubscribers() {
        authViewModel.createJwtTokenState.collectUIState(
            onSuccess = {
                requireContext().showToast(getString(R.string.you_access_enter_your_account))
                findNavController().navigate(R.id.library)
            },
        )
    }

    override fun setupListeners() {
        binding.btnSignIn.setOnClickListener {
            authViewModel.getJwt(
                com.example.kitepkana.domain.model.authorization.CreateJwtToken(
                    binding.edEmail.text.toString(),
                    binding.edPassword.text.toString()
                )
            )
        }
        binding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.registerFragment)
        }
        binding.tvRestore.setOnClickListener {
            findNavController().navigate(R.id.restoreFragment)
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
    }

}