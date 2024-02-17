package practice_1

class Reader {

   fun readName (label: String): String {
       while (true) {
           print(label)
           val userName = readlnOrNull()?.trim()
           if (userName != null && userName != ""){
               return userName
           }
       }
   }

    private fun parseInt (label: String): Int {
        while (true) {
            print(label)
            val input = readlnOrNull()
            val integerNumber: Int? = try { input?.toInt() } catch (e: NumberFormatException) { null }
            if (integerNumber != null) {
                return integerNumber
            }
        }
    }

    fun parsePositiveInt (label: String): Int {
        while (true) {
            val positiveNumber = this.parseInt(label)
            if (positiveNumber > 0) {
                return positiveNumber
            }
        }
    }
}