package br.com.fiap.novomail.screens


import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetalheEmail(navController: NavHostController, emailId: Int) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalhes do e-mail") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Voltar")
                    }
                },
                actions = {

                    IconButton(onClick = { /* Ação de deletar */ }) {
                        Icon(Icons.Default.Delete, contentDescription = "Deletar")
                    }
                    IconButton(onClick = { /* Ação de responder */ }) {
                        Icon(Icons.Default.ArrowForward, contentDescription = "Responder")
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .fillMaxWidth(),
                containerColor = Color(0xFF13CB26),
                contentPadding = PaddingValues(start = 16.dp, end = 16.dp, bottom = 8.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    IconButton(
                        onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.Home,
                            contentDescription = "Home",
                            tint = Color.White,
                            modifier = Modifier.clickable {navController.navigate("listaEmail")}
                        )
                    }

                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.Email,
                            contentDescription = "E-mails",
                            tint = Color.White,
                            modifier = Modifier.clickable {navController.navigate("listaEmail")}
                        )}
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.Favorite,
                            contentDescription = "Favoritos",
                            tint = Color.White,
                            modifier = Modifier.clickable {navController.navigate("listaEmail")}
                        )}
                    IconButton(onClick = { /* Navegar para tela de Configurações */ }) {
                        Icon(
                            imageVector = Icons.Filled.Settings,
                            contentDescription = "Configurações",
                            tint = Color.White,
                            modifier = Modifier.clickable {navController.navigate("listaEmail")}
                            )}
                }
            }
        }
    ) { innerPadding ->
        // Conteúdo da tela de detalhes do e-mail
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            // Aqui você deve buscar e exibir os detalhes reais do e-mail com base no emailId
            Text(text = "Remetente: Thiago@gmail.com")
            Text(text = "Data: 10/06/2024")
            Text(
                text = "Reunião mês que vem",
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
                modifier = Modifier.padding(vertical = 15.dp) // Adiciona espaçamento vertical entre o título e o próximo texto
            )
            Text(text = "Olá, teremos reunião dia 05.07.2024.")
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetalheEmail2(navController: NavHostController, emailId: Int) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalhes do e-mail") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Voltar")
                    }
                },
                actions = {
                    IconButton(onClick = { /* Ação de deletar */ }) {
                        Icon(Icons.Default.Delete, contentDescription = "Deletar")
                    }
                    IconButton(onClick = { /* Ação de responder */ }) {
                        Icon(Icons.Default.ArrowForward, contentDescription = "Responder")
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .fillMaxWidth(),
                containerColor = Color(0xFF13CB26),
                contentPadding = PaddingValues(start = 16.dp, end = 16.dp, bottom = 8.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    IconButton(
                        onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.Home,
                            contentDescription = "Home",
                            tint = Color.White,
                            modifier = Modifier.clickable {navController.navigate("listaEmail")}
                        )
                    }

                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.Email,
                            contentDescription = "E-mails",
                            tint = Color.White,
                            modifier = Modifier.clickable {navController.navigate("listaEmail")}
                        )}
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.Favorite,
                            contentDescription = "Favoritos",
                            tint = Color.White,
                            modifier = Modifier.clickable {navController.navigate("listaEmail")}
                        )}
                    IconButton(onClick = { /* Navegar para tela de Configurações */ }) {
                        Icon(
                            imageVector = Icons.Filled.Settings,
                            contentDescription = "Configurações",
                            tint = Color.White,
                            modifier = Modifier.clickable {navController.navigate("listaEmail")}
                        )}
                }
            }
        }
    ) { innerPadding ->
        // Conteúdo da tela de detalhes do e-mail
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            // Aqui você deve buscar e exibir os detalhes reais do e-mail com base no emailId
            Text(text = "Remetente: amazon@amazon.com")
            Text(text = "Data: 09/06/2024")
            Text(text = "Título", fontWeight = FontWeight.Bold, fontSize = 24.sp )
            Text(text = "A liquidação vai até o dia 23.08.2024.")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetalheEmail3(navController: NavHostController, emailId: Int) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalhes do e-mail") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Voltar")
                    }
                },
                actions = {
                    IconButton(onClick = { /* Ação de deletar */ }) {
                        Icon(Icons.Default.Delete, contentDescription = "Deletar")
                    }
                    IconButton(onClick = { /* Ação de responder */ }) {
                        Icon(Icons.Default.ArrowForward, contentDescription = "Responder")
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .fillMaxWidth(),
                containerColor = Color(0xFF13CB26),
                contentPadding = PaddingValues(start = 16.dp, end = 16.dp, bottom = 8.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    IconButton(
                        onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.Home,
                            contentDescription = "Home",
                            tint = Color.White,
                            modifier = Modifier.clickable {navController.navigate("listaEmail")}
                        )
                    }

                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.Email,
                            contentDescription = "E-mails",
                            tint = Color.White,
                            modifier = Modifier.clickable {navController.navigate("listaEmail")}
                        )}
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.Favorite,
                            contentDescription = "Favoritos",
                            tint = Color.White,
                            modifier = Modifier.clickable {navController.navigate("listaEmail")}
                        )}
                    IconButton(onClick = { /* Navegar para tela de Configurações */ }) {
                        Icon(
                            imageVector = Icons.Filled.Settings,
                            contentDescription = "Configurações",
                            tint = Color.White,
                            modifier = Modifier.clickable {navController.navigate("listaEmail")}
                        )}
                }
            }
        }
    ) { innerPadding ->
        // Conteúdo da tela de detalhes do e-mail
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            // Aqui você deve buscar e exibir os detalhes reais do e-mail com base no emailId
            Text(text = "Remetente: Rafael@outlook.com")
            Text(text = "Data: 07/06/2024")
            Text(text = "Título", fontWeight = FontWeight.Bold, fontSize = 24.sp )
            Text(text = "Oi primo, vou casar dia 09.07.2024.")
        }
    }
}




