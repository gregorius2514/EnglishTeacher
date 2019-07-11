package pl.english.teacher

interface LanguageTranslator {
    fun translate(wordToTranslate: String): ArrayList<String>
}
