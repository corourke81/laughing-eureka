import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        System.out.println("Please enter a non-negative integer.");
        System.out.println("The number of palindromes for base 2 to 10 will be returned.");
        Scanner scanner = new Scanner(System.in);
        int numberBaseTen = scanner.nextInt(); // decimal number, user input
        int count = 0; // incremented each time user input is a palindrome when converted to base 2-10

        for (int base = 2; base <= 10; base++) {
            long numberToBase = baseConverter(numberBaseTen, base); // decimal number converted to base 2-10
            if (isPalindrome(numberToBase)) { // if converted number is a palindrome,
                count++; // increment the count
            }
        }
        System.out.println(count); // return the number of palindromes for conversion to base 2-10
    }

    public static long baseConverter(int number, int base) { // method to convert decimal number to different bases

        if (number < 0) return number;
        int digit; // will be digit in converted number, 0 to (base - 1)
        int position = 0; // will be position of the digit in converted number
        long convertedNumber = 0; // IMPORTANT!!! This will be a 'decimal' to the compiler.

        while (number > 0) {
            digit = number % base; // remainder...
            number = number / base; // and integer answer on division by base. New number mod the base is next digit
            convertedNumber = convertedNumber + digit * (long) Math.pow(10, position); // prepend digit by adding on a power of 10
            position++;
        }

        return convertedNumber;
    }

    public static boolean isPalindrome(long number) {
        long initialNumber = number; // store initial number
        int lengthOfNumber = 0;

        while (number > 0) {
            number = number / 10;
            lengthOfNumber++;
        } // gets no of digits

        long num = initialNumber;
        long initialNumberReversed = 0; //

        for (int i = lengthOfNumber - 1; i >= 0; i--) { // loop reversing initial number
            initialNumberReversed = initialNumberReversed + (num % 10) * (long) Math.pow(10, i);
            // last digit of num is appended to initialNumberReversed by adding  digit by a power of 10
            num = num / 10;
            // Next digit is last digit of num
        }

        return initialNumberReversed == initialNumber;
    }
}
