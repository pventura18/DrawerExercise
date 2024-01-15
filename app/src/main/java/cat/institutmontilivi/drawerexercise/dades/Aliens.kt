package cat.institutmontilivi.drawerexercise.dades

import kotlin.random.Random

data class Alien(
    val id: Int,
    val nom: String,
    val foto: String,
    val origen: String,
    val edat: Int,
    val perillositat: Int,
    val inteligencia: Int,
    val compatibilitat:Int,
    val descobriment: Int


)

class Aliens {
    companion object{
        val dades = CreaAliens()

        fun CreaAliens() : List<Alien>{
            val llista = mutableListOf<Alien>()
            val llistaNoms = listOf("Josep", "Ferran", "Pol", "Xevi", "Marx", "Alex", "Antoni", "Carles", "Nayara", "Laura", "Sílvia")
            val llistaOrigen = listOf("Mart", "Júpiter", "Saturn", "Venus", "Mercuri", "La Lluna", "Plutó", "Neptú")

            for(i in 1..100){
                llista.add(
                    Alien(i, "Alien ${llistaNoms[Random.nextInt(0,11)]}",
                        "https://loremflickr.com/300/300/alien/?lock=${i+300}",
                        llistaOrigen[Random.nextInt(0,8)],
                        Random.nextInt(0, 10000),
                        Random.nextInt(0,100),
                        Random.nextInt(0,100),
                        Random.nextInt(0,100),
                        Random.nextInt(2000, 3000)
                    )
                )
            }

            return llista
        }
    }



}