package practice_6

import shared.Reader

class CoffeeMachine {
    private val reader = Reader()

    fun start() {
        showOrderIngredients()
    }

    private fun showOrderIngredients() {
        val numberOfCups = reader.parsePositiveInt(
            "Write how many cups of coffee you will need: > "
        )
        val drink = Drink(name = "Coffee", price =  1)
        val ingredients = calcIngredients(drink.name, numberOfCups)
        println("""
            For $numberOfCups cups of coffee you will need:
            ${ingredients.water} ml of water
            ${ingredients.milk} ml of milk
            ${ingredients.beans} g of coffee beans
        """.trimIndent())
    }

    private fun getDrinkIngredients(name: String): Ingredients {
        if (name == "Coffee") {
            return Ingredients(
                water = 200,
                milk = 50,
                beans = 15
            )
        }
        throw Error("Unknown drink")
    }

    private fun calcIngredients(drinkName: String, numberOfCups: Int): Ingredients {
        val ingredients = getDrinkIngredients(drinkName)
        return Ingredients (
            water = ingredients.water * numberOfCups,
            milk = ingredients.milk * numberOfCups,
            beans = ingredients.beans * numberOfCups
        )
    }
}