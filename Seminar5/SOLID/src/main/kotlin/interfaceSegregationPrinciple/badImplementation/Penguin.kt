package interfaceSegregationPrinciple.badImplementation


class Penguin(var numberOfFeathers: Int) : SwimableBird, FeathersLoosbleBird {
    var currentLocation: String? = null

    override fun swim() {
        currentLocation = "in the water"
    }

    override fun looseFeathers() {
        numberOfFeathers -= 1
    }
}