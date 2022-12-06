fun main() {
    // NOTE: This will not work for stacks exceeding 9
    fun getStacks(input: List<String>): Pair<List<MutableList<Char>>, Int> {
        val regex = Regex("""([0-9])+""")
        var stacks = 0
        var limit = 0
        for ((index, line) in input.withIndex()) {
            val text = line.filter { !it.isWhitespace() }
            if(regex.matches(text)) {
                stacks = text.last().digitToInt()
                limit = index
                break
            }
        }
        val temp = List(stacks) {
            mutableListOf<Char>()
        }
        return temp to limit
    }

    fun part1(input: List<String>): String {
        val stacks = getStacks(input)

        var start = 1
        for (x in stacks.first) {
            for (index in stacks.second - 1 downTo 0) {
                if (start < input[index].length && !input[index].elementAt(start).isWhitespace()) x.add(input[index].elementAt(start))
            }
            start += 4
        }

        val regexForCmd = Regex("""move ([0-9]+) from ([0-9]+) to ([0-9]+)""")
        input.forEach {
            if (it.startsWith("move")) {
                val (count, from, to) = regexForCmd.matchEntire(it)!!.destructured
                repeat(count.toInt()) {
                    val tmp2 = stacks.first[from.toInt() - 1].removeLast()
                    stacks.first[to.toInt() - 1].add(tmp2)
                }
            }
        }

        return stacks.first.map {
            it.last()
        }.joinToString("")
    }

    fun part2(input: List<String>): String {
        val stacks = getStacks(input)

        var start = 1
        for (x in stacks.first) {
            for (index in stacks.second - 1 downTo 0) {
                if (start < input[index].length && !input[index].elementAt(start).isWhitespace()) x.add(input[index].elementAt(start))
            }
            start += 4
        }

        val regexForCmd = Regex("""move ([0-9]+) from ([0-9]+) to ([0-9]+)""")
        input.forEach {
            if (it.startsWith("move")) {
                val (count, from, to) = regexForCmd.matchEntire(it)!!.destructured
                val temp3 = mutableListOf<Char>()
                repeat(count.toInt()) {
                    val tmp2 = stacks.first[from.toInt() - 1].removeLast()
                    temp3.add(tmp2)
                }
                temp3.reverse()
                stacks.first[to.toInt() - 1].addAll(temp3)
            }
        }

        return stacks.first.map {
            it.last()
        }.joinToString("")
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day05_test")
    check(part2(testInput) == "MCD")

    val input = readInput("Day05")
    println(part1(input))
    println(part2(input))
}
