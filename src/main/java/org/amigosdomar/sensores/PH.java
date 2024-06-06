package org.amigosdomar.sensores;

public class PH extends Sensor {

    public PH() {
        setValorMinimo(7.5);
        setValorMaximo(8.3);
        setValorMaxSim(10.);
    }

    @Override
    public Double getValorAtual() {
        return super.getValorAtual();
    }
}
