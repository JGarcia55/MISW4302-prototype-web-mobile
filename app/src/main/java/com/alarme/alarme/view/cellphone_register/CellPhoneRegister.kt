package com.alarme.alarme.view.cellphone_register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alarme.alarme.theme.Primary_700
import com.alarme.alarme.theme.Secondary_100
import com.alarme.alarme.theme.Secondary_500
import com.alarme.alarme.view.core.BottomBar
import com.alarme.alarme.view.core.TopBar
import com.alarme.contactregister.R


@Composable
fun CellphoneRegister() {
    Scaffold(
        topBar = { TopBar(topBarName = R.string.backup_contacts_name, isBackEnabled = true) },
        bottomBar = { BottomBar() }
    ) { paddingValues ->

        Card(
            modifier = Modifier
                .padding(paddingValues)
                .padding(top = 16.dp, start = 16.dp, end = 16.dp),
            colors = CardDefaults.cardColors(
                contentColor = Color.Black,
                containerColor = Secondary_100
            )
        ) {
            GetDescriptionText()
        }

    }
}

@Composable
fun GetDescriptionText() {
    Column(modifier = Modifier.fillMaxHeight(0.65F),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            modifier = Modifier
                .padding(start = 24.dp, end = 24.dp, top = 24.dp),
            text = LocalContext.current.getString(R.string.cellphone_register_text),
            style = TextStyle(
                fontSize = dimensionResource(id = R.dimen.text_medium).value.sp,
                color = Secondary_500
            )
        )
        Column {
            PhoneNumberInput()
        }

        

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Button(modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(
                    top = dimensionResource(id = R.dimen.value_64).value.dp,
                    start = dimensionResource(id = R.dimen.value_8).value.dp,
                    end = dimensionResource(id = R.dimen.value_8).value.dp
                ),
                colors = ButtonColors(
                    containerColor = Primary_700,
                    contentColor = Color.White,
                    disabledContainerColor = Color.Unspecified,
                    disabledContentColor = Color.Unspecified
                ),
                onClick = { /*TODO*/ }) {
                Text(text = LocalContext.current.getString(R.string.continue_text),
                    style = TextStyle(
                        textAlign = TextAlign.Center,
                        fontSize = dimensionResource(id = R.dimen.text_large).value.sp
                    ))
            }
        }

        Text(
            modifier = Modifier
                .padding(
                    top = dimensionResource(id = R.dimen.value_32).value.dp,
                    start = dimensionResource(id = R.dimen.value_32).value.dp,
                    end = dimensionResource(id = R.dimen.value_32).value.dp
                ),
            text = LocalContext.current.getString(R.string.cellphone_register_subtext),
            style = TextStyle(
                fontSize = dimensionResource(id = R.dimen.text_medium).value.sp,
                textAlign = TextAlign.Center,
                color = Secondary_500
            )
        )

    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhoneNumberInput() {
    var phoneNumber by remember { mutableStateOf("") }
    var selectedCountryCode by remember { mutableStateOf("+1") } // Default country code
    var expanded by remember { mutableStateOf(false) }
    var text by remember { mutableStateOf("3102561578") }

    val countryCodes = listOf("+1", "+34", "+52", "+55") // Add more country codes as needed

    Row(modifier = Modifier
        .padding(top = dimensionResource(id = R.dimen.value_64).value.dp,
        start = dimensionResource(id = R.dimen.value_32).value.dp,
        end = dimensionResource(id = R.dimen.value_32).value.dp),
        ) {
        // Dropdown for country code selection
        ExposedDropdownMenuBox(
            modifier = Modifier
                .width(96.dp),
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            TextField(
                readOnly = true,
                value = selectedCountryCode,
                onValueChange = {},
                label = { Text("País") },
                trailingIcon = {
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Dropdown")
                },
                modifier = Modifier
                    .menuAnchor(MenuAnchorType.PrimaryEditable, enabled = true)
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                countryCodes.forEach { code ->
                    DropdownMenuItem(text =
                    { Text(text = code) }, onClick = {
                        selectedCountryCode = code
                        expanded = false
                    })
                }
            }
        }

        // TextField for phone number
        TextField(value = text,
            onValueChange = { text = it},
            label = { Text(LocalContext.current.getString(R.string.telephone_text)) },
            placeholder = { Text("Placeholder") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = dimensionResource(R.dimen.value_24).value.dp),
        )
    }
}