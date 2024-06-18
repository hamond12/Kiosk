fun main() {
    val user = User(10000)

    while (true) {
        showMainMenu()
        try {
            val menuNum = readln().toInt()
            if (menuNum == 0){
                print("\n프로그램을 종료합니다.")
                break
            }
            println()
            while (true) {
                val foodMenu = Menu.menuItems[menuNum - 1]
                chooseFood(foodMenu)
                try {
                    val foodNum = readln().toInt()
                    if (foodNum == 0) {
                        println()
                        break
                    }
                    val food = foodMenu.items[foodNum-1]
                    user.purchase(food)
                    println()
                }catch (e:ArrayIndexOutOfBoundsException){
                    printErrorMessage1()
                } catch (e: NumberFormatException){
                    printErrorMessage2()
                }
            }
        } catch (e:ArrayIndexOutOfBoundsException){
            printErrorMessage1()
        } catch (e: NumberFormatException){
            printErrorMessage2()
        }
    }
}

fun showMainMenu() {
    println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.")
    println()
    println("[ 주영버거 메뉴 ]")
    Menu.menuItems.forEachIndexed{i, menu -> println("${i + 1}. ${menu.name}")}
    println("0. 프로그램 종료")
    println()
    print("메뉴를 선택하세요: ")
}

fun chooseFood(foodMenu: MenuItem) {
    println("[ ${foodMenu.name} 메뉴 ]")
    foodMenu.items.forEachIndexed { index, item ->
        println("${index + 1}. ${item.displayInfo()}")
    }
    println("0. 뒤로가기")
    println()
    print("${foodMenu.name} 선택: ")
}

fun printErrorMessage1(){
    println("\nError: 잘못된 입력입니다. 숫자를 입력해주세요.")
    println()
}

fun printErrorMessage2(){
    println("\nError: 잘못된 입력입니다. 숫자를 입력해주세요.")
    println()
}




