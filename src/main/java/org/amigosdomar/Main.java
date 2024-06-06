package org.amigosdomar;

import org.amigosdomar.helper.Helper;
import org.amigosdomar.monitoramento.Tanque;

public class Main {
    public static void main(String[] args) {

        Helper helper = new Helper();
        Tanque tanqueNorte = new Tanque("Tanque Norte", 200000.0);
        Tanque tanqueSul = new Tanque("Tanque Sul", 100000.);

        boolean continuar = true;
        while(continuar){
            helper.imprimeLogo();
            System.out.println();
            System.out.println("** Escolha uma das opções: **");
            helper.imprimeOpcao("1 - Tanque Norte");
            helper.imprimeOpcao("2 - Tanque Sul");
            helper.imprimeOpcao("9 - Encerrar o programa");
            System.out.print("opção: ");
            int escolha = helper.opcao();

            /*****************************************************************
             * Escolha do tanque - Tanque Norte ou Sul
             * **************************************************************/
            switch (escolha){
                case 1:
                    tanqueNorte.menu();
                    break;
                case 2:
                    tanqueSul.menu();
                    break;
                case 9:
                    System.out.println();
                    System.out.println();
                    System.out.println("Saindo...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Escolha uma opção válida!"); 
                    break;   
            }
        }
    }
}
