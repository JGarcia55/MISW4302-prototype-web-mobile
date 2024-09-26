package com.alarme.alarme.view.user_register

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults.colors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.alarme.alarme.theme.Primary_700
import com.alarme.alarme.theme.Secondary_100
import com.alarme.alarme.view.core.SecondaryTopBar
import com.alarme.alarme.view.home.AlarmeHomeActivity
import com.alarme.alarme.view.util.newIntent
import com.alarme.contactregister.R

@Composable
fun UserRegisterUI() {
    Scaffold(
        topBar = { SecondaryTopBar(isBackEnabled = true) },
        containerColor = Color.White
    ) { paddingValues ->
        UserRegisterData(paddingValues)
    }
}

@Composable
fun UserRegisterData(paddingValues: PaddingValues) {
    var userData by remember { mutableStateOf(UserData()) }
    val isFormValid = userData.isFormValid()
    val context = LocalContext.current as? ComponentActivity

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(top = dimensionResource(id = R.dimen.value_64).value.dp)
            .fillMaxWidth()
    ) {
        Card(
            colors = CardDefaults.cardColors(
                contentColor = Color.Black,
                containerColor = Secondary_100
            ),
            modifier = Modifier
                .padding(16.dp)
                .fillMaxHeight(0.86f),
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                ItemRegisterData(
                    label = "Nombre",
                    value = userData.name,
                    onValueChange = {
                        userData = userData.copy(name = it, nameError = validateName(it))
                    },
                    error = userData.nameError
                )
                ItemRegisterData(
                    label = "Apellido",
                    value = userData.lastName,
                    onValueChange = {
                        userData = userData.copy(lastName = it, lastNameError = validateName(it))
                    },
                    error = userData.lastNameError
                )
                ItemRegisterData(
                    label = "Correo",
                    value = userData.email,
                    onValueChange = {
                        userData = userData.copy(email = it, emailError = validateEmail(it))
                    },
                    error = userData.emailError
                )
                ItemRegisterData(
                    label = "Contraseña",
                    value = userData.password,
                    onValueChange = {
                        userData =
                            userData.copy(password = it, passwordError = validatePassword(it))
                    },
                    error = userData.passwordError,
                    isPassword = true
                )
            }
            Button(
                onClick = {
                    context?.startActivity(context.newIntent<AlarmeHomeActivity>())
                },
                enabled = !isFormValid || userData.isFormValid(),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth(0.5f)
                    .padding(top = dimensionResource(id = R.dimen.value_32).value.dp)
                    .size(width = 200.dp, height = 48.dp),
            ) {
                Text("Registrarse")
            }
        }
    }
}

@Composable
fun ItemRegisterData(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    error: String?,
    isPassword: Boolean = false
) {
    Column(
        modifier = Modifier
            .padding(vertical = 16.dp, horizontal = 16.dp)
    ) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            label = { Text(label) },
            placeholder = { Text("Indique aquí su $label") },
            visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
            isError = error != null,
            colors =
            colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                disabledTextColor = Color.Gray,
                errorTextColor = Color.Red,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                disabledContainerColor = Color.LightGray,
                errorContainerColor = Color.White,
                cursorColor = Color.Black,
                errorCursorColor = Color.Red,
                focusedIndicatorColor = Primary_700, // Suponiendo que este es tu color azul primario
                unfocusedIndicatorColor = Primary_700,
                disabledIndicatorColor = Color.Gray,
                errorIndicatorColor = Color.Red,
                focusedTrailingIconColor = Primary_700,
                unfocusedTrailingIconColor = Primary_700,
                disabledTrailingIconColor = Color.Gray,
                errorTrailingIconColor = Color.Red,
                focusedLabelColor = Primary_700,
                unfocusedLabelColor = Primary_700,
                disabledLabelColor = Color.Gray,
                errorLabelColor = Color.Red,
                focusedPlaceholderColor = Color.Gray,
                unfocusedPlaceholderColor = Color.Gray,
                disabledPlaceholderColor = Color.LightGray,
                errorPlaceholderColor = Color.Red,
                focusedSupportingTextColor = Color.Gray,
                unfocusedSupportingTextColor = Color.Gray,
                disabledSupportingTextColor = Color.LightGray,
                errorSupportingTextColor = Color.Red,
                focusedPrefixColor = Color.Gray,
                unfocusedPrefixColor = Color.Gray,
                disabledPrefixColor = Color.LightGray,
                errorPrefixColor = Color.Red,
                focusedSuffixColor = Color.Gray,
                unfocusedSuffixColor = Color.Gray,
                disabledSuffixColor = Color.LightGray,
                errorSuffixColor = Color.Red,
            ),
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                if (value.isNotEmpty()) {
                    IconButton(onClick = { onValueChange("") }) {
                        Icon(Icons.Filled.Close, contentDescription = "Clear text")
                    }
                }
            }
        )
        if (error != null) {
            Text(
                text = error,
                color = Color.Red,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }
}

// Validación de nombre y apellido (Ejemplo básico)
fun validateName(name: String): String? {
    return if (name.isBlank()) "El campo no puede estar vacío" else null
}

// Validación de correo electrónico
fun validateEmail(email: String): String? {
    return if (email.isBlank()) {
        "El campo no puede estar vacío"
    } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
        "Correo electrónico no válido"
    } else null
}

// Validación de contraseña (Ejemplo básico)
fun validatePassword(password: String): String? {
    return if (password.isBlank()) {
        "El campo no puede estar vacío"
    } else if (password.length < 6) {
        "La contraseña debe tener al menos 6 caracteres"
    } else null
}

data class UserData(
    val name: String = "",
    val lastName: String = "",
    val email: String = "",
    val password: String = "",
    val nameError: String? = null,
    val lastNameError: String? = null,
    val emailError: String? = null,
    val passwordError: String? = null
) {
    fun isFormValid(): Boolean {
        return nameError == null && lastNameError == null && emailError == null && passwordError == null &&
                name.isNotBlank() && lastName.isNotBlank() && email.isNotBlank() && password.isNotBlank()
    }
}