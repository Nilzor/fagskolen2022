package inheritance.abstract


/**
 * An animal class tree using abstract classes, val and constructors.
 * Notice how we use 10 less lines of code doing the same, compared to AnimalPlain.kt
 */
abstract class Animal(val legCount: Int) {
    abstract fun speak()
}

class Cat : Animal(4) {
    override fun speak() {
        println("Meow")
    }
}

class Snake : Animal(0) {
    var hasShedSkin: Boolean = false

    override fun speak() {
        println("Ssssssssssss")
    }
}