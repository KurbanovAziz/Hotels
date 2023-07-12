package com.example.kitepkana.presentation.ui.fragments.library

import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitepkana.R
import com.example.kitepkana.databinding.FragmentLibraryBinding
import com.example.kitepkana.presentation.base.BaseFragment
import com.example.kitepkana.presentation.utils.UIState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LibraryFragment : BaseFragment(R.layout.fragment_library) {

    private val binding by viewBinding(FragmentLibraryBinding::bind)
    private val libraryViewModel by lazy {
        ViewModelProvider(this)[LibraryViewModel::class.java]
    }
    private val adapter by lazy { LibraryAdapter(this::onClick) }

    private var allBooksFilter = Filter()
    private var recommendedBooksFilter = Filter()


    override fun initialize() {
        binding.rvLibrary.adapter = adapter
    }

    override fun setupRequests() {
        libraryViewModel.getBooks()
        libraryViewModel.getRecommendedBooks()
    }

    override fun setupSubscribers() {
        libraryViewModel.getBooksState.collectUIState(
            state = {
                binding.progressBar.isVisible = it is UIState.Loading
            },
            onSuccess = {
                allBooksFilter = Filter(title = "Все книги", books = it)
            },
        )
        libraryViewModel.getRecommendedBooksState.collectUIState(
            state = {
                binding.progressBar.isVisible = it is UIState.Loading
            },
            onSuccess = {
                recommendedBooksFilter = Filter(
                    title =
                    "Рекомендации", books = it
                )
                adapter.submitList(listOf(recommendedBooksFilter,allBooksFilter))
            },
        )
    }

    override fun initSubscribers() {
    }

    private fun onClick(position: Int) {
        findNavController().navigate(R.id.bookFragment, bundleOf(ARGS_BOOK_ID to position))
    }

    companion object {
        const val ARGS_BOOK_ID = "bookID"
    }
}