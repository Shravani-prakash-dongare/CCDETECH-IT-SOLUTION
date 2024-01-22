import java.io.*;
import java.util.Scanner;

public class enc_dec1 {
    private static Scanner scanner = new Scanner(System.in);
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) {
        try {
            System.out.println("Enter file Path :");
            String filename = reader.readLine();

            System.out.println("\nWhich Operation Do you want to perform.\n1.Encryption\n2.Decryption\n");
            int choice = scanner.nextInt();
            if (choice == 1) {
                fileEncrypt(filename);
            } else if (choice == 2) {
                fileDecrypt(filename);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            scanner.close();

        }
    }

    public static void fileEncrypt(String filename) {
        try {
            long key = enterKey();
            if (key >= 1) {
                convert(filename, -key);
            } else {
                System.out.println("Please enter a nonzero key");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fileDecrypt(String filename) {
        try {
            long key = enterKey();
            if (key >= 1) {
                convert(filename, key);
            } else {
                System.out.println("Please enter a nonzero key");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void convert(String filename, long key) throws IOException {
        System.out.print("Enter the output file name with .txt extension : ");
        String outputFileName = reader.readLine();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(filename));
                BufferedWriter fileWriter = new BufferedWriter(new FileWriter(outputFileName))) {
            int currentChar;
            while ((currentChar = fileReader.read()) != -1) {
                if (Character.isLetter(currentChar)) {
                    char decryptedChar = (char) (currentChar - key);
                    fileWriter.write(decryptedChar);
                } else {
                    fileWriter.write(currentChar);
                }
            }
        }
        System.out.println("Operation completed successfully.");
    }

    private static long enterKey() throws IOException {
        long k = 0;
        System.out.println("Enter Secure Key");
        long intkey = scanner.nextInt();
        long temp = intkey;
        checking: {
            do {
                k = k + (intkey % 10);
                intkey = intkey / 10;
            } while (intkey >= 10);
            k = k + intkey;
            if (k > 32) {
                intkey = temp / 10;
                break checking;
            }
        }
        return k;
    }
}
