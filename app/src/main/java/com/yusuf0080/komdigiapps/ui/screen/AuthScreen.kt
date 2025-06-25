package com.yusuf0080.komdigiapps.ui.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.yusuf0080.komdigiapps.model.User
import com.yusuf0080.komdigiapps.navigation.Screen
import com.yusuf0080.komdigiapps.util.ViewModelFactory

@Composable
fun LoginScreen(navController: NavController) {
    val context = LocalContext.current
    val viewModel: AuthViewModel = viewModel(factory = ViewModelFactory(context))
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Login", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = username, onValueChange = { username = it }, label = { Text("Username") })
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = password, onValueChange = { password = it }, label = { Text("Password") }, visualTransformation = PasswordVisualTransformation())
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            viewModel.login(username, password) { success ->
                if (success) {
                    Toast.makeText(context, "Login Berhasil!", Toast.LENGTH_SHORT).show()
                    navController.navigate(Screen.Home.route) { popUpTo(0) }
                } else {
                    Toast.makeText(context, "Username atau Password Salah", Toast.LENGTH_SHORT).show()
                }
            }
        }) { Text("MASUK") }
        Spacer(modifier = Modifier.height(8.dp))
        TextButton(onClick = { navController.navigate(Screen.Register.route) }) {
            Text("Belum punya akun? Daftar")
        }
    }
}

@Composable
fun RegisterScreen(navController: NavController) {
    val context = LocalContext.current
    val viewModel: AuthViewModel = viewModel(factory = ViewModelFactory(context))
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Daftar Akun", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = username, onValueChange = { username = it }, label = { Text("Username") })
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = password, onValueChange = { password = it }, label = { Text("Password") }, visualTransformation = PasswordVisualTransformation())
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            val user = User(username = username, password = password)
            viewModel.registerUser(user) { success, message ->
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                if (success) {
                    navController.popBackStack()
                }
            }
        }) { Text("DAFTAR") }
    }
}