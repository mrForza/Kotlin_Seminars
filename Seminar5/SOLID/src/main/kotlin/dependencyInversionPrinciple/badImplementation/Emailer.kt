package dependencyInversionPrinciple.badImplementation

class Emailer : ITrackble {
    override fun generateWeatherAlert(weatherConditions: String): String {
        return "Email: It is $weatherConditions"
    }
}