package prog4

class GroceryStore {
    private val availableGroceries: MutableList<StoreItem> = mutableListOf()

    /**
     * Returns a StoreItem of correct count, if the store has
     * the item in enough quantity. The store then reduces its count.
     */
    fun orderItem(name: String, number: Int): StoreItem? {
        var customerItem : StoreItem? = null
        val shopItem = findItemWithCount(name, number)
        if (shopItem != null) {
            shopItem.quantity -= number
            customerItem = StoreItem(
                shopItem.groceryItem,
                shopItem.pricePerItem,
                number
            )
        }
        return customerItem
    }

    private fun findItemWithCount(name: String, number: Int): StoreItem? {
        for (item in availableGroceries) {
            if (item.groceryItem.name == name && item.quantity >= number) {
                return item
            }
        }
        return null
    }

    fun printStore() {
        for (grocery in availableGroceries) {
            println(grocery.getStoreRepresentation())
        }
    }
}