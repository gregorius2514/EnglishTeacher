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