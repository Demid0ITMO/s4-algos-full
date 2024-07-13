package codeforces.block2

import java.util.Scanner
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val k = sc.nextInt()
    val a = arrayListOf<Int>()
    for (i in 1..n) a.add(sc.nextInt())
    var l = 1
    var r = n + 1
    while (abs(l -  r) > 1) {
        val m = (l + r) / 2
        val b = arrayListOf<Int>()
        for (i in 0..<n) {
            if (a[i] >= m) b.add(1)
            else b.add(-1)
        }
        for (i in 1..<n) b[i] += b[i - 1]
        var maximum = b[k - 1]
        var minimum = 0
        for (i in k..<n) {
            minimum = min(minimum, b[i - k])
            maximum = max(maximum, b[i] - minimum)
        }
        if (maximum > 0) l = m
        else r = m
    }
    println(l)
}