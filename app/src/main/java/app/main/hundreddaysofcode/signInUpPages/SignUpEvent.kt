package app.main.hundreddaysofcode.signInUpPages

sealed interface SignUpEvent {
    data object SaveUser: SignUpEvent
    data class SetUsername(val username: String): SignUpEvent
    data class SetEmail(val email: String): SignUpEvent
    data class SetPassword(val password: String): SignUpEvent
    data class SetRepeatingPassword(val repeatingPassword: String): SignUpEvent
}