fun main() {
    fun part1(input: List<String>): Int {
        val sections = input.map {
            val pattern = """([0-9]+)-([0-9]+),([0-9]+)-([0-9]+)"""
            val regex = Regex(pattern)
            val (m1, m2, m3, m4) = regex.matchEntire(it)!!.destructured
            IntRange(m1.toInt(), m2.toInt()) to IntRange(m3.toInt(), m4.toInt())
        }
        val duplicates = sections.map {
            val intersect = it.first intersect it.second
            if (intersect == it.first.toSet() || intersect == it.second.toSet()) 1 else 0
        }
        return duplicates.sum()
    }

    fun part2(input: List<String>): Int {
        val sections = input.map {
            val pattern = """([0-9]+)-([0-9]+),([0-9]+)-([0-9]+)"""
            val regex = Regex(pattern)
            val (m1, m2, m3, m4) = regex.matchEntire(it)!!.destructured
            IntRange(m1.toInt(), m2.toInt()) to IntRange(m3.toInt(), m4.toInt())
        }
        val duplicates = sections.map {
            val intersect = it.first intersect it.second
            if (intersect.isNotEmpty()) 1 else 0
        }
        return duplicates.sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part2(testInput) == 4)

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}
