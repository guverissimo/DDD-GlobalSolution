package org.amigosdomar.helper;

import java.util.Scanner;

public class Helper {
    Scanner scanner = new Scanner(System.in);
    public int opcao() {
        while (!scanner.hasNextInt()) {
            // Se não for um número inteiro, limpa o buffer do scanner
            scanner.next();
            // Solicita novamente ao usuário para inserir um número inteiro
            System.out.print("\u001B[31mEntrada inválida. Por favor, digite um número inteiro: \u001B[0m");
        }
        int escolha = scanner.nextInt();
        return escolha;
    }

    public void imprimeLogo(){
        System.out.println();
        System.out.println();
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

//    public void imprimeErro()
}
