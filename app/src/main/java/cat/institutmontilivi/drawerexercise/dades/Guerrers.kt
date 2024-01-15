package cat.institutmontilivi.drawerexercise.dades

import kotlin.random.Random

data class Guerrer(
    val id: Int,
    val nom: String,
    val foto: String,
    val tipus: String,
    val edat: Int,
    val forca: Int,
    val resistencia: Int,
    val atac: Int,
    val defensa: Int
)

class Guerrers {
    companion object{
        val dades: List<Guerrer>

        init{
            dades = CreaGuerrers()
        }

        fun CreaGuerrers() : List<Guerrer>{
            val llista = mutableListOf<Guerrer>()
            val llistaTipus = listOf("Lluitador", "Mag", "Assassí", "Curador", "Tanc", "Paladí", "Pesat")

            for(i in 1..100){
                llista.add(
                    Guerrer(i, "Guerrer $i",
                        "https://loremflickr.com/300/300/warrior/?lock=${i+300}",
                        llistaTipus[Random.nextInt(0,7)],
                        Random.nextInt(10, 100),
                        Random.nextInt(1, 100),
                        Random.nextInt(1, 100),
                        Random.nextInt(1, 100),
                        Random.nextInt(1, 100)
                    )
                )
            }

            return llista
        }
    }



}