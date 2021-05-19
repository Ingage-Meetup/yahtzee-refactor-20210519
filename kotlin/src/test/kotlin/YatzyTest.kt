
import org.junit.*
import org.junit.Assert.*

class YatzyTest {

    @Test
    fun chance_scores_sum_of_all_dice() {
        val expected = 15
        val actual = Yatzy(2, 3, 4, 5, 1).chance()
        assertEquals(expected, actual)
        assertEquals(16, Yatzy(3, 3, 4, 5, 1).chance())
    }

    @Test
    fun yatzy_scores_50() {
        val expected = 50
        val actual = Yatzy(4, 4, 4, 4, 4).yatzy()
        assertEquals(expected, actual)
        assertEquals(50, Yatzy(6, 6, 6, 6, 6).yatzy())
        assertEquals(0, Yatzy(6, 6, 6, 6, 3).yatzy())
    }

    @Test
    fun test_1s() {
        assertEquals(1, Yatzy(1, 2, 3, 4, 5).ones())
        assertEquals(2, Yatzy(1, 2, 1, 4, 5).ones())
        assertEquals(0, Yatzy(6, 2, 2, 4, 5).ones())
        assertEquals(4, Yatzy(1, 2, 1, 1, 1).ones())
    }

    @Test
    fun test_2s() {
        assertEquals(4, Yatzy(1, 2, 3, 2, 6).twos())
        assertEquals(10, Yatzy(2, 2, 2, 2, 2).twos())
    }

    @Test
    fun test_threes() {
        assertEquals(6, Yatzy(1, 2, 3, 2, 3).threes())
        assertEquals(12, Yatzy(2, 3, 3, 3, 3).threes())
    }

    @Test
    fun fours_test() {
        assertEquals(12, Yatzy(4, 4, 4, 5, 5).fours())
        assertEquals(8, Yatzy(4, 4, 5, 5, 5).fours())
        assertEquals(4, Yatzy(4, 5, 5, 5, 5).fours())
    }

    // TODO: Make consistent test names (use NAME_test with underscores)
    @Test
    fun fives() {
        assertEquals(10, Yatzy(4, 4, 4, 5, 5).fives())
        assertEquals(15, Yatzy(4, 4, 5, 5, 5).fives())
        assertEquals(20, Yatzy(4, 5, 5, 5, 5).fives())
    }

    @Test
    fun sixes_test() {
        assertEquals(0, Yatzy(4, 4, 4, 5, 5).sixes())
        assertEquals(6, Yatzy(4, 4, 6, 5, 5).sixes())
        assertEquals(18, Yatzy(6, 5, 6, 6, 5).sixes())
    }

    @Test
    fun one_pair() {
        assertEquals(6, Yatzy(3, 4, 3, 5, 6).score_pair())
        assertEquals(10, Yatzy(5, 3, 3, 3, 5).score_pair())
        assertEquals(12, Yatzy(5, 3, 6, 6, 5).score_pair())
    }

    @Test
    fun two_Pair() {
        assertEquals(16, Yatzy(3, 3, 5, 4, 5).two_pair())
        assertEquals(16, Yatzy(3, 3, 5, 5, 5).two_pair())
    }

    @Test
    fun three_of_a_kind() {        
        assertEquals(9, Yatzy(3, 3, 3, 4, 5).three_of_a_kind())
        assertEquals(15, Yatzy(5, 3, 5, 4, 5).three_of_a_kind())
        assertEquals(9, Yatzy(3, 3, 3, 3, 5).three_of_a_kind())
    }
    
    @Test
    fun four_of_a_kind() {
        assertEquals(12, Yatzy(3, 3, 3, 3, 5).four_of_a_kind())
        assertEquals(20, Yatzy(5, 5, 5, 4, 5).four_of_a_kind())
        assertEquals(12, Yatzy(3, 3, 3, 3, 3).four_of_a_kind())
    }

    @Test
    fun smallStraight() {
        assertEquals(15, Yatzy(1, 2, 3, 4, 5).smallStraight())
        assertEquals(15, Yatzy(2, 3, 4, 5, 1).smallStraight())
        assertEquals(0, Yatzy(1, 2, 2, 4, 5).smallStraight())
    }

    @Test
    fun largeStraight() {
        assertEquals(20, Yatzy(6, 2, 3, 4, 5).largeStraight())
        assertEquals(20, Yatzy(2, 3, 4, 5, 6).largeStraight())
        assertEquals(0, Yatzy(1, 2, 2, 4, 5).largeStraight())
    }

    @Test
    fun fullHouse() {
        assertEquals(18, Yatzy(6, 2, 2, 2, 6).fullHouse())
        assertEquals(0, Yatzy(2, 3, 4, 5, 6).fullHouse())
    }
}