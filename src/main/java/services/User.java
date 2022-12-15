package services;

import java.util.Scanner;

public class User {

	public static  void showTable(String [][] table){

		for (int i = 0; i < 3; i++) {

			for (int j = 0; j < 3; j++) {

				System.out.print(table[i][j]);
			}
			System.out.println();
		}

	}

	public static boolean checkIsEmpty(String [][] table, int i, int j){

		return (table[i][j]!="x" && table[i][j]!="0");
	}

	public static  void menuWork(String [][] table, String player, int playerNumber){

		Scanner scanner=new Scanner(System.in);

		showTable(table);
		System.out.println();
		System.out.println(player+" navbatingiz: ");
		while(true) {
			int row, column;

			System.out.print("Qator: ");
			row = scanner.nextInt();

			System.out.print("Ustun: ");
			column =scanner.nextInt();

			if(checkIsEmpty(table, row, column)) {

				table[row][column] =(playerNumber == 1) ? "[x]" : "[0]";
				break;
			}

			else {
				System.out.println("Bu katak bo'sh emas, qaytadan kiritiing!");
			}
		}
	}

	public static boolean CheckDraw(String[][] table) {
		byte exit = 0;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(table[i][j] == "[x]" || table[i][j] == "[0]") {
					exit++;
				}

				if(exit == 9) {
					return true;
				}
			}

		}

		return false;
	}



	public static boolean CheckWin(String[][] table, String belgi) {
		byte winCondition1_1 = 0, winCondition1_2 = 0, winCondition1_3 = 0, winCondition1_4 = 0;

		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(table[i][j] == belgi)
				winCondition1_1++;
				if(table[j] [i] == belgi)
				winCondition1_2++;
				if(table[i][j] == belgi && i == j)
				winCondition1_3++;
				if(table[i][j] == belgi && i + j == 2)
				winCondition1_4++;
				if(winCondition1_1 == 3 || winCondition1_2 == 3 || winCondition1_3 == 3 || winCondition1_4 == 3)
					return true;
			}

			winCondition1_1 = 0;
			winCondition1_2 = 0;
		}

		return false;
	}





}
