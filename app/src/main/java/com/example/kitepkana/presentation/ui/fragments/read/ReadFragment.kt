package com.example.kitepkana.presentation.ui.fragments.read

import com.example.kitepkana.presentation.ui.fragments.book.open.ReadBookAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitepkana.R
import com.example.kitepkana.data.local.AppPrefs
import com.example.kitepkana.databinding.FragmentReadBinding
import com.example.kitepkana.presentation.base.BaseFragment
import com.example.kitepkana.presentation.ui.fragments.book.open.ReadBookViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ReadFragment : BaseFragment(R.layout.fragment_read) {

    @Inject
    lateinit var appPrefs: AppPrefs
    private val binding by viewBinding(FragmentReadBinding::bind)
    private val readBookViewModel by lazy {
        ViewModelProvider(this)[ReadBookViewModel::class.java]
    }
    private val adapter by lazy { ReadBookAdapter(ArrayList()) }

    override fun initialize() {
        binding.rvOpenBook.adapter = adapter
        binding.rvOpenBook.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                if (position == adapter.itemCount - 1) {
                    readBookViewModel.getReadBook(appPrefs.id, appPrefs.page++)
                    binding.scrollView.scrollTo(0, 0)
                }
            }
        })
    }

    override fun setupRequests() {
        readBookViewModel.getReadBook(appPrefs.id, appPrefs.page)
    }

    override fun setupSubscribers() {
        getReadBook()
    }

    private fun getReadBook() {

        readBookViewModel.getReadBookState.collectUIState(
            onSuccess = {
                adapter.addData(it.results)
            }
        )
    }
}