package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class MineLayerTest {
    lateinit var fixture: Fixture

    @BeforeEach
    fun setUp() {
        fixture = Fixture()
        val (board, selector, mineNumber) = fixture
        MineLayer(board, selector).layMines(mineNumber)
    }

    @DisplayName("MineLayer 를 통해, board 에 여러개의 지뢰들을 설치할 수 있다.")
    @Test
    fun layMines() {
        assertThat(fixture.drawnBoard()).isEqualTo(
            """
                C C C * C C C * C C
                C C * C * C C C C C
                C C C C C C C C C C
                C C C C C C C C C C
                * C C C C C C C C C
                C C C C C C * C C C
                C C * C C C * C C C
                C C C C C C * C C *
                C C C C C C C C C C
                C C C C C C C C C C
            """.trimIndent()
        )
    }

    @DisplayName("MineLayer 를 통해 설치된 주변 지뢰의 갯수를 알 수 있어야 한다.")
    @Test
    fun minNumbers() {
        assertThat(fixture.mineNumbers()).isEqualTo(
            """
                0 1 2 * 2 1 1 * 1 0
                0 1 * 3 * 1 1 1 1 0
                0 1 1 2 1 1 0 0 0 0
                1 1 0 0 0 0 0 0 0 0
                * 1 0 0 0 1 1 1 0 0
                1 2 1 1 0 2 * 2 0 0
                0 1 * 1 0 3 * 3 1 1
                0 1 1 1 0 2 * 2 1 *
                0 0 0 0 0 1 1 1 1 1
                0 0 0 0 0 0 0 0 0 0
            """.trimIndent()
        )
    }
}
