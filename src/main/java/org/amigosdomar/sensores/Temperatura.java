package org.amigosdomar.sensores;

import org.amigosdomar.helper.Helper;

import java.sql.SQLOutput;
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
        System.out.println("Temperatura: " + getValorAtual());
        calcularMedia();
        System.out.println("Temperatura Maxima definida: " + getValorMaximo());
        System.out.println("Temperatura Minima definida: " + getValorMinimo());

        if (getValorAtual() >= getValorMaximo()){
            System.out.println();
            System.out.println("A temperatura atingiu a sua máxima ");
            System.out.println("Diminuindo a temperatura do tanque");
            setValorAtual(getValorMaximo()/getValorMinimo());
            System.out.println();
            return;
        }

        if (getValorAtual() <= getValorMaximo() && getValorAtual() >= getValorMinimo()){
            System.out.println();
            System.out.println("A temperatura esta normal");
            System.out.println();
            return;
        }

        if (getValorAtual() <= getValorMinimo()){
            System.out.println();
            System.out.println("A temperatura esta muito abaixo do normal");
            setValorAtual(getValorMaximo()/getValorMinimo());
            System.out.println("Aumentando a temperatura do tanque");
            setValorAtual(getValorMaximo()/getValorMinimo());
        }

    }

    public void menu() {

        boolean continuar = true;
        while (continuar) {
            helper.imprimeSubtitulo("** Temperatura **");
            helper.imprimeOpcao("1 - Monitorar");
            helper.imprimeOpcao("2 - Adicionar Temperatura manual");
            helper.imprimeOpcao("3 - Alterar Valor Maximo de segurança");
            helper.imprimeOpcao("4 - Alterar Valor Minimo de segurança");
            helper.imprimeOpcao("5 - Calcular o valor médio: ");
            helper.imprimeOpcao("6 - Histórico ");
            helper.imprimeOpcao("9 - Voltar");

            System.out.print("Opção: ");
            int op = helper.opcaoInt();

            switch (op) {
                case 1:
                    monitorar();
                    break;
                case 2:
                    System.out.println("Temperatura atual: " + getTemperaturaAtual());
                    System.out.print("Digite a temperatura: ");
                    Double temp = helper.opcaoDouble();
                    super.adicionarHistorico(temp);
                    System.out.println("Processado com sucesso!");
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Valor Maximo atual: " + getValorMaximo());
                    System.out.print("Digite o novo valor maximo: ");
                    double valorMax = helper.opcaoDouble();
                    if (valorMax <= getValorMinimo()) {
                        System.out.println("O valor maximo nao pode ser menor que o valor minimo: "+ getValorMinimo());
                        return;
                    }

                    setValorMaximo(valorMax);
                    System.out.println("Valor atualizado");
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Valor Minimo atual: " + getValorMinimo());
                    System.out.print("Digite o novo valor minimo: ");
                    double valorMin = helper.opcaoDouble();

                    if (valorMin >= getValorMaximo()) {
                        System.out.println("O valor minimo nao pode ser maior que o valor máximo: "+ getValorMaximo());
                        return;
                    }

                    setValorMaximo(valorMin);
                    System.out.println("Valor atualizado");
                    System.out.println();
                    break;
                case 5:
                    calcularMedia();
                    break;
                case 6:
                    imprimeHistorico();
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