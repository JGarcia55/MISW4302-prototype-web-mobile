package com.alarme.alarme.view.maincontactregister

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alarme.alarme.theme.Primary_700
import com.alarme.alarme.theme.Secondary_100
import com.alarme.alarme.theme.Secondary_500
import com.alarme.alarme.theme.Secondary_700
import com.alarme.alarme.view.cellphone_register.CellphoneRegisterActivity
import com.alarme.alarme.view.core.BottomBar
import com.alarme.alarme.view.core.TopBar
import com.alarme.alarme.view.util.newIntent
import com.alarme.contactregister.R

@Composable
fun MainContactRegisterUI() {
    Scaffold(
        topBar = { TopBar(topBarName = R.string.backup_contacts_name, isBackEnabled = true) },
        bottomBar = { BottomBar() }
    ) { paddingValues ->

        Card(
            modifier = Modifier
                .padding(paddingValues)
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                .clickable {
//                        ContextCompat.startActivity(
//                            context,
//                            CollectorDetailActivity.newIntent(context, collector),
//                            null
//                        )
                },
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
    val activity = LocalContext.current as? MainContactRegisterActivity
    Column(modifier = Modifier.fillMaxHeight(0.6F),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            modifier = Modifier
                .padding(start = 24.dp, end = 24.dp, top = 24.dp),
            text = LocalContext.current.getString(R.string.backup_contact_description_text),
            style = TextStyle(
                fontSize = dimensionResource(id = R.dimen.text_medium).value.sp,
                color = Secondary_500
            )
        )
        Text(
            modifier = Modifier
                .padding(
                    start = dimensionResource(id = R.dimen.value_32).value.dp,
                    top = 8.dp,
                    end = dimensionResource(id = R.dimen.value_32).value.dp
                ),
            text = LocalContext.current.getString(R.string.backup_contact_description_first_subtext),
            style = TextStyle(
                fontSize = dimensionResource(id = R.dimen.text_medium).value.sp,
                color = Secondary_500
            )
        )
        Text(
            modifier = Modifier
                .padding(
                    start = dimensionResource(id = R.dimen.value_32).value.dp,
                    end = dimensionResource(id = R.dimen.value_32).value.dp
                ),
            text = LocalContext.current.getString(R.string.backup_contact_description_second_subtext),
            style = TextStyle(
                fontSize = dimensionResource(id = R.dimen.text_medium).value.sp,
                color = Secondary_500
            )
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(modifier = Modifier
                .padding(top = dimensionResource(id = R.dimen.value_64).value.dp,
                    start = dimensionResource(id = R.dimen.value_8).value.dp,
                    end = dimensionResource(id = R.dimen.value_8).value.dp)
                .weight(0.5f),
                colors = ButtonColors(
                    containerColor = Primary_700,
                    contentColor = Color.White,
                    disabledContainerColor = Color.Unspecified,
                    disabledContentColor = Color.Unspecified
                ),
                onClick = {
                    context.startActivity(activity?.newIntent<CellphoneRegisterActivity>())
                }) {
                Text(text = LocalContext.current.getString(R.string.import_contacts_text),
                    style = TextStyle(
                        textAlign = TextAlign.Center,
                        fontSize = dimensionResource(id = R.dimen.text_large).value.sp
                    ))
            }
            Button(modifier = Modifier
                .padding(top = dimensionResource(id = R.dimen.value_64).value.dp,
                    start = dimensionResource(id = R.dimen.value_8).value.dp,
                    end = dimensionResource(id = R.dimen.value_8).value.dp)
                .weight(0.5f),
                colors = ButtonColors(
                    containerColor = Secondary_700,
                    contentColor = Color.White,
                    disabledContainerColor = Color.Unspecified,
                    disabledContentColor = Color.Unspecified
                ),
                onClick = { /*TODO*/ }) {
                Text(text = LocalContext.current.getString(R.string.add_contact_text),
                    style = TextStyle(
                        textAlign = TextAlign.Center,
                        fontSize = dimensionResource(id = R.dimen.text_large).value.sp
                    ))
            }
        }

    }
}