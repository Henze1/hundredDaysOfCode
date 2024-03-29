package app.main.hundreddaysofcode.signInUpPages

data class SignUpState(
    val users: List<DataInfo> = emptyList(),
    val username: String = "",
    val email: String = "",
    val password: String = "",
    val repeatingPassword: String = ""
)
