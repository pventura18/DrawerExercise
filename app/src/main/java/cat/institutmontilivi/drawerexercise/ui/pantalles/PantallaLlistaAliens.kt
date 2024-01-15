package cat.institutmontilivi.drawerexercise.ui.pantalles

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cat.institutmontilivi.drawerexercise.R
import cat.institutmontilivi.drawerexercise.dades.Alien
import cat.institutmontilivi.drawerexercise.dades.Aliens
import cat.institutmontilivi.drawerexercise.dades.Guerrer
import coil.compose.AsyncImage
import coil.request.ImageRequest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaLlistaAliens(
    llista: List<Alien>,
    onClickAlien: (Int) ->  Unit
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {

        item { Text(modifier = Modifier.fillMaxWidth() ,text = stringResource(R.string.llista_d_aliens), fontSize = 45.sp, textAlign = TextAlign.Center) }
        items(Aliens.dades) {
            ListItem(
                modifier = Modifier.clickable { onClickAlien(it.id) },
                colors = ListItemDefaults.colors(Color.Gray, Color.White, Color.White),
                headlineText = { Text(it.nom, fontWeight = FontWeight.Bold, fontSize = 20.sp) },
                supportingText = { Text(it.origen) },
                leadingContent = {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(it.foto)
                            .crossfade(true)
                            .build(),
                        placeholder = painterResource(R.drawable.ic_launcher_foreground),
                        contentDescription = "Alien",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.clip(CircleShape)
                    )
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

        }
    }


}