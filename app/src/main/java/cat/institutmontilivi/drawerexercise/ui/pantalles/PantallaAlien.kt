package cat.institutmontilivi.drawerexercise.ui.pantalles

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
import cat.institutmontilivi.drawerexercise.dades.Aliens
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun PantallaAlien(id : Int){

    val alien = Aliens.dades.find { it.id == id }

    Column(){
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(alien!!.foto)
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
            Text(stringResource(R.string.nom) + alien.nom)
            Spacer(modifier = Modifier.height(10.dp))
            Text(stringResource(R.string.origen) + alien.origen)
            Spacer(modifier = Modifier.height(10.dp))
            Text(stringResource(R.string.edat) +alien.edat)
            Spacer(modifier = Modifier.height(10.dp))
            Text(stringResource(R.string.perillositat))
            LinearProgressIndicator(progress = alien.perillositat.toFloat()/100)
            Spacer(modifier = Modifier.height(10.dp))
            Text(stringResource(R.string.intel_ligencia))
            LinearProgressIndicator(progress = alien.inteligencia.toFloat()/100)
            Spacer(modifier = Modifier.height(10.dp))
            Text(stringResource(R.string.compatibilitat))
            LinearProgressIndicator(progress = alien.compatibilitat.toFloat()/100)
            Spacer(modifier = Modifier.height(10.dp))
            Text(stringResource(R.string.descobriment) + alien.descobriment)

        }
    }
}