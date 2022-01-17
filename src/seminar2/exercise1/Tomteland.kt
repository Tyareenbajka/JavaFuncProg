package seminar2.exercise1

/*

Philip Tonaczew

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

    val hierarchy = mapOf(
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

        fun underlings(list: List<String>): List<String> {
            for (s in list) {
                res.add(s)
                if (hierarchy.containsKey(s)) underlings(hierarchy[s]!!)
            }
            return res
        }
        return underlings(hierarchy[currentName]!!)
    }
}

fun main() {
    //Exempel på anrop till den rekursiva funktionen getUnderlings,
    // här är tanken att hitta Gladers underlydande
    //listan fylls på successivt när vi rekurserar

    val tomteland = Tomteland()
    val list: MutableList<String> = mutableListOf()

    println(tomteland.getUnderlings("Tomten", list))
}