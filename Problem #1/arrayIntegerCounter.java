/*********************************************************/
/* Programmer: Megan Spiers                              */
/*                                                       */
/* Purpose:    This was created to solve problem #1,     */
/*             for the RTS Labs Coding Assessment.       */
/*                                                       */
/* Task:      "Print the number of integers in an array  */
/*             that are above the given input and the    */ 
/*             number that are below, e.g. for the array */
/*             [1, 5, 2, 1, 10] with input 6, print      */
/*             "above: 1, below: 4".                     */
/*                                                       */
/* Note:       I have also included "Exact" as part of   */
/*             the output to cover the scenario of the   */
/*             user entering an integer that exists in   */
/*             the array.                                */
/*********************************************************/


import java.util.Scanner;


public class arrayIntegerCounter {

    // Declare static variables for use throughout entire program
    public static int[] inputArray;
    public static int integerToEvaluate;
    public static Scanner scnr = new Scanner(System.in);


    /*******************************************************************************/
    /* This method takes the user's input in as a string and converts the numbers, */
    /* if they pass error-checking, to an array.                                   */
    /*******************************************************************************/
    public static int[] getInputArray() {

        // Declare and initialize flag variable for while loop
        boolean flag = false;

        // Print initial prompt for use to enter elements of array
        System.out.println("Enter integers for array in a single line separated by spaces.\nEx. \"1 2 3 4 5\"");

        // While flag is false, use a try-catch to evaluate user input
        while (!flag) {

            // Try the following code until all integers are entered for the inputArray
            try {

                // Prompt user to enter array
                System.out.print("\nInput Array: ");

                // Accept input as entire line
                String line = scnr.nextLine();

                // Split the elements input into a String array based on a whitespace delimiter
                String[] inputs = line.split("\\s+");

                // initialize the previously declare static int inputArray to have same length as the String array
                inputArray = new int[inputs.length];

                // For each index in the inputArray, populate with the proper integer converted from the String array
                for (int i=0; i<inputArray.length;i++) {
                    inputArray[i] = Integer.parseInt(inputs[i]);
                }

                // Set flag = true to break out of while loop
                flag = true;
            }

            // If the user enters an element that is not an integer, catch exception and start over
            catch (Exception exception) {

                // print message prompting user to enter correct values
                System.out.println("\nEnter only integers for the array.");
            }

        }

        // Method returns the converted inputArray
        return inputArray;
    } 


    /**********************************************************************/
    /* This method obtains the integer to evaluate after determining that */
    /* the input was, in fact, an integer.                                */
    /**********************************************************************/
    public static int getEvaluationInteger() {
        
        // Declare and initialize flag variable for while loop
        boolean flag = false;

        // While flag is false, use a try-catch to evaluate user input
        while (!flag){

            // Try the following code until next input is confirmed to be an integer
            try{

                // Prompt user to enter an integer
                System.out.print("\nEnter integer to evaluate: ");

                // Take next input in as a String
                String input = scnr.next();

                // Parse input into an integer
                integerToEvaluate = Integer.parseInt(input);

                // Set flag = true to break out of while loop
                flag = true;
                
            }

            // If the user enters an element that is not an integer, catch exception and start over
            catch (Exception exception) {

                // print message prompting user to enter correct values
                System.out.println("\nInput must be an integer.");
            }
        }

        // Method returns the error-checked integer to evaluate
        return integerToEvaluate;
    }


    /***********************************************************************************/
    /*  This method checks the integerToEvaluate against the inputArray and prints the */
    /*  number of integers in the inputArray above, below, and exactly the same as     */
    /*  the integerToEvaluate.                                                         */
    /***********************************************************************************/
    public static void checkIntegersInArray(int[] inputArray, int integerToEvaluate) {

        // Declare and initialize all count variables
        int aboveCount = 0;
        int belowCount = 0;
        int exactCount = 0;

        // Traverse inputArray
        for (int i = 0; i < inputArray.length; i++) {

            // Increase aboveCount if integerToEvaluate is below current inputArray integer
            if (integerToEvaluate < inputArray[i]) {
                aboveCount++;
            }

            // Increase belowCount if integerToEvaluate is above current inputArray integer
            else if (integerToEvaluate > inputArray[i]) {
                belowCount++;
            }

            // Increase exactCount if integerToEvaluate is the same as current inputArray integer
            else {
                exactCount++;
            }
        }

        // Set results = to prompt and count for each variable
        String results = "Above: " + aboveCount + ", Below: " + belowCount + ", Exact: " + exactCount;

        // Print results
        System.out.println("\n" + results);
    }


    /*******************************************************************************************/
    /* This main method simply calls and runs the three previously created methods as follows: */
    /* getInputArray(), getEvaluationInteger, and checkInteger()                               */
    /*******************************************************************************************/
    public static void main(String[] args) {

        // call getInputArray() method and set output to arr
        int[] arr = getInputArray();

        // call getEvaluationInteger and set output to integer
        int integer = getEvaluationInteger();

        // Call checkInteger method with arr and integer as inputs to print results
        checkIntegersInArray(arr, integer);

   }
   
}