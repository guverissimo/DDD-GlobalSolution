package org.amigosdomar.sensores;

import org.amigosdomar.helper.Helper;

import java.util.Scanner;

public class Temperatura extends Sensor{
    Helper helper = new Helper();

    public Temperatura(){
        setValorMaximo(50.0);
        setValorMinimo(5.0);
        setValorMaxSim(30.0);
    }

    public double getTemperaturaAtual() {
        Double temp = getValorAtual();
        return temp;
    }

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
            System.out.println("** Temperatura **");
            System.out.println("1 - Monitorar");
            System.out.println("2 - Adicionar Temperatura manual");
            System.out.println("3 - Alterar Valor Maximo de segurança");
            System.out.println("4 - Alterar Valor Minimo de segurança");
            System.out.println("9 - Voltar");

            int op = helper.opcao();

            switch (op) {
                case 1:
                    monitorar();
                    break;
                case 2:
                    Scanner scanner = new Scanner(System.in);
                    Double temp = scanner.nextDouble();
                    super.adicionarHistorico(temp);
                    break;
                case 3:
                    int valorMax = helper.opcao();
                    setValorMaximo((double) valorMax);
                    System.out.println("Valor atualizado");
                    System.out.println();
                    break;
                case 4:
                    int valorMin = helper.opcao();
                    setValorMaximo((double) valorMin);
                    System.out.println("Valor atualizado");
                    System.out.println();
                    break;
                case 9:
                    System.out.println();
                    System.out.println("Voltando...");
                    System.out.println();
                default:
                    System.out.println("Escolha uma opção válida!");
                    break;                 
            }
        }

    }

}