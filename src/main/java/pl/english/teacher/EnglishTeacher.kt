package pl.english.teacher

import java.io.FileWriter

fun main(args: Array<String>) {
    // todo attach header to file
    FileWriter("englishWords.csv", true).use { outputFile ->
        while (true) {
            print("Type english word: ")
            var englishWord = readLine()

            print("Type polish word: ")
            var polishWord = readLine()

            if ("exit".equals(englishWord?.toLowerCase()) || "exit".equals(polishWord?.toLowerCase())) {
                return;
            }
            outputFile.write("$englishWord;$polishWord\n")

            println("---------------------------------------------------")
        }
    }

}
