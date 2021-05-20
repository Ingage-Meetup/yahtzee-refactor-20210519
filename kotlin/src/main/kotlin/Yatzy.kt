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

    fun yatzy() =
        dice.distinct().takeIf { it.size == 1 }?.let { 50 } ?: 0

    fun chance() = dice.sum()

    fun score_pair() =
        dice.groupBy { it }.filter { it.value.size >= 2 }.maxBy { it.key }?.value?.take(2)?.sum() ?: 0

    fun two_pair() =
        dice.groupBy { it }.filter { it.value.size >= 2 }.takeIf { it.size >= 2 }?.toSortedMap()?.values?.map { it.take(2) }?.flatten()?.sum() ?: 0

    fun four_of_a_kind() =
        dice.groupBy { it }.filter { it.value.size >= 4 }.map { it.value }[0].take(4).sum()

    fun three_of_a_kind() =
        dice.groupBy { it }.filter { it.value.size >= 3 }.map { it.value }[0].take(3).sum()

    fun smallStraight() =
        dice.toSortedSet().takeIf { it.size == 5 && it.last() == 5 }?.let { 15 } ?: 0

    fun largeStraight() =
        dice.toSortedSet().takeIf { it.size == 5 && it.last() == 6 }?.let { 20 } ?: 0

    fun fullHouse() =
        dice.groupBy { it }.filter { it.value.size == 2 || it.value.size == 3 }?.takeIf { it.size == 2 }?.values?.flatten()?.sum()
            ?: 0
}


