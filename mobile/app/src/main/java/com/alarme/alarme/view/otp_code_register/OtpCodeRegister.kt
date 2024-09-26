package com.alarme.alarme.view.otp_code_register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
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
import com.alarme.alarme.theme.Primary_50
import com.alarme.alarme.theme.Primary_700
import com.alarme.alarme.theme.Secondary_100
import com.alarme.alarme.theme.Secondary_500
import com.alarme.alarme.view.core.BottomBar
import com.alarme.alarme.view.core.TopBar
import com.alarme.contactregister.R

@Composable
fun OtpCodeRegister() {
    Scaffold(
        topBar = { TopBar(topBarName = R.string.verification_title_text, isBackEnabled = true) },
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
            OtpCardView()
        }

    }
}

@Composable
fun OtpCardView() {
    Column(modifier = Modifier.fillMaxHeight(0.9F),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            modifier = Modifier
                .padding(start = 24.dp, end = 24.dp, top = 24.dp),
            text = LocalContext.current.getString(R.string.verification_phone_text),
            style = TextStyle(
                fontSize = dimensionResource(id = R.dimen.text_medium).value.sp,
                color = Secondary_500
            )
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, top = 24.dp),
            text = LocalContext.current.getString(R.string.verification_phone_4_digits_subtext),
            style = TextStyle(
                fontSize = dimensionResource(id = R.dimen.text_medium).value.sp,
                color = Secondary_500,
                textAlign = TextAlign.Start
            )
        )
        Column {
            OtpScreen()
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
                    )
                )
            }
        }

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = dimensionResource(id = R.dimen.value_32).value.dp,
                    start = dimensionResource(id = R.dimen.value_32).value.dp,
                    end = dimensionResource(id = R.dimen.value_32).value.dp
                ),
            text = LocalContext.current.getString(R.string.wrong_number_text),
            style = TextStyle(
                fontSize = dimensionResource(id = R.dimen.text_medium).value.sp,
                textAlign = TextAlign.Start,
                color = Secondary_500
            )
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = dimensionResource(id = R.dimen.value_8).value.dp,
                    start = dimensionResource(id = R.dimen.value_32).value.dp,
                    end = dimensionResource(id = R.dimen.value_32).value.dp
                ),
            text = LocalContext.current.getString(R.string.resend_code_text),
            style = TextStyle(
                fontSize = dimensionResource(id = R.dimen.text_medium).value.sp,
                textAlign = TextAlign.Start,
                color = Secondary_500
            )
        )

    }
}
@Composable
fun OtpScreen() {
    var otpCode by remember { mutableStateOf("") }

    Column {
        OtpView(
            otpText = otpCode,
            onOtpTextChange = { otpCode = it },
            otpCount = 4,
            type = KeyboardType.Number
        )
    }
}

@Composable
fun OtpView(
    otpText: String,
    onOtpTextChange: (String) -> Unit,
    otpCount: Int,
    type: KeyboardType
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp, top = 32.dp)
    ) {
        (0 until otpCount).forEach { index ->
            TextField(
                value = otpText.getOrNull(index)?.toString() ?: "",
                onValueChange = { if (it.length <= 1) onOtpTextChange(otpText.substring(0, index) + it + otpText.substring(index)) },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = type),
                singleLine = true,
                modifier = Modifier
                    .width(50.dp)
                    .padding(4.dp)
                    .background(Primary_50),
            )
        }
    }
}
