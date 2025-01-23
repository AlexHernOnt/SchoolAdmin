package org.example;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

    public class Main {
        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            String userInput = "";
            HashMap<String, List<Integer>> students = new HashMap<>();

            do {
                System.out.println("Welcome to School Admin: \n -1: Add student\n -2: Record grade\n -3: View student's data\n -4: Get best achievers");
                try {
                    userInput = sc.nextLine().toLowerCase();

                    switch (userInput) {
                        case "1":
                        {
                            System.out.print("Enter the student name:");

                            try {
                                userInput = sc.nextLine().toLowerCase();

                                if (students.containsKey(userInput))
                                    throw new Exception("Name already used\n");

                                students.put(userInput, new ArrayList<>());
                                System.out.println("Perfect, student saved!\n");

                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        }
                        case "2":
                        {
                            System.out.print("Enter student name:");

                            try {
                                userInput = sc.nextLine().toLowerCase();

                                if (!students.containsKey(userInput))
                                    throw new Exception("Not registered!\n");
                                try {

                                    System.out.println("Enter the grade from 0 to 100:");

                                    int userInputInt = sc.nextInt();

                                    if (userInputInt > 100 || userInputInt < 0)
                                        throw new Exception("You inputed a wrong grade!\n");

                                    students.get(userInput).add(userInputInt);
                                    System.out.println("Grade Saved!");

                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }

                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        }
                        case "3":
                        {
                            System.out.println("Enter the student name:");

                            try {
                                userInput = sc.nextLine().toLowerCase();

                                if (!students.containsKey(userInput))
                                    throw new Exception("Not registered!\n");
                                if (!students.get(userInput).isEmpty())
                                    System.out.println(userInput + "'s grades are: " + students.get(userInput) +" with an average of " + calAverage(students.get(userInput)) + "\n");
                                else
                                    System.out.println(userInput + "'s hasn't any grades yet!\n");
                            } catch (Exception e) {
                                System.out.println("Incorrect Grade");
                            }
                            break;
                        }
                        case "4":
                        {
                            System.out.println("Input a limit grade:");
                            try {
                                int userInputInt = sc.nextInt();

                                if (userInputInt )

                                System.out.println("The High performers are:");
                                for (int i = 0; i < students.size(); ++i)
                                    System.out.println(students.get(i));

                            } catch (Exception e) {
                                System.out.println("Incorrect Grade");
                            }
                            break;
                        }
                    }




            } catch (Exception e) {
                    System.out.println("Please input a number");
            }

            } while (!userInput.equals("exit"));


//
//        try  {
//            if (userName.length() > 5 || userName.length() < 3)
//                throw new Exception("Incorrect number of chars");
//            System.out.println("Username is: " + userName);  // Output user input
//        } catch (Exception e) {
//            System.out.println("Exception " + e.getMessage());
//        }

        }

        static int calAverage(List<Integer> list) {
            int sum = 0;

            for (int grade : list) {
                sum += grade;
            }
            return  (int) Math.round(sum / list.size());
        }
    }


//    FileReader fr;
//
//        try {
//        fr = new FileReader("file.txt"));
//    } catch (FileNotFoundException e) {
//        System.out.println(e);
//    }
//        System.out.println("Hello, World!");
//}


