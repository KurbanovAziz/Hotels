package com.example.kitepkana.presentation.ui.fragments.profile.settings

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitepkana.R
import com.example.kitepkana.data.local.AppPrefs
import com.example.kitepkana.databinding.FragmentSettingsBinding
import com.example.kitepkana.presentation.base.BaseFragment
import com.example.kitepkana.presentation.ui.fragments.profile.ProfileViewModel
import com.example.kitepkana.presentation.utils.loadImage
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SettingsFragment : BaseFragment(R.layout.fragment_settings) {

    private val binding by viewBinding(FragmentSettingsBinding::bind)
    private val settingsViewModel by lazy {
        ViewModelProvider(this)[ProfileViewModel::class.java]
    }

    @Inject
    lateinit var appPrefs: AppPrefs

    override fun initialize() {
    }

    override fun setupRequests() {
        settingsViewModel.getProfile()
    }

    override fun setupSubscribers() {
        settingsViewModel.getProfileState.collectUIState(
            state = {

            },
            onSuccess = { profile ->
                binding.ivPhoto.loadImage(profile.user_photo)
                binding.tvGmail.text = profile.email
                binding.tvName.text = profile.username
            }
        )
    }


    override fun setupListeners() {
        super.setupListeners()
        binding.btnEditProfile.setOnClickListener {
            findNavController().navigate(R.id.infoFragment)
        }
        binding.btnLanguagesApp.setOnClickListener {
            findNavController().navigate(R.id.languagesFragment)
        }
        binding.btnPrivacyPolicy.setOnClickListener {
            findNavController().navigate(R.id.privacyFragment)
        }
        binding.btnWriteToSupport.setOnClickListener {
            findNavController().navigate(R.id.supportFragment)
        }
        binding.btnGoToWebsite.setOnClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://64a6a662b9883f1bec3a7a60--gilded-arithmetic-73b507.netlify.app/setting_users")
            )
            startActivity(browserIntent)
        }
        binding.ivBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}
