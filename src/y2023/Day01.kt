fun main() {
    fun part1(input: List<String>): Int {
        return input.sumOf {
            val first = it.first { c -> c.isDigit() }
            val last = it.last { c -> c.isDigit() }

            first.digitToInt() * 10 + last.digitToInt()
        }
    }

    fun part2(input: List<String>): Int {
        return part1(input.map { s ->
            s
                    .replace("one", "one1one")
                    .replace("two", "two2two")
                    .replace("three", "three3three")
                    .replace("four", "four4four")
                    .replace("five", "five5five")
                    .replace("six", "six6six")
                    .replace("seven", "seven7seven")
                    .replace("eight", "eight8eight")
                    .replace("nine", "nine9nine")
        })
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("y2023/day1_test")
    check(part1(testInput) == 142)

    val testInput2 = readInput("y2023/day1_test2")
    check(part2(testInput2) == 281)

    val input = readInput("y2023/day1")
    part1(input).println()
    part2(input).println()
}
