fun main() {
    fun Char.getPriority() = this.code - if (this.isLowerCase()) 96 else 38

    fun part1(input: List<String>) = input.sumOf {
        (it.substring(0, it.length / 2).toSet() intersect it.substring(it.length / 2).toSet())
            .single()
            .getPriority()
    }

    fun part2(input: List<String>) = input.chunked(3).sumOf {
        (it[0].toSet() intersect it[1].toSet() intersect it[2].toSet())
            .single()
            .getPriority()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
