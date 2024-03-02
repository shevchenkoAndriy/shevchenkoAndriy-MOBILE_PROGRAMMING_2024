package practice_2

import shared.Reader
import java.time.Year

val VOWELS = listOf('a', 'e', 'i', 'o', 'u', 'y')

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
        showTaskHead(1)
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
        showTaskHead(2)
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
        showTaskHead(3)
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
        showTaskHead(4)
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

    /**
     * Finds the minimum integer in the given integer array.
     *
     * @param integerArray The array of integers to search.
     */
    fun task5 (integerArray: IntArray) {
        showTaskHead(5)
        var minNumber = integerArray.first()
        for (number in integerArray) {
            if (number < minNumber) {
                minNumber = number
            }
        }

        println(minNumber)
    }

    private fun showTaskHead (taskNumber: Int) {
        println("############## TASK:${taskNumber} ################")
    }

    /**
     * Finds the two largest integers in the given integer array.
     *
     * @param integerArray The array of integers to search.
     */
    fun task6(integerArray: IntArray) {
        showTaskHead(6)

        if (integerArray.isEmpty()) {
            println(emptyList<Int>())
            return
        }

        val listOfInt = integerArray.toMutableList()
        listOfInt.sortDescending()

        val biggestIntList = listOfInt.subList(0, minOf(2, listOfInt.size))
        
        println(biggestIntList)
    }

    /**
     * Counts the number of positive integers and calculates the sum of negative integers in the given integer array.
     * Returns a list containing the count of positive integers and the sum of negative integers.
     *
     * @param integerArray The array of integers to process.
     */
    fun task7(integerArray: IntArray?) {
        showTaskHead(7)

        if (integerArray == null || integerArray.isEmpty()) {
            println(emptyList<Int>())
            return
        }

        var positiveNumbersAmount = 0
        var negativeNumbersSum = 0
        for (number in integerArray) {
            if (number > 0) {
                positiveNumbersAmount++
            }

            if (number < 0) {
                negativeNumbersSum += number
            }
        }
        println(listOf(positiveNumbersAmount, negativeNumbersSum))
    }

    /**
     * Counts the number of vowels in the given word.
     * Vowels are defined as the characters 'a', 'e', 'i', 'o', and 'u' (both lowercase and uppercase).
     *
     * @param word The word to count vowels in.
     */
    fun task8(word: String) {
        showTaskHead(8)
        var amountOfVowels = 0
        for (letter in word) {
            if (VOWELS.contains(letter.lowercaseChar())) amountOfVowels++
        }

        println(amountOfVowels)
    }

    /**
     * Prints the middle character(s) of the given word.
     * If the word has an odd length, prints the middle character.
     * If the word has an even length, prints the two middle characters.
     *
     * @param word The word to extract the middle character(s) from.
     */
    fun task9(word: String) {
        showTaskHead(9)

        if (word.length < 3) {
            println(word)
            return
        }

        if (word.length % 2 != 0) {
            val middleIndex = (word.length / 2)
            println(word[middleIndex])
            return
        }

        val middleStartIndex = (word.length.toDouble() / 2).toInt()

        println(word.substring(middleStartIndex, middleStartIndex + 2 ))
    }

}
