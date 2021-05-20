class Yatzy(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int) {

    private val dice = listOf(d1, d2, d3, d4, d5).toIntArray()

    private fun IntArray.scoreIndividual(number: Int) =
        this.filter { it == number }.size * number

    fun scoreOnes() = dice.scoreIndividual(1)
    fun scoreTwos() = dice.scoreIndividual(2)
    fun scoreThrees() = dice.scoreIndividual(3)
    fun scoreFours() = dice.scoreIndividual(4)
    fun scoreFives() = dice.scoreIndividual(5)
    fun scoreSixes() = dice.scoreIndividual(6)

    fun scoreYatzy() =
        dice.distinct().takeIf { it.size == 1 }?.let { 50 } ?: 0

    fun scoreChance() = dice.sum()

    fun scorePair() =
        dice.groupBy { it }.filter { it.value.size >= 2 }.maxBy { it.key }?.value?.take(2)?.sum() ?: 0

    fun scoreTwoPair() =
        dice.groupBy { it }.filter { it.value.size >= 2 }.takeIf { it.size >= 2 }?.toSortedMap()?.values?.map { it.take(2) }?.flatten()?.sum() ?: 0

    fun scoreFourOfAKind() =
        dice.groupBy { it }.filter { it.value.size >= 4 }.map { it.value }[0].take(4).sum()

    fun scoreThreeOfAKind() =
        dice.groupBy { it }.filter { it.value.size >= 3 }.map { it.value }[0].take(3).sum()

    fun scoreSmallStraight() =
        dice.toSortedSet().takeIf { it.size == 5 && it.last() == 5 }?.let { 15 } ?: 0

    fun scoreLargeStraight() =
        dice.toSortedSet().takeIf { it.size == 5 && it.last() == 6 }?.let { 20 } ?: 0

    fun scoreFullHouse() =
        dice.groupBy { it }.filter { it.value.size == 2 || it.value.size == 3 }?.takeIf { it.size == 2 }?.values?.flatten()?.sum()
            ?: 0
}


