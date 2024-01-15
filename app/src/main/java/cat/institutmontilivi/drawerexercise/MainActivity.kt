package cat.institutmontilivi.drawerexercise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import cat.institutmontilivi.drawerexercise.ui.Aplicacio
import cat.institutmontilivi.drawerexercise.ui.PantallaDeLAplicacio

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaDeLAplicacio {
                Aplicacio ()

            }
        }
    }
}