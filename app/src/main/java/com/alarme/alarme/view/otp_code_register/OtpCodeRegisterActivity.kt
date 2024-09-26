package com.alarme.alarme.view.otp_code_register

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.alarme.alarme.theme.MainAppTheme

class OtpCodeRegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainAppTheme {
                OtpCodeRegister()
            }
        }
    }
}
