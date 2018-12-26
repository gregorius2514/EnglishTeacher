package pl.english.teacher

import java.nio.file.Path

interface CsvParser<T> {

    fun parseFile(csvFilePath: Path): List<T>
}
