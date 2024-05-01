package practice_6

import shared.Reader
import kotlin.math.min
import kotlin.math.truncate

class CoffeeMachine {
    private val reader = Reader()
    private var numberOfWater = 0
    private var numberOfMilk = 0
    private var numberOfBeans = 0

    fun start() {
        showNumberOfAvailableDrinks()
    }

    private fun showOrderIngredients() {
        val numberOfCups = reader.parsePositiveInt(
            "Write how many cups of coffee you will need: > "
        )
        val drink = Drink(name = "Coffee", price = 1)
        val ingredients = calcIngredients(drink.name, numberOfCups)
        println("""
            For $numberOfCups cups of coffee you will need:
            ${ingredients.water} ml of water
            ${ingredients.milk} ml of milk
            ${ingredients.beans} g of coffee beans
        """.trimIndent())
    }

    private fun showNumberOfAvailableDrinks() {
        numberOfWater = reader.parsePositiveInt(
            "Write how many ml of water the coffee machine has: > "
        )
        numberOfMilk = reader.parsePositiveInt(
            "Write how many ml of milk the coffee machine has: > "
        )
        numberOfBeans = reader.parsePositiveInt(
            "Write how many grams of coffee beans the coffee machine has: > "
        )
        val numberOfCups = reader.parsePositiveInt(
            "Write how many cups of coffee you will need: > "
        )

        val ingredients = getDrinkIngredients("Coffee")

        val numberOfAvailableDrinks = calcNumberOfAvailableDrinks(ingredients)

        if (numberOfCups > numberOfAvailableDrinks) {
            println("No, I can make only $numberOfAvailableDrinks cups of coffee")
            return
        } else if (numberOfCups == numberOfAvailableDrinks) {
            println("Yes, I can make that amount of coffee")
            return
        }
        println(
            "Yes, I can make that amount of coffee" +
                    " (and even ${numberOfAvailableDrinks - numberOfCups} more than that)"
        )
    }

    private fun calcNumberOfAvailableDrinks(ingredients: Ingredients): Int {
        val maxNumberOfDrinkByWater = truncate(numberOfWater.toFloat() / ingredients.water)
        val maxNumberOfDrinkByMilk = truncate(numberOfMilk.toFloat() / ingredients.milk)
        val maxNumberOfDrinkByBeans = truncate(numberOfBeans.toFloat() / ingredients.beans)
        return min(maxNumberOfDrinkByBeans, min(maxNumberOfDrinkByWater, maxNumberOfDrinkByMilk)).toInt()
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