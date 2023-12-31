package application;

import java.util.Scanner;

public class CrudFuncionario extends Funcoes {
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

        switch (escolha) {
            case 0:
                findIdFuncionario();
                break;
            case 1:
                findAllFuncionario();
                break;
            case 2:
                insertFuncionario();
                break;
            case 3:
                findAllFuncionario();
                deleteFuncionario();
                break;
            case 4:
                findAllFuncionario();
                updateFuncionario();
                break;
            default:
                System.out.println("escolha invalida");
        }
    }
}
