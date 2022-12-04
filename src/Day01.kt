fun main() {
    fun part1(input: List<String>): Int {
        val calories = mutableListOf<Int>()
        var sum = 0
        input.forEach {
            sum = if (it.isNotBlank()) sum + it.toInt() else {
                calories.add(sum)
                0
            }
        }
        return calories.max()
    }

    fun part2(input: List<String>): Int {
        val calories = mutableListOf<Int>()
        var sum = 0
        input.forEach {
            sum = if (it.isNotBlank()) sum + it.toInt() else {
                calories.add(sum)
                0
            }
        }
        calories.sortDescending()
        return calories[0] + calories[1] + calories[2]
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
