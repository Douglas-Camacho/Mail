package br.com.fiap.novomail

import androidx.navigation.compose.rememberNavController
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.fiap.novoMail.screens.Lista
import br.com.fiap.novomail.screens.Login
//import br.com.fiap.novomail.screens.Login
import br.com.fiap.novomail.screens.DetalheEmail
import br.com.fiap.novomail.screens.DetalheEmail2
import br.com.fiap.novomail.screens.DetalheEmail3
import br.com.fiap.novomail.EmailFavorito
import br.com.fiap.novomail.ui.theme.NovoMailTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NovoMailTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val emailPreferences = remember { EmailFavorito(context = this) }
                    //TODO DESCREVER A ROTA DAS SCREENS
                    NavHost(
                        navController = navController,
                        startDestination = "listaEmail" // Inicia na lista de e-mails
                    ) {
                        composable(route = "listaEmail") {
                            Lista(navController = navController, emailPreferences = emailPreferences)
                        }
                        composable(route = "detalheEmail/{emailId}") { backStackEntry ->
                            val emailId = backStackEntry.arguments?.getString("emailId")?.toIntOrNull()
                            DetalheEmail(navController = navController, emailId = emailId ?: 0)
                        }
                        composable(route = "detalheEmail2/{emailId}") { backStackEntry ->
                            val emailId = backStackEntry.arguments?.getString("emailId")?.toIntOrNull()
                            DetalheEmail2(navController = navController, emailId = emailId ?: 0)
                        }
                        composable(route = "detalheEmail3/{emailId}") { backStackEntry ->
                            val emailId = backStackEntry.arguments?.getString("emailId")?.toIntOrNull()
                            DetalheEmail3(navController = navController, emailId = emailId ?: 0)
                        }

                        composable(route = "login") {
                            val context = LocalContext.current
                            Login(navController = navController, context = context)
                        }
                    }
                }
            }
        }
    }
}



//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    ChegouAquiTheme {
//        Greeting("Android")
//    }
//}