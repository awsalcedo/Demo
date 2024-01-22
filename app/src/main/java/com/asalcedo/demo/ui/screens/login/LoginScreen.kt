package com.asalcedo.demo.ui.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.asalcedo.demo.R
import com.asalcedo.demo.ui.common.CButtonLogin
import com.asalcedo.demo.ui.common.CTextField
import com.asalcedo.demo.ui.common.DontHaveAccountRow
import com.asalcedo.demo.ui.navigation.ItemsMenu.HomeScreen
import com.asalcedo.demo.ui.theme.AlegreyaFontFamily
import com.asalcedo.demo.ui.theme.AlegreyaSansFontFamily
import kotlinx.coroutines.launch

/****
 * Project: Bottom Navigation Bar Compose
 * From: com.asalcedo.bottomnavigationbarcompose.ui.screens
 * Created by Alex Salcedo Silva on 10/1/24 at 11:01
 * All rights reserve 2022.
 ***/

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavHostController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val email: String by viewModel.email.observeAsState("")
    val password: String by viewModel.password.observeAsState("")
    val loginEnabled: Boolean by viewModel.loginEnabled.observeAsState(false)
    val loginUiState by viewModel.loginUiState.observeAsState()
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    /// Muestra el Snackbar cuando se detecta un estado de error
    loginUiState?.let {
        if (it is LoginState.Error) {
            LaunchedEffect(it) {
                snackbarHostState.showSnackbar(it.error)
            }
        }
    }


    when (loginUiState) {
        is LoginState.Success -> {
            //navegar a HomeScreen
            if ((loginUiState as LoginState.Success).status == 200) {
                navController.navigate(HomeScreen.route)
            } else {
                //Body
                Surface(
                    color = Color(0xFF253334),
                    modifier = Modifier.fillMaxSize()
                ) {


                    Box(modifier = Modifier.fillMaxSize()) {
                        /// Background Image
                        Image(
                            painter = painterResource(id = R.drawable.bg1),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(190.dp)
                                .align(Alignment.BottomCenter)
                        )

                        /// Content

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 24.dp)
                        ) {

                            // Logo
                            Image(
                                painter = painterResource(id = R.drawable.logo),
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(top = 54.dp)
                                    .height(100.dp)
                                    .align(Alignment.Start)
                                    .offset(x = (-20).dp)
                            )

                            Text(
                                text = "Login",
                                style = TextStyle(
                                    fontSize = 28.sp,
                                    fontFamily = AlegreyaFontFamily,
                                    fontWeight = FontWeight(500),
                                    color = Color.White
                                ),
                                modifier = Modifier.align(Alignment.Start)
                            )

                            Text(
                                "Inicia sesión ahora para acceder.",
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    fontFamily = AlegreyaSansFontFamily,
                                    color = Color(0xB2FFFFFF)
                                ),
                                modifier = Modifier
                                    .align(Alignment.Start)
                                    .padding(bottom = 24.dp)
                            )

                            // Text Field
                            CTextField(
                                hint = "Email Address",
                                value = email.trim(),
                                onValueChange = { viewModel.onLoginChanged(it, password) })

                            CTextField(
                                hint = "Password",
                                value = password.trim(),
                                onValueChange = { viewModel.onLoginChanged(email, it) },
                                isPassword = true
                            )

                            Spacer(modifier = Modifier.height(24.dp))

                            CButtonLogin(
                                text = "Sign In",
                                onClick = {
                                    coroutineScope.launch {
                                        viewModel.onLoginSelected()
                                    }

                                },
                                loginEnable = loginEnabled
                            )

                            DontHaveAccountRow(
                                onSignupTap = {
                                    navController.navigate("signup")
                                }
                            )

                        }

                    }

                }
            }

        }

        is LoginState.Loading -> {
            //Mostrar CircularProgressIndicator
            Box(Modifier.fillMaxSize()) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }

        }

        else -> {
            //Body
            Surface(
                color = Color(0xFF253334),
                modifier = Modifier.fillMaxSize()
            ) {


                Box(modifier = Modifier.fillMaxSize()) {
                    /// Background Image
                    Image(
                        painter = painterResource(id = R.drawable.bg1),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(190.dp)
                            .align(Alignment.BottomCenter)
                    )

                    /// Content

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 24.dp)
                    ) {

                        // Logo
                        Image(
                            painter = painterResource(id = R.drawable.logo),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(top = 54.dp)
                                .height(100.dp)
                                .align(Alignment.Start)
                                .offset(x = (-20).dp)
                        )

                        Text(
                            text = "Login",
                            style = TextStyle(
                                fontSize = 28.sp,
                                fontFamily = AlegreyaFontFamily,
                                fontWeight = FontWeight(500),
                                color = Color.White
                            ),
                            modifier = Modifier.align(Alignment.Start)
                        )

                        Text(
                            "Inicia sesión ahora para acceder.",
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontFamily = AlegreyaSansFontFamily,
                                color = Color(0xB2FFFFFF)
                            ),
                            modifier = Modifier
                                .align(Alignment.Start)
                                .padding(bottom = 24.dp)
                        )

                        // Text Field
                        CTextField(
                            hint = "Email Address",
                            value = email.trim(),
                            onValueChange = { viewModel.onLoginChanged(it, password) })

                        CTextField(
                            hint = "Password",
                            value = password.trim(),
                            onValueChange = { viewModel.onLoginChanged(email, it) },
                            isPassword = true
                        )

                        Spacer(modifier = Modifier.height(24.dp))

                        CButtonLogin(
                            text = "Sign In",
                            onClick = {
                                coroutineScope.launch {
                                    viewModel.onLoginSelected()
                                }

                            },
                            loginEnable = loginEnabled
                        )

                        DontHaveAccountRow(
                            onSignupTap = {
                                navController.navigate("signup")
                            }
                        )

                    }

                }

            }
        }
    }

    // Mostrar el host del Snackbar
    SnackbarHost(
        hostState = snackbarHostState,
        modifier = Modifier.padding(16.dp)
    ) { data ->
        Snackbar(
            snackbarData = data,
            modifier = Modifier.padding(16.dp)
        )
    }

}


@Preview(showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun LoginScreenPreview() {
    LoginScreen(rememberNavController())
}