package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double saldo = 0.0;

        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("----- Sistema da Padaria -----");
            System.out.println("1 - Consultar Saldo");
            System.out.println("2 - Realizar Depósito");
            System.out.println("3 - Realizar Saque");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");

            if (!sc.hasNextInt()) {
                System.out.println("Opção Inválida");
                continue;
            }

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.printf("Saldo atual: R$ %.2f%n", saldo);
                    break;

                case 2:
                    System.out.print("Informe o valor do depósito: ");
                    if (!sc.hasNextDouble()) {
                        System.out.println("Valor inválido");
                        sc.next();
                        break;
                    }
                    double deposito = sc.nextDouble();
                    if (deposito > 0) {
                        saldo += deposito;
                        System.out.println("Depósito realizado com sucesso.");
                    } else {
                        System.out.println("Valor inválido");
                    }
                    break;

                case 3:
                    System.out.print("Informe o valor do saque: ");
                    if (!sc.hasNextDouble()) {
                        System.out.println("Valor inválido");
                        sc.next();
                        break;
                    }
                    double saque = sc.nextDouble();
                    if (saque <= saldo) {
                        if (saque > 0) {
                            saldo -= saque;
                            System.out.println("Saque realizado com sucesso.");
                        } else {
                            System.out.println("Valor inválido");
                        }
                    } else {
                        System.out.println("Saldo insuficiente");
                    }
                    break;

                case 4:
                    System.out.println("Encerrando o sistema. Até logo!");
                    break;

                default:
                    System.out.println("Opção Inválida");
            }

            if (sc.hasNextLine()) sc.nextLine();

        } while (opcao != 4);

        sc.close();
    }
}