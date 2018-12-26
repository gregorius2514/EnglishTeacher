package pl.english.teacher.inregularverbs

import java.lang.System.currentTimeMillis
import java.nio.file.Paths
import java.util.*

//TODO
// 1. dodac obsluge poprawnie wprowadzonych slowek i zle (countery w pliku ze slowkami)
// 2. czyszczenie konsoli po wprowadzeniu przez uzytkownika danych. Do kotlin console dodac
// metode clear
// 3. dodac test do nauki czasow czyli zdanie w present simple i jak zamienic to zdanie na
// present perfect. Template w present perfect i przygotowany template w present perfect
// 4. wyswietlanie na koniec statystyk ile slowek udalo sie poprawnie nauczyc + slowka ze zlymi
// odpowiedziami
// 5. mozliwosc nauki slowek, ktore sprawiaja najwiecej problemow
// 6. tryb zaawansowany gdzie kolejnosc form (I, II, II) sa w innej kolejnosci na ekranie
// 7. dodanie sprawdzania wprowadzonych slowek z ignore_case
fun main(args: Array<String>) {
    val inregularVerbs = InregularVerbParser(",").parseFile(Paths.get("inregularVerbs.csv"))
    val changedInregularVerbs = ArrayList<InregularVerb>()

    val randomizer = Random(currentTimeMillis())
    for (i in inregularVerbs) {
        val randomIndex = randomizer.nextInt(inregularVerbs.size)
        val randomInregularVerb = inregularVerbs[randomIndex]

        println(randomInregularVerb)

        println(randomInregularVerb.polishTranslation)
        print("Type first form: ")
        val firstForm = readUserInput()
        print("Type second form: ")
        val secondForm = readUserInput()
        print("Type third form: ")
        val thirdForm = readUserInput()

        randomInregularVerb.changeAnswerCorrectness(InregularVerb(firstForm, secondForm, thirdForm))
        changedInregularVerbs.add(randomInregularVerb)

        print("Want to continue teaching? [T/F] or to print statistics press [S]: ")
        val teachingMenu = readLine() ?: ""

        if (teachingMenu.toUpperCase() == "S") {
            changedInregularVerbs.forEach { record ->
                println(record)
            }
        } else if (teachingMenu.toUpperCase() == "F") break

        clearConsole()
    }
}

fun readUserInput() = readLine() ?: ""

fun clearConsole() {
    // FIXME nie dziala
    Runtime.getRuntime().exec("clear")
}

