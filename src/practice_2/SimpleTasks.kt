package practice_2

import shared.Reader
import java.time.Year

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

    /**
     * Return the negative of the given positive number.
     * For example, if the input is 1, the output is -1; for -5, return -5.
     *
     * @param label The label to prompt the user for input.
     */
    fun task3 (label: String = "> ") {
        val reader = Reader()
        val number = reader.parsePositiveInt(label)

        println(number * -1)
    }

    /**
     * Prompt the user for their year of birth, calculate their age, and print the result.
     *
     * @param label The label to prompt the user for input.
     */
    fun task4 (label: String = "> ") {
        val reader = Reader()
        val yearOfBirth = reader.parsePositiveInt(label)
        val age = calculateAge(yearOfBirth)
        println(age)
    }

    /**
     * Calculate the age based on the given year.
     * For example, if the year is 2000, the age is 24.
     *
     * @param year The year of birth or the year to calculate the age for.
     * @return The age calculated based on the given year.
     */
    private fun calculateAge (year: Int): Int {
        val currentYear = Year.now().value
        return currentYear - year
    }

}
