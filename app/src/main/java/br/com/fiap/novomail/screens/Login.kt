package br.com.fiap.novomail.screens

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.com.fiap.novomail.R


@Composable
fun Login(navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        //Efeito lateral superior direito
        Card(
            modifier = Modifier
                .size(width = 120.dp, height = 40.dp)
                .align(Alignment.End),
            colors = CardDefaults.cardColors(containerColor = Color(color = 0xFF13CB26)),
            shape = RoundedCornerShape(bottomStart = 16.dp)
        ) {

        }
        //Foto de Perfil da tela
        Card(
            modifier = Modifier
                .size(width = 99.dp, height = 99.dp)
                .align(Alignment.CenterHorizontally),
            shape = CircleShape,
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.homem_perfil),
                contentDescription = "Foto de Perfil",
                contentScale = ContentScale.Crop
            )
        }
        Column(
            modifier = Modifier.padding(start = 32.dp)
        ) {
            Text(
                text = "Login",
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF13CB26)
            )
            Text(
                text = "Insira as informações para continuar.",
                fontSize = 14.sp,
                color = Color(0xffA09C9C)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
        ) {
            OutlinedTextField(
                value = email,
                onValueChange = { newValue -> email = newValue },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = "",
                        tint = Color(0xff13CB26)
                    )
                },
                label = {
                    Text(text = "E-mail")
                },
                placeholder = {
                    Text(text = "seuemail@email.com.br")
                }
            )
            OutlinedTextField(
                value = senha,
                onValueChange = {newValue -> senha = newValue},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = "",
                        tint = Color(0xff13CB26)
                    )
                },
                label = {
                    Text(text = "Senha")
                },
                placeholder = {
                    Text(text = "******")
                },
                visualTransformation = PasswordVisualTransformation()


            )
            Button(
                onClick = {
                    navController.navigate("listaEmail")
                },
                modifier = Modifier
                    .padding(top = 16.dp)
                    .align(Alignment.End),
                colors = ButtonDefaults
                    .buttonColors(Color(0xFF13CB26))
            ) {
                Text(
                    text = "Entrar",
                    color = Color(0xFFFFFFFF)
                )
                Icon(
                    imageVector = Icons
                        .Filled
                        .ArrowForward,
                    contentDescription = "",
                    tint = Color(0xFFFFFFFF)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = "Não possue uma conta?"
                )
                Text(
                    text = "Criar conta",
                    color = Color(0xFF13CB26),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
        }
        Card(
            modifier = Modifier
                .size(width = 120.dp, height = 40.dp)
                .align(Alignment.Start),
            colors = CardDefaults.cardColors(containerColor = Color(color = 0xFF13CB26)),
            shape = RoundedCornerShape(topEnd = 16.dp)
        ) {

        }

    }


}