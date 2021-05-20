class Yatzy(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int) {

    protected var dice: IntArray = IntArray(5)

    init {
        dice[0] = d1
        dice[1] = d2
        dice[2] = d3
        dice[3] = d4
        dice[4] = d5
    }

    private fun scoreIndividualDice(number: Int) =
        dice.filter { it == number }.size * number

    fun ones() = scoreIndividualDice(1)
    fun twos() = scoreIndividualDice(2)
    fun threes() = scoreIndividualDice(3)
    fun fours() = scoreIndividualDice(4)
    fun fives() = scoreIndividualDice(5)
    fun sixes() = scoreIndividualDice(6)

    fun yatzy() = if (dice.distinct().size == 1) {
        50
    } else {
        0
    }

    fun chance() = dice.sum()

    fun score_pair() =
        dice.groupBy { it }.filter { it.value.size >= 2 }.maxBy { it.key }?.value?.take(2)?.sum() ?: 0

    fun two_pair() =
        dice.groupBy { it }.filter { it.value.size >= 2 }.takeIf { it.size >= 2 }?.toSortedMap()?.values?.map { it.take(2) }?.flatten()?.sum() ?: 0

    fun four_of_a_kind() =
        dice.groupBy { it }.filter { it.value.size >= 4 }.map { it.value }[0].take(4).sum()

    fun three_of_a_kind() =
        dice.groupBy { it }.filter { it.value.size >= 3 }.map { it.value }[0].take(3).sum()

    fun smallStraight(): Int {
        val tallies: IntArray = IntArray(6)
        tallies[dice[0] - 1] += 1
        tallies[dice[1] - 1] += 1
        tallies[dice[2] - 1] += 1
        tallies[dice[3] - 1] += 1
        tallies[dice[4] - 1] += 1
        return if (tallies[0] == 1 &&
            tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1
        ) 15 else 0
    }

    fun largeStraight(): Int {
        val tallies: IntArray = IntArray(6)
        tallies[dice[0] - 1] += 1
        tallies[dice[1] - 1] += 1
        tallies[dice[2] - 1] += 1
        tallies[dice[3] - 1] += 1
        tallies[dice[4] - 1] += 1
        return if (tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1
            && tallies[5] == 1
        ) 20 else 0
    }

    fun fullHouse(): Int {
        val tallies: IntArray
        var _2 = false
        var i: Int
        var _2_at = 0
        var _3 = false
        var _3_at = 0

        tallies = IntArray(6)
        tallies[dice[0] - 1] += 1
        tallies[dice[1] - 1] += 1
        tallies[dice[2] - 1] += 1
        tallies[dice[3] - 1] += 1
        tallies[dice[4] - 1] += 1

        i = 0
        while (i != 6) {
            if (tallies[i] == 2) {
                _2 = true
                _2_at = i + 1
            }
            i += 1
        }

        i = 0
        while (i != 6) {
            if (tallies[i] == 3) {
                _3 = true
                _3_at = i + 1
            }
            i += 1
        }

        return if (_2 && _3)
            _2_at * 2 + _3_at * 3
        else
            0
    }
}


