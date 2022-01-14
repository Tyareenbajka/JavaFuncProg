package seminar2.exercise1


/*
Tomtarna på Nordpolen har en strikt chefs-hierarki

Högsta chefen för allt är "Tomten"
Under "Tomten" jobbar "Glader" och "Butter"
Under "Glader" jobbar "Tröger", "Trötter"och "Blyger"
Under "Butter" jobbar "Rådjuret", "Nyckelpigan", "Haren" och "Räven"
Under "Trötter" jobbar "Skumtomten"
Under "Skumtomten" jobbar "Dammråttan"
Under "Räven" jobbar "Gråsuggan" och "Myran"
Under "Myran" jobbar "Bladlusen"

Er uppgift är att illustrera tomtens arbetshierarki i en lämplig datastruktur.
(Det finns flera tänkbara datastrukturer här)
Skriv sedan en funktion där man anger ett namn på tomten eller någon av hens underhuggare som
inparameter.
Funktionen listar sedan namnen på alla underlydandesom en given person har
Expempel: Du anger "Trötter" och får som svar ["Skumtomten", "Dammråttan"]"
För att bli godkänd på uppgiften måste du använda rekursion.
 */

class Tomteland {

    val tomteLand = mapOf(
        "Tomten" to listOf("Glader", "Butter"),
        "Glader" to listOf("Tröger", "Trötter", "Blyger"),
        "Butter" to listOf("Rådjuret", "Nyckelpigan", "Haren", "Räven"),
        "Trötter" to listOf("Skumtomten"),
        "Skumtomten" to listOf("Dammråttan"),
        "Räven" to listOf("Gråsuggan", "Myran"),
        "Myran" to listOf("Bladlusen")
    )

    // current namn är den tomte vars underlydande ni vill ta fram
    //res är listan som håller alla underlydande
    fun getUnderlings(currentName: String, res: MutableList<String>): List<String> {
        res.add(currentName)
        return res
    }

    fun playgroundUnderlings(currentName: String, res: MutableList<String>): List<String> {

        tailrec fun underlings(counter: Int, currentName: String, res: MutableList<String>): List<String>{
            return if(counter == tomteLand.size) return res
            else underlings(counter + 1, currentName, res)

        }
        return underlings(0, currentName, res)
    }

    fun playgroundUnderlings2(currentName: String, res: MutableList<String>): List<String> {

        for(s in tomteLand.get(currentName)!!) {
            if(tomteLand.containsKey(s)) {
                println(s)
                for (s2 in tomteLand[s]!!) {
                    if(tomteLand.containsKey(s2)){
                        println(s2)
                        for (s3 in tomteLand[s2]!!){
                            println(s3)
                        }
                    } else println(s2)
                }
            } else println(s)
        }
        return res
    }


}

fun main() {

    //Exempel på anrop till den rekursiva funktionen getUnderlings,
    // här är tanken att hitta Gladers underlydande
    //listan fylls på successivt när vi rekurserar

    val tomteland = Tomteland()

    val list: MutableList<String> = mutableListOf()
    //println(tomteland.getUnderlings("Glader", list))
    //println(tomteland.playgroundUnderlings("Räven", list))
    tomteland.playgroundUnderlings2("Butter", list)

}