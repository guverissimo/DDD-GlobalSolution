package org.amigosdomar.sensores;

import org.amigosdomar.helper.Helper;

import javax.sound.midi.Soundbank;

public class Salinidade extends Sensor{
    private Double condutividade;

    Helper helper = new Helper();
    public Double calcularSalinidade(Double condutividade){

        System.out.println("S  = Salinidade em partes por mil (ppt)");
        System.out.println("Cl = Condutividade (mS/cm)");

        System.out.println("Fórmula: ");
        System.out.println("S = 0.008 * Cl + 0.03");
        double calc = 0.008 * condutividade + 0.03;
        calc = calc*0.4665;

        System.out.println("A salinidade da água é de aproximadamente: " + calc + " partes por mil (ppt)");
        return calc;
    }

    public void menu() {
        boolean continuar = true;

        while (continuar) {
            helper.imprimeSubtitulo("** Salinidade **");
            helper.imprimeOpcao("1 - Calcular Salinidade");
            helper.imprimeOpcao("9 - Voltar");

            System.out.print("Opção: ");
            int op = helper.opcaoInt();

            switch (op) {
                case 1:
                    System.out.print("Digite a condutividade: ");
                    Double condutividade = helper.opcaoDouble();

                    calcularSalinidade(condutividade);
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
