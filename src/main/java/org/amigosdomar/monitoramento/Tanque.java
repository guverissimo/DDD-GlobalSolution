package org.amigosdomar.monitoramento;

import org.amigosdomar.helper.Helper;
import org.amigosdomar.sensores.Temperatura;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Tanque {
    private Temperatura temperatura = new Temperatura();
    private String nome;
    private double volume;

    Scanner scanner = new Scanner(System.in);
    Helper helper = new Helper();

    public Tanque(String nome, Double volume){
        temperatura.generateHistorico();
        temperatura.monitorar();
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
            System.out.println("** Escolha uma das opções **");
            System.out.println("1 - Temperatura");
            System.out.println("2 - PH");
            System.out.println("3 - Voltar");
            int opcao = scanner.nextInt();
            switch (opcao){
                case 1:
                    temperatura.menu();
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println();
                    System.out.println("Voltando...");
                    System.out.println();
                    cont = false;
            }
        }


    }


}
