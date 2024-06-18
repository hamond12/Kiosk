open class Food(val name: String, val price: Int) {
    fun displayInfo(): String {
        return "$name - ${price}원"
    }
}

class Hamburger(name: String, price: Int) : Food(name, price)
class Potato(name: String, price: Int) : Food(name, price)
class Drink(name: String, price: Int) : Food(name, price)

class MenuItem(val name: String, val items: List<Food>)

object Menu {
    val menuItems: List<MenuItem>

    init {
        val hamburgers = listOf(
            Hamburger("불고기 버거", 2800),
            Hamburger("치즈 버거", 3200),
            Hamburger("치킨 버거", 3600)
        )

        val potatoes = listOf(
            Potato("기본 감자튀김", 1200),
            Potato("양념 감자튀김", 1500),
            Potato("허니 감자튀김", 1800)
        )

        val drinks = listOf(
            Drink("사이다", 1000),
            Drink("콜라", 1000),
            Drink("환타", 1000)
        )

        menuItems = listOf(
            MenuItem("햄버거", hamburgers),
            MenuItem("감자튀김", potatoes),
            MenuItem("음료", drinks)
        )
    }
}

class User(var money: Int) {
    fun purchase(food: Food) {
        if (money >= food.price) {
            money -= food.price
            println("${food.name} 구매, 잔액: ${money}원")
        } else {
            println("잔액 부족, 현재 잔액: ${money}원")
        }
    }
}