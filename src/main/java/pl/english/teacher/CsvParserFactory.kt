package pl.english.teacher

interface CsvParserFactory<T> {

    fun createParser(): T

    fun csvSeparator() : String

}
