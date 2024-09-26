package com.alarme.alarme.view.contact_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alarme.alarme.theme.Secondary_100
import com.alarme.alarme.view.core.BottomBar
import com.alarme.alarme.view.core.TopBar
import com.alarme.alarme.view.maincontactregister.MainContactRegisterActivity
import com.alarme.alarme.view.util.newIntent
import com.alarme.contactregister.R

@Composable
fun ContactListRegister() {
    val context = LocalContext.current
    val activity = context as? ContactListRegisterActivity
    Scaffold(
        topBar = { TopBar(topBarName = R.string.backup_contacts_name, isBackEnabled = true) },
        bottomBar = { BottomBar() }
    ) { paddingValues ->
        Column (modifier = Modifier.padding(paddingValues)) {
            ItemList(
                title = LocalContext.current.getString(R.string.backup_cellphone_contacts_title),
                paddingValues = null,
                items = listOf("Juan Diego García", "Camilo García", "Brayan García")
            )
            ItemList(
                title = LocalContext.current.getString(R.string.backup_app_contacts_title),
                paddingValues = null,
                items = listOf("Juan Diego García", "Brayan García")
            )

            Button(
                modifier = Modifier
                    .padding(top = LocalContext.current.resources.getDimension(R.dimen.value_16).dp)
                    .align(Alignment.CenterHorizontally)
                    .size(width = 184.dp, height = LocalContext.current.resources.getDimension(R.dimen.value_32).dp),
                onClick = {
                    context.startActivity(activity?.newIntent<MainContactRegisterActivity>())
            }) {
                Text(
                    text = LocalContext.current.getString(R.string.register_contact_text),
                    style = TextStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 22.sp,
                        color = Color.White
                    ),
                    textAlign = TextAlign.Center
                )
            }
        }

    }

}

@Composable
fun ItemList(title: String, paddingValues: PaddingValues?, items: List<String>) {
    Text(
        text = title,
        paddingValues?.let {
            Modifier
                .padding(
                    start = dimensionResource(id = R.dimen.value_16).value.dp,
                    top = dimensionResource(id = R.dimen.value_82).value.dp,
                    bottom = dimensionResource(id = R.dimen.value_16).value.dp
                )
        } ?: Modifier
            .padding(
                start = dimensionResource(id = R.dimen.value_16).value.dp,
                top = dimensionResource(id = R.dimen.value_16).value.dp,
                bottom = dimensionResource(id = R.dimen.value_16).value.dp
            ),
        fontSize = dimensionResource(id = R.dimen.text_large).value.sp,
        textAlign = TextAlign.Center,
        style = TextStyle(
            fontWeight = FontWeight.Normal
        )
    )
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp)) {
        items(items.size) { item ->
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Transparent),
                colors = CardDefaults.cardColors(
                    contentColor = Secondary_100,
                    containerColor = Secondary_100
                )
            ) {
                Text(
                    modifier = Modifier.padding(16.dp),
                    text = items[item],
                    color = Color.Black,
                    style = TextStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                        color = Color.Black
                    ),
                )
            }
        }
    }
}