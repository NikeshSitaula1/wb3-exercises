package com.pluralsight;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {


        String[] quotes =
                {"You must be the change you wish to see in the world. -Mahatma Gandhi",
                        "Do one thing every day that scares you. -Eleanor Roosevelt",
                        "Well done is better than well said. -Benjamin Franklin",
                        "Be yourself; everyone else is already taken. -Oscar Wilde",
                        "The way to get started is to quit talking and begin doing. -Walt Disney",
                        "The greatest glory in living lies not in never falling, but in rising every time we fall. -Nelson Mandela",
                        "If you set your goals ridiculously high and it's a failure, you will fail above everyone else's success. -James Cameron",
                        "Do not go where the path may lead; go instead where there is no path and leave a trail. – Ralph Waldo Emerson",
                        "Be yourself; everyone else is already taken. – Oscar Wilde",
                        "Life itself is the most wonderful fairy tale. – Hans Christian Andersen"
                };

        System.out.println("Choose from 1 to 10");

        while (true){

            try{
                int id = scanner.nextInt();

                if(id < 1 | id > 10){
                    System.out.println("Choose a number from 1 to 10");

                }
                else {
                    System.out.println(quotes[id - 1]);
                    while(true){
                        System.out.println("------------------------------------------------------------");
                        System.out.print("Would you like to pick another book? [Y]es or [N]o: ");
                        String yesOrNo = scanner.next();
                        if (yesOrNo.equalsIgnoreCase("Y") ||
                                yesOrNo.equalsIgnoreCase("yes")){
                            System.out.println("Choose a number from 1 to 10");
                            scanner.next();
                            System.out.println(quotes[id - 1]);
                        }
                        else {
                            return;
                        }
                    }
                }

            } catch (Exception e) {
                System.out.println("Invalid, choose a number from 1 to 10");
                scanner.next();

            }

        }
    }
}