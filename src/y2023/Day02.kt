fun main() {
    fun part1(input: List<String>): Int {
        return input.sumOf {
            val split = it.split("[:;]".toRegex())
            val game = split[0].split(" ")[1].toInt()
            var result : Int = game

            for ((index, s) in split.withIndex()) {
                if (index == 0) continue
                val cubs = s.split(",".toRegex())

                val inputLineRegex = """ (\d+) (\w+)""".toRegex()

                val map = HashMap<String, Int>()

                for (cub in cubs) {
                    val (value, color) = inputLineRegex
                            .matchEntire(cub)
                            ?.destructured
                            ?: throw IllegalArgumentException("Incorrect input line $cub")

                    map[color] = value.toInt()
                }

                if (
                        map.getOrDefault("red", 0) > 12
                        || map.getOrDefault("green", 0) > 13
                        || map.getOrDefault("blue", 0) > 14) {
                    result = 0
                }
            }

            result
        }
    }

    fun part2(input: List<String>): Int {
        return input.sumOf {
            val split = it.split("[:;]".toRegex())
            val map = HashMap<String, MutableList<Int>>()
            map["red"] = ArrayList()
            map["green"] = ArrayList()
            map["blue"] = ArrayList()

            for ((index, s) in split.withIndex()) {
                if (index == 0) continue
                val cubs = s.split(",".toRegex())

                val inputLineRegex = """ (\d+) (\w+)""".toRegex()

                for (cub in cubs) {
                    val (value, color) = inputLineRegex
                            .matchEntire(cub)
                            ?.destructured
                            ?: throw IllegalArgumentException("Incorrect input line $cub")

                    map[color]?.add(value.toInt())
                }
            }

            map.get("red")?.maxOrNull()!! * map.get("green")?.maxOrNull()!! * map.get("blue")?.maxOrNull()!!
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("y2023/day2_test")
    val input = readInput("y2023/day2")

    check(part1(testInput) == 8)
    part1(input).println()

    check(part2(testInput) == 2286)
    part2(input).println()
}
