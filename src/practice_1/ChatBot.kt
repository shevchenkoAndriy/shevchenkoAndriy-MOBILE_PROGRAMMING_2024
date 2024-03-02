package practice_1

import shared.Reader

class ChatBot {
    init {
        println("Hello! My name is DICT_Bot.")
    }

    fun remindName () {
        println("Please, remind me your name.")
        val userName = Reader().readName("> ")
        println("What a great name you have, $userName!")
    }

    fun guessAge() {
        println("Let me guess your age.")
        println("Enter remainders of dividing your age by 3, 5 and 7.")
        val reader = Reader()
        val remainder3 = reader.parsePositiveInt("by 3 > ")
        val remainder5 = reader.parsePositiveInt("by 5 > ")
        val remainder7 = reader.parsePositiveInt("by 7 > ")
        val age = this.calcAge(remainder3, remainder5, remainder7)
        println("Your age is $age!")
    }

   private fun calcAge (remainder3: Int, remainder5: Int, remainder7: Int): Int {
        return (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105
   }

    fun countToAnyNumber() {
        println("Now I will prove to you that I can count to any number you want.")
        val countUpTo = Reader().parsePositiveInt("> ")
        for (i in 0 .. countUpTo) {
            println("$i !")
        }
    }

    fun checkProgrammingKnowledge(tests: List<Map<String, Any>> ) {
        println("Let's test your programming knowledge.")
        val reader = Reader()
        var step = 1
        while (step <= tests.size) {
           val test = tests[step - 1]

            println(test["question"])
            val options = test["options"] as List<*>
            printAllOptions(options)
            val userAnswer = reader.parsePositiveInt("> ")

            val isUserPassTest = test["answer"] == userAnswer

            if (!isUserPassTest) {
                println("Please, try again.")
                continue
            }

            println("Completed, have a nice day!")
            step++
        }
        println("Congratulations, have a nice day!")
    }

    private fun printAllOptions(options: List<*>) {
        for (i in options.indices){
            println("${i + 1}. ${options[i]}")
        }
    }

}
