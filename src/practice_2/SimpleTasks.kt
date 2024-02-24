package practice_2

import shared.Reader

/**
 * Contains simple tasks.
 */
class SimpleTasks {

    /**
     * Determines whether a given number is even or odd.
     *
     * @param label The label to prompt the user for input.
     */
    fun task1 (label: String = "> ") {
        val reader = Reader()
        val number = reader.parseInt(label)

        if (number % 2 == 0) {
            println("Even")
            return
        }

        println("Odd")
    }

    /**
     * Multiply the given number by 4 if it is even, and by 5 otherwise.
     *
     * @param label The label to prompt the user for input.
     */
    fun task2 (label: String = "> ") {
        val reader = Reader()
        val number = reader.parseInt(label)

        if (number % 2 == 0) {
            println(number * 4)
            return
        }

        println(number * 5)
    }

}
