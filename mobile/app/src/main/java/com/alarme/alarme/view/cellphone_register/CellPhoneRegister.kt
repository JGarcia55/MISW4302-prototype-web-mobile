package com.alarme.alarme.view.cellphone_register

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alarme.alarme.theme.Primary_700
import com.alarme.alarme.theme.Secondary_100
import com.alarme.alarme.theme.Secondary_200
import com.alarme.alarme.theme.Secondary_500
import com.alarme.alarme.view.core.BottomBar
import com.alarme.alarme.view.core.TopBar
import com.alarme.alarme.view.otp_code_register.OtpCodeRegisterActivity
import com.alarme.alarme.view.util.newIntent
import com.alarme.contactregister.R
import com.google.i18n.phonenumbers.PhoneNumberUtil
import java.util.Locale as JavaLocale


@Composable
fun CellphoneRegister() {
    Scaffold(
        topBar = { TopBar(topBarName = R.string.register_number_name, isBackEnabled = true) },
        bottomBar = { BottomBar() }
    ) { paddingValues ->

        Card(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxHeight(0.7f),
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
    val context = LocalContext.current
    val activity = context as? CellphoneRegisterActivity
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
                onClick = {
                    context.startActivity(activity?.newIntent<OtpCodeRegisterActivity>())
                }) {
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
    var expanded by remember { mutableStateOf(false) }
    var text by remember { mutableStateOf("3102561578") }

    Row(modifier = Modifier
        .padding(top = dimensionResource(id = R.dimen.value_64).value.dp,
        start = dimensionResource(id = R.dimen.value_32).value.dp,
        end = dimensionResource(id = R.dimen.value_32).value.dp),
        ) {
        // Dropdown for country code selection
        CountryCodePicker(
            isoCountries = JavaLocale.getISOCountries().toList()
        )

        // TextField for phone number
        TextField(value = text,
            onValueChange = { text = it},
            label = { Text(LocalContext.current.getString(R.string.telephone_text)) },
            placeholder = { Text("Placeholder") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = dimensionResource(R.dimen.value_24).value.dp),
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
                )
        )
    }
}

@Composable
fun CountryCodePicker(
    isoCountries: List<String>
) {
    var selectedCountryCode by remember { mutableStateOf(JavaLocale.US) } // Default country code
    var expanded by remember { mutableStateOf(false) }
    val locales = isoCountries.map { countryCode -> JavaLocale("", countryCode) }
    val phoneUtil = PhoneNumberUtil.getInstance()

    Box (modifier = Modifier.background(Secondary_200)) {
        Row(
            modifier = Modifier
                .clickable { expanded = true }
                .padding(16.dp)
        ) {
            Text(text = getFlagEmoji(selectedCountryCode.country))
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "+${phoneUtil.getCountryCodeForRegion(selectedCountryCode.country)}")
            Spacer(modifier = Modifier.width(8.dp))
            Icon(Icons.Filled.ArrowDropDown, contentDescription = "Country code dropdown")
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            locales.forEach { locale ->
                DropdownMenuItem(text = {
                    Row {
                        Text(text = getFlagEmoji(locale.country))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "${locale.displayCountry} (+${phoneUtil.getCountryCodeForRegion(locale.country)})")
                    }
                                        },onClick = {
                    selectedCountryCode = locale
                    expanded = false
                })
            }
        }
    }
}

fun getFlagEmoji(countryCode: String): String {
    return countryCode
        .uppercase()
        .map { char ->
            Character.toChars(127397 + char.code).joinToString("")
        }.joinToString("")
}