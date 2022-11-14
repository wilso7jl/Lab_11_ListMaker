import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<String> menuList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String userInput = "";
        String choiceMenu = "";
        boolean userQuit = false;
        boolean done = false;
        int listNum;

        do {
            System.out.print("\n Choose one of the following ");
            choiceMenu = SafeInputs.getRegExString(in, "\n A: Add an item \n D: Delete an item \n P: Print the list \n Q: Quit", "[AaDdPpQq]");

            switch (choiceMenu) {
                case "A": case "a":
                    userInput = SafeInputs.getNonZeroLenString(in, "Enter an item to add: ");
                    menuList.add(userInput);
                    System.out.println(userInput + " has been added to the list ");
                    break;
                case "D": case "d":
                    if (menuList.size() > 0) {
                        displayArrayList();
                        listNum = SafeInputs.getRangedInt(in, "Enter the number you want to delete: ", 1, menuList.size());
                        listNum = listNum - 1;
                        System.out.println("The item has been deleted from the list: " + menuList.get(listNum));
                        menuList.remove(listNum);
                    }
                    else {
                        System.out.println("\n There is nothing in the list to delete");
                    }
                    break;
                case "P": case "p":
                    displayArrayList();
                    break;
                case "Q": case "q":
                    userQuit = SafeInputs.getYNConfirm(in, "Are you sure you want to quit?: ");
                    if (userQuit) {
                        System.out.println("Quitting Program");
                        System.exit(0);
                    }
                    break;
            }
        } while (!done);
    }

    private static void displayArrayList() {
        int counter = 0;
        if (menuList.size() == 0) {
            System.out.println("\n The list is empty");
        }
        else {
            System.out.println("\n Printed List: ");
            for (String i:menuList) {
                counter++;
                System.out.println(counter + ": " + i);
            }
        }
    }
}