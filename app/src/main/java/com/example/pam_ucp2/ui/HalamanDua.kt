import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pam_ucp2.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanDua(
    macamsayur : List<String>,
    macambuah : List<String>,
    onSelectionChanged1: (String) -> Unit,
    onSelectionChanged2: (String) -> Unit,
    onSubmitClicked : (MutableList<String>)->Unit
){
    var nama by remember {
        mutableStateOf("")
    }
    var sayur by remember {
        mutableStateOf("")
    }
    var buah by remember {
        mutableStateOf("")
    }
    var listData : MutableList<String> = mutableListOf(nama)
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ){
            OutlinedCard(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                border = BorderStroke(1.dp, Color.Black),
                modifier = Modifier
                    .fillMaxWidth(0.95f)
                    .fillMaxHeight(0.95f)
                    .padding(vertical = 50.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Text(
                        stringResource(id = R.string.jdl),
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    OutlinedTextField(
                        value = nama,
                        onValueChange = { nama = it },
                        label = { Text(stringResource(id = R.string.nama)) },
                    )
                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ){
                        Text(stringResource(id = R.string.sayur))
                        Text(stringResource(id = R.string.buah))
                    }
                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ){
                        Column {
                            macamsayur.forEach { item ->
                                Row(
                                    modifier = Modifier.selectable(
                                        selected = sayur == item,
                                        onClick = {
                                            sayur = item
                                            onSelectionChanged1(item)
                                        }
                                    ),
                                    verticalAlignment = Alignment.CenterVertically
                                ){
                                    RadioButton(selected = sayur == item, onClick = {
                                        sayur = item
                                        onSelectionChanged1(item)
                                    })
                                    Text(item)
                                }
                            }
                        }
                        Column {
                            macambuah.forEach { item ->
                                Row(
                                    modifier = Modifier.selectable(
                                        selected = buah == item,
                                        onClick = {
                                            buah = item
                                            onSelectionChanged1(item)
                                        }
                                    ),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    RadioButton(selected = buah == item, onClick = {
                                        buah = item
                                        onSelectionChanged1(item)
                                    })
                                    Text(item)
                                }
                            }
                        }
                    }
                    Button(onClick = { onSubmitClicked(listData) },
                        enabled = nama.isNotEmpty() && sayur.isNotEmpty() && buah.isNotEmpty(),

                        ) {
                        Text(stringResource(id = R.string.btn_submit))
                    }
                }
            }
        }
    }
}