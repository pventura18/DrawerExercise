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
import cat.institutmontilivi.drawerexercise.dades.Guerrers
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun PantallaGuerrer(id : Int){
    Log.d("POL", "Id dintre de pantalla guerrers és $id")
    val guerrer = Guerrers.dades.find { it.id == id }
    Log.d("POL", "Guerrer details: $guerrer")
    Column(){
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(guerrer!!.foto)
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
            Text(stringResource(R.string.id) +id)
            Spacer(modifier = Modifier.height(10.dp))
            Text(stringResource(R.string.nom) + guerrer.nom)
            Spacer(modifier = Modifier.height(10.dp))
            Text(stringResource(R.string.edat) +guerrer.edat)
            Spacer(modifier = Modifier.height(10.dp))
            Text(stringResource(R.string.for_a))
            LinearProgressIndicator(progress = guerrer.forca.toFloat()/100)
            Spacer(modifier = Modifier.height(10.dp))
            Text(stringResource(R.string.resistencia))
            LinearProgressIndicator(progress = guerrer.resistencia.toFloat()/100)
            Spacer(modifier = Modifier.height(10.dp))
            Text(stringResource(R.string.atac))
            LinearProgressIndicator(progress = guerrer.atac.toFloat()/100)
            Spacer(modifier = Modifier.height(10.dp))
            Text(stringResource(R.string.defensa))
            LinearProgressIndicator(progress = guerrer.defensa.toFloat()/100)
        }
    }
}