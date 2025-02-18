package com.albatros.kplanner.ui.fragments.register

import android.os.Bundle
import android.text.InputType
import android.transition.TransitionInflater
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.albatros.kplanner.R
import com.albatros.kplanner.databinding.RegisterFragmentBinding
import com.albatros.kplanner.domain.playFadeInAnimation
import com.albatros.kplanner.domain.playFadeOutAnimation
import com.albatros.kplanner.model.data.DiraUser
import com.albatros.kplanner.model.util.EnterResult
import com.albatros.kplanner.ui.activity.MainActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterFragment : Fragment(), MainActivity.IOnBackPressed {

    override fun onBackPressed(): Boolean {
        activity?.finish()
        activity?.finishAffinity()
        return true
    }

    private lateinit var binding: RegisterFragmentBinding
    private val viewModel: RegisterViewModel by viewModel()

    private val onUserCreated = Observer<EnterResult> {
        when (it) {
            is EnterResult.EntryStarted -> {

            }
            is EnterResult.EntryFailure -> {
                binding.passwordInput.helperText = it.exception.message
            }
            is EnterResult.EntrySuccess -> {

                binding.passwordInput.playFadeOutAnimation(1000L)
                binding.addressInput.playFadeOutAnimation(1000L)

                viewModel.transformDiraUser(it.user)
            }
            is EnterResult.EntryInvalid -> {
                binding.passwordInput.helperText = "Input data is invalid. Try again."
            }
        }
    }

    private val onDiraUserCreated = Observer<DiraUser?> {
        if (it == null) {
            binding.passwordInput.helperText = "Internal server error. Try again."
            lifecycleScope.launch {
                binding.passwordInput.playFadeInAnimation(500L)
                binding.addressInput.playFadeInAnimation(500L)
            }
            return@Observer
        }

        binding.registerText.setOnClickListener { }

        lifecycleScope.launch {
            binding.registerText.playFadeOutAnimation(300L)
            delay(300L)
            val direction = RegisterFragmentDirections.actionRegisterFragmentToWelcomeFragment()
            findNavController().navigate(direction)
        }
    }

    private fun processUserData() {
        with(binding) {
            viewModel.authenticate(
                addressEdit.text.toString(),
                passwordEdit.text.toString()
            )
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postponeEnterTransition()
        sharedElementEnterTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        startPostponedEnterTransition()

        viewModel.user.observe(viewLifecycleOwner, onUserCreated)
        viewModel.diraUser.observe(viewLifecycleOwner, onDiraUserCreated)

        binding.passwordEdit.inputType =
            InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD

        binding.registerText.setOnClickListener {
            processUserData()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = RegisterFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}