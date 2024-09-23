package com.alarme.alarme.view.core

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.alarme.alarme.theme.Primary_100
import com.alarme.alarme.view.util.ActionItems
import com.alarme.contactregister.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    @StringRes topBarName: Int,
    isBackEnabled: Boolean,
    rightButtonAction: @Composable () -> Unit = { RightTextAction() }
) {
    val colorResource = colorResource(id = R.color.primary_700)
    val toolbarColor = remember { mutableStateOf(colorResource) }
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .weight(0.8f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = ContextCompat.getString(LocalContext.current, topBarName),
                        color = Primary_100,
                        style = TextStyle(
                            fontWeight = FontWeight.SemiBold,
                            fontStyle = FontStyle.Italic,
                            fontSize = dimensionResource(id = R.dimen.text_large).value.sp,
                            color = Primary_100
                        )
                    )
                }
                rightButtonAction()

            }
        },
        colors = TopAppBarDefaults.topAppBarColors(toolbarColor.value),
        navigationIcon = {
            if (isBackEnabled) {
                ActionItems()
            }
        })
}

@Composable
fun RightTextAction(@StringRes textName: Int = R.string.logout_text) {
    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = Color.White
        ),
    ) {
        Text(
            text = ContextCompat.getString(LocalContext.current, textName),
            color = Color.White,
            style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontStyle = FontStyle.Italic,
                fontSize = dimensionResource(id = R.dimen.text_small).value.sp,
                color = Color.White
            )
        )
    }

}