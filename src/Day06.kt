fun main() {
    fun part1(input: List<String>): Int {
        val line = input.single()
        var temp = -1
        for (startIndex in line.indices) {
            val endIndex = startIndex + 4
            if (endIndex < line.lastIndex) {
                if (line.substring(startIndex, endIndex).toSet().size == 4) {
                    temp = endIndex
                    break
                }
            }
        }
        return temp
    }

    fun part2(input: List<String>): Int {
        val line = input.single()
        var temp = -1
        for (startIndex in line.indices) {
            val endIndex = startIndex + 14
            if (endIndex < line.lastIndex) {
                if (line.substring(startIndex, endIndex).toSet().size == 14) {
                    temp = endIndex
                    break
                }
            }
        }
        return temp
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day06_test")
    check(part2(testInput) == 19)

    val input = readInput("Day06")
    println(part1(input))
    println(part2(input))
}
