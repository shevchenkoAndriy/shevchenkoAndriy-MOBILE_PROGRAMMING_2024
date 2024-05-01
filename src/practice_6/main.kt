package practice_6

fun main() {
    val coffeeMachine = CoffeeMachine(
        numberOfWater = 400,
        numberOfMilk = 540,
        numberOfBeans = 120,
        numberOfCups = 9
    )
    coffeeMachine.start()
}