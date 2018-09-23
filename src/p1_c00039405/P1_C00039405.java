// Your Name: Coadiey Bryan
// Your ID: C00039405
// CMPS 261
// Programming Project: #1
// Due Date : 8/30/18 11:00 p.m.
// Program Description: Using Recursion to do different static methods and then
// calling them with main function.
// Certificate of Authenticity:
// I certify that the code in the method functions including method function main of this project are entirely my own work.
package p1_c00039405;

/**
 *
 * @author cxb0250
 */
public class P1_C00039405 {

    /*sum 
    *
    * Sums the number 1 to n recursively. Checks if given number is <= 1
    * if not it recursively calls itself with one less then the current number
    * and then adds that number to the current number.
    *
    * Must be given a integer number greater then 0 to work and greater then 
    * 1 to sum anything.
    *
    * If preconditions met it returns an integer sum of numbers 1 to n.
     */
    static int sum(int n) {
        if (n <= 1) {
            return 1;
        }
        return sum(n - 1) + n;
    }

    /*gcd          
    *
    * Finds the greatest common divider of two int numbers given. Does this by
    * first checking wether m modular n results in 0 and if it does then we know
    * that n is the greatest common divider of the two numbers so far. If 
    * the test returns not 0 then the method calls itself again this time with 
    * n being the new m and m modular n being the new n. Does this until
    * m modular n returns 0 or in other words n is the gcd.
    *
    * Must be given two integer numbers.
    *
    * If preconditions met it returns one integer number. Representing the 
    * greatest common divider of the two numbers.
     */
    static int gcd(int m, int n) {
        if ((m % n) == 0) {
            return n;
        }
        return gcd(n, m % n);
    }

    /*binary         
    *
    * Converts the given decimal number into it's binary form. Checks 
    * if the given decimal number is greater then 0 if so it sets an integer
    * equal to the decimal number modular 2, which is the same as a single
    * binary bit representation of that decimal number. Then the method 
    * converts and stores that bit into a string. Next it shifts the left 
    * operand number by 1 bit to the right, cutting off one binary bit and
    * therefore dividing the decimal number by 2. we do this so that way in the 
    * next step we can pass this rounded down half of the previous number back
    * to the method as many times as it takes until the number given to the
    * method is not bigger then 0. All the results of the method calls are 
    * stored in the string 'binaryStringNow' and then returned altogether when
    * the method is called.
    *
    * Must be given a positive integer decimal number.
    *
    * If preconditions met it returns one String representation of the
    * binary equivalent of given int number.
     */
    static String binary(int dec) {                      //given a decimal number
        String binaryStringNow, stringNum;
        if (dec > 0) {                                   //threshold
            int binaryBit = dec % 2;                    //makes the binary bit for decNum
            stringNum = Integer.toString(binaryBit);    //converts the binarybit to a string like the instructions requested 
            dec = dec >>> 1;                            //shifts the left operand number by 1 bit to the right, cutting off one binary bit and therefore dividing by two
            binaryStringNow = binary(dec);              //the recursion
            binaryStringNow += stringNum;               //collects all the bit results into one string
            return binaryStringNow;                     //returns the entire binary string
        }
        return "";                                    //because Java is needy
    }

    /*harmonic        
    *
    * Computes the given integer number's harmonic number. Checks that the int
    * given to the equation is greater then 1 if so it uses the given number 
    * as the denominator dividing one as the numerator and then adding this
    * result to the given number minus one. the result of the these numbers is
    * stored in a float and returned when the equation is called. When the 
    * equation counts down until the number being passed to the equation is no
    * longer bigger then 1 it returns 1 this multiplies the current returned
    * number by 1 and returns that number.
    *
    * Must be given a integer number that is positive.
    *
    * If preconditions met it returns one float number.
     */
    static float harmonic(int n) {
        float harmonicNum;
        if (n > 1) {
            harmonicNum = (float) ((1.0 / (float) (n)) + harmonic(n - 1));       //the equation for harmonic numbers + the recursive result
            return harmonicNum;                                             //returns actual answer
        }
        return 1;                                                           //multiplies by the previous return and is what is returned when static method is called
    }

    /*mi        
    *
    * Computes the given integer number into the equation. Checks if given 
    * number is bigger then 0 if so it inputs that number into the equation:
    * "i/(2i+1)", casting the numbers inside to double in order to return
    * the double value we want. Then it stores this result in 'm' and 
    * then we call the method again passing it 1 less then the current number
    * and then add that result to our current summised number in 'm'. Lastly,
    * we return 'm' until the number we are passing the method isn't bigger 
    * then 0 at which point we return .0 which is added to all of our previous
    * returns which should equal the number we want.
    *
    * Must be given a integer number that is positive.
    *
    * If preconditions met it returns one double number.
     */
    static double mi(int i) {
        if (i > 0) {                                                    //threshold
            double m = ((double) (i) / ((2.0 * (double) (i)) + 1.0));          //calculating the equation based on i
            m += mi(i - 1);                                              //this is adding all the results from the recursive equations for each i
            return m;                                                  //returning the actual results
        }
        return .0;                                                     //when mi(int i) is called previous return + .0 is returned
    }

    /*biggestNumFinder 
    *
    * Takes user array and calls the helper function biggestNumFinder
    * with the given array, 0 for the initial index value, and 0 as the 
    * initial maximum value.
    *
    * Must be given an array with more then 1 integer number.
    *
    * If preconditions met it returns one integer number that is the 
    * largest element in the array.
     */
    static int biggestNumFinder(int[] array) {                  //main function for biggestNumFinder
        return P1_C00039405.biggestNumFinder(array, 0, 0);
    }

    /*biggestNumFinder     
    *
    * Finds the biggest number in the array by looking through each element
    * from index 0 to the length of the array and compares each index to 
    * current biggest found number so far. Checks if the index is the same as
    * the length of the array, which should stop us when we have gone through
    * every element of the array. if we have we return our current largest 
    * number stored in max. If not: if our current element given by the 
    * index we were passed is bigger then the current max then that number
    * becomes the new max number. if or if not we call the method again with
    * the array, the current index plus one, and the current maximum number.
    *
    * Must be given an array with more then 1 integer number and given 0 as
    * initial index and 0 as initial maximum number if sorting positive 
    * numbers. If sorting negative numbers start with a negative 
    * number less then the least number in the array.
    *
    * If preconditions met it returns one integer number that is the 
    * largest element in the array.
     */
    static int biggestNumFinder(int[] array, int index, int max) {      //helper function
        if (index == array.length) {                                    //Thresh hold 
            return max;                                                 //returns max to whatever calls this method
        }
        if (array[index] > max) {
            max = array[index];                                         //sets max if element in array is bigger then current max
        }
        return biggestNumFinder(array, index + 1, max);                  //recursively checkes each index from 0 to end of function
    }

    /*oddEvenFact    
    *
    * Finds the odd/even factorial of the given number. Checks wether given 
    * integer number is greater then 0. If so sets a long equal to the given
    * number * the method called again and this time passed the current number 
    * minus 2. This will happen until we go from the initial given number all
    * the way down to 1 and return the result of all these calls multiplied
    * together and returns them. Then once the number is not greater then 0 it
    * will return 1 on top of what it already returned which should multiply by
    * the currently returned value. 
    *
    * Must be given a positive integer greater then 0.
    *
    * If preconditions met it returns one long number representing 
    * the fraction of the odd/even factorial of given number.
     */
    static long oddEvenFact(int number) {
        long longNum;
        if (number > 0) {                                    //threshold
            longNum = number * oddEvenFact(number - 2);         //the current number * the given number - 2 answer stored in longNum
            return longNum;                                 //returns the actual answer
        }
        return 1;                                          //multiplies by the previous return and is what is returned when method is called
    }

    public static void main(String[] args) {

        java.util.Scanner keyboard = new java.util.Scanner(System.in);
        System.out.println("Please enter 8 non negative decimal numbers:");
        int[] userNumArray = {keyboard.nextInt(), keyboard.nextInt(),
            keyboard.nextInt(), keyboard.nextInt(), keyboard.nextInt(),
            keyboard.nextInt(), keyboard.nextInt(), keyboard.nextInt()};

        System.out.println(harmonic(1) + harmonic(2) + harmonic(3)
                + harmonic(4) + harmonic(5) + harmonic(6) + harmonic(7)
                + harmonic(8) + harmonic(9) + harmonic(10));
        System.out.println(mi(1) + mi(2) + mi(3) + mi(4) + mi(5)
                + mi(6) + mi(7) + mi(8) + mi(9) + mi(10));
        System.out.println(biggestNumFinder(userNumArray));

    }
}
