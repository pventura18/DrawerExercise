package cat.institutmontilivi.drawerexercise.ui.pantalles

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cat.institutmontilivi.drawerexercise.R

@Composable
fun PantallaFort(){
    Column(modifier = Modifier
        .fillMaxSize()){
        Spacer(modifier = Modifier.height(150.dp))
        Text(text = "Estic molt,\n\nmolt, molt fort!",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(50.dp))
        Image(painterResource(id = R.drawable.bicepspng), contentDescription = null, contentScale = ContentScale.Fit, modifier = Modifier.fillMaxWidth())
    }
}