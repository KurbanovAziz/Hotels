package com.example.kitepkana.presentation.ui.fragments.book.open

import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitepkana.R
import com.example.kitepkana.data.local.AppPrefs
import com.example.kitepkana.databinding.FragmentReadBookBinding
import com.example.kitepkana.presentation.base.BaseFragment
import com.example.kitepkana.presentation.ui.fragments.library.LibraryFragment.Companion.ARGS_BOOK_ID
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ReadBookFragment : BaseFragment(R.layout.fragment_read_book) {

    @Inject
    lateinit var appPrefs: AppPrefs
    private val binding by viewBinding(FragmentReadBookBinding::bind)
    private val readBookViewModel by lazy {
        ViewModelProvider(this)[ReadBookViewModel::class.java]
    }
    private val adapter by lazy { ReadBookAdapter(ArrayList()) }
    private var id: Int? = null
    private var page: Int = 1

    override fun initialize() {
        binding.rvOpenBook.adapter = adapter
        binding.rvOpenBook.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                if (position == adapter.itemCount - 1) {
                    page++
                    appPrefs.page = page
                    appPrefs.id = id!!
                    id?.let { readBookViewModel.getReadBook(id = it, page = page) }
                    binding.scrollView.scrollTo(0, 0)
                }
            }
        })
    }

    override fun setupRequests() {
        id = arguments?.getInt(ARGS_BOOK_ID)
        id?.let { readBookViewModel.getReadBook(id = it, page = page) }
    }

    override fun setupSubscribers() {
        getReadBook()
    }

    private fun getReadBook() {

        readBookViewModel.getReadBookState.collectUIState(
            onSuccess = {
                adapter.addData(it.results)
                binding.tvPage.text = page.toString()
                binding.tvCount.text = it.count.toString()
            }
        )
    }

    override fun setupListeners() {
        binding.root.setOnClickListener {
            if (binding.customToolbar.visibility == View.GONE) {
                binding.customToolbar.visibility = View.VISIBLE
            } else {
                binding.customToolbar.visibility = View.GONE
            }
        }
        binding.ivBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}
