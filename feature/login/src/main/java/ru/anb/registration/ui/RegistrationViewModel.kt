package ru.anb.registration.ui

import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.IntentSenderRequest
import androidx.lifecycle.viewModelScope
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.SignInClient
import kotlinx.coroutines.launch
import ru.anb.core.BaseViewModel
import ru.anb.login.BuildConfig
import ru.anb.registration.domain.RegistrationFlowWrapper
import ru.anb.registration.domain.RegistrationInteractor

class RegistrationViewModel(
    private val registrationInteractor: RegistrationInteractor,
    override val flowWrapper: RegistrationFlowWrapper.Mutable,

    ) : BaseViewModel<RegistrationUiState>() {

    fun signUp(email: String, password: String) {
        flowWrapper.post(RegistrationUiState.Loading())
        viewModelScope.launch {
            val result = registrationInteractor.signIn(email, password)
            result.handle(flowWrapper)
        }
    }

    fun handleToken(token: String) {
        flowWrapper.post(RegistrationUiState.Loading())
        viewModelScope.launch {
            val result = registrationInteractor.signInWithGoogle(token)
            result.handle(flowWrapper)
        }
    }

    fun startSignInWithGoogle(client: SignInClient, launcher: ActivityResultLauncher<IntentSenderRequest>){
        val options = BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
            .setSupported(true)
            .setFilterByAuthorizedAccounts(false)
            .setServerClientId(BuildConfig.WEB_CLIENT_ID)
            .build()
        val request = BeginSignInRequest.builder().setGoogleIdTokenRequestOptions(options)
            .setAutoSelectEnabled(true)
            .build()
        client.beginSignIn(request).addOnSuccessListener {
            launcher.launch(IntentSenderRequest.Builder(it.pendingIntent).build())
        }
    }
}