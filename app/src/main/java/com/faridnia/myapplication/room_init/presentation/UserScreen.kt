package com.faridnia.myapplication.room_init.presentation


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.faridnia.myapplication.room_init.data.User

@Composable
fun UserScreen(
    viewModel: UserViewModel = hiltViewModel()
) {
    val users by viewModel.users.collectAsState(emptyList())

    UserContent(users)
}

@Composable
fun UserContent(users: List<User>) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        // 🔹 Form
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )

        Button(
            onClick = {
                if (name.isNotBlank() && email.isNotBlank()) {
                    // viewModel.addUser(User(name = name, email = email, timestamp = System.currentTimeMillis()))
                    name = ""
                    email = ""
                }
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Add User")
        }

        Divider(modifier = Modifier.padding(vertical = 16.dp))

        // 🔹 User List
        LazyColumn {
            items(users) { user ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text("👤 ${user.name}")
                        Text("📧 ${user.email}", style = MaterialTheme.typography.bodyMedium)
                    }
                    IconButton(onClick = {/* viewModel.deleteUser(user)*/ }) {
                        Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete")
                    }
                }
                Divider()
            }
        }
    }
}


@Preview
@Composable
fun PreviewUserScreen() {
    UserContent(
        listOf(
            User(
                name = "Milad",
                email = "thomas.a.hendricks@example.com",
                createDate = 2222
            )
        )
    )
}