package practice_6

class CoffeeMachine {
    fun start() {
        showCookingSteps()
    }

    private fun showCookingSteps() {
        println("""
            Starting to make a coffee in NIX office
            Grinding coffee beans
            Boiling water
            Mixing boiled water with crushed coffee beans
            Pouring coffee into the cup
            Pouring some milk into the cup
            Coffee is ready! Go to work!
        """.trimIndent())
    }
}