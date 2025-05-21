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
    var health: Int = 1000
    var level: Int = 1
    var alive: Boolean = true

    fun damage(damage: Int) {
        health = Math.clamp(health - damage.toLong(), 0, MAX_HEALTH)
        if (health == 0) {
            alive = false
        }
    }

    fun heal(amount: Int) {
        if (alive) {
            health = Math.clamp(health + amount.toLong(), 0, MAX_HEALTH)
        }
    }
}
