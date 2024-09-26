package com.alarme.alarme.view.util

import android.content.Context
import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.alarme.contactregister.R

@Composable
fun ActionItems(color: Color = Color.White) {
    val activity = LocalContext.current as? ComponentActivity
    // IconButton se beneficia del RowScope para ser colocado dentro de un Row
    IconButton(
        onClick = { activity?.finish() },
        modifier = Modifier.testTag("BackButton")
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = ContextCompat.getString(
                LocalContext.current,
                R.string.back_button_text
            ),
            modifier = Modifier
                .size(40.dp),
            tint = color
        )
    }
}

inline fun <reified T : ComponentActivity> ComponentActivity.newIntent(): Intent =
    Intent(this, T::class.java)