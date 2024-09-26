package com.alarme.alarme.view.cellphone_register

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.alarme.alarme.theme.MainAppTheme

class CellphoneRegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainAppTheme {
                CellphoneRegister()
            }
        }
    }
}
