package ru.anb.login.ui.forgotpassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.anb.login.databinding.DialogForgotPasswordBinding

class ForgotPasswordDialog : BottomSheetDialogFragment() {

    private var _binding: DialogForgotPasswordBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ForgotPasswordDialogViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogForgotPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.sendCode.root.setOnClickListener {
            val emailIsValid = binding.emailInput.root.isValid()
            if (emailIsValid) {
                viewModel.resetPassword(email = binding.emailInput.root.text())
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.collect {
                    it.update(binding)
                }
            }
        }
    }
}