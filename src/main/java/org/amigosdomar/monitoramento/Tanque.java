package org.amigosdomar.monitoramento;

import org.amigosdomar.helper.Helper;
import org.amigosdomar.sensores.PH;
import org.amigosdomar.sensores.Salinidade;
import org.amigosdomar.sensores.Temperatura;
import java.util.Scanner;

public class Tanque {
    private Temperatura temperatura = new Temperatura();
    private PH ph = new PH();
    private Salinidade salinidade = new Salinidade();
    private String nome;
    private double volume;

    Scanner scanner = new Scanner(System.in);
    Helper helper = new Helper();

    public Tanque(String nome, Double volume){
        temperatura.generateHistorico();
        ph.generateHistorico();
        setNome(nome);
        setVolume(volume);
    }

    public Double getTemperatura() {
        return temperatura.getTemperaturaAtual();
    }

    public void getHistorico() {
        temperatura.imprimeHistorico();
    }

    public void setTemperaturaAtual() {
        temperatura.getTemperaturaAtual();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public void menu() {
        System.out.println();
        helper.imprimeTitulo(this.nome);
        System.out.println("Temperatura Atual: " + getTemperatura().intValue() + " | PH: ");
        System.out.println();

        boolean cont = true;

        while (cont){
            /*****************************************************************
             * Escolher qual dado deseja manipular - Temperatura ou PH
             * **************************************************************/
            helper.imprimeOpcao("** Escolha uma das opções **");
            helper.imprimeOpcao("1 - Temperatura");
            helper.imprimeOpcao("2 - PH");
            helper.imprimeOpcao("3 - Salinidade");
            System.out.println("9 - Voltar");
            int opcao = scanner.nextInt();
            switch (opcao){
                case 1:
                    temperatura.menu();
                    break;
                case 2:
                    ph.menu();
                    break;
                case 3:
                    salinidade.menu();
                case 9:
                    System.out.println();
                    System.out.println("Voltando...");
                    System.out.println();
                    cont = false;
            }
        }


    }


}
