package practice_1

val PROGRAMMING_TESTS = listOf(
    mapOf(
        "question" to "What is the difference between val and var in Kotlin?",
        "options" to listOf(
            "val is mutable and var is immutable",
            "val is immutable and var is mutable",
            "Both are mutable",
            "Both are immutable"
        ),
        "answer" to 2
    ),
    mapOf(
        "question" to "What is the file extension for Kotlin files?",
        "options" to listOf(
            ".java",
            ".kt",
            ".kotlin",
            ".js"
        ),
        "answer" to 2
    ), mapOf(
        "question" to "How do you declare a variable 'x' with the value 10 in Kotlin?",
        "options" to listOf(
            "const x = 10",
            "int x = 10",
            "val x = 10",
            "x = 10"
        ),
        "answer" to 3
    )
)


fun main () {
    val chatBot = ChatBot()
    chatBot.remindName()
    chatBot.guessAge()
    chatBot.countToAnyNumber()
    chatBot.checkProgrammingKnowledge(PROGRAMMING_TESTS)
}