package com.alarme.alarme.view.contactregister

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alarme.alarme.theme.Secondary_50
import com.alarme.alarme.view.core.BottomBar
import com.alarme.alarme.view.core.TopBar
import com.alarme.contactregister.R

@Composable
fun ContactRegisterUI() {
    Scaffold(
        topBar = { TopBar(topBarName = R.string.backup_contacts_name, isBackEnabled = true) },
        bottomBar = { BottomBar() }
    ) { paddingValues ->
        Column {
            Text(
                text = LocalContext.current.getString(R.string.contacts_text),
                Modifier.padding(paddingValues),
                fontSize = dimensionResource(id = R.dimen.text_large).value.sp,
                textAlign = TextAlign.Center
            )

            ItemList(items = listOf("Juan Diego García", "Brayan García"))
        }

    }

}

@Composable
fun ItemList(items: List<String>) {
    LazyColumn (contentPadding = PaddingValues(horizontal = 16.dp)) {
        items(items.size) { item ->
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Transparent)
                    .testTag("CollectorListItem")
                    .clickable {
//                        ContextCompat.startActivity(
//                            context,
//                            CollectorDetailActivity.newIntent(context, collector),
//                            null
//                        )
                    },
                colors = CardDefaults.cardColors(
                    contentColor = Secondary_50,
                    containerColor = Secondary_50
                )
            ) {
                Text(
                    modifier = Modifier.padding(16.dp),
                    text = items[item],
                    color = Color.Black,
                    style = TextStyle(
                        fontWeight = FontWeight.Medium,
                        fontSize = 24.sp,
                        color = Color.Black
                    ),
                )
            }
        }
    }
}