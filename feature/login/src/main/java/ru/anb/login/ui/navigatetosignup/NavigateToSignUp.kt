package ru.anb.login.ui.navigatetosignup

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import ru.anb.core.viewModel
import ru.anb.login.R

class NavigateToSignUp @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val signUpButton: TextView by lazy { findViewById(R.id.sign_up_button) }

    private val viewModel: NavigateToSignUpViewModel by viewModel()


    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        signUpButton.setOnClickListener {
            viewModel.navigateToSignUp()
        }
    }
}