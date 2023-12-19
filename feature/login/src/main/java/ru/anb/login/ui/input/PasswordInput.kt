package ru.anb.login.ui.input

import android.content.Context
import android.util.AttributeSet
import androidx.core.widget.doOnTextChanged
import ru.anb.login.R

class PasswordInput @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AbstractInputLayout(context, attrs, defStyleAttr) {

    override val errorMessageId: Int = R.string.password_input_error

    override fun innerIsValid(): Boolean {
        return text().length > 5
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        isEndIconVisible = false
        editText?.doOnTextChanged { text, _, _, _ ->
            isEndIconVisible = text?.isNotEmpty() ?: false
        }
    }
}