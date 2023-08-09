/* 
    The program is to determine whether the triangle is Equilateral, Isosceles, Scalene, or Right angled.
*/

import java.util.Scanner;

public class TriangleChecker_21000210A {
    public static void main(String[] arg) {

        //Prepare for integers input for the three sides of a triangle
        Scanner input = new Scanner(System.in);

        int sideA = 0, sideB = 0, sideC = 0;
        String lengthInput = null; //Save the initial input from user 

        //Instruction to users
        System.out.println("Please input the length of three sides of the triangle.");

        //Check for invalid input
        try {
        	//Assign value to side A, B, C 
            System.out.print("The first side of the triangle: ");
            lengthInput = input.nextLine();
            sideA = Integer.parseInt(lengthInput);
            
            System.out.print("The second side of the triangle: ");
            lengthInput = input.nextLine();
            sideB = Integer.parseInt(lengthInput);
            
            System.out.print("The last side of the triangle: ");
            lengthInput = input.nextLine();
            sideC = Integer.parseInt(lengthInput);
            
            
            //Prevent Logical bug with negative numbers
            if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
                System.out.println("\nPlease input a number greater than 0.");
                System.exit(0);
            }
            
            //Prevent Logical bug with Triangle Inequality Theorem 
            else if (sideA + sideB <= sideC || sideA + sideC <= sideB || sideB + sideC <= sideA) {
            	if(sideA + sideB <= 0 || sideA + sideC <= 0 || sideC + sideB <= 0)
            		System.out.println("\nThe numbers you inputted are too larger to handle. Please input smaller numbers.");
            	else 
            		System.out.println("\nPlease enter sides that the sum of two sides is larger than the third.");
                System.exit(0);
            }
        }
        //Prevent Runtime bug
        catch(java.lang.NumberFormatException e) {
        	//Press enter without entering anything
        	if(lengthInput.equals("")  == true)
        		System.out.println("\nYou enter nothing. Please enter an integer.");
        	//Enter a space
        	else if(lengthInput.contains(" ") == true) 
                System.out.println("\nPlease enter an integer without any space.");
        	//Enter a alphabets e.g. abcd, or symbols like #@$
            else if(lengthInput.matches("[+-]?\\d*(\\.\\d+)?") == false || lengthInput.matches("[+-]")) 
                System.out.println("\nPlease enter an integer without any alphabets or symbols.");
        	//Enter a floating-point number e.g. 5.6
            else if(lengthInput.contains(".") == true)
            	System.out.println("\nPlease enter an integer without any floating-point.");
        	//Enter a large number
            else 
            	System.out.print("\nPlease enter an integer less than "+Integer.MAX_VALUE+".");
            
            System.exit(0);
        }
        catch (Exception e) {
        	System.out.println("\nPlease contact the author for\n" + e);
        	System.exit(0);
        }

        //Determine the type of triangle
        System.out.println("");

        // Equilateral triangle
        if (sideA == sideB && sideB == sideC)
            System.out.println("It is a Equilateral triangle.");

        //Isosceles triangle 
        else if (sideA == sideB || sideB == sideC || sideA == sideC)
            System.out.println("It is a Isosceles triangle.");

        //Scalene triangle
        else System.out.println("It is a Scalene triangle.");

        // Right angled triangle determining with Pythagorean theorem
        if (sideA * sideA == sideB * sideB + sideC * sideC ||
            sideB * sideB == sideA * sideA + sideC * sideC ||
            sideC * sideC == sideB * sideB + sideA * sideA)
            System.out.println("It is a Right angled triangle.");
    }
}
