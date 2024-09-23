package com.alarme.alarme.view.core


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.sharp.FavoriteBorder
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.alarme.alarme.theme.Primary_50
import com.alarme.alarme.theme.Primary_800
import com.alarme.contactregister.R

@Composable
fun BottomBar() {
    val context = LocalContext.current
    val alarmInteractionSource = remember { MutableInteractionSource() }
    val contactsInteractionSource = remember { MutableInteractionSource() }

    var isAlarmTabSelected by remember { mutableStateOf(false) }
    var isContactTabSelected by remember { mutableStateOf(true) }
    BottomAppBar(containerColor = Color.Transparent) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(0.5f)
                    .background(
                        if (isContactTabSelected) {
                            Primary_50
                        } else {
                            Primary_800
                        }
                    )
                    .clickable {
//                        TODO("MOSTRAR PANTALLA DE ALARMAS")
                        isContactTabSelected = false
                        isAlarmTabSelected = true
                    },
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                IconButton(
                    onClick = {
                        isContactTabSelected = false
                        isAlarmTabSelected = true
                    },
                    interactionSource = alarmInteractionSource
                ) {
                    Icon(
                        painter = if (isAlarmTabSelected) {
                            painterResource(id = R.drawable.filled_alarm) // Asegúrate que sea un drawable
                        } else {
                            painterResource(id = R.drawable.outline_alarm) // Otro drawable
                        }, contentDescription = "Alarm",
                        tint = if (isContactTabSelected) {
                            Primary_800
                        } else {
                            Primary_50
                        }
                    )
                }
                Text(
                    text = context.getString(R.string.alarms_text),
                    color = if (isContactTabSelected) {
                        Primary_800
                    } else {
                        Primary_50
                    },
                    fontSize = 12.sp // Adjust as necessary
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(0.5f)
                    .background(
                        if (isAlarmTabSelected) {
                            Primary_50
                        } else {
                            Primary_800
                        }
                    )
                    .clickable {
                        isContactTabSelected = true
                        isAlarmTabSelected = false
                    }
            ) {
                IconButton(
                    onClick = {
                        isContactTabSelected = true
                        isAlarmTabSelected = false
                    },
                    interactionSource = contactsInteractionSource
                ) {
                    Icon(
                        if (isContactTabSelected) {
                            Icons.Filled.Favorite
                        } else {
                            Icons.Sharp.FavoriteBorder
                        }, contentDescription = "Contacts",
                        tint = if (isAlarmTabSelected) {
                            Primary_800
                        } else {
                            Primary_50
                        }
                    )
                }
                Text(
                    text = context.getString(R.string.contacts_text),
                    color = if (isAlarmTabSelected) {
                        Primary_800
                    } else {
                        Primary_50
                    },
                    fontSize = 12.sp // Adjust as necessary
                )
            }
        }
    }

}
