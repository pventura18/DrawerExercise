package cat.institutmontilivi.drawerexercise.dades

import kotlin.random.Random

data class Ordinador(
    val id: Int,
    val nom: String,
    val foto: String,
    val marca: String,
    val anyFabricacio: Int,
    val processador: String,
    val eficaciaProcessador: Int,
    val ram: Int,
    val eficaciaRam: Int,
    val targetaGrafica: String,
    val eficaciaTargeta: Int,
    val connexioWiFi: String,
)

class Ordinadors {
    companion object{
        val dades = CreaOrdinadors()

        fun CreaOrdinadors() : List<Ordinador>{
            val llista = mutableListOf<Ordinador>()
            val llistaNom = listOf("increïble", "genial", "patètic", "perfecte", "bo", "millorable", "dolent")
            val llistaMarca = listOf("HP", "Lenovo", "Per peces", "Asus", "Acer", "Microsoft", "Xiaomi")
            val llistaProcessadors = listOf("Intel 7", "Intel 8","Intel 9", "Intel 5", "Ryzen 5", "Ryzen 7", "Ryzen 8", "Ryzen 9")
            val llistaGrafiques = listOf("GTX 1060", "GTX 1070","GTX 1080","RTX 2060","RTX 2070","RTX 2080","RTX 3060")

            for(i in 1..100){
                llista.add(
                    Ordinador(i, "Ordinador ${llistaNom[Random.nextInt(0,7)]}",
                        "https://loremflickr.com/300/300/computer/?lock=${i+300}",
                        llistaMarca[Random.nextInt(0,7)],
                        Random.nextInt(2000, 2023),
                        llistaProcessadors[Random.nextInt(0, 8)],
                        Random.nextInt(0,101),
                        Random.nextInt(4, 33),
                        Random.nextInt(0,101),
                        llistaGrafiques[Random.nextInt(0,7)],
                        Random.nextInt(0,101),
                        if(Random.nextInt(0,2) == 0) "Sí" else "No"
                    )
                )
            }

            return llista
        }
    }



}