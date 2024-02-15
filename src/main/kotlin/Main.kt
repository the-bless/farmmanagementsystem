import java.util.*
import FarmDetails.*

fun main() {
    val scanner = Scanner(System.`in`)

    println("Welcome to the Farm Management System!")
    println("Please login to continue.")
    print("Username: ")
    val username = scanner.nextLine()
    print("Password: ")
    val password = scanner.nextLine()

    if (authenticate(username, password)) {
        val lands = listOf(
            Land(1, 10, "CHEBAON", 50000.0),
            Land(2, 20, "KIPKORGOT", 75000.0),
            Land(3, 15, "FLAX", 60000.0)
        )

        val animals = listOf(
            Cow(5, 80000.0, 10.5),
            Cow(3, 60000.0, 8.0),
            Chicken(1, 3, 20.0),
            Chicken(2, 2, 15.0)
        )

        var choice: Int
        do {
            println("\nMenu:")
            println("1. Display Available Lands")
            println("2. Select a Specific Land")
            println("3. Display Animals")
            println("4. Exit")
            print("Enter your choice: ")
            choice = scanner.nextInt()

            when (choice) {
                1 -> {
                    println("Available Lands:")
                    lands.forEach { println("Land ${it.id}: ${it.location}") }
                }
                2 -> {
                    println("Available Lands:")
                    lands.forEach { println("Land ${it.id}: ${it.location}") }
                    print("Enter the Land ID to view details: ")
                    val landId = scanner.nextInt()
                    val selectedLand = lands.find { it.id == landId }
                    selectedLand?.let {
                        println("Details of Land ${it.id}: ${it.location}")
                        it.displayDetails()
                    } ?: run {
                        println("Land not found.")
                    }
                }
                3 -> {
                    println("Select the type of animal:")
                    println("1. Cow")
                    println("2. Chicken")
                    print("Enter your choice: ")
                    val animalChoice = scanner.nextInt()
                    when (animalChoice) {
                        1 -> {
                            println("Cows:")
                            animals.filterIsInstance<Cow>().forEach { it.display() }
                        }
                        2 -> {
                            println("Chickens:")
                            animals.filterIsInstance<Chicken>().forEach { it.display() }
                        }
                        else -> println("Invalid animal choice.")
                    }
                }
                4 -> println("Exiting...")
                else -> println("Invalid choice. Please try again.")
            }
        } while (choice != 4)
    } else {
        println("Login failed. Incorrect username/password.")
    }
}

private fun authenticate(username: String, password: String): Boolean {
    
    return username == "NICK" && password == "12345"
}

private fun Land.displayDetails() {
    println("Size: $size acres, Current Price: $currentPrice")
}
