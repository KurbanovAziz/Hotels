package com.example.kitepkana.presentation.ui.fragments.search

import android.annotation.SuppressLint
import android.text.Editable
import android.text.TextWatcher
import android.view.MotionEvent
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitepkana.R
import com.example.kitepkana.data.local.AppPrefs
import com.example.kitepkana.databinding.FragmentSearchBinding
import com.example.kitepkana.presentation.base.BaseFragment
import com.example.kitepkana.presentation.ui.fragments.library.LibraryFragment.Companion.ARGS_BOOK_ID
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@Suppress("CAST_NEVER_SUCCEEDS")
@AndroidEntryPoint
class SearchFragment : BaseFragment(R.layout.fragment_search) {

    private val binding by viewBinding(FragmentSearchBinding::bind)
    private val searchViewModel by lazy {
        ViewModelProvider(this)[SearchViewModel::class.java]
    }
    private val searchAdapter by lazy { SearchAdapter(this::onClick) }
    private val recentRequestAdapter by lazy {
        RecentRequestAdapter(
            this::onClickAddTextSearch,
            this::onClickRemove
        )
    }
    private var searchList = arrayListOf<String>()

    @Inject
    lateinit var appPrefs: AppPrefs

    override fun initialize() {
        binding.rvSearch.adapter = searchAdapter
        binding.rvRecentRequest.adapter = recentRequestAdapter
    }

    override fun setupRequests() {

    }

    override fun setupSubscribers() {
        searchViewModel.searchFilterState.collectUIState(
            state = {},
            onSuccess = {
                searchAdapter.submitList(it)
            },
        )
    }

    private fun onClick(position: Int) {
        findNavController().navigate(R.id.bookFragment, bundleOf(ARGS_BOOK_ID to position))
    }

    private fun onClickAddTextSearch(book: String) {
        binding.edSearch.setText(book)
        binding.edSearch.text?.let { binding.edSearch.setSelection(it.length) }
        performSearch(binding.edSearch.text.toString())
    }

    private fun onClickRemove(pos: Int) {
        searchList.removeAt(pos)
    }

    private fun performSearch(query: String) {
        if (query.isNotEmpty()) {
            binding.rvSearch.isVisible = true
            searchViewModel.searchFilter(query)
        } else {
            binding.rvSearch.isVisible = false
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun setupListeners() {
        binding.edSearch.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {

                searchList.add(binding.edSearch.text.toString())
                recentRequestAdapter.submitList(searchList)

                val inputMethodManager = getSystemService(
                    requireContext(), InputMethodManager::class.java
                )
                inputMethodManager?.hideSoftInputFromWindow(binding.edSearch.windowToken, 0)

                return@setOnEditorActionListener true
            }
            false
        }

        binding.edSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                val drawables = binding.edSearch.compoundDrawablesRelative

                if (s != null) {
                    if (s.isNotEmpty()) {
                        binding.searchLayout.setBoxCornerRadii(
                            resources.getDimension(R.dimen.box_corners_10),
                            resources.getDimension(R.dimen.box_corners_10),
                            resources.getDimension(R.dimen.box_corners_0),
                            resources.getDimension(R.dimen.box_corners_0)
                        )
                        drawables[2] =
                            AppCompatResources.getDrawable(requireContext(), R.drawable.ic_clear)
                        binding.edSearch.setCompoundDrawablesRelativeWithIntrinsicBounds(
                            drawables[0], drawables[1], drawables[2], drawables[3]
                        )
                    } else {
                        binding.searchLayout.setBoxCornerRadii(
                            resources.getDimension(R.dimen.box_corners_10),
                            resources.getDimension(R.dimen.box_corners_10),
                            resources.getDimension(R.dimen.box_corners_10),
                            resources.getDimension(R.dimen.box_corners_10)
                        )
                        drawables[2] =
                            AppCompatResources.getDrawable(requireContext(), R.drawable.ic_search2)
                        binding.edSearch.setCompoundDrawablesRelativeWithIntrinsicBounds(
                            drawables[0], drawables[1], drawables[2], drawables[3]
                        )
                    }
                }
                performSearch(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })

        binding.edSearch.setOnTouchListener { _, event ->
            val clearDrawable = binding.edSearch.compoundDrawablesRelative[2]
            if (event.action == MotionEvent.ACTION_UP && clearDrawable != null) {
                val clearButtonEnd =
                    binding.edSearch.right - binding.edSearch.paddingEnd - clearDrawable.intrinsicWidth
                if (event.rawX >= clearButtonEnd) {
                    binding.edSearch.text = null
                    return@setOnTouchListener false
                }
            }
            false
        }
    }

}