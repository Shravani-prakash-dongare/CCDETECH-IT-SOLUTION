import java.util.Scanner;

public class Basic_calculator {
 public static void main(String[] args) {
        int a, b, ch;

		System.out.println("Enter the first number :");
		Scanner scanner = new Scanner(System.in);
		a = scanner.nextInt();
		System.out.println("Enter the second number :");
		b = scanner.nextInt();

		System.out.println("\n1.Addition \n2.Subtration \n3.Multiplication \n4.Division");
		System.out.println("Pleas enter the Operation no :");
		ch = scanner.nextInt();
		switch (ch) {

		case 1:
			int add = a + b;
			System.out.println("Addition of given numbers = " + add);
			break;
		case 2:
			int sub = a - b;
			System.out.println("Subtration of the given number = " + sub);
			break;
		case 3:
			int mul = a * b;
			System.out.println("Multiplication of the given number = " + mul);
			break;
		case 4:
			int div = a / b;
			System.out.println("Divion of the given number = " + div);
			break;
		default:
			System.out.println("Invalid Choice");
		}
        scanner.close();
    }
}
