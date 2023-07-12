package com.example.kitepkana.presentation.ui.fragments.authorization.register.activation

import android.animation.ValueAnimator
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.animation.DecelerateInterpolator
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitepkana.R
import com.example.kitepkana.databinding.FragmentActivationBinding
import com.example.kitepkana.domain.model.authorization.ActivationAccount
import com.example.kitepkana.domain.model.authorization.ResendActivationAccount
import com.example.kitepkana.presentation.base.BaseFragment
import com.example.kitepkana.presentation.ui.fragments.authorization.register.RegisterFragment.Companion.ARGS_EMAIL
import com.example.kitepkana.presentation.utils.showToast
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ActivationFragment : BaseFragment(R.layout.fragment_activation) {

    private val binding by viewBinding(FragmentActivationBinding::bind)
    private val profileViewModel by lazy {
        ViewModelProvider(this)[ActivationViewModel::class.java]
    }
    private lateinit var timer: CountDownTimer
    private var email: String? = null

    override fun initialize() {
        email = arguments?.getString(ARGS_EMAIL)
    }

    override fun setupSubscribers() {
        profileViewModel.getRegisterActivation.collectUIState(
            onSuccess = {
                findNavController().navigate(R.id.authFragment)
                requireContext().showToast(getString(R.string.please_enter_to_account))
            }
        )
        profileViewModel.getRegisterResendActivation.collectUIState(
            onSuccess = {

            }
        )
    }

    override fun setupListeners() {
        binding.tvToRetry.setOnClickListener {
            if (binding.tvToRetry.text.toString() == getString(R.string.to_retry)) {
                email?.let { it1 ->
                    ResendActivationAccount(
                        it1
                    )
                }?.let { it2 -> profileViewModel.resendActivationAccount(it2) }
                startTimer()
            }
        }
        binding.btnRegister.setOnClickListener {
            profileViewModel.activationAccount(
                ActivationAccount(
                    binding.edActivationCode.text.toString()
                )
            )

        }
        binding.btnAuth.setOnClickListener {
            findNavController().navigate(R.id.authFragment)
        }

    }

    private fun startTimer() {
        val countdownValue = 60L

        timer = object : CountDownTimer(countdownValue * 1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val secondsLeft = millisUntilFinished / 1000
                animateCountdown(secondsLeft)
            }

            override fun onFinish() {}
        }
        timer.start()
    }

    private fun animateCountdown(secondsLeft: Long) {
        val animator = ValueAnimator.ofInt(secondsLeft.toInt(), 0)
        animator.duration = 60000
        animator.interpolator = DecelerateInterpolator()
        animator.addUpdateListener { valueAnimator ->
            val animatedValue = valueAnimator.animatedValue as Int
            binding.tvToRetry.text = formatTime(animatedValue)
        }
        animator.start()

        Handler(Looper.getMainLooper())
            .postDelayed({
                animator.cancel()
                timer.cancel()
                binding.tvToRetry.text = getString(R.string.to_retry)
            }, 38000)
    }

    private fun formatTime(seconds: Int): String {
        val minutes = seconds / 60
        val remainingSeconds = seconds % 60
        return String.format("Повторить попытку через %d:%02d", minutes, remainingSeconds)
    }

    override fun onDestroy() {
        super.onDestroy()
        timer.cancel()
    }
}