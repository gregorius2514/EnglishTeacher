package pl.english.teacher.englishwords

data class EnglishWord(val word: String, val translation: String) {

    fun toCsvFormat(csvSeparator: String): String {
        require(!csvSeparator.isBlank()) { "Required non-empty csvSeparator" }
        return "$word$csvSeparator$translation"
    }
}
