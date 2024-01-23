package com.asalcedo.demo.ui.screens.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.asalcedo.demo.R
import com.asalcedo.demo.domain.model.ClientModel
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.observeAsState()
    val corroutineScope = rememberCoroutineScope()


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Botón para cargar la lista de clientes
        Button(
            onClick = { corroutineScope.launch { viewModel.onGetClients() } },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Text("Cargar Clientes")
        }

        if (uiState is HomeState.Loading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        if (uiState is HomeState.Success) {
            val clientes = (uiState as HomeState.Success).clients
            // Muestra la lista de clientes en tarjetas verticales
            LazyColumn {
                items(clientes) { cliente ->
                    ClientCard(cliente = cliente)
                    // Agrega un espaciador entre las tarjetas
                    Spacer(modifier = Modifier.height(14.dp))
                }
            }
        }

    }
}

@Composable
fun ClientCard(cliente: ClientModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(topStart = 16.dp, bottomEnd = 16.dp),
        border = BorderStroke(width = 3.dp, color = Color.LightGray)

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "User",
                modifier = Modifier
                    .height(190.dp)
                    .fillMaxWidth().padding(bottom = 8.dp),
                contentScale = ContentScale.Crop
            )
            Column {
                Text(
                    text = cliente.razonSocial,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth()

                )
                Text(
                    text = "Razón social: ${cliente.razonSocial}",
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "Ciudad: ${cliente.ciudad}",
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "Teléfono: ${cliente.telefonos}",
                    style = MaterialTheme.typography.bodySmall
                )
            }


        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}