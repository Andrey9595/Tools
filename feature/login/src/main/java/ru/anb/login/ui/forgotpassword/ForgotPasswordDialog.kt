package ru.anb.login.ui.forgotpassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ru.anb.login.databinding.DialogForgotPasswordBinding

class ForgotPasswordDialog : BottomSheetDialogFragment() {

    private var _binding: DialogForgotPasswordBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DialogForgotPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }
}