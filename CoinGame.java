import java.util.Scanner;

public class CoinGame {
    public static void main(String[] args) {
        int coins = 21; 
        Scanner scanner = new Scanner(System.in);
        
        while (coins > 0) {
    
            System.out.print("Pick 1, 2, 3, or 4 coins: ");
            int humanChoice = scanner.nextInt();
            while (humanChoice < 1 || humanChoice > 4 || humanChoice > coins) {
            
                System.out.print("Invalid choice. Pick 1, 2, 3, or 4 coins: ");
                humanChoice = scanner.nextInt();
            }
            coins -= humanChoice;
            System.out.println("You picked up " + humanChoice + " coins.");
            System.out.println("Coins remaining: " + coins);
            
            if (coins == 0) {
                System.out.println("You lost. AI wins.");
                break;
            }
            
    
            int aiChoice = (coins - 1) % 5;
            if (aiChoice == 0) {
                aiChoice = 1; // pick up 1 coin if no winning move available
            }
            coins -= aiChoice;
            System.out.println("AI picked up " + aiChoice + " coins.");
            System.out.println("Coins remaining: " + coins);
            
            if (coins == 0) {
                System.out.println("You won! AI lost.");
                break;
            }
 }
}
}