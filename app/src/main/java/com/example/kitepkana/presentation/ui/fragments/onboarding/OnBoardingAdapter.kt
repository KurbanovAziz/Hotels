package com.example.kitepkana.presentation.ui.fragments.onboarding

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.kitepkana.R
import com.example.kitepkana.data.model.OnBoard
import com.example.kitepkana.databinding.ItemBoardingBinding

class OnBoardingAdapter(
    context: Context,
    private val ClickSkip: () -> Unit,
    private val ClickRegister: () -> Unit,
    private val ClickLogin: () -> Unit,
) : RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {


    private val data = arrayListOf(
        OnBoard(R.drawable.ic_onboard_one, context.getString(R.string.welcome_to_muras)),
        OnBoard(R.drawable.ic_onboard_two, context.getString(R.string.muras_enjoy_books)),
        OnBoard(R.drawable.ic_onboard_three, context.getString(R.string.muras_read_share))
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemBoardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class OnBoardingViewHolder(private val binding: ItemBoardingBinding) :
        ViewHolder(binding.root) {
        fun bind(onBoard: OnBoard) {
            binding.tvTitle.text = onBoard.title
            binding.ivBoarding.setImageResource(onBoard.image!!)
            if (adapterPosition == data.lastIndex) {
                binding.btnLayout.isVisible = true
                binding.tvSkip.isVisible = false
            } else {
                binding.tvSkip.isVisible = true
                binding.btnLayout.isVisible = false
            }
            binding.tvSkip.setOnClickListener {
                ClickSkip()
            }
            binding.btnRegister.setOnClickListener {
                ClickRegister()
            }
            binding.btnLogin.setOnClickListener {
                ClickLogin()
            }
        }
    }
}