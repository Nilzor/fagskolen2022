package inheritance.animal

open class Animal

class Cat : Animal()

class Snake : Animal() {
    var hasShedSkin: Boolean = false

    init {
        legCount = 0
    }

    override fun speak() {
        println("Ssssssssssss")
    }
}

