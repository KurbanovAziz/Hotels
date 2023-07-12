package com.example.kitepkana.presentation.ui.fragments.reviews

import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitepkana.R
import com.example.kitepkana.databinding.FragmentReviewsBinding
import com.example.kitepkana.presentation.base.BaseFragment
import com.example.kitepkana.presentation.ui.fragments.library.LibraryFragment.Companion.ARGS_BOOK_ID
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReviewsFragment : BaseFragment(R.layout.fragment_reviews) {

    private val binding by viewBinding(FragmentReviewsBinding::bind)
    private val reviewsViewModel by lazy {
        ViewModelProvider(this)[ReviewsViewModel::class.java]
    }
    private val adapter by lazy { ReviewsAdapter() }
    private var id: Int? = 0

    override fun initialize() {
        id = arguments?.getInt(ARGS_BOOK_ID)
        binding.rvReviews.adapter = adapter
    }

    override fun setupRequests() {
        id.let { reviewsViewModel.getBook(it!!) }

    }

    override fun setupSubscribers() {
        reviewsViewModel.getBookState.collectUIState(
            state = {
            },
            onSuccess = {
                adapter.submitList(it.reviews)
            },
        )
    }

    override fun setupListeners() {
    }
}