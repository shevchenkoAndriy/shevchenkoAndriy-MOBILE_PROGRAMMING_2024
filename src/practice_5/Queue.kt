package practice_5

class CustomQueue<T : Any> {
    private val elements = ArrayList<T>()

    fun enqueue(element: T) {
        elements.add(element)
    }

    fun dequeue(): T? {
        return if (!isEmpty()) {
            elements.removeAt(0)
        } else {
            null
        }
    }

    private fun isEmpty(): Boolean {
        return elements.isEmpty()
    }

    fun peek(): T? {
        return if (!isEmpty()) {
            elements[0]
        } else {
            null
        }
    }

    val count: Int
        get() = elements.size
}
