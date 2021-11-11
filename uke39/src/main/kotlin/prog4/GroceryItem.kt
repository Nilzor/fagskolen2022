package prog4

import kotlin.math.roundToInt

class GroceryItem(
    val name: String,
    val type: String
) {
    fun print() {
        print(getItemRepresentation())
    }

    fun getItemRepresentation(): String {
        return "$name ($type)"
    }
}