package pl.english.teacher.englishwords

import pl.english.teacher.CsvParser
import java.io.FileReader
import java.io.FileWriter
import java.nio.file.Path

class EnglishWordParser(val csvSeparator: String) : CsvParser<EnglishWord> {

    override fun parseFile(csvFilePath: Path): List<EnglishWord> {
        FileReader(csvFilePath.toFile()).use { englishWordFile ->
            return englishWordFile
                    .readLines()
                    .map { csvRow ->
                        val englishWord = csvRow.split(csvSeparator)
                        EnglishWord(englishWord[0], englishWord[1])
                    }
                    .toCollection(ArrayList())
        }
    }

    fun storeWord(englishWord: EnglishWord) {
        FileWriter("englishWords.csv", true).use { outputFile ->
            outputFile.write(englishWord.toCsvFormat(csvSeparator))
        }
    }
}

