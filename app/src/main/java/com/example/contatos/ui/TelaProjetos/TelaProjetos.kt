package com.example.contatos.ui.TelaProjetos

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.contatos.data.BDProjetos
import com.example.contatos.model.Projetos
import com.example.contatos.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaProjetos(
    controlenavegacao: NavController
)
{
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = colorResource(id = R.color.teal_700),
                ),
                title = {
                    Text(
                        text = stringResource(id = R.string.listaProjetos),
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                },navigationIcon = {
                    IconButton(
                        onClick = { },
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = null,
                        )
                    }
                },

                )
        },
        bottomBar = {
            BottomAppBar (
                containerColor = colorResource(id = R.color.teal_700),
                contentColor = Color.White,
                actions = {
                    Spacer(modifier = Modifier.size(20.dp))

                    Icon(
                        imageVector = Icons.Filled.Create,
                        contentDescription = null
                    )

                    Spacer(modifier = Modifier.size(40.dp))

                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = null
                    )

                    Spacer(modifier = Modifier.size(40.dp))

                    Icon(
                        imageVector = Icons.Filled.Check,
                        contentDescription = null
                    )
                },
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = { /*TODO*/ },
                        containerColor = colorResource(id = R.color.teal_800),
                        contentColor = Color.White,
                        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = null )
                    }
                }
            )
        }
    ) { espacoDasBarras ->
        Column (
            modifier = Modifier.padding(espacoDasBarras)
        ){
            ListaProjetos(
                listaProjetos = BDProjetos().carregaListaProjetos(),
            )
        }

    }
}
@Composable
fun ListaProjetos(
    listaProjetos: List<Projetos>,
){
    LazyColumn() {
        items (listaProjetos){
            projeto ->
                CardProjeto(projeto)
        }
    }
}

@Composable
fun CardProjeto(
    projeto: Projetos
){
    var expandir by remember { mutableStateOf(false) }

    Card (
        colors = CardDefaults.cardColors(colorResource(id = R.color.teal_claro)),
        elevation = CardDefaults.cardElevation(6.dp),
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth()
    ){
        Column (
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
                .padding(
                    top = 20.dp,
                    start = 20.dp,
                    end = 10.dp,
                    bottom = 10.dp
                )
        ){
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ){
                Image(
                    painter = painterResource( projeto.imagem),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(80.dp),

                )
                Column {
                    Row {
                        Text(
                            text = stringResource(id = R.string.nomeProjeto),
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                        Spacer(modifier = Modifier.size(5.dp))
                        Text(
                            text = projeto.nome,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    }
                    Row {
                        Text(
                            text = stringResource(id = R.string.prazoProjeto),
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.size(5.dp))
                        Text(
                            text = projeto.prazo,
                            fontWeight = FontWeight.Bold
                            )
                    }
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Checkbox(
                            checked = projeto.emAndamento,
                            onCheckedChange = {projeto.emAndamento=it}
                        )
                        Text(text = "Em Andamento")
                    }
                }
                if (!expandir){
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowDown,
                        contentDescription = null,
                        modifier = Modifier
                            .clickable {
                                expandir = true
                            }
                            .size(30.dp)
                    )
                }else{
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowUp,
                        contentDescription = null,
                        modifier = Modifier
                            .clickable {
                                expandir = false
                            }
                            .size(30.dp)
                    )
                }

            }
            if (expandir){
                Column (
                    modifier = Modifier.fillMaxWidth()
                ){
                    Row {
                        Text(
                            text = stringResource(id = R.string.descricaoProjeto),
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.size(5.dp))
                        Text(text = projeto.descricao)
                    }

                }
            }

        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewListaProjetos(){
    ListaProjetos(
        listaProjetos = BDProjetos().carregaListaProjetos()
    )
}