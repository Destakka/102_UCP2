package com.example.pam_ucp2.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.pam_ucp2.R
import com.example.pam_ucp2.data.UIState

@Composable
fun HalamanTiga(
    FormUIState : UIState,
    onCancelButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
){
    val items = listOf(
        Pair(stringResource(R.string.nama), FormUIState.nama),
        Pair(stringResource(R.string.sayur), FormUIState.sayur),
        Pair(stringResource(R.string.buah), FormUIState.buah)
    )
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            Column(
                modifier = Modifier
                    .padding(10.dp),

                ) {
                items.forEach { item ->
                    Column {
                        Text(item.first.uppercase())
                        Text(text = item.second.toString(), fontWeight = FontWeight.Bold)
                    }
                    Divider(thickness = 1.dp)
                    Spacer(modifier = Modifier.padding(10.dp))
                }
            }
            Row(
                modifier = Modifier
                    .weight(1f, false)
                    .padding(8.dp)
            ){
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedButton(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = onCancelButtonClicked
                    ) {
                        Text(stringResource(R.string.Kembali))
                    }
                }
            }
        }
    }
}