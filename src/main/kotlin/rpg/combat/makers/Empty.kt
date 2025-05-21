package rpg.combat.makers

class Empty {
    fun doNothing() {
        println("Please delete me!")
    }
}

class Character {
    companion object {
        const val MAX_HEALTH: Int = 1000
    }
    val name: String
    var health: Int = 1000
    var level: Int = 1
    var alive: Boolean = true

    constructor(name: String) {
        this.name = name
    }

    fun dealDamage(amount: Int, target: Character) {
        if (this.name != target.name ) {
            target.takeDamage(amount)
        }
    }

    fun dealHeal(amount: Int, target: Character) {
        if (this.name != target.name ) {
            target.takeHeal(amount)
        }
    }

    fun takeDamage(amount: Int) {
        health = Math.clamp(health - amount.toLong(), 0, MAX_HEALTH)
        if (health == 0) {
            alive = false
        }
    }

    fun takeHeal(amount: Int) {
        if (alive) {
            health = Math.clamp(health + amount.toLong(), 0, MAX_HEALTH)
        }
    }
}
