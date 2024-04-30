import java.nio.BufferOverflowException;
import java.util.Scanner;  // Import the Scanner class
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Greeting {

    private static final int BUFFER_SIZE = 20;

    public static void main(String[] args){

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("What is your name?");

        String name = myObj.nextLine();  // Read user input

        // Empty string
        if (name.isEmpty()) {
            throw new IllegalArgumentException();
        }

        // String too long
        if (name.length() > BUFFER_SIZE) {
            throw new BufferOverflowException();
        }

        // Special characters
        Pattern pattern = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
        Matcher matcher = pattern.matcher(name);
        boolean matchFound = matcher.find();
        if(matchFound) {
            throw new IllegalArgumentException();
        }

        System.out.println("Hi there, " + name);  // Output user input

    }
}
