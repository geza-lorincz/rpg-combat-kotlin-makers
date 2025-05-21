package rpg.combat.makers

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class EmptyTest {
    fun createCharacter(): Character = Character()

    @Test
    fun `empty test`() {
        assertDoesNotThrow { Empty().doNothing() }
    }

    @Test
    fun `can create a character`() {
        assertDoesNotThrow { createCharacter() }
    }

    @Test
    fun `character starts with 1000 health when created`() {
        val character = createCharacter()

        assertEquals(1000, character.health)
    }

    @Test
    fun `character starts with level 1 when created`() {
        val character = createCharacter()

        assertEquals(1, character.level)
    }

    @Test
    fun`character is alive when created`() {
        val character = createCharacter()

        assertEquals(true, character.alive)
    }

    @Test
    fun`character's health decreases by damage amount when damaged`() {
        val character = createCharacter()

        character.damage(100)

        assertEquals(900, character.health)
    }

    @Test
    fun `character dies when health reaches a value of 0`() {
        val character = createCharacter()

        character.damage(1000)

        assertEquals(false, character.alive)
    }

    @Test
    fun `character's health increases by healed amount when healed`() {
        val character = createCharacter()

        character.damage(100)
        character.heal(50)

        assertEquals(950, character.health)
    }

    @Test
    fun `character's health does not increase further when it reaches 1000`() {
        val character = createCharacter()

        character.heal(100)

        assertEquals(1000, character.health)
    }

    @Test
    fun `dead character's health does not change when healed`() {
        val character = createCharacter()

        character.damage(1000)
        character.heal(100)

        assertEquals(0, character.health)
    }
}
