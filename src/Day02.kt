fun main() {
    fun part1(input: List<String>): Int {
        // Assuming that we trust the input
        fun scoreOfShape(shape: Char) = when (shape) {
            'X' -> 1
            'Y' -> 2
            else -> 3
        }

        fun score(opponent: Char, player: Char) = when (opponent to player) {
            'A' to 'Y', 'C' to 'X', 'B' to 'Z' -> 6
            'A' to 'X', 'B' to 'Y', 'C' to 'Z' -> 3
            else -> 0
        }
        return input.sumOf { scoreOfShape(it[2]) + score(it[0], it[2]) }
    }

    fun part2(input: List<String>): Int {
        fun scoreOfShape(result: Pair<Char, Int>) = result.second + when (result.first) {
            'X' -> 1
            'Y' -> 2
            else -> 3
        }

        fun getOutcome(opponent: Char, outcome: Char): Pair<Char,Int> {
            val ch = when (outcome to opponent) {
                'X' to 'A', 'Y' to 'C', 'Z' to 'B' -> 'Z'
                'X' to 'B', 'Y' to 'A', 'Z' to 'C' -> 'X'
                else -> 'Y'
            }
            return ch to (outcome - 'X') * 3
        }
        return input.sumOf { scoreOfShape(getOutcome(it[0], it[2])) }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part2(testInput) == 12)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
