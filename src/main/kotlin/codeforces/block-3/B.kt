package codeforces.block3

import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val map = HashMap<String, Long>()
    val map2 = HashMap<String, Long>()
    val rounds = ArrayList<Pair<String, Int>>()
    var maxScore = Long.MIN_VALUE
    for (i in 1..n) {
        val name = sc.next()
        val score = sc.nextInt()
        rounds.add(name to score)
        if (map[name] == null) map[name] = score.toLong()
        else map[name] = map[name]!! + score
    }
    for (pip in map) if (pip.value > maxScore) maxScore = pip.value
    for (round in rounds) {
        val name = round.first
        val score = round.second
        if (map2[name] == null) map2[name] = score.toLong()
        else map2[name] = map2[name]!! + score
        if (map2[name]!! >= maxScore && map[name]!! == maxScore) {
            println(name)
            return
        }
    }
}