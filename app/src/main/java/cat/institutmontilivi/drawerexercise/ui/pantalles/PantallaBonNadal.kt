package cat.institutmontilivi.drawerexercise.ui.pantalles

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cat.institutmontilivi.drawerexercise.R

@Preview
@Composable
fun PantallaBonNadal(){

Column(modifier = Modifier
    .fillMaxSize()){
    Spacer(modifier = Modifier.height(150.dp))
    Text(text = "Bon Nadal!",
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontSize = 50.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Magenta
    )
    Spacer(modifier = Modifier.height(50.dp))
    Image(painterResource(id = R.drawable.christmaspng), contentDescription = null, contentScale = ContentScale.Fit, modifier = Modifier.fillMaxWidth())
}


}