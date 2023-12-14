package dependencyInversionPrinciple.badImplementation

import kotlin.properties.Delegates

interface ITrackble {
    fun generateWeatherAlert(weatherConditions: String): String
}

class WeatherTracker (private var conditions: String, private val phone: Phone,
    private val emailer: Emailer) {

    fun setCurrentConditions(weatherDescription: String) {
        this.conditions = weatherDescription
        if (weatherDescription === "rainy") {
            val alert: String = phone.generateWeatherAlert(weatherDescription)
            print(alert)
        }
        if (weatherDescription === "sunny") {
            val alert: String = emailer.generateWeatherAlert(weatherDescription)
            print(alert)
        }
    }

}