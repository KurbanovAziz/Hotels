package com.example.kitepkana.presentation.ui.fragments.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitepkana.R
import com.example.kitepkana.data.local.AppPrefs
import com.example.kitepkana.databinding.FragmentOnBoardingBinding


class OnBoardingFragment : Fragment() {

    private val binding by viewBinding(FragmentOnBoardingBinding::bind)
    private lateinit var adapter: OnBoardingAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return inflater.inflate(R.layout.fragment_on_boarding, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = OnBoardingAdapter(
            requireContext(),
            this::clickSkip,
            this::clickRegister,
            this::clickLogin
        )
        binding.viewPager.adapter = adapter
        binding.indicator.setViewPager(binding.viewPager)
    }

    private fun clickSkip() {
        val pref = AppPrefs(requireContext())
        pref.onBoard = false
        findNavController().navigateUp()
    }

    private fun clickRegister() {
        val pref = AppPrefs(requireContext())
        pref.onBoard = false
        findNavController().navigate(R.id.registerFragment)
    }

    private fun clickLogin() {
        val pref = AppPrefs(requireContext())
        pref.onBoard = false
        findNavController().navigate(R.id.authFragment)
    }

}