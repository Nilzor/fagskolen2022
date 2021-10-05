package inheritance.animal

open class Animal {
    var legCount: Int = -1

    open fun speak() {
        println("I don't know how to speak")
    }
}

class Cat : Animal() {
    init {
        legCount = 4
    }

    override fun speak() {
        println("Meow")
    }
}

class Snake : Animal() {
    var hasShedSkin: Boolean = false

    init {
        legCount = 0
    }

    override fun speak() {
        println("Ssssssssssss")
    }
}

