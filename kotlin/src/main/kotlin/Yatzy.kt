
class Yatzy(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int) {

    protected var dice: IntArray = IntArray(5)

    init {
        dice[0] = d1
        dice[1] = d2
        dice[2] = d3
        dice[3] = d4
        dice[4] = d5
    }

    fun fours(): Int {
        var sum: Int = 0
        for (at in 0..4) {
            if (dice[at] == 4) {
                sum += 4
            }
        }
        return sum
    }

    fun fives(): Int {
        var s = 0
        var i: Int = 0
        while (i < dice.size) {
            if (dice[i] == 5)
                s = s + 5
            i++
        }
        return s
    }

    fun sixes(): Int {
        var sum = 0
        for (at in dice.indices)
            if (dice[at] == 6)
                sum = sum + 6
        return sum
    }

    fun yatzy(): Int {
        val counts = IntArray(6)
        for (die in dice)
            counts[die - 1]++
        for (i in 0..5)
            if (counts[i] == 5)
                return 50
        return 0
    }

    fun chance(): Int {var total = 0
        total += dice[0]
        total += dice[1]
        total += dice[2]
        total += dice[3]
        total += dice[4]
        return total
    }

    fun ones(): Int {
        var sum = 0
        if (dice[0] == 1) sum++
        if (dice[1] == 1) sum++
        if (dice[2] == 1) sum++
        if (dice[3] == 1) sum++
        if (dice[4] == 1)
            sum++

        return sum
    }

    fun twos(): Int {
        var sum = 0
        if (dice[0] == 2) sum += 2
        if (dice[1] == 2) sum += 2
        if (dice[2] == 2) sum += 2
        if (dice[3] == 2) sum += 2
        if (dice[4] == 2) sum += 2
        return sum
    }

    fun threes(): Int {
        var s: Int = 0
        if (dice[0] == 3) s += 3
        if (dice[1] == 3) s += 3
        if (dice[2] == 3) s += 3
        if (dice[3] == 3) s += 3
        if (dice[4] == 3) s += 3
        return s
    }

    fun score_pair(): Int {
        val counts = IntArray(6)
        counts[dice[0] - 1]++
        counts[dice[1] - 1]++
        counts[dice[2] - 1]++
        counts[dice[3] - 1]++
        counts[dice[4] - 1]++
        var at: Int
        at = 0
        while (at != 6) {
            if (counts[6 - at - 1] >= 2)
                return (6 - at) * 2
            at++
        }
        return 0
    }

    fun two_pair(): Int {
        val counts = IntArray(6)
        counts[dice[0] - 1]++
        counts[dice[1] - 1]++
        counts[dice[2] - 1]++
        counts[dice[3] - 1]++
        counts[dice[4] - 1]++
        var n = 0
        var score = 0
        var i = 0
        while (i < 6) {
            if (counts[6 - i - 1] >= 2) {
                n++
                score += 6 - i
            }
            i += 1
        }
        return if (n == 2)
            score * 2
        else
            0
    }

    fun four_of_a_kind(): Int {
        val tallies: IntArray = IntArray(6)
        tallies[dice[0] - 1]++
        tallies[dice[1] - 1]++
        tallies[dice[2] - 1]++
        tallies[dice[3] - 1]++
        tallies[dice[4] - 1]++
        for (i in 0..5)
            if (tallies[i] >= 4)
                return (i + 1) * 4
        return 0
    }

    fun three_of_a_kind(): Int {
        val t: IntArray = IntArray(6)
        t[dice[0] - 1]++
        t[dice[1] - 1]++
        t[dice[2] - 1]++
        t[dice[3] - 1]++
        t[dice[4] - 1]++
        for (i in 0..5)
            if (t[i] >= 3)
                return (i + 1) * 3
        return 0
    }

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


