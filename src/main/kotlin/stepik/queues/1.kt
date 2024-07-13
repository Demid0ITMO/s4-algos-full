package stepik.queues

import java.util.*

val ans = arrayListOf<Pair<Int, Int>>()

fun heapify(arr: IntArray, n: Int, i: Int) {
    var min = i
    val l = 2 * i + 1
    val r = 2 * i + 2

    if (l < n && arr[l] < arr[min]) {
        min = l
    }

    if (r < n && arr[r] < arr[min]) {
        min = r
    }

    if (min != i) {
        val temp = arr[i]
        arr[i] = arr[min]
        arr[min] = temp
        ans.add(i to min)
        heapify(arr, n, min)
    }
}

fun heapSort(n: Int, arr: IntArray) {
    for (i in n / 2 - 1 downTo 0) {
        heapify(arr, n, i)
    }
}

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val arr = IntArray(n)
    repeat(n) { i -> arr[i] = sc.nextInt() }
    heapSort(n, arr)
    println(ans.size)
    for ((a, b) in ans) println("$a $b")
}