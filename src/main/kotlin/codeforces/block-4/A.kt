import java.util.*

const val INF = 1000000000

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val m = sc.nextInt()
    val g = MutableList(n + 1) { mutableListOf<Pair<Int, Int>>() }
    val s = 1

    repeat(m) {
        val a = sc.nextInt()
        val b = sc.nextInt()
        val w = sc.nextInt()
        g[a].add(b to w)
        g[b].add(a to w)
    }

    val d = IntArray(n+1) { INF }
    val p = IntArray(n+1) { -1 }
    d[s] = 0
    val u = BooleanArray(n+1)

    for (i in 1..n) {
        var v = -1
        for (j in 1..n) {
            if (!u[j] && (v == -1 || d[j] < d[v])) {
                v = j
            }
        }
        if (d[v] == INF) {
            break
        }
        u[v] = true

        for ((to, len) in g[v]) {
            if (d[v] + len < d[to]) {
                d[to] = d[v] + len
                p[to] = v
            }
        }
    }
    if (d[n] == INF) {
        println(-1)
    } else {
        val path = Stack<Int>()
        var node = n
        while (node != -1) {
            path.add(node)
            node = p[node]
        }
        while (path.isNotEmpty()) print("${path.pop()} ")
    }
}