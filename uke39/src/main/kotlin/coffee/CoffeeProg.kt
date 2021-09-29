package coffee

var coffees = mutableListOf<Coffee>(
    Coffee("Americano", 4),
    Coffee("Espresso", 5),
    Coffee("Capuccino", 1),
    Coffee("Cafe Latte", 2)
)

fun main() {
    while (true) {
        presentMenu()
        takeOrder()
    }
}

fun presentMenu() {
    println("Velkommen til kaffemaskinen.")
    println("Vennligst velg ditt kaffeønske ved å velge tallet ved siden av kaffen:")

    var counter = 1
    for ((index, coffee) in coffees.withIndex()) {
        print("$counter: $coffee")

        if (numberOfCoffees[index] < 1) {
            print(" (TOMT)")
        }

        counter++
        println()
    }
}

fun takeOrder() {
    while (true) {
        try {
            val orderNumber = readLine()!!.toInt()

            if (orderNumber in 1..coffees.size) {
                if (numberOfCoffees[orderNumber - 1] < 1) {
                    println("Det er dessverre tomt for denne kaffen.")
                    continue
                }

                prepareCoffee(orderNumber)
                break
            } else {
                println("Dette er ikke et gyldig valg")
            }
        } catch (e: Exception) {
            println("Du må velge et tall")
        }
    }
}

fun prepareCoffee(orderNumber: Int) {
    val selectedCoffee = coffees[orderNumber - 1]
    numberOfCoffees[orderNumber - 1]--

    val wantDouble: Boolean
    while (true) {
        println("Ønsker du dobbel eller enkel?")
        val input = readLine()!!.lowercase()

        if (input == "dobbel" || input == "d") {
            wantDouble = true
            break
        } else if (input == "enkel" || input == "e") {
            wantDouble = false
            break
        } else {
            println("Forstod ikke ønsket. Prøv igjen.")
        }
    }

    if (wantDouble) {
        println("Du har valgt dobbel $selectedCoffee. Den blir nå laget!")
    } else {
        println("Du har valgt enkel $selectedCoffee. Den blir nå laget!")
    }

    serveCoffee(selectedCoffee)
}

fun serveCoffee(selectedCoffee: String) {
    when (selectedCoffee) {
        "Americano", "Cappuccino", "Cafe Latte" -> {
            println(
                "         {\n" +
                        "      {   }\n" +
                        "       }_{ __{\n" +
                        "    .-{   }   }-.\n" +
                        "   (   }     {   )\n" +
                        "   |`-.._____..-'|\n" +
                        "   |             ;--.\n" +
                        "   |            (__  \\\n" +
                        "   |             | )  )\n" +
                        "   |             |/  /\n" +
                        "   |             /  /\n" +
                        "   |            (  /\n" +
                        "   \\             y'\n" +
                        "    `-.._____..-'"
            )
        }
        else -> {
            println(
                "   ( (\n" +
                        "    ) )\n" +
                        "  ........\n" +
                        "  |      |]\n" +
                        "  \\      /\n" +
                        "   `----'"
            )
        }
    }
}