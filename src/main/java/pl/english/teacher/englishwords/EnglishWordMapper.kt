package pl.english.teacher.englishwords

fun convertEnglishWordToCsvRecord(englishWord: EnglishWord, csvSeparator: String): String {
    require(!csvSeparator.isBlank()) { "Required non-empty csvSeparator" }
    return "$englishWord.word$csvSeparator$englishWord.translation"
}