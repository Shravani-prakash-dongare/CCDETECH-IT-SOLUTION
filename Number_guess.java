import java.util.*;

public class Number_guess{
    public static void main(String args[]) {
        int answer,guess=0;
        final int MAX=100;
        Scanner scanner=new Scanner(System.in);

        Random rand=new Random();
        answer=rand.nextInt(MAX)+1;
        int k=5;

        System.out.println("Enter the number between 1 and 100 to guess \nyou have 5 tries to guess the number.");

        while(k>0){
            System.out.println("\nEnter your guess :");
            guess=scanner.nextInt();

            if(guess== answer){
                System.out.println("You guesses the number. \nYou Win..!");
                break;
            }
            if(guess>answer){
                System.out.println("You guesses is too High. \nYou have "+(k-1)+" tries to left");
                k--;
            }
            if(guess<answer){
                System.out.println("You guesses is too Low. \nYou have "+(k-1)+" tries to left");
                k--;
            }
        }
        if(k==0){
            System.out.println("You ran out of tries \n you Lose....!\n the answer is :"+answer);
        }
        scanner.close();

    }
}