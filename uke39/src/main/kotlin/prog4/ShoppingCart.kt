package prog4

class ShoppingCart {
    private var shoppingCart = mutableListOf<StoreItem>()
    fun printCart() {
        println("Innhold i handlekurven:")
        for (item in shoppingCart) {
            println(item.getStoreRepresentation())
        }
    }
    fun add(item: StoreItem) {
        shoppingCart.add(item)
    }

    fun removeItem(name: String) {
        var found: StoreItem? = null
        for (item in shoppingCart) {
           if (item.groceryItem.name == name) {
               found = item
               break
           }
        }
        shoppingCart.remove(found)
    }

    fun checkOut() {
        printReceipt()
        shoppingCart.clear()
    }

    private fun getTotalPrice(): Double {
        var sum = 0.0
        for (item in shoppingCart) {
            sum += item.pricePerItem
        }
        return sum
    }

    private fun printReceipt() {}
}