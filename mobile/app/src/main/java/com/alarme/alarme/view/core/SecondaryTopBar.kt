package com.alarme.alarme.view.core

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.alarme.alarme.theme.Primary_700
import com.alarme.alarme.view.util.ActionItems
import com.alarme.contactregister.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondaryTopBar(
    isBackEnabled: Boolean,
) {
    val colorResource = Color.White
    val toolbarColor = remember { mutableStateOf(colorResource) }
    TopAppBar(
        title = {
            Text(
                modifier = Modifier
                    .fillMaxWidth(0.9f),
                text = ContextCompat.getString(LocalContext.current, R.string.app_name),
                color = Primary_700,
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = dimensionResource(id = R.dimen.value_48).value.sp,
                    color = Primary_700
                )
            )

        },
        colors = TopAppBarDefaults.topAppBarColors(toolbarColor.value),
        navigationIcon = {
            if (isBackEnabled) {
                ActionItems(Primary_700)
            }
        })
}