package practice_3

import kotlin.random.Random

class RockScissorsPaperGame {

    private val rules = mapOf(
        "rock" to "scissors",
        "paper" to "rock",
        "scissors" to "paper"
    )

    fun start() {
        println("===== Rock Scissors Paper =====")
        val options = rules.keys.toList()

        while (true) {
            val randomIndex =  Random.nextInt(options.size)
            val botOption = options[randomIndex]

            print("Choose one (rock,paper,scissors) > ")

            val playerOption = readlnOrNull()

            if (playerOption == null || !options.contains(playerOption)) {
                continue
            }

            println("Bot: $botOption")
            println("Player: $playerOption")

            if (botOption == playerOption) {
                println("Draw")
                return
            }

            val isPlayerWon = rules[playerOption] == botOption

            if (isPlayerWon) {
                println("You won!")
                return
            } else {
                println("You lose")
                return
            }
        }
    }
}
