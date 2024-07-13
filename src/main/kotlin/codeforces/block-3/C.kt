package codeforces.block3

import java.util.*

fun main() {
    val line = readln()
    val map = mapOf(
        '(' to ')',
        '{' to '}',
        '[' to ']',
        '<' to '>'
    )
    val stack = Stack<Char>()
    var ans = 0
    try {
        for (s in line) {
            if (map[s] != null) stack.push(s)
            else {
                val p = stack.peek()
                if (map[p] != s) ans++
                stack.pop()
            }
        }
        if (stack.isNotEmpty()) throw Exception()
        println(ans)
    } catch (_: Exception) { println("Impossible") }
}