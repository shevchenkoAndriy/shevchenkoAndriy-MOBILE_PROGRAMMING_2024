package practice_6

class CoffeeMachine (
    private var numberOfWater: Int = 0,
    private var numberOfMilk: Int = 0,
    private var numberOfBeans: Int = 0,
    private var numberOfCups: Int = 0,
    private var money: Int = 0
) {
    fun takeMoney(): Int {
        val money = this.money
        this.money = 0
        return money
    }

    fun getResources (): Resource {
        return Resource(
            money = this.money,
            ingredients = Ingredients(
                cups = numberOfCups,
                water = numberOfWater,
                milk = numberOfMilk,
                beans = numberOfBeans,
            )
        )
    }

    fun fillMachine(ingredients: Ingredients) {
        numberOfWater += ingredients.water
        numberOfMilk += ingredients.milk
        numberOfBeans += ingredients.beans
        numberOfCups += ingredients.cups
    }

    fun buyDrink(price: Int, ingredients: Ingredients) {
        if (numberOfWater < ingredients.water) {
            throw Error("Sorry, not enough water!")
        }

        if (numberOfMilk < ingredients.milk) {
            throw Error("Sorry, not enough milk!")
        }

        if (numberOfBeans < ingredients.beans) {
            throw Error("Sorry, not enough coffee beans!")
        }

        if (numberOfCups < ingredients.cups) {
            throw Error("Sorry, not enough cups!")
        }

        numberOfWater -= ingredients.water
        numberOfMilk -= ingredients.milk
        numberOfBeans -= ingredients.beans
        numberOfCups -= 1
        money += price
    }
}