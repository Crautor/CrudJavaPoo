package application;

import java.util.Scanner;

public class CrudCnae extends Funcoes {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Escolha uma das opções abaixo");
		System.out.println("0 - findId\n" +
				"1 - findAll\n" +
				"2 - insert\n" +
				"3 - delete\n" +
				"4 - update\n" +
				"Digite o numero:");
		Integer escolha = sc.nextInt();

		switch (escolha){
			case 0:
				findIdCnae();
				break;
			case 1:
				findAllCnae();
				break;
			case 2:
				insertCnae();
				break;
			case 3:
				findAllCnae();
				deleteCnae();
				break;
			case 4:
				findAllCnae();
				updateCnae();
				break;
			default:
				System.out.println("escolha invalida");
		}
	}
}
