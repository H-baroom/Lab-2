import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
/*
1.Write a program to find all of the longest word in a given dictionary.
Example:
{ "cat", "dog", "red", "is", "am" } Expected
Output:
"cat", "dog", "red"
 */
        String[] arr = {"cat", "dog", "red", "is", "am"};
        longestWord(arr);

/*
2. Write a program that displays the number of occurrences of an element in the array.
Original Array:
[1,1,1,3,3,5]
Sample Output:
3 occurs 2 times
1 occurs 3 times
9 occurs 0 times
 */

        int[] arr1 = {1,1,1,3,3,5};
        int num2 =0;
        do {
            System.out.println("please enter the number, zero for quit :");
            num2 = input.nextInt();
            if (num2 !=0){
                System.out.println(num2+" occurs "+occurs(arr1,num2)+" times");
            }
        }while(num2 !=0);


        /*
3- Write a program to find the k largest elements in a given array. Elements in the array can be in
any order.
Original Array:
[1, 4, 17, 7, 25, 3, 100]
Expected Output:
3 largest elements of the said array are:
100 25 17
 */
        int[] largest = {1, 4, 17, 7, 25, 3, 100};
        largest(largest);
       /*
4. Create a method to reverse an array of integers. Implement the method without
creating a new array.
Original Array:
[5,4,3,2,1]
Expected Output:
Reversed Array:
1 2 3 4 5
 */
        ArrayList<Integer> arr2 = new ArrayList();
        arr2.add(5); arr2.add(4); arr2.add(3); arr2.add(2); arr2.add(1);
        reversedArray(arr2);

/*
5. Write a menu driven Java program with following option:
1. Accept elements of an array
2. Display elements of an array
3. Search the element within array
4. Sort the array 5. To Stop the size of the array should be
entered by the user.
 */
        System.out.println("please enter the size of array : ");
        int size = input.nextInt();
        int[] arr5 = new int[size];
        int num=0;
        int c = 0;
        do {
            menu();
            num = input.nextInt();
            if(num == 1){
                System.out.println("please enter the number : ");
                int number = input.nextInt();
                arr5[c]=number;
                c++;
            } else if (num == 2) {
                System.out.println(Arrays.toString(arr5));
            } else if (num == 3) {
                System.out.println("please enter the number ypu want to find : ");
                int number = input.nextInt();
                for (int n:arr5){
                    if (n == number){
                        System.out.println("the number "+number+" is founded");
                        break;
                    } else if (n ==arr5[arr5.length-1] ) {
                        System.out.println("the number "+number+" is not founded");
                    }
                }
            } else if (num == 4) {
                sort(arr5);
            }else if(num != 5){
                System.out.println("please enter number between 1-5");
                continue;
            }
        }while(num != 5);

        /*
6. Create a method that generates a random number within a given range. Allow the user to
specify the range and call the method to display random numbers.
Hint: use Random class
Sample Output:
3
Enter the minimum value of the range: 10
Enter the maximum value of the range: 100
Enter the number of random numbers to generate: 5 Random
numbers within the specified range:
71 - 98 - 96 - 71 - 71
         */
        System.out.println("Enter the minimum value of the range: ");
        int min_rang = input.nextInt();
        System.out.println("Enter the maximum value of the range: ");
        int max_rang = input.nextInt();
        System.out.println("Enter the number of random numbers to generate: ");
        int random_numbers = input.nextInt();
        randomNumbers(min_rang,max_rang,random_numbers);

        /*
7. Write a program that checks the strength of a password. Create a method that evaluates a
password based on criteria like length, inclusion of special characters, and
uppercase/lowercase letters.
- We have three methods: checkLength, checkSpecialCharacters, and
checkUpperCaseLowerCase, each of which assigns a score based on specific criteria.
- The totalScore is calculated by adding the scores from these methods.
- Classify the password as strong (8 or more), moderately strong (5 or more), or weak
based on the totalScore. - The criteria for scoring:
• Length: 0-5 characters (0 points), 6-7 characters (2 points), 8 or more characters
(3 points).
• Special characters: Absence (0 points), Presence (2 points).
• Uppercase and lowercase letters: Absence of both (0 points), presence of both (3
points).
Example:
Enter a password: 3456 Expected Output:
Password is weak.
         */
        System.out.println();
        System.out.println("please Enter a password: ");
        input.nextLine();
        String password = input.nextLine();
        int total = checkLength(password) + checkSpecialCharacters(password)+ checkUpperCaseLowerCase(password);
        if(total >=8){
            System.out.println("Strong password ");
        } else if (total >=5) {
            System.out.println(" moderately strong password ");
        } else{
            System.out.println("weak password");
        }
        /*
8. Create a method that generates the Fibonacci sequence up to a specified number of terms.
Hint: The Fibonacci sequence is a mathematical sequence of numbers that starts with 0 and 1,
and each subsequent number in the sequence is the sum of the two preceding ones.
4
Example:
Enter the number of Fibonacci terms to generate: 10
Expected Output:
Fibonacci sequence with 10 terms:
0 1 1 2 3 5 8 13 21 34
         */
        System.out.println();
        System.out.println("Enter the number of Fibonacci terms to generate: ");
        int Fibonacci =input.nextInt();
        System.out.println("Fibonacci sequence with "+Fibonacci+" terms: ");
        Fibonacci(Fibonacci);
    }
    public static void Fibonacci(int n){
        int num1 =0;
        int num2 = 1;
        int num3 =0;
        System.out.print(num1 + "    "+num2);
        for (int i = 2; i < n; i++) {
            num3 = num1 +num2;
            System.out.print("    " +num3);
            num1 = num2;
            num2 = num3;
        }
    }

    public static int checkLength(String password){
        if (password.length()>=0 && password.length()<=5){
            return 0;
        } else if (password.length()>=6 && password.length()<=7) {
            return 2;
        }else {
            return 3;
        }
    }

    public static int checkSpecialCharacters(String password){
        for (int i = 0; i < password.length(); i++) {
            if(!(password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') ||
                    !(password.charAt(i) >= 'a' && password.charAt(i) <= 'z') ||
            !(password.charAt(i) >= '0' && password.charAt(i) <= '9')){
                return 2;
            }
        }
        return 0;
    }

    public static int checkUpperCaseLowerCase(String password){
        boolean uper = false;
        boolean lower = false;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z'){
                uper = true;
            }else if(password.charAt(i) >= 'a' && password.charAt(i) <= 'z'){
                lower = true;
            }
        }
        if (uper && lower){
          return 3;
        }
        return 0;
    }

    public static void randomNumbers(int min_rang, int max_rang, int random_numbers ){
        Random rand = new Random();
        System.out.println("numbers within the specified range: ");
        for (int i = 0; i < random_numbers; i++) {
            System.out.print(rand.nextInt(max_rang - min_rang +1)+min_rang+ " - ");
        }
    }

    public static void sort(int[] arr5){
        int y =0;
        for (int i = 0; i < arr5.length; i++) {
            for (int j = 0; j < arr5.length ; j++) {
                if (arr5[i] < arr5[j]){
                    y = arr5[i];
                    arr5[i] = arr5[j];
                    arr5[j]=y;
                }
            }
        }
        System.out.println("the array after the sort is : "+Arrays.toString(arr5));
    }



    public static void menu(){
        System.out.println("**************************************************");
        System.out.println("1. Accept elements of an array : ");
        System.out.println("2. Display elements of an array : ");
        System.out.println("3. Search the element within array : ");
        System.out.println("4. Sort the array : ");
        System.out.println("5. To Stop the size of the array : ");
        System.out.println("**************************************************");
    }

    public static void reversedArray(ArrayList<Integer> arr2){
        int swap =0;
        for (int i = 0; i < arr2.size()/2 + 1; i++) {
            if (arr2.size() % 2 ==0){
                swap = arr2.get(i);
                arr2.set(i,arr2.get(arr2.size()-i));
                arr2.set(arr2.size()-i,swap);
            }else if(i != arr2.size()/2 + 1 ){
                swap = arr2.get(i);
                arr2.set(i,arr2.get(arr2.size()-i -1));
                arr2.set(arr2.size()-i -1,swap);
            }
        }
        System.out.println(arr2);

    }

    public static void largest(int[] largest){
        int larg1=0; int larg2 =0; int larg3 =0;
        for (int n:largest){
            if (n > larg1 && larg1<=larg2 && larg1<=larg3 ){
                larg1 = n;
            } else if (n > larg2 && larg2<=larg1 && larg2<=larg3) {
                larg2 = n;
            } else if (n > larg3) {
                larg3 = n;
            }
        }
        System.out.println(larg1 +" "+larg2+" "+ larg3);
    }

    public static int occurs(int[] arr1,int occur){
        int count=0;
        for (int c:arr1){
            if(c == occur){
                count++;
            }
        }
        return count;
    }

    public static void longestWord(String[] arr){
        int long_length = 0;
        for (String s:arr){
            if (s.length() > long_length){
                long_length = s.length();
            }
        }
        System.out.print("the logest word is : ");
        for (String s:arr){
            if (s.length() == long_length){
                System.out.print(s + ", ");
            }
        }
        System.out.println();
    }
}