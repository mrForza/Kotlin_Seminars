package interfaceSegregationPrinciple.badImplementation


interface SwimableBird {
    fun swim()
}

interface FlybleBird {
    fun fly()
}

interface FeathersLoosbleBird {
    fun looseFeathers() {
        println("I lose my feathers!")
    }
}