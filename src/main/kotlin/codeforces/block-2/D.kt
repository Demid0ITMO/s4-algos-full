package codeforces.block2

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val a = arrayListOf<Long>()
    val b = arrayListOf<Long>()
    val ans = arrayListOf<Pair<Int, Int>>()
    for (i in 0 until n) a.add(sc.nextLong())
    for (i in 0 until n) b.add(sc.nextLong())
    for (i in 0 until n) {
        if (b[i] != a[i]) {
            for (j in i + 1 until n) {
                if (a[i] == b[j]) {
                    for (k in 0 until j - i) {
                        val p = b[j - k]
                        b[j - k] = b[j - k - 1]
                        b[j - k - 1] = p
                        ans.add(j - k to j - k + 1)
                    }
                    break
                }
            }
        }
    }
    println(ans.size)
    for (i in ans.indices) println("${ans[i].first} ${ans[i].second}")
}