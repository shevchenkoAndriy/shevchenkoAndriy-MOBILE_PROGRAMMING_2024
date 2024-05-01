package practice_5

fun main(){

    val queue = CustomQueue<String>()
    queue.enqueue("Alex")
    queue.enqueue("Jack")
    queue.enqueue("Peter")
    println("Queue length: ${queue.count}")
    println("Element at the beginning of the queue -> " + queue.peek())
    queue.dequeue()
    println("Dequeue")
    println("Queue length: ${queue.count}")
    println("Element at the beginning of the queue -> " + queue.peek())
    queue.dequeue()
    println("Dequeue")
    queue.dequeue()
    println("Dequeue")
    println("Queue length: ${queue.count}")
}