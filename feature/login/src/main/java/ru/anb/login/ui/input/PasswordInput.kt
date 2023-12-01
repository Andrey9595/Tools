package ru.anb.login.ui.input

import android.content.Context
import android.util.AttributeSet
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
}