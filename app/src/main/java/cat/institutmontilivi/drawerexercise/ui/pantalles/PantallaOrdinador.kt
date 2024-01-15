package cat.institutmontilivi.drawerexercise.ui.pantalles

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import cat.institutmontilivi.drawerexercise.R
import cat.institutmontilivi.drawerexercise.dades.Ordinadors
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun PantallaOrdinador(id : Int){
    Log.d("POL", "Id dintre de pantalla ordinador és $id")
    val ordinador = Ordinadors.dades.find { it.id == id }
    Log.d("POL", "Guerrer details: $ordinador")
    Column(){
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(ordinador!!.foto)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "Alien",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .weight(1F)
        )
        Column(modifier = Modifier
            .weight(2F)
            .padding(20.dp),
            verticalArrangement = Arrangement.Center){
            Text("Id: $id")
            Spacer(modifier = Modifier.height(10.dp))
            Text(stringResource(R.string.marca) + ordinador.marca)
            Spacer(modifier = Modifier.height(10.dp))
            Text(stringResource(R.string.any_de_fabricacio) +ordinador.anyFabricacio)
            Spacer(modifier = Modifier.height(10.dp))
            Text(stringResource(R.string.processador) +ordinador.processador)
            Spacer(modifier = Modifier.height(10.dp))
            Text(stringResource(R.string.potencia_processador))
            LinearProgressIndicator(progress = ordinador.eficaciaProcessador.toFloat()/100)
            Spacer(modifier = Modifier.height(10.dp))
            Text(stringResource(R.string.ram) + ordinador.ram + "GB")
            Spacer(modifier = Modifier.height(10.dp))
            Text(stringResource(R.string.potencia_ram))
            LinearProgressIndicator(progress = ordinador.eficaciaRam.toFloat()/100)
            Spacer(modifier = Modifier.height(10.dp))
            Text(stringResource(R.string.targeta_gr_fica) +ordinador.targetaGrafica)
            Spacer(modifier = Modifier.height(10.dp))
            Text(stringResource(R.string.potencia_gr_fica))
            LinearProgressIndicator(progress = ordinador.eficaciaTargeta.toFloat()/100)
            Spacer(modifier = Modifier.height(10.dp))
            Text(stringResource(R.string.connexi_wifi) + ordinador.connexioWiFi)
        }
    }
}