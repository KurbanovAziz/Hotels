package com.example.kitepkana.presentation.ui.events

import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitepkana.R
import com.example.kitepkana.databinding.FragmentEventsBinding
import com.example.kitepkana.presentation.base.BaseFragment

class EventsFragment : BaseFragment(R.layout.fragment_events) {

    private val binding by viewBinding(FragmentEventsBinding::bind)

    override fun initialize() {
        super.initialize()
    }
}