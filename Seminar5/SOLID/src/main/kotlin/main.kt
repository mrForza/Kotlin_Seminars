import dependencyInversionPrinciple.badImplementation.Emailer
import dependencyInversionPrinciple.badImplementation.Phone
import dependencyInversionPrinciple.badImplementation.WeatherTracker
import interfaceSegregationPrinciple.badImplementation.Eagle
import interfaceSegregationPrinciple.badImplementation.Penguin
import openClosedPrinciple.badImplementation.EmailGreeting

fun testOpenClosedPrinciple() {
    val greeting1: EmailGreeting = EmailGreeting("formal")
    require(greeting1.greeting == "Good evening, sir.") {
        "Wrong message intro"
    }
    val greeting2: EmailGreeting = EmailGreeting("casual")
    require(greeting2.greeting == "Sup bro?") {
        "Wrong message intro"
    }
    val greeting3: EmailGreeting = EmailGreeting("intimate")
    require(greeting3.greeting == "Hello Darling!") {
        "Wrong message intro"
    }
    val greeting4: EmailGreeting = EmailGreeting("undefined")
    require(greeting4.greeting == "Hello!") {
        "Wrong message intro"
    }
}

fun testInterfaceSegregationPrinciple() {
    val eagle = Eagle(150)
    val penguin = Penguin(30)

    eagle.fly()
    eagle.looseFeathers()

    penguin.swim()
    penguin.looseFeathers()
}

fun testDependencyInversionPrinciple() {
    val tracker = WeatherTracker(phone = Phone(), emailer = Emailer(), conditions = "sunny")
    tracker.setCurrentConditions("rainy")
    tracker.setCurrentConditions("sunny")
}

fun main(args: Array<String>) {
    // ЗАДАНИЕ 1: Приветствие
    testOpenClosedPrinciple()

    // ЗАДАНИЕ 2: Уведомления о погоде
    testDependencyInversionPrinciple()

    // ЗАДАНИЕ 3: Птицы бывают разные (но не все всё умеют)
    testInterfaceSegregationPrinciple()
}