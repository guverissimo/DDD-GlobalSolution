package org.amigosdomar.sensores;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class Sensor {
    private ArrayList<Double> historico = new ArrayList<>();
    private Double valorMaximo;
    private Double valorMinimo;
    private Double valorMaxSim;
    private Double valorAtual;

    public Double getValorAtual() {
        return valorAtual;
    }

    public ArrayList<Double> getHistorico() {
        return historico;
    }

    public Double getValorMaximo(){
        return this.valorMaximo;
    }

    public Double getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMaximo(Double valorMaximo) {
        this.valorMaximo = valorMaximo;
    }

    public void setValorMinimo(Double valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public void setValorMaxSim(Double valorMaxSim) {
        this.valorMaxSim = valorMaxSim;
    }

    public void setValorAtual(Double valorAtual) {
        this.valorAtual = valorAtual;
    }

    public double calcularMedia() {
        double media;
        double soma = 0;

        for (double numero : historico) {
            soma += numero;
        }

        media = soma / historico.size();

        System.out.println("Média: " + media);
        return media;
    }

    public Double adicionarHistorico(Double valor){
        historico.add(valor);
        setValorAtual(valor);
        imprimeHistorico();
        return valor;
    }

    public void generateHistorico(){
        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            Double numSim = random.nextDouble(valorMaxSim);
            this.valorAtual = numSim;
            adicionarHistorico(numSim);
        }
    }

    public void imprimeHistorico(){

        LocalTime horaAtual = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm ");

        System.out.println("|      Horário     | Temperatura ");
        System.out.println("08:20:46.733815048 | 28");
        for(int i = 0; i < historico.size(); i++){
            System.out.println(horaAtual +" | " + (int) Math.round(historico.get(i)) + " C");

            horaAtual = horaAtual.minusHours(1);
        }
    }
}
