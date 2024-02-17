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
}