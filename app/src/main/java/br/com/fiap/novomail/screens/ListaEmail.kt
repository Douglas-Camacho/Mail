package br.com.fiap.novomail.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.com.fiap.novomail.EmailFavorito
import kotlinx.coroutines.flow.first
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch
import androidx.compose.ui.res.painterResource

data class Email(val id: Int, val remetente: String, val data: LocalDate, val titulo: String, val corpo: String, var favorito: Boolean = false)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Lista(navController: NavHostController, emailPreferences: EmailFavorito) {
    // Lista de e-mails original
    val emails = remember {
        mutableStateListOf(
            Email(1, "Thiago", LocalDate.of(2024, 6, 10), "Reunião mês que vem", "Olá, teremos reunião dia 05.07.2024"),
            Email(2, "Amazon", LocalDate.of(2024, 6, 9), "A promoção está acabando", "A liquidação vai até o dia 23.08.2024."),
            Email(3, "Rafael", LocalDate.of(2024, 6, 7), "Casamento", "Oi primo, vou casar dia 25.07.2024."),
        )
    }
    val dataFormatted = DateTimeFormatter.ofPattern("dd/MM")
    val searchText = remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()

    // Filtra a lista de e-mails com base no texto de busca
    val filteredEmails = emails.filter {
        it.remetente.contains(searchText.value, ignoreCase = true) ||
                it.titulo.contains(searchText.value, ignoreCase = true) ||
                it.corpo.contains(searchText.value, ignoreCase = true)
    }

    val headerText = "Caixa de Entrada"

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Campo de pesquisa
        OutlinedTextField(
            value = searchText.value,
            onValueChange = { searchText.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = { Text("Pesquisar e-mail") },
            singleLine = true,
            leadingIcon = {
                Icon(Icons.Filled.Search, contentDescription = "Search")
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Gray,
                cursorColor = Color.Black
            )
        )

        // Lista de e-mails filtrada
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            // Header
            item {
                Text(
                    text = headerText,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 24.sp
                )
            }

            // Lista de e-mails filtrada
            items(filteredEmails) { email ->

                var isFavorite by remember { mutableStateOf(false) }

                LaunchedEffect(email.id) {
                    isFavorite = emailPreferences.isEmailFavorite(email.id).first()
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            when (email.id) {
                                1 -> navController.navigate("detalheEmail/${email.id}")
                                2 -> navController.navigate("detalheEmail2/${email.id}")
                                3 -> navController.navigate("detalheEmail3/${email.id}")
                            }
                        }
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(text = email.remetente, fontWeight = FontWeight.Bold, fontSize = 21.sp)
                        Text(text = email.titulo, fontWeight = FontWeight.Bold)
                        Text(text = email.corpo)
                        Text(text = email.data.format(dataFormatted))
                    }

                    IconButton(
                        onClick = {
                            isFavorite = !isFavorite
                            coroutineScope.launch {
                                emailPreferences.setEmailFavorite(email.id, isFavorite)
                            }
                        },
                        modifier = Modifier.padding(start = 8.dp)
                    ) {
                        Icon(
                            imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                            contentDescription = "Favorito",
                            tint = if (isFavorite) Color.Red else Color.Gray
                        )
                    }
                }
            }
        }

        // Navbar
        BottomAppBar(
            modifier = Modifier.fillMaxWidth(),
            containerColor = Color(0xFF13CB26),
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp, bottom = 8.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(
                    onClick = { navController.navigate("login") },
                    modifier = Modifier.clickable { }
                ) {
                    Icon(Icons.Filled.Home, contentDescription = "Home", tint = Color.White)
                }
                IconButton(
                    onClick = { navController.navigate("listaEmail") },
                    modifier = Modifier.clickable { }
                ) {
                    Icon(Icons.Filled.Email, contentDescription = "E-mails", tint = Color.White)
                }
                IconButton(
                    onClick = { navController.navigate("listaEmail") },
                    modifier = Modifier.clickable { }
                ) {
                    Icon(Icons.Filled.Favorite, contentDescription = "Favoritos", tint = Color.White)
                }
                IconButton(
                    onClick = { navController.navigate("listaEmail") },
                    modifier = Modifier.clickable { }
                ) {
                    Icon(Icons.Filled.Settings, contentDescription = "Configurações", tint = Color.White)
                }
            }
        }
    }
}
