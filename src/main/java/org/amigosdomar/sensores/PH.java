package org.amigosdomar.sensores;

import org.amigosdomar.helper.Helper;

public class PH extends Sensor {

    public PH() {
        setValorMinimo(7.5);
        setValorMaximo(8.3);
        setValorMaxSim(10.);
    }

    Helper helper = new Helper();

    public void monitorar() {
        if (getValorAtual() >= getValorMaximo() || calcularMedia() >= getValorMaximo()){
            System.out.println();
            System.out.println("A temperatura atingiu a sua máxima ");
            System.out.println("Diminuindo a temperatura do tanque");
            System.out.println();
        }

        if (getValorAtual() <= getValorMaximo() || calcularMedia() <= getValorMaximo()){
            System.out.println();
            System.out.println("A temperatura esta normal");
            System.out.println();
        }

        if (getValorAtual() <= getValorMinimo() || calcularMedia() <= getValorMinimo()){
            System.out.println();
            System.out.println("A temperatura esta muito abaixo do normal");
            System.out.println("Aumentando a temperatura do tanque");
        }

    }

    public void menu() {
        boolean continuar = true;

        while (continuar) {
            helper.imprimeTitulo("PH");

            helper.imprimeSubtitulo("Escolha uma das opções");
            helper.imprimeOpcao("1 - Monitorar");
            helper.imprimeOpcao("2 - Histórico ");
            helper.imprimeOpcao("3 - Adicionar PH manual");
            helper.imprimeOpcao("4 - Alterar Valor Maximo de segurança");
            helper.imprimeOpcao("5 - Alterar Valor Minimo de segurança");
            helper.imprimeOpcao("9 - Voltar");
            
            int op = helper.opcao();

            switch (op) {
                case 1:
                    
                    break;
                default:
                    System.out.println("Escolha uma opção válida!");
                    break; 
            }
        }
    }
}
