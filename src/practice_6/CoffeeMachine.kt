package practice_6

import shared.Reader
import kotlin.math.min
import kotlin.math.truncate

class CoffeeMachine (
    private var numberOfWater: Int = 0,
    private var numberOfMilk: Int = 0,
    private var numberOfBeans: Int = 0,
    private var numberOfCups: Int = 0,
    private var money: Int = 0
) {
    private val reader = Reader()
    private var drinks = listOf(
        Drink(DrinkType.ESPRESSO.value, 4),
        Drink(DrinkType.LATTE.value, 7),
        Drink(DrinkType.CAPPUCCINO.value, 6)
    )

    fun start() {
        while (true) {
            print("Write action (buy, fill, take): > ")
            val option = readln()
            when (option) {
                "buy" -> buyDrink()
                "fill" -> fillMachine()
                "take" -> takeMoney()
                "exit" -> {
                    return
                }
                else -> {
                    continue
                }
            }
        }
    }

    private fun takeMoney() {
        println("I gave you $money")
        money = 0
    }

    private fun fillMachine() {
        numberOfWater += reader.parsePositiveInt(
            "Write how many ml of water you want to add: > "
        )
        numberOfMilk += reader.parsePositiveInt(
            "Write how many ml of milk you want to add: > "
        )
        numberOfBeans += reader.parsePositiveInt(
            "Write how many grams of coffee beans you want to add: > "
        )
        numberOfCups += reader.parsePositiveInt(
            "Write how many disposable coffee cups you want to add: > "
        )
        showCoffeeMachineState()
    }

    private fun showCoffeeMachineState() {
        println(
            """
                The coffee machine has:
                $numberOfWater of water
                $numberOfMilk of milk
                $numberOfBeans of coffee beans
                $numberOfCups of disposable cups
                $money of money
            """.trimIndent()
        )
    }

    private fun buyDrink() {
        val option = reader.parsePositiveInt(
            "What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: > "
        )

        val drink = drinks[option - 1]

        val ingredients = getDrinkIngredients(drink.name)

        val numberOfAvailableDrinks = calcNumberOfAvailableDrinks(ingredients)

        if (numberOfAvailableDrinks < 1) {
            println("I have enough resources, making you a coffee!")
            return
        }

        numberOfWater -= ingredients.water
        numberOfMilk -= ingredients.milk
        numberOfBeans -= ingredients.beans
        numberOfCups -= 1
        money += drink.price

        showCoffeeMachineState()
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
        when (name) {
            DrinkType.ESPRESSO.value -> {
                return Ingredients(
                    water = 250,
                    milk = 0,
                    beans = 16
                )
            }
            DrinkType.LATTE.value -> {
                return Ingredients(
                    water = 350,
                    milk = 75,
                    beans = 20
                )
            }
            DrinkType.CAPPUCCINO.value -> {
                return Ingredients(
                    water = 200,
                    milk = 100,
                    beans = 12
                )
            }
        }

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