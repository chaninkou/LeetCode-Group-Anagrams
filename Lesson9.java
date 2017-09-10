package lesson9;

import java.util.Scanner;

public class Lesson9 {
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("What is your favorite movie? ");
		String movieName = input.nextLine();
		System.out.println("Wow, " + movieName + " is my favorit movie too.");
	}
}
