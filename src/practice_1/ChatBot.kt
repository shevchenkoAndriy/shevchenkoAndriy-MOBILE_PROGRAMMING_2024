package practice_1

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


}