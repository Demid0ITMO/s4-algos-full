package codeforces.block3

import java.util.*
import kotlin.collections.HashMap

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val map = HashMap<String, Long>()
    for (i in 1..n) {
        val s = sc.next()
        if (map[s] == null) {
            println("OK")
            map[s] = 1
        }
        else {
            println(s + map[s])
            map[s] = map[s]!! + 1
        }
    }
}