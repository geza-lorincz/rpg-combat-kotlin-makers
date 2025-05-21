package rpg.combat.makers

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class EmptyTest {
    val characterList = mutableListOf<Character>()
    fun createCharacter(name: String = "test"): Character {
        val character = Character(name)
        characterList.add(character)
        return character
    }

    fun getAllCharacters(): List<Character> = characterList.toList()

    @Test
    fun `can create a character with a name`() {
        val character = assertDoesNotThrow {
            createCharacter("test")
        }

        assertEquals("test", character.name)
    }

    @Test
    fun `can retrieve all characters`() {
        createCharacter("test")
        createCharacter("test2")
        val characters = getAllCharacters()

        assertEquals(2, characters.size)
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

        character.takeDamage(100)

        assertEquals(900, character.health)
    }

    @Test
    fun `character dies when health reaches a value of 0`() {
        val character = createCharacter()

        character.takeDamage(1000)

        assertEquals(false, character.alive)
    }

    @Test
    fun `character's health increases by healed amount when healed`() {
        val character = createCharacter()

        character.takeDamage(100)
        character.takeHeal(50)

        assertEquals(950, character.health)
    }

    @Test
    fun `character's health does not increase further when it reaches 1000`() {
        val character = createCharacter()

        character.takeHeal(100)

        assertEquals(1000, character.health)
    }

    @Test
    fun `dead character's health does not change when healed`() {
        val character = createCharacter()

        character.takeDamage(1000)
        character.takeHeal(100)

        assertEquals(0, character.health)
    }

    @Test
    fun `character can deal damage to another character`() {
        val character1 = createCharacter("test")
        val character2 = createCharacter("test2")

        character1.dealDamage(100, character2)

        assertEquals(900, character2.health)
    }

    @Test
    fun `character can heal  another character`() {
        val character1 = createCharacter("test")
        val character2 = createCharacter("test2")

        character1.dealDamage(100, character2)
        character1.dealHeal(50, character2)

        assertEquals(950, character2.health)
    }

}
