
import org.junit.*
import org.junit.Assert.*

class YatzyTest {

    @Test
    fun `Chance must score the sum of all dice`() {
        assertEquals(15, Yatzy(2, 3, 4, 5, 1).scoreChance())
        assertEquals(16, Yatzy(3, 3, 4, 5, 1).scoreChance())
    }

    @Test
    fun `Five of the same dice as Yatzy scores 50`() {
        assertEquals(50, Yatzy(4, 4, 4, 4, 4).scoreYatzy())
        assertEquals(50, Yatzy(6, 6, 6, 6, 6).scoreYatzy())
    }

    @Test
    fun `A non yatzy scored as a Yatzy scores 0`() {
        assertEquals(0, Yatzy(6, 6, 6, 6, 3).scoreYatzy())
    }

    @Test
    fun `Ones are scored as sum of the ones in the roll`() {
        assertEquals(1, Yatzy(1, 2, 3, 4, 5).scoreOnes())
        assertEquals(2, Yatzy(1, 2, 1, 4, 5).scoreOnes())
        assertEquals(0, Yatzy(6, 2, 2, 4, 5).scoreOnes())
        assertEquals(4, Yatzy(1, 2, 1, 1, 1).scoreOnes())
    }

    @Test
    fun `Two are scored as sum of the two in the roll`() {
        assertEquals(4, Yatzy(1, 2, 3, 2, 6).scoreTwos())
        assertEquals(10, Yatzy(2, 2, 2, 2, 2).scoreTwos())
    }

    @Test
    fun `Threes are scored as sum of the threes in the roll`() {
        assertEquals(6, Yatzy(1, 2, 3, 2, 3).scoreThrees())
        assertEquals(12, Yatzy(2, 3, 3, 3, 3).scoreThrees())
    }

    @Test
    fun `Fours are scored as sum of the fours in the roll`() {
        assertEquals(12, Yatzy(4, 4, 4, 5, 5).scoreFours())
        assertEquals(8, Yatzy(4, 4, 5, 5, 5).scoreFours())
        assertEquals(4, Yatzy(4, 5, 5, 5, 5).scoreFours())
    }

    @Test
    fun `Fives are scored as sum of the fives in the roll`() {
        assertEquals(10, Yatzy(4, 4, 4, 5, 5).scoreFives())
        assertEquals(15, Yatzy(4, 4, 5, 5, 5).scoreFives())
        assertEquals(20, Yatzy(4, 5, 5, 5, 5).scoreFives())
    }

    @Test
    fun `Sixes are scored as sum of the sixes in the roll`() {
        assertEquals(0, Yatzy(4, 4, 4, 5, 5).scoreSixes())
        assertEquals(6, Yatzy(4, 4, 6, 5, 5).scoreSixes())
        assertEquals(18, Yatzy(6, 5, 6, 6, 5).scoreSixes())
    }

    @Test
    fun one_pair() {
        assertEquals(6, Yatzy(3, 4, 3, 5, 6).scorePair())
        assertEquals(10, Yatzy(5, 3, 3, 3, 5).scorePair())
        assertEquals(12, Yatzy(5, 3, 6, 6, 5).scorePair())
    }

    @Test
    fun two_Pair() {
        assertEquals(16, Yatzy(3, 3, 5, 4, 5).scoreTwoPair())
        assertEquals(16, Yatzy(3, 3, 5, 5, 5).scoreTwoPair())
    }

    @Test
    fun three_of_a_kind() {
        assertEquals(9, Yatzy(3, 3, 3, 4, 5).scoreThreeOfAKind())
        assertEquals(15, Yatzy(5, 3, 5, 4, 5).scoreThreeOfAKind())
        assertEquals(9, Yatzy(3, 3, 3, 3, 5).scoreThreeOfAKind())
    }

    @Test
    fun four_of_a_kind() {
        assertEquals(12, Yatzy(3, 3, 3, 3, 5).scoreFourOfAKind())
        assertEquals(20, Yatzy(5, 5, 5, 4, 5).scoreFourOfAKind())
        assertEquals(12, Yatzy(3, 3, 3, 3, 3).scoreFourOfAKind())
    }

    @Test
    fun smallStraight() {
        assertEquals(15, Yatzy(1, 2, 3, 4, 5).scoreSmallStraight())
        assertEquals(15, Yatzy(2, 3, 4, 5, 1).scoreSmallStraight())
        assertEquals(0, Yatzy(1, 2, 2, 4, 5).scoreSmallStraight())
    }

    @Test
    fun largeStraight() {
        assertEquals(20, Yatzy(6, 2, 3, 4, 5).scoreLargeStraight())
        assertEquals(20, Yatzy(2, 3, 4, 5, 6).scoreLargeStraight())
        assertEquals(0, Yatzy(1, 2, 2, 4, 5).scoreLargeStraight())
    }

    @Test
    fun fullHouse() {
        assertEquals(18, Yatzy(6, 2, 2, 2, 6).scoreFullHouse())
        assertEquals(0, Yatzy(2, 3, 4, 5, 6).scoreFullHouse())
    }
}