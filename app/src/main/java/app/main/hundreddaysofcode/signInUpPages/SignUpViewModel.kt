package app.main.hundreddaysofcode.signInUpPages

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val dao: DataDao
): ViewModel() {

    val state = MutableStateFlow(SignUpState())

    fun onEvent(event: SignUpEvent) {
        when(event) {
            SignUpEvent.SaveUser -> {
                val username = state.value.username
                val email = state.value.email
                val password = state.value.password
                val repeatingPassword = state.value.repeatingPassword

                if (username.isBlank() || email.isBlank() || password.isBlank() || repeatingPassword.isBlank()){
                    return
                }

                val dataInfo = DataInfo(
                    username = username,
                    email = email,
                    password = password,
                    repeatingPassword = repeatingPassword
                )
                viewModelScope.launch {
                    dao.upsertData(dataInfo)
                }

                state.update { it.copy(
                    username = "",
                    email = "",
                    password = "",
                    repeatingPassword = ""
                ) }
            }
            is SignUpEvent.SetEmail -> {
                state.update { it.copy(
                    email = event.email
                ) }
            }
            is SignUpEvent.SetPassword -> {
                state.update { it.copy(
                    password = event.password
                ) }
            }
            is SignUpEvent.SetRepeatingPassword -> {
                state.update { it.copy(
                    repeatingPassword = event.repeatingPassword
                ) }
            }
            is SignUpEvent.SetUsername -> {
                state.update { it.copy(
                    username = event.username
                ) }
            }
        }
    }
}