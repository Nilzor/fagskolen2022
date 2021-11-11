package prog4

class StoreItem(
    val groceryItem: GroceryItem,
    val pricePerItem: Double,
    var quantity: Int
) {
    fun isEmpty(): Boolean  {
        return quantity == 0
    }

    fun getStoreRepresentation(): String {
        val itemText = groceryItem.getItemRepresentation()
        return "$itemText: $pricePerItem kr. Antall: $quantity"
    }
}