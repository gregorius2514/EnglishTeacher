package pl.english.teacher.inregularverbs

import java.lang.System.currentTimeMillis
import java.nio.file.Paths
import java.util.*

fun main() {
    val inregularVerbs = InregularVerbParser().parseFile(Paths.get("inregularVerbs.csv"))

    val randomizer = Random(currentTimeMillis())
    for (i in 1..3) {
        var randomIndex = randomizer.nextInt(inregularVerbs.size)
        var randominregularVerb = inregularVerbs.get(randomIndex)

        println(randominregularVerb)

        println(randominregularVerb.polishTranslation)
        print("Type first form: ")
        val firstForm = readLine()
        print("Type second form: ")
        val secondForm = readLine()
        print("Type third form: ")
        val thirdForm = readLine()

        if (randominregularVerb.firstForm.equals(firstForm)) println("First form was correct")
        else println("First form was incorrect")

        if (randominregularVerb.secondForm.equals(secondForm)) println("Second form was correct")
        else println("Second form was incorrect")

        if (randominregularVerb.thirdForm.equals(thirdForm)) println("Third form was correct")
        else println("Third form was incorrect")
    }
}