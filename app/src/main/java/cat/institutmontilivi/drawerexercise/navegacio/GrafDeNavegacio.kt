package cat.institutmontilivi.drawerexercise.navegacio

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import cat.institutmontilivi.drawerexercise.dades.Aliens
import cat.institutmontilivi.drawerexercise.dades.Guerrers
import cat.institutmontilivi.drawerexercise.dades.Ordinadors
import cat.institutmontilivi.drawerexercise.ui.pantalles.PantallaAlien
import cat.institutmontilivi.drawerexercise.ui.pantalles.PantallaBonNadal
import cat.institutmontilivi.drawerexercise.ui.pantalles.PantallaFort
import cat.institutmontilivi.drawerexercise.ui.pantalles.PantallaGuerrer
import cat.institutmontilivi.drawerexercise.ui.pantalles.PantallaLlistaAliens
import cat.institutmontilivi.drawerexercise.ui.pantalles.PantallaLlistaGuerrers
import cat.institutmontilivi.drawerexercise.ui.pantalles.PantallaLlistaOrdinadors
import cat.institutmontilivi.drawerexercise.ui.pantalles.PantallaOrdinador

@Composable
fun GrafDeNavegacio (
    controladorDeNavegacio: NavHostController = rememberNavController(),
    paddingValues: PaddingValues
)
{
    NavHost(navController = controladorDeNavegacio, startDestination =CategoriaDeNavegacio.FelicNadal.rutaPrevia,
        modifier = Modifier.padding(paddingValues))
    {
        navigation(startDestination = Destinacio.FelicNadal.rutaBase, route =CategoriaDeNavegacio.FelicNadal.rutaPrevia )
        {
            composable(route = Destinacio.FelicNadal.rutaGenerica){
                PantallaBonNadal()
            }
        }

        navigation(startDestination = Destinacio.EsticFort.rutaBase, route =CategoriaDeNavegacio.EsticFort.rutaPrevia )
        {
            composable(route = Destinacio.EsticFort.rutaGenerica){
                PantallaFort()
            }
        }

        navigation(startDestination = Destinacio.LlistaGuerrers.rutaBase, route =CategoriaDeNavegacio.CategoriaGuerrers.rutaPrevia )
        {
            composable(route = Destinacio.LlistaGuerrers.rutaGenerica){
                PantallaLlistaGuerrers(
                    llista = Guerrers.dades,
                    onClickGuerrer = {id : Int -> controladorDeNavegacio.navigate(Destinacio.DetallsGuerrer.CreaRutaAmbArguments(id))}
                )
            }
            composable(route = Destinacio.DetallsGuerrer.rutaGenerica, arguments = Destinacio.DetallsGuerrer.navArgs){
                val id = it.arguments?.getInt(ArgumentDeNavegacio.IdGuerrer.clau)
                requireNotNull(id)
                PantallaGuerrer(id = id)
            }
        }

        navigation(startDestination = Destinacio.LlistaOrdinadors.rutaBase, route = CategoriaDeNavegacio.CategoriaOrdinadors.rutaPrevia){
            composable(route = Destinacio.LlistaOrdinadors.rutaGenerica){
                PantallaLlistaOrdinadors(
                    llista = Ordinadors.dades,
                    onClickOrdinador = {id : Int -> controladorDeNavegacio.navigate(Destinacio.DetallsOrdinador.CreaRutaAmbArguments(id))}
                )
            }
            composable(route = Destinacio.DetallsOrdinador.rutaGenerica, arguments = Destinacio.DetallsOrdinador.navArgs){
                val id = it.arguments?.getInt(ArgumentDeNavegacio.IdOrdinador.clau)
                requireNotNull(id)
                PantallaOrdinador(id = id)
            }
        }

        navigation(startDestination = Destinacio.LlistaAliens.rutaBase, route = CategoriaDeNavegacio.CategoriaAliens.rutaPrevia){
            composable(route = Destinacio.LlistaAliens.rutaGenerica){
                PantallaLlistaAliens(
                    llista = Aliens.dades,
                    onClickAlien = {id : Int -> controladorDeNavegacio.navigate(Destinacio.DetallsAlien.CreaRutaAmbArguments(id))}
                )
            }
            composable(route = Destinacio.DetallsAlien.rutaGenerica, arguments = Destinacio.DetallsAlien.navArgs){
                val id = it.arguments?.getInt(ArgumentDeNavegacio.IdAlien.clau)
                requireNotNull(id)
                PantallaAlien(id = id)
            }
        }
    }
}
