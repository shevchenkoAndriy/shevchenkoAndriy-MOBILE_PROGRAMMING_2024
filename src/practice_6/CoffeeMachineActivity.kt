package practice_6

import shared.Reader

class CoffeeMachineActivity {
    private val reader = Reader()
    private val coffeeMachine: CoffeeMachine = CoffeeMachine(
        numberOfWater = 400,
        numberOfMilk = 540,
        numberOfBeans = 120,
        numberOfCups = 9,
        money = 550
    )
    private val drinks = mapOf(
        Drink(
            name = DrinkType.ESPRESSO.value,
            price = 4
        ) to Ingredients(
            water = 250,
            milk = 0,
            beans = 16,
            cups = 1
        ),
        Drink(
            name = DrinkType.LATTE.value,
            price = 7
        ) to Ingredients(
            water = 350,
            milk = 75,
            beans = 20,
            cups = 1,
        ),
        Drink(
            name = DrinkType.CAPPUCCINO.value,
            price = 6
        ) to Ingredients(
            water = 200,
            milk = 100,
            beans = 12,
            cups = 1
        )
    )
    fun menu() {
        while (true) {
            print("Write action (buy, fill, take, remaining, exit): > ")
            val option = readln()
            when (option) {
                "buy" -> buyDrink()
                "fill" -> fillMachine()
                "take" -> takeMoney()
                "remaining" -> showMachineResources()
                "exit" -> {
                    return
                }
                else -> {
                    continue
                }
            }
        }
    }

    private fun showMachineResources() {
       val resources = coffeeMachine.getResources()
        val ingredients = resources.ingredients

        println("""
            The coffee machine has:
            ${ingredients.water} of water
            ${ingredients.milk} of milk
            ${ingredients.beans} of coffee beans
            ${ingredients.cups} of disposable cups
            ${resources.money} of money
        """.trimIndent())
    }

    private fun takeMoney() {
        val money = coffeeMachine.takeMoney()
        println("I gave you $money")
    }

    private fun fillMachine() {
        val numberOfWater = reader.parsePositiveInt(
            "Write how many ml of water you want to add: > "
        )
        val numberOfMilk = reader.parsePositiveInt(
            "Write how many ml of milk you want to add: > "
        )
        val numberOfBeans = reader.parsePositiveInt(
            "Write how many grams of coffee beans you want to add: > "
        )
        val numberOfCups = reader.parsePositiveInt(
            "Write how many disposable coffee cups you want to add: > "
        )
        val ingredients = Ingredients(
            water = numberOfWater,
            milk = numberOfMilk,
            beans = numberOfBeans,
            cups = numberOfCups
        )
        coffeeMachine.fillMachine(ingredients)
    }

    private fun buyDrink() {
        val option = reader.parsePositiveInt(
            """
                What do you want to buy?
                1 - espresso
                2 - latte
                3 - cappuccino
                4 - back to main menu
                > 
            """.trimIndent()
        )

        if (option == 4) {
            return
        }

        if (option > drinks.size) {
            println("Warning: Unknown drink")
            return
        }

        val drink = drinks.keys.toList()[option - 1]

        val ingredients = drinks[drink] ?: return

        try {
            coffeeMachine.buyDrink(drink.price, ingredients)
            println("I have enough resources, making you a coffee!")
        }
        catch (error: Error) {
            println(error.message)
        }
    }
}