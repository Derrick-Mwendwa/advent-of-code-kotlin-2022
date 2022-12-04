fun main() {
    fun part1(input: List<String>): Int {
        val calories = input.joinToString("\n").split("\n\n").map {
            it.lines().sumOf { line ->
                line.toInt()
            }
        }
        return calories.max()
    }

    fun part2(input: List<String>): Int {
        val calories = input.joinToString("\n").split("\n\n").map {
            it.lines().sumOf { line ->
                line.toInt()
            }
        }.sortedDescending()
        return calories[0] + calories[1] + calories[2]
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part2(testInput) == 45000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
