enum class Choices {
    ROCK, PAPER, SCISSORS
}
fun rotate(x: Choices): Choices {
    return when (x) {
        Choices.PAPER -> Choices.SCISSORS
        Choices.ROCK -> Choices.PAPER
        Choices.SCISSORS -> Choices.ROCK
    }
}
fun selectWinner(x: Choices, y:Choices): String {
    return when {
        (x==y) -> "No one is"
        (rotate(x)==y) -> "The computer is"
        else -> "You are"
    }
}
fun stabilizeChoice(x:String): String {
    return when (x) {
        "1" -> "rock"
        "2" -> "paper"
        "3" -> "scissors"
        else -> x
    }
}
fun main() {
    val aiOptions = mutableListOf("rock", "paper", "scissors")
    println("This Kotlin program plays Tic-Tac-Toe")
    while (true) {
        //Note: I couldn't find a way to make aiOptions.add work without the function being nested here
        fun addAntiChoice(x: String) {
            when(x) {
                "rock" -> aiOptions.add("paper")
                "paper" -> aiOptions.add("scissors")
                "scissors" -> aiOptions.add("rock")
            }
        }
        println("\nChoose rock, paper, or scissors (or 1, 2, or 3)")
        Thread.sleep(500)
        var choice2: String = readln()
        choice2 = stabilizeChoice(choice2)
        addAntiChoice(choice2)
        val choice = Choices.valueOf(choice2.uppercase())
        val aiChoice = (0..aiOptions.size-1).random()
        val stableaiChoice2 = aiOptions[aiChoice]
        val stableaiChoice = Choices.valueOf(stableaiChoice2.uppercase())
        print("Your choice is: ")
        println(choice.toString().lowercase())
        Thread.sleep(1000)
        print("The computer's choice is: ")
        println(stableaiChoice.toString().lowercase())
        Thread.sleep(1000)
        val pickedWinner = selectWinner(choice, stableaiChoice)
        print(pickedWinner)
        println(" the winner")
        Thread.sleep(2000)
    }
}

