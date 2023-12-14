package openClosedPrinciple.badImplementation

interface Formalble {
    fun sendFormableGreeting(): String {
        return "Good evening, sir."
    }
}

interface Casualble {
    fun sendCausableGreeting(): String {
        return "Sup bro?"
    }
}

interface Intimatable {
    fun sendIntimatbleGreeting(): String {
        return "Hello Darling!"
    }
}

class EmailGreeting(private var formality: String) : Formalble, Casualble, Intimatable {

    val greeting: String = when(formality) {
        "formal" -> sendFormableGreeting()
        "casual" -> sendCausableGreeting()
        "intimate" -> sendIntimatbleGreeting()
        else -> "Hello!"
    }

    fun setFormality(formality: String) {
        this.formality = formality
    }

}