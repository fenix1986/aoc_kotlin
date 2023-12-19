package y2023

import println
import readInput

fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("y2023/dayXX_test")
    val input = readInput("y2023/dayXX")

    check(part1(testInput) == 1)
    part1(input).println()

    check(part2(testInput) == 1)
    part2(input).println()
}
