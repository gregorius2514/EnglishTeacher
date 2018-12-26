package pl.english.teacher.inregularverbs

data class InregularVerb(val firstForm: String, val secondForm: String, val thirdForm: String, val
polishTranslation: String = "", var correctAnswer: Int = 0, var incorrectAnswer: Int = 0) {

    constructor(firstForm: String, secondForm: String, thirdForm: String,
                polishTranslation: String, correctAnswer: String, incorrectAnswer: String) : this(firstForm,
            secondForm, thirdForm, polishTranslation, correctAnswer.toInt(), incorrectAnswer.toInt())

    fun changeAnswerCorrectness(userTypedVerb: InregularVerb) {
        if (firstForm == userTypedVerb.firstForm && secondForm == userTypedVerb.secondForm &&
                thirdForm == userTypedVerb.thirdForm) {
            correctAnswer++
        } else {
            incorrectAnswer++
        }
    }
}

