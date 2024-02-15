class FarmDetails {

        open class Farm

        class Land(val id: Int, val size: Int, val location: String, var currentPrice: Double) : Farm() {
            fun display() {
                println("Land $id - Size: $size acres, Location: $location, Current Price: $currentPrice")
            }
        }

        open class Animal : Farm()

        class Cow(val age: Int, var price: Double, var litresOfMilk: Double) : Animal() {
            fun display() {
                println("Cow Age: $age years, Price: $price, Litres of Milk Produced: $litresOfMilk")
            }
        }

        class Chicken(val age: Int, var numberOfEggs: Int, var price: Double) : Animal() {
            fun display() {
                println("Chicken Age: $age months, Number of Eggs Laid: $numberOfEggs per day, Price: $price")
            }
        }
    }

