package interfaceSegregationPrinciple.badImplementation


class Eagle(var numberOfFeathers: Int): FlybleBird, FeathersLoosbleBird {
    var currentLocation: String? = null

    override fun fly() {
        currentLocation = "in the air"
    }

    override fun looseFeathers() {
        numberOfFeathers -= 1
    }
}