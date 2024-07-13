package codeforces.block3

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val t = sc.nextInt()
    repeat(t) {
        val n = sc.nextInt()
        val a = PriorityQueue(reverseOrder<Int>())
        val b = PriorityQueue(reverseOrder<Int>())
        repeat(n) { a.add(sc.nextInt()) }
        repeat(n) { b.add(sc.nextInt()) }
        var ans = 0
        while (a.isNotEmpty() && b.isNotEmpty()) {
            if (a.peek() == b.peek()) {
                a.remove()
                b.remove()
                continue
            }
            ans++
            if (a.peek() > b.peek()) {
                a.add(a.peek().toString().length)
                a.remove(a.peek())
            } else {
                b.add(b.peek().toString().length)
                b.remove(b.peek())
            }
        }
        println(ans)
    }
}