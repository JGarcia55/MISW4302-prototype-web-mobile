package com.alarme.alarme.view.contact_list

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.alarme.alarme.theme.MainAppTheme

class ContactListRegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainAppTheme {
                ContactListRegister()
            }
        }
    }
}
