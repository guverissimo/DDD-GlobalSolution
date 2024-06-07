package org.amigosdomar.helper;

import java.util.Scanner;

public class Helper {
    Scanner scanner = new Scanner(System.in);
    public int opcaoInt() {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("\u001B[31mEntrada inválida. Por favor, digite um número inteiro: \u001B[0m");
        }
        int escolha = scanner.nextInt();
        return escolha;
    }
    public double opcaoDouble() {
        while (!scanner.hasNextDouble()) {
            scanner.next();
            System.out.print("\u001B[31mEntrada inválida. Por favor, digite um número double. EX: 8,1: \u001B[0m");
        }
        String entrada = scanner.next();
        entrada = entrada.replace(",", ",");
        double escolha = Double.parseDouble(entrada);
        return escolha;
    }



    public void imprimeLogo(){
        System.out.println("\u001B[36m***********************************\u001B[0m");
        System.out.println("\u001B[36m*          Amigos do Mar          *\u001B[0m");
        System.out.println("\u001B[36m***********************************\u001B[0m");
    }

    public void imprimeTitulo(String titulo){
        System.out.println();
        System.out.println();
        System.out.println("\u001B[36m********** " + titulo + " **********\u001B[0m");
    }

    public void imprimeSubtitulo(String texto){
        System.out.println();
        System.out.println("\u001B[36m** " + texto + " **\u001B[0m");
    }

    public void imprimeOpcao(String opcao){
        System.out.println("\u001B[34m " + opcao + " \u001B[0m");
    }
}


