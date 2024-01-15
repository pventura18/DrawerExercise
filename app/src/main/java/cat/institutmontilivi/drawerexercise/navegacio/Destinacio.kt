package cat.institutmontilivi.drawerexercise.navegacio

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import cat.institutmontilivi.drawerexercise.R

enum class CategoriaDeNavegacio(
    val rutaPrevia: String,
    val icona: Int,
    val titol: String
){
    FelicNadal ("FelicNadal", R.drawable.tree_vector, "Feliç Nadal!"),
    EsticFort ("EsticFort", R.drawable.arm_vector, "Estic fort..."),
    CategoriaGuerrers ("CategoriaGuerrers", R.drawable.sword_vector, "Guerrers"),
    CategoriaOrdinadors ("CategoriaOrdinadors", R.drawable.computer_vector, "Ordinadors"),
    CategoriaAliens ("CategoriaAliens", R.drawable.alien_vector, "Aliens"),
}

sealed class Destinacio(
    val rutaBase: String,
    val argumentsDeNavegacio: List <ArgumentDeNavegacio> = emptyList()
)
{

    val navArgs = argumentsDeNavegacio.map { it.toNavArgument()}
    /**
     * Propietat que crea l'string amb la ruta base i tots els arguments separats per barres
     */
    val rutaGenerica = run {
        //cal construir un string tipus: rutabase/{arg1}/{arg2} ...
        val clausArguments = argumentsDeNavegacio.map{"{${it.clau}}"}
        listOf(rutaBase)
            .plus(clausArguments)
            .joinToString("/")
    }

    object FelicNadal: Destinacio(CategoriaDeNavegacio.FelicNadal.rutaPrevia+"/Inici")
    object EsticFort: Destinacio(CategoriaDeNavegacio.EsticFort.rutaPrevia+"/Inici")
    object LlistaGuerrers: Destinacio(CategoriaDeNavegacio.CategoriaGuerrers.rutaPrevia+"/Inici")
    object DetallsGuerrer: Destinacio(CategoriaDeNavegacio.CategoriaGuerrers.rutaPrevia+"/Segona", listOf(ArgumentDeNavegacio.IdGuerrer)){
        fun CreaRutaAmbArguments (idGuerrer: Int) = "$rutaBase/$idGuerrer"
    }
    object LlistaOrdinadors: Destinacio(CategoriaDeNavegacio.CategoriaOrdinadors.rutaPrevia+"/Inici")
    object DetallsOrdinador: Destinacio(CategoriaDeNavegacio.CategoriaOrdinadors.rutaPrevia+"/Segona", listOf(ArgumentDeNavegacio.IdOrdinador)){
        fun CreaRutaAmbArguments (idOrdinador: Int) = "$rutaBase/$idOrdinador"
    }
    object LlistaAliens: Destinacio(CategoriaDeNavegacio.CategoriaAliens.rutaPrevia+"/Inici")
    object DetallsAlien: Destinacio(CategoriaDeNavegacio.CategoriaAliens.rutaPrevia+"/Segona", listOf(ArgumentDeNavegacio.IdAlien)){
        fun CreaRutaAmbArguments (idAlien: Int) = "$rutaBase/$idAlien"
    }

}

enum class ArgumentDeNavegacio (val clau: String, val tipus: NavType<*>){
    IdGuerrer("IdGuerrer", NavType.IntType),
    IdOrdinador("IdOrdinador", NavType.IntType),
    IdAlien("IdAlien", NavType.IntType);

    fun toNavArgument (): NamedNavArgument {
        return navArgument(clau) {type = tipus}
    }
}