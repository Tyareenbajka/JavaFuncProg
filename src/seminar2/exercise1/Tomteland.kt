package seminar2.exercise1

/*

Philip Tonaczew 2022-01-18 

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

    fun getUnderlings(currentName: String, res: MutableList<String>): List<String> {
        fun underlings(list: List<String>): List<String> {
            for (s in list) {
                res.add(s)
                if (hierarchy.containsKey(s)) underlings(hierarchy[s]!!)
            }
            return res
        }
        return if(hierarchy.contains(currentName)) underlings(hierarchy[currentName]!!) else res
    }
}

fun main() {
    val tomteland = Tomteland()
    val list: MutableList<String> = mutableListOf()

    println(tomteland.getUnderlings("Dammråttan", list))
}
