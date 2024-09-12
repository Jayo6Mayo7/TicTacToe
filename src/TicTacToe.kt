import java.lang.Math.random

fun pickWinner(x: String, y: String): String {
    if (x == "rock") {
        if (y == "rock") {
            val winner = "No one is"
            return winner
        }
        if (y == "paper") {
            val winner = "The computer is"
            return winner
        }
        if (y == "scissors") {
            val winner = "You are"
            return winner
        }
    }
    if (x == "paper") {
        if (y == "rock") {
            val winner = "You are"
            return winner
        }
        if (y == "paper") {
            val winner = "No one is"
            return winner
        }
        if (y == "scissors") {
            val winner = "The computer is"
            return winner
        }
    }
    if (x == "scissors") {
        if (y == "rock") {
            val winner = "The computer is"
            return winner
        }
        if (y == "paper") {
            val winner = "You are"
            return winner
        }
        if (y == "scissors") {
            val winner = "No one is"
            return winner
        }
    }
    return ""
}
fun stabilizeChoice(x:String): String {
    if (x == "1") {
        val stableChoice = "rock"
        return stableChoice
        }
    if (x == "2") {
        val stableChoice = "paper"
        return stableChoice
    }
    if (x == "3") {
        val stableChoice = "scissors"
        return stableChoice
    }
    return ""
}
fun main() {
    val placeholder = arrayListOf("rock", "paper", "scissors")
    val aiOptions = placeholder.toMutableList()
    while (true) {
        //Note: I couldn't find a way to make aiOptions.add work without the function being nested here
        fun addAntiChoice(x: String) {
            if (x == "rock") {
                aiOptions.add("paper")
            }
            if (x == "paper") {
                aiOptions.add("scissors")
            }
            if (x == "scissors") {
                aiOptions.add("rock")
            }
        }
        println("")
        println("Choose rock, paper, or scissors (or 1, 2, or 3)")
        Thread.sleep(500)
        var choice: String = readln()
        choice = stabilizeChoice(choice)
        addAntiChoice(choice)
        val aiChoice = (0..aiOptions.size-1).random()
        val stableaiChoice = aiOptions[aiChoice]
        print("Your choice is: ")
        println(choice)
        Thread.sleep(1000)
        print("The computer's choice is: ")
        println(stableaiChoice)
        Thread.sleep(1000)
        val pickedWinner = pickWinner(choice, stableaiChoice)
        print(pickedWinner)
        println(" the winner")
        Thread.sleep(2000)
    }
}

