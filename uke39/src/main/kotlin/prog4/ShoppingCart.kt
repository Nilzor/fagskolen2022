package prog4

class ShoppingCart {
    private var shoppingCart = mutableListOf<StoreItem>()
    fun printCart() {}
    fun add(item: StoreItem) {}
    fun removeItem(name: String) {}
    fun checkOut() {}
    private fun getTotalPrice(): Double { return 0.0 }
    private fun printRecepit() {}
}