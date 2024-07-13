package codeforces.block4

import java.util.Scanner
import kotlin.math.max

val sc = Scanner(System.`in`)
var n = 0
var m = 0
val vis = ArrayList<ArrayList<Boolean>>(1000)
val a = ArrayList<ArrayList<Int>>(1000)

fun dfs(i: Int, j: Int): Int {
    vis[i][j] = true;
    var ans = a[i][j];
    if (i != 0 && a[i - 1][j] != 0 && !vis[i - 1][j])
        ans += dfs(i - 1, j);
    if (i != n - 1 && a[i + 1][j] != 0 && !vis[i + 1][j])
        ans += dfs(i + 1, j);
    if (j != 0 && a[i][j - 1] != 0 && !vis[i][j - 1])
        ans += dfs(i, j - 1);
    if (j != m - 1 && a[i][j + 1] != 0 && !vis[i][j + 1])
        ans += dfs(i, j + 1);
    return ans;
}

fun solve() {
    n = sc.nextInt()
    m = sc.nextInt()
    for (i in 0 until n) {
        for (j in 0 until m){
            try { vis[i][j] = false } catch (_: Exception) { vis[i].add(false) }
            val c = sc.nextInt()
            try { a[i][j] = c } catch (_: Exception) { a[i].add(c) }
        }
    }
    var ans = 0;
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (!vis[i][j] && a[i][j] != 0) ans = max(ans, dfs(i, j));
        }
    }
    println(ans)
}

fun main() {
    var t = sc.nextInt()
    repeat(1000) {
        vis.add(ArrayList(1000))
        a.add(ArrayList(1000))
    }
    while (t != 0) {
        solve()
        t--
    }
}