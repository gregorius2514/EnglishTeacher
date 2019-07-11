package pl.english.teacher.englishwords

import pl.english.teacher.DikiTranlator

fun main(args: Array<String>) {
    val wordTranslator = DikiTranlator()
    val englishWordService = EnglishWordService()

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

            val translation = translations.get(chosenTranslationIndex.toInt())
            englishWordService.storeWord(EnglishWord(userWord, translation))

            println("---------------------------------------------------")
        }

}
