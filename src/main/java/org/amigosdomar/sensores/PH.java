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
        System.out.println();
        System.out.println("PH: " + getValorAtual());
        calcularMedia();
        System.out.println("PH Maxima definida: " + getValorMaximo());
        System.out.println("PH Minima definida: " + getValorMinimo());
        System.out.println();
        if (getValorAtual() >= getValorMaximo()){
            System.out.println();
            System.out.println("O nível de PH atingiu a sua máxima ");
            System.out.println("Diminuindo  PH da água");
            setValorAtual(getValorMaximo()/getValorMinimo());
            System.out.println();
        }

        if (getValorAtual() <= getValorMaximo() && getValorAtual() >= getValorMinimo()){
            System.out.println();
            System.out.println("O PH esta normalizado");
            System.out.println();
        }

        if (getValorAtual() <= getValorMinimo()){
            System.out.println();
            System.out.println("O nível de PH atingiu a minima");
            setValorAtual(getValorMaximo()/getValorMinimo());
            System.out.println("Aumentando o PH da água");
            setValorAtual(getValorMaximo()/getValorMinimo());
        }

    }

    public void menu() {
        boolean continuar = true;

        while (continuar) {
            helper.imprimeTitulo("PH");

            helper.imprimeSubtitulo("Escolha uma das opções");
            helper.imprimeOpcao("1 - Monitorar");
            helper.imprimeOpcao("2 - Adicionar PH manual");
            helper.imprimeOpcao("3 - Alterar Valor Maximo de segurança");
            helper.imprimeOpcao("4 - Alterar Valor Minimo de segurança");
            helper.imprimeOpcao("5 - Calcular o valor médio: ");
            helper.imprimeOpcao("6 - Histórico ");
            helper.imprimeOpcao("9 - Voltar");
            
            int op = helper.opcaoInt();

            switch (op) {
                case 1:
                    monitorar();
                    break;
                case 2:
                    System.out.println("Nível de PH atual: " + getValorAtual());
                    System.out.print("Digite o PH: ");
                    Double temp = helper.opcaoDouble();
                    super.adicionarHistorico(temp);
                    System.out.println("Processado com sucesso!");
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Valor Maximo atual: " + getValorMaximo());
                    System.out.print("Digite o novo valor maximo: ");
                    double valorMax = helper.opcaoDouble();
                    if (valorMax <= getValorMaximo()) {
                        System.out.println("O valor maximo nao pode ser menor que o valor minimo: " + getValorMinimo());
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

                    if (valorMin <= getValorMinimo()) {
                        System.out.println("O valor maximo nao pode ser maior que o valor máximo: " + getValorMaximo());
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
