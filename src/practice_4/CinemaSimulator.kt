package practice_4
import shared.Reader

class CinemaSimulator {
    private var scene = emptyList<MutableList<String>>()
    private val reader = Reader()
    private var numberOfRows = 0
    private var numberOfSeatsInEachRow = 0
    private var numberOfPurchasedTickets = 0
    private var totalIncome = 0
    private var currentIncome = 0

    init {
        numberOfRows = reader.parsePositiveInt("Enter number of rows > ")
        numberOfSeatsInEachRow = reader.parsePositiveInt("Enter number of seats in each row> ")
        scene = MutableList(numberOfRows) { MutableList(numberOfSeatsInEachRow) { "S" } }
    }

    fun start() {
        menu()
    }

    private fun menu() {
        while (true) {
            println("""
            1. Show the seats
            2. Buy a ticket
            3. Statistics
            0. Exit
        """.trimIndent())
        val option = reader.parseInt("> ")
            when (option) {
                1 -> showScene()
                2 -> buyTicket()
                3 -> showStatistics()
                0 -> {
                    return
                }
            }
        }
    }

    private fun showStatistics() {
        val percentOfPurchasedTickets = (numberOfPurchasedTickets.toFloat() / (numberOfRows * numberOfSeatsInEachRow)) * 100
        val roundedPercent = String.format("%.2f", percentOfPurchasedTickets)
        println("Number of purchased tickets: $numberOfPurchasedTickets\n" +
                "Percentage: $roundedPercent%\n" +
                "Current income: \$$currentIncome\n" +
                "Total income: \$$totalIncome")
    }

    private fun buyTicket() {
        val rowNumber = reader.parsePositiveInt("Enter a row number: > ")
        val sitNumber = reader.parsePositiveInt("Enter a seat number in that row: > ")

        if (rowNumber > numberOfRows || sitNumber > numberOfSeatsInEachRow) {
            println("Wrong input!")
            return
        }

       val isFree = this.scene[rowNumber - 1][sitNumber - 1] == "S"

        if (!isFree){
            println("That ticket has already been purchased!")
            return
        }

        currentIncome = calcTicketPrice(rowNumber)
        totalIncome += currentIncome
        this.scene[rowNumber - 1][sitNumber - 1] = "B"
        numberOfPurchasedTickets += 1
        println("Ticket price: \$$currentIncome")
    }

    private fun calcTicketPrice(rowNumber: Int): Int {
        val totalSeats = numberOfRows * numberOfSeatsInEachRow
        val cheapThreshold = numberOfRows / 2
        return if (totalSeats < 60 || rowNumber <= cheapThreshold) {
            10
        } else {
            8
        }
    }

    private fun showScene() {
        println("Cinema:")
        print("  ")
        for (i in 1..scene[0].size) {
            print("$i ")
        }
        println()

        for ((index, row) in scene.withIndex()) {
            print("${index + 1} ")
            println(row.joinToString(" "))
        }
    }
}
