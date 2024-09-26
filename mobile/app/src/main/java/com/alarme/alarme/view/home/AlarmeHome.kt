package com.alarme.alarme.view.home

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alarme.alarme.theme.Secondary_100
import com.alarme.alarme.theme.Secondary_800
import com.alarme.alarme.view.core.BottomBar
import com.alarme.alarme.view.core.TopBar
import com.alarme.contactregister.R

@Composable
fun AlarmeHome() {
    Scaffold(
        topBar = { TopBar(topBarName = R.string.start_title, isBackEnabled = false) },
        bottomBar = { BottomBar(alarmTabSelected = true) }
    ) { paddingValues ->
        Column {
            AlarmItem(
                paddingValues = paddingValues,
                items = listOf(
                    Alarm("Despertador", "12:00 AM", "Diario"),
                    Alarm("Llamar a amigo", "7:30 AM", "30/05/2024")
                )
            )

            Button(
                modifier = Modifier
                    .padding(top = LocalContext.current.resources.getDimension(R.dimen.value_16).dp)
                    .align(Alignment.End)
                    .size(
                        width = 110.dp,
                        height = 110.dp
                    ),
                onClick = {

                }) {
                Text(
                    text = LocalContext.current.getString(R.string.add_alarm_text),
                    style = TextStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                        color = Color.White
                    ),
                    textAlign = TextAlign.Justify
                )
            }
        }

    }

}

@Composable
fun AlarmItem(paddingValues: PaddingValues, items: List<Alarm>) {
    val switchStatus = remember { mutableStateListOf(true, true) }

    var isClicked by remember { mutableStateOf(false) }
    val interactionSource = remember {
        mutableStateListOf(
            MutableInteractionSource(),
            MutableInteractionSource()
        )
    }
    val isPressed = remember { mutableStateListOf(false, false) }

    // Monitorear las interacciones de tipo Press y Release
    interactionSource.forEachIndexed { index, mutableInteractionSource ->
        LaunchedEffect(mutableInteractionSource) {

            mutableInteractionSource.interactions.collect { interaction ->

                when (interaction) {
                    is PressInteraction.Press -> isPressed[index] = true
                    is PressInteraction.Release,
                    is PressInteraction.Cancel -> isPressed[index] = false
                }
            }

        }
    }


    Spacer(
        modifier = Modifier
            .size(22.dp)
            .padding(paddingValues)
    )
    LazyColumn(contentPadding = paddingValues) {
        items(items.size) { item ->
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Transparent)
                    .padding(start = 16.dp, end = 16.dp),
                colors = CardDefaults.cardColors(
                    contentColor = Secondary_100,
                    containerColor = Secondary_100
                )
            ) {
                Spacer(
                    modifier = Modifier
                        .size(10.dp)
                        .padding(paddingValues)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly,
                ) {
                    Column(
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .fillMaxWidth(0.5F)
                    ) {
                        Text(
                            modifier = Modifier.padding(start = 8.dp),
                            text = items[item].title,
                            color = Secondary_800,
                            style = TextStyle(
                                fontWeight = FontWeight.Normal,
                                fontSize = 12.sp,
                                color = Secondary_800
                            ),
                        )
                        Text(
                            modifier = Modifier.padding(start = 8.dp, top = 4.dp, bottom = 4.dp),
                            text = items[item].hour,
                            color = Color.Black,
                            style = TextStyle(
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp,
                                color = Color.Black
                            ),
                        )
                        Text(
                            modifier = Modifier.padding(start = 8.dp, bottom = 8.dp),
                            text = items[item].frequency,
                            color = Secondary_800,
                            style = TextStyle(
                                fontWeight = FontWeight.Normal,
                                fontSize = 12.sp,
                                color = Secondary_800
                            ),
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.End,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Row {
                            Switch(
                                checked = switchStatus[item],
                                onCheckedChange = { switchStatus[item] = it }
                            )
                            IconButton(
                                interactionSource = interactionSource[item],
                                onClick = {

                                    /* Acción cuando se presiona el botón */
                                },
                            ) {
                                Icon(
                                    modifier = Modifier
                                        .size(if (isPressed[item]) 48.dp else 24.dp),
                                    imageVector = Icons.Outlined.Delete,
                                    contentDescription = "Delete",
                                    tint = if (isPressed[item]) Color.Red else Color.Black
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}