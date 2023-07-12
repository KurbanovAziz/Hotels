package com.example.kitepkana.presentation.ui.fragments.book

import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitepkana.R
import com.example.kitepkana.data.local.AppPrefs
import com.example.kitepkana.databinding.FragmentBookBinding
import com.example.kitepkana.domain.model.AddFavorite
import com.example.kitepkana.domain.model.CreateReviews
import com.example.kitepkana.presentation.base.BaseFragment
import com.example.kitepkana.presentation.ui.fragments.library.LibraryFragment.Companion.ARGS_BOOK_ID
import com.example.kitepkana.presentation.ui.fragments.library.ListHorizontalBooksAdapter
import com.example.kitepkana.presentation.utils.UIState
import com.example.kitepkana.presentation.utils.loadImage
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BookFragment : BaseFragment(R.layout.fragment_book) {

    @Inject
    lateinit var appPrefs: AppPrefs

    private val binding by viewBinding(FragmentBookBinding::bind)
    private val bookViewModel by lazy {
        ViewModelProvider(this)[BookViewModel::class.java]
    }
    private val adapter by lazy { ListHorizontalBooksAdapter(this::onClick) }
    private var id: Int? = 0
    private var star: Double = 0.0

    override fun initialize() {
        id = arguments?.getInt(ARGS_BOOK_ID)
        binding.rvRecentlyWatched.adapter = adapter
    }

    override fun setupRequests() {
        id?.let { bookViewModel.getBook(it) }
    }

    override fun setupSubscribers() {
        bookViewModel.getBookState.collectUIState(
            state = {
                binding.progressBar.isVisible = true
                binding.bookLayout.isVisible = false
            },
            onSuccess = {
                binding.progressBar.isVisible = false
                binding.bookLayout.isVisible = true
                binding.tvTitle.text = it.title
                binding.tvAuthor.text = it.author_name
                binding.tvGenre.text = it.genre[0].genre_name
                binding.tvRating.text = it.middle_star.toString()
                binding.ivBook.loadImage(it.cover)
                binding.tvSummary.text = it.summary
                binding.tvPublicationYear.text = it.publication_year
                adapter.submitList(it.similar_books)
            },
        )
        bookViewModel.addFavoriteState.collectUIState(
            state = {

            },
            onSuccess = {
            }
        )
        bookViewModel.deleteFavoriteState.collectUIState(
            state = {

            },
            onSuccess = {

            }
        )
        bookViewModel.createReviewsState.collectUIState(
            state = {},
            onSuccess = {
                binding.tvReviewBook.isVisible = false
                binding.edLayoutReviews.isVisible = false
                binding.btnSend.isVisible = false
                binding.tvReviews.isVisible = true
                binding.tvReviews.text = it.text
                binding.tvRatingReviews.text = it.star.toString()
            }
        )
    }

    override fun setupListeners() {
        createStar()
        binding.ivFavorites.setOnClickListener {
                bookViewModel.addFavorite(com.example.kitepkana.domain.model.AddFavorite(id!!))
                binding.ivFavorites.setImageResource(R.drawable.ic_favorites)
        }
        binding.tvAllReviews.setOnClickListener {
            findNavController().navigate(R.id.reviewsFragment, bundleOf(ARGS_BOOK_ID to id))
        }
        binding.ivBack.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.btnRead.setOnClickListener {
            findNavController().navigate(R.id.openBookFragment, bundleOf(ARGS_BOOK_ID to id))
        }
        binding.btnSend.setOnClickListener {
            bookViewModel.createReviews(
                com.example.kitepkana.domain.model.CreateReviews(
                    id!!, star, binding.edReviews.text.toString()
                )
            )
        }
    }

    private fun createStar() {
        binding.ivStar1.setOnClickListener {
            star = 1.0
            binding.ivStar1.setImageResource(R.drawable.ic_star)
            binding.ivStar2.setImageResource(R.drawable.ic_star_outline)
            binding.ivStar3.setImageResource(R.drawable.ic_star_outline)
            binding.ivStar4.setImageResource(R.drawable.ic_star_outline)
            binding.ivStar5.setImageResource(R.drawable.ic_star_outline)
            binding.tvRatingReviews.text = star.toString()
        }
        binding.ivStar2.setOnClickListener {
            star = 2.0
            binding.ivStar1.setImageResource(R.drawable.ic_star)
            binding.ivStar2.setImageResource(R.drawable.ic_star)
            binding.ivStar3.setImageResource(R.drawable.ic_star_outline)
            binding.ivStar4.setImageResource(R.drawable.ic_star_outline)
            binding.ivStar5.setImageResource(R.drawable.ic_star_outline)
            binding.tvRatingReviews.text = star.toString()
        }
        binding.ivStar3.setOnClickListener {
            star = 3.0
            binding.ivStar1.setImageResource(R.drawable.ic_star)
            binding.ivStar2.setImageResource(R.drawable.ic_star)
            binding.ivStar3.setImageResource(R.drawable.ic_star)
            binding.ivStar4.setImageResource(R.drawable.ic_star_outline)
            binding.ivStar5.setImageResource(R.drawable.ic_star_outline)
            binding.tvRatingReviews.text = star.toString()
        }
        binding.ivStar4.setOnClickListener {
            star = 4.0
            binding.ivStar1.setImageResource(R.drawable.ic_star)
            binding.ivStar2.setImageResource(R.drawable.ic_star)
            binding.ivStar3.setImageResource(R.drawable.ic_star)
            binding.ivStar4.setImageResource(R.drawable.ic_star)
            binding.ivStar5.setImageResource(R.drawable.ic_star_outline)
            binding.tvRatingReviews.text = star.toString()
        }
        binding.ivStar5.setOnClickListener {
            star = 5.0
            binding.ivStar1.setImageResource(R.drawable.ic_star)
            binding.ivStar2.setImageResource(R.drawable.ic_star)
            binding.ivStar3.setImageResource(R.drawable.ic_star)
            binding.ivStar4.setImageResource(R.drawable.ic_star)
            binding.ivStar5.setImageResource(R.drawable.ic_star)
            binding.tvRatingReviews.text = star.toString()
        }
    }

    private fun onClick(position: Int) {
        findNavController().navigate(R.id.bookFragment, bundleOf(ARGS_BOOK_ID to position))
    }
}