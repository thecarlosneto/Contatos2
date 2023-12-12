package com.example.contatos.ui.TelaLogin

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.contatos.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaLogin(
    controlenavegacao: NavController
){
    var nome by remember { mutableStateOf("") }
    var usuario by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var confirmarSenha by remember { mutableStateOf("") }
    var cadastrar by remember { mutableStateOf(false) }
    var erroLogar by remember { mutableStateOf(false) }

    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = colorResource(id = R.color.teal_700)
                ),
                title = {
                    Text(
                        text = stringResource(R.string.titulo_app),
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                },
                )
        },
    ) { espacoDasBarras ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(espacoDasBarras)
                .fillMaxSize()
        ) {

            Column(
                modifier = Modifier.animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
            ) {
                if (cadastrar) {
                    CampoDeTexto(
                        value = nome,
                        onValueChange = { nome = it },
                        idText = R.string.nome,
                        isError = false
                    )
                    Spacer(modifier = Modifier.size(15.dp))
                }

                CampoDeTexto(
                    value = usuario,
                    onValueChange = { usuario = it },
                    idText = if (erroLogar)
                        R.string.usuarioIncorreto
                    else
                        R.string.usuario,
                    isError = erroLogar
                )

                Spacer(modifier = Modifier.size(15.dp))

                CampoDeTexto(
                    value = senha,
                    onValueChange = { senha = it },
                    idText = if (erroLogar)
                        R.string.senhaIncorreta
                    else
                        R.string.senha,
                    isError = erroLogar
                )
                if (cadastrar) {
                    Spacer(modifier = Modifier.size(15.dp))
                    CampoDeTexto(
                        value = confirmarSenha,
                        onValueChange = { confirmarSenha = it },
                        idText = R.string.confirmarSenha,
                        isError = erroLogar
                    )
                }
            }
            Spacer(modifier = Modifier.size(30.dp))

            Button(
                onClick = {
                    if (senha == "1234" && usuario == "calos") {
                        cadastrar = false
                        erroLogar = false
                        controlenavegacao.navigate("TelaProjetos")
                    } else {
                        erroLogar = true
                    }
                },
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.teal_700)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 50.dp,
                        end = 50.dp
                    )
            ) {
                if (!cadastrar) {
                    Text(
                        text = stringResource(id = R.string.entrar),
                        fontSize = 18.sp
                    )
                } else {
                    Text(
                        text = stringResource(id = R.string.cadastrar),
                        fontSize = 18.sp
                    )
                }
            }

            Spacer(modifier = Modifier.size(5.dp))

            if (!cadastrar) {
                Text(
                    text = ("Cadastrar"),
                    color = colorResource(id = R.color.teal_700),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.clickable {
                        cadastrar = true
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CampoDeTexto(
    value: String,
    onValueChange: (String) -> Unit,
    idText:Int,
    isError: Boolean
){


    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(id = R.color.teal_700),
            unfocusedBorderColor = colorResource(id = R.color.teal_700),

            ),
        label = {
            Text(
                text = stringResource(idText),
                color = if (isError)
                            Color.Red
                else
                    colorResource(id = R.color.teal_700)
            )
        },
        isError = isError
    )
}