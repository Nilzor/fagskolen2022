package inheritance.plain

fun main() {
    /** Below: Use the animal child classes directly */
    val cat = Cat()
    val snake = Snake()

    cat.speak()
    snake.speak()

    println("A cat has ${cat.legCount} legs")
    println("A snake has ${snake.legCount} legs")

    /** Use the animal child classes by only knowing the parent type "Animal" */
    val animalList = mutableListOf<Animal>()
    animalList.add(snake)
    animalList.add(cat)

    for (animal in animalList) {
        println("The animal that says...")
        animal.speak()
        println("..has ${animal.legCount} legs\n")
    }
}
