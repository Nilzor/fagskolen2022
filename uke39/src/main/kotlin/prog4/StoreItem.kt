package prog4

class StoreItem(
    val groceryItem: GroceryItem,
    val pricePerItem: Double,
    var quantity: Int
) {
    fun isEmpty(): Boolean  {
        return false
    }
    fun getStoreRepresentation(): String {
        return ""
    }
}