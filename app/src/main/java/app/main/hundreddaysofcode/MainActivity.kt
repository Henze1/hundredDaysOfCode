package app.main.hundreddaysofcode

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import app.main.hundreddaysofcode.signInUpPages.LogInPG
import app.main.hundreddaysofcode.signInUpPages.SignUpDb
import app.main.hundreddaysofcode.signInUpPages.SignUpEvent
import app.main.hundreddaysofcode.signInUpPages.SignUpPG
import app.main.hundreddaysofcode.signInUpPages.SignUpState
import app.main.hundreddaysofcode.signInUpPages.SignUpViewModel
import app.main.hundreddaysofcode.ui.theme.HundredDaysOfCodeTheme

class MainActivity : ComponentActivity() {

    val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            SignUpDb::class.java,
            "signUp.db"
        ).build()
    }
    @Suppress("UNCHECKED_CAST")
    private val viewModel by viewModels<SignUpViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return SignUpViewModel(db.dao) as T
                }
            }
        }
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            setContent {
                HundredDaysOfCodeTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        val state by viewModel.state.collectAsState()
                        MainScreen(state = state, onEvent = viewModel::onEvent)
                    }
                }
            }
        } catch (e : ClassNotFoundException) {
            println("Caught exception: $e")
        }
    }
}

@Composable
fun MainScreen(state: SignUpState, onEvent: (SignUpEvent) -> Unit) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "logInPG") {
        composable("logInPG") {
            LogInPG({ navController.navigate("signUpPG") }, state)
        }
        composable("signUpPG") {
            SignUpPG({ navController.navigate("logInPG") }, state, onEvent)
        }
    }
}