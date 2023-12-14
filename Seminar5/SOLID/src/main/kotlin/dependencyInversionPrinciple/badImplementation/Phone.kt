package dependencyInversionPrinciple.badImplementation

class Phone : ITrackble {
    override fun generateWeatherAlert(weatherConditions: String): String {
        return "Phone: It is $weatherConditions"
    }
}