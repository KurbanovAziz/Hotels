package com.example.kitepkana.presentation.ui.fragments.profile

import android.content.res.ColorStateList
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitepkana.R
import com.example.kitepkana.data.local.AppPrefs
import com.example.kitepkana.databinding.FragmentProfileBinding
import com.example.kitepkana.presentation.base.BaseFragment
import com.example.kitepkana.presentation.ui.fragments.library.LibraryFragment
import com.example.kitepkana.presentation.ui.fragments.profile.adapter.FavoritesAdapter
import com.example.kitepkana.presentation.ui.fragments.profile.adapter.FinishAdapter
import com.example.kitepkana.presentation.ui.fragments.profile.adapter.ReadingAdapter
import com.example.kitepkana.presentation.utils.loadImage
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ProfileFragment : BaseFragment(R.layout.fragment_profile) {

    private val binding by viewBinding(FragmentProfileBinding::bind)
    private val profileViewModel by lazy {
        ViewModelProvider(this)[ProfileViewModel::class.java]
    }
    private val favoritesAdapter by lazy { FavoritesAdapter(this::onClick) }
    private val readingAdapter by lazy { ReadingAdapter(this::onClick) }
    private val finishAdapter by lazy { FinishAdapter(this::onClick) }

    @Inject
    lateinit var appPrefs: AppPrefs

    override fun initialize() {
        binding.rvFavorites.adapter = favoritesAdapter
        binding.rvReading.adapter = readingAdapter
        binding.rvFinish.adapter = finishAdapter
    }

    override fun setupRequests() {
        profileViewModel.getProfile()
    }

    override fun setupSubscribers() {
        profileViewModel.getProfileState.collectUIState(
            state = {

            },
            onSuccess = { profile ->
                binding.ivPhoto.loadImage(profile.user_photo)
                binding.tvGmail.text = profile.email
                binding.tvName.text = profile.username
                favoritesAdapter.submitList(profile.favorite)
                readingAdapter.submitList(profile.reading)
                finishAdapter.submitList(profile.finish)
            }
        )
    }

    override fun setupListeners() {
        binding.ivSettings.setOnClickListener {
            findNavController().navigate(R.id.settingsFragment)
        }
        binding.btnFavorite.setOnClickListener {
            binding.btnFavorite.setTextColor(requireActivity().getColor(R.color.white))
            binding.btnFavorite.backgroundTintList =
                ColorStateList.valueOf(requireActivity().getColor(R.color.orange))
            binding.btnReading.setTextColor(requireActivity().getColor(R.color.orange))
            binding.btnReading.backgroundTintList =
                ColorStateList.valueOf(requireActivity().getColor(R.color.white))
            binding.btnFinish.setTextColor(requireActivity().getColor(R.color.orange))
            binding.btnFinish.backgroundTintList =
                ColorStateList.valueOf(requireActivity().getColor(R.color.white))
            binding.rvFavorites.isVisible = true
            binding.rvReading.isVisible = false
            binding.rvFinish.isVisible = false
        }
        binding.btnReading.setOnClickListener {
            binding.btnFavorite.setTextColor(requireActivity().getColor(R.color.orange))
            binding.btnFavorite.backgroundTintList =
                ColorStateList.valueOf(requireActivity().getColor(R.color.white))
            binding.btnReading.setTextColor(requireActivity().getColor(R.color.white))
            binding.btnReading.backgroundTintList =
                ColorStateList.valueOf(requireActivity().getColor(R.color.orange))
            binding.btnFinish.setTextColor(requireActivity().getColor(R.color.orange))
            binding.btnFinish.backgroundTintList =
                ColorStateList.valueOf(requireActivity().getColor(R.color.white))
            binding.rvFavorites.isVisible = false
            binding.rvReading.isVisible = true
            binding.rvFinish.isVisible = false
        }
        binding.btnFinish.setOnClickListener {
            binding.btnFavorite.setTextColor(requireActivity().getColor(R.color.orange))
            binding.btnFavorite.backgroundTintList =
                ColorStateList.valueOf(requireActivity().getColor(R.color.white))
            binding.btnReading.setTextColor(requireActivity().getColor(R.color.orange))
            binding.btnReading.backgroundTintList =
                ColorStateList.valueOf(requireActivity().getColor(R.color.white))
            binding.btnFinish.setTextColor(requireActivity().getColor(R.color.white))
            binding.btnFinish.backgroundTintList =
                ColorStateList.valueOf(requireActivity().getColor(R.color.orange))
            binding.rvFavorites.isVisible = false
            binding.rvReading.isVisible = false
            binding.rvFinish.isVisible = true
        }

    }

    private fun onClick(position: Int) {
        findNavController().navigate(R.id.bookFragment, bundleOf(LibraryFragment.ARGS_BOOK_ID to position))
    }
}