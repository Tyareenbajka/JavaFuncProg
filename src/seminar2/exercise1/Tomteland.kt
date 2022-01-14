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

    val hierarchy = mapOf(
        "Tomten" to listOf("Glader", "Butter"),
        "Glader" to listOf("Tröger", "Trötter", "Blyger"),
        "Butter" to listOf("Rådjuret", "Nyckelpigan", "Haren", "Räven"),
        "Trötter" to listOf("Skumtomten"),
        "Skumtomten" to listOf("Dammråttan"),
        "Räven" to listOf("Gråsuggan", "Myran"),
        "Myran" to listOf("Bladlusen")
    )

    // [glader[], tröger, trötter[], skumtomten[], dammråttan, blyger, butter[],
    // rådjuret, nyckelpiga, haren, räven[], gråsuggan, myran, bladlusen]

    // current namn är den tomte vars underlydande ni vill ta fram
    //res är listan som håller alla underlydande
    fun getUnderlings2(currentName: String, res: MutableList<String>): List<String> {
        res.add(currentName)
        return res
    }

    fun playgroundUnderlings(currentName: String, res: MutableList<String>): List<String> {

        tailrec fun underlings(counter: Int, currentName: String, res: MutableList<String>): List<String>{
            return if(counter == hierarchy.size) return res
            else underlings(counter + 1, currentName, res)

        }
        return underlings(0, currentName, res)
    }

    fun playgroundUnderlings2List(currentName: String, res: MutableList<String>): List<String> {

        for(s in hierarchy.get(currentName)!!) {
            if(hierarchy.containsKey(s)) {
                res.add(s)
                for (s2 in hierarchy[s]!!) {
                    if(hierarchy.containsKey(s2)){
                        res.add(s2)
                        for (s3 in hierarchy[s2]!!) res.add(s3)
                    } else res.add(s2)
                }
            } else res.add(s)
        }
        return res
    }

    fun getUnderlings(currentName: String, res: MutableList<String>): List<String> {

        fun helper(name: String, list: List<String>, currentList: MutableList<String>){
            for(s in list){
                if(hierarchy.containsKey(s)) {
                    currentList.add(s)
                    helper(s, hierarchy[s]!!, currentList)
                } else currentList.add(s)
            }
        }

         fun underlings(index: Int, res: MutableList<String>): List<String>{
            return if(index == hierarchy[currentName]?.size) res
            else {
                helper(currentName, hierarchy[currentName]!!,res)
                res
            }
        }
        return underlings(0,res)
    }

    fun getUnderlings3(currentName: String, res: MutableList<String>): List<String> {

        fun helper(list: List<String>, currentList: MutableList<String>){
            for(s in list){
                if(hierarchy.containsKey(s)) {
                    currentList.add(s)
                    helper(hierarchy[s]!!, currentList)
                } else currentList.add(s)
            }
        }

        fun underlings(index: Int, res: MutableList<String>): List<String>{
            return if(index == hierarchy[currentName]?.size) res
            else {

                helper(hierarchy[currentName]!!,res)
                res
            }
        }
        return underlings(0,res)
    }


}

fun main() {

    //Exempel på anrop till den rekursiva funktionen getUnderlings,
    // här är tanken att hitta Gladers underlydande
    //listan fylls på successivt när vi rekurserar

    val tomteland = Tomteland()

    val list: MutableList<String> = mutableListOf()
    val list2: MutableList<String> = mutableListOf()
    //println(tomteland.getUnderlings("Glader", list))
    //println(tomteland.playgroundUnderlings("Räven", list))
    println(tomteland.getUnderlings3("Tomten", list2))



}