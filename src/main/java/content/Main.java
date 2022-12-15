package content;

import services.User;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner=new Scanner(System.in);

		Random random = new Random();
		int choosePlayer = random.nextInt();


		boolean go_on = true;
		do
		{
			String  [][] table ={{"[ ]", "[ ]", "[ ]"}, {"[ ]", "[ ]", "[ ]"}, {"[ ]", "[ ]", "[ ]"},};

			go_on = false;
			String player1, player2, first, second;

			System.out.print("1-o'yinchi ismingizni kiriting: ");
			player1 = scanner.nextLine();

			System.out.print("2-o'yinchi ismingizni kiriting: ");
			player2 = scanner.nextLine();

			if(choosePlayer % 2 == 1) {
				first = player1;
				second = player2;
			}

			else {
				first = player2;
				second = player1;
			}

			while(true) {
				User.menuWork(table, first, 1);

				if(User.CheckWin(table , "[x]")) {
					User.showTable(table);
					System.out.println(player1+" yutdi");
					break;
				}

				if(User.CheckDraw(table)) {
					User.showTable(table);
					System.out.println("THE END\nDurang");
					break;
				}

				User.menuWork(table, second, 2);

				if(User.CheckWin(table , "[0]")) {
					User.showTable(table);
					System.out.println(player2+" yutdi");
					break;
				}

				if(User.CheckDraw(table)) {
					User.showTable(table);
					System.out.println("THE END\nDurang");
					break;
				}
			}
		}while(go_on);
	}
}
