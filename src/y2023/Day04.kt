package y2023

import println
import readInput
import kotlin.streams.toList

fun main() {
    fun numberOfWins(input: String): Int {
        val split = input.split(" +\\| +".toRegex())
        val wins = split[0].split(": +| +".toRegex())
        val winning = wins.stream()
            .skip(2)
            .map(String::toInt)
            .toList()

        val mine = split[1].split(" +".toRegex()).stream()
            .map(String::toInt)
            .toList()

        return mine.filter { winning.contains(it) }.size
    }

    fun part1(input: List<String>): Int {
        return input.sumOf {
            val size = numberOfWins(it)
            if (size > 0) {
                1 shl (size - 1)
            } else {
                0
            }
        }
    }

    fun part2(input: List<String>): Int {
        val cards = Array(input.size) { 0 }

        for ((index, it) in input.withIndex()) {
            cards[index]++

            val size = numberOfWins(it)
            if (size > 0) {
                for (i in 0..<size) {
                    cards[index + i + 1] += cards[index]
                }
            }
        }

        return cards.sum()
    }


    // test if implementation meets criteria from the description, like:
    val testInput = readInput("y2023/day4_test")
    val input = readInput("y2023/day4")

    check(part1(testInput) == 13)
    part1(input).println()

    check(part2(testInput) == 30)
    part2(input).println()
}
