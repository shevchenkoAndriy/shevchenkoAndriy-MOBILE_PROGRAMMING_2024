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
}