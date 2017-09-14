package com.apaza.app.moneyhelper;

/**
 * Created by Alumno on 11/09/2017.
 */

public class Transferencias {

    private double monto;
    private String tipocuenta;
    private int tipotransferencia;

    public Transferencias(double monto, String tipocuenta, int tipotransferencia) {
        this.monto = monto;
        this.tipocuenta = tipocuenta;
        this.tipotransferencia = tipotransferencia;
    }

    public Transferencias(double monto, String tipocuenta) {
        this.monto = monto;
        this.tipocuenta = tipocuenta;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getTipocuenta() {
        return tipocuenta;
    }

    public void setTipocuenta(String tipocuenta) {
        this.tipocuenta = tipocuenta;
    }

    public int getTipotransferencia() {
        return tipotransferencia;
    }

    public void setTipotransferencia(int tipotransferencia) {
        this.tipotransferencia = tipotransferencia;
    }

    @Override
    public String toString() {
        return "Transferencias{" +
                "monto=" + monto +
                ", tipocuenta='" + tipocuenta + '\'' +
                ", tipotransferencia='" + tipotransferencia + '\'' +
                '}';
    }
}
