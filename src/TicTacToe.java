import java.util.*;
//The computer dynamically adapts based off what you play
public class TicTacToe {
    static String pickWinner(String x, String y) {
        if (Objects.equals(x, "rock")) {
            if (Objects.equals(y, "rock")) {
                return "No one is";
            }
            if (Objects.equals(y, "paper")) {
                return "The computer is";
            }
            if (Objects.equals(y, "scissors")) {
                return "You are";
            }
        }
        if (Objects.equals(x, "paper")) {
            if (Objects.equals(y, "rock")) {
                return "You are";
            }
            if (Objects.equals(y, "paper")) {
                return "No one is";
            }
            if (Objects.equals(y, "scissors")) {
                return "The computer is";
            }
        }
        if (Objects.equals(x, "scissors")) {
            if (Objects.equals(y, "rock")) {
                return "The computer is";
            }
            if (Objects.equals(y, "paper")) {
                return "You are";
            }
            if (Objects.equals(y, "scissors")) {
                return "No one is";
            }
        }
        return "error message";
    }
    static String stabilizeChoice(String x) {
        if (Objects.equals(x, "1")) {
            return "rock";
        }
        if (Objects.equals(x, "2")) {
            return "paper";
        }
        if (Objects.equals(x, "3")) {
            return "scissors";
        }
        return "error message";
    }
    static List<String> aiOptions = new ArrayList<>();
    public static void addAntiChoice(String x) {
        if (Objects.equals(x, "rock")) {
            aiOptions.add("paper");
        }
        if (Objects.equals(x, "paper")) {
            aiOptions.add("scissors");
        }
        if (Objects.equals(x, "scissors")) {
            aiOptions.add("rock");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        aiOptions.add("rock");
        aiOptions.add("paper");
        aiOptions.add("scissors");
        System.out.println("This Java program plays Tic-Tac-Toe");
        while (true) {
            System.out.print("\nChoose rock, paper, or scissors (or 1, 2, or 3)\n");
            Thread.sleep(500);
            Scanner myObj = new Scanner(System.in);
            String choice = myObj.nextLine();
            if (Objects.equals(choice, "1") || Objects.equals(choice, "2") || (Objects.equals(choice, "3"))) {
                choice = stabilizeChoice(choice);
            }
            addAntiChoice(choice);
            Random rand = new Random();
            int aiChoice = rand.nextInt(aiOptions.size() - 1);
            String stableaiChoice = aiOptions.get(aiChoice);
            System.out.print("Your choice is: ");
            System.out.println(choice);
            Thread.sleep(500);
            System.out.print("The computer's choice is: ");
            System.out.println(stableaiChoice);
            Thread.sleep(1000);
            String pickedWinner = pickWinner(choice, stableaiChoice);
            System.out.print(pickedWinner);
            System.out.println(" the winner");
            Thread.sleep(2000);
        }
    }
}
