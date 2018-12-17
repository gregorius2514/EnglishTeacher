package pl.english.teacher

import java.io.FileWriter

fun main(args: Array<String>) {
    val wordTranslator = DikiTranlator()

    // todo attach header to file
    FileWriter("englishWords.csv", true).use { outputFile ->
        while (true) {
            print("Type word: ")
            val userWord = readLine() ?: continue

            if ("exit".equals(userWord.toLowerCase())) {
                return
            }
            val translations = wordTranslator.translate(userWord)

            println("Possible translations:")
            translations.forEachIndexed { index, value ->
                println("$index - $value")
            }
            var chosenTranslationIndex = readLine() ?: continue
            if (chosenTranslationIndex.isBlank()) continue

            val chosenTranslation = translations.get(chosenTranslationIndex.toInt())
            outputFile.write("$userWord;$chosenTranslation\n")

            println("---------------------------------------------------")
        }
    }

}
