package stepik.queues

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val m = scanner.nextInt()
    val tasks = LongArray(m) { scanner.nextLong() }
    val processors = PriorityQueue<Processor>()

    for (i in 0 until n) processors.add(Processor(i, 0))

    for (i in 0 until m) {
        val processor = processors.poll()
        println("${processor.id} ${processor.time}")
        processor.time += tasks[i]
        processors.add(processor)
    }
}

class Processor(val id: Int, var time: Long) : Comparable<Processor> {
    override fun compareTo(other: Processor): Int {
        val t = time.compareTo(other.time)
        return if (t == 0) id.compareTo(other.id) else t
    }
}