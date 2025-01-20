package dev.omuzalevska.cuenta_bancaria;

public class Cuenta {
    protected float saldo;
    protected int numConsignaciones;
    protected int numRetiros;
    protected float tasaAnual;
    protected float comisionMensual;

    public Cuenta(float saldoInicial, float tasaAnual) {
        this.saldo = saldoInicial;
        this.tasaAnual = tasaAnual;
        this.numConsignaciones = 0;
        this.numRetiros = 0;
        this.comisionMensual = 0;
    }

    public void consignar(float cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            numConsignaciones++;
        }
    }

    public boolean retirar(float cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            numRetiros++;
            return true;
        }
        return false;
    }

    public void calcularInteres() {
        float interesMensual = saldo * (tasaAnual / 12 / 100);
        System.out.println("Interés mensual: " + interesMensual);
        
        saldo += Math.round(interesMensual * 100.0) / 100.0; // Округлення до двох 
        System.out.println("saldo: " + saldo);

    }

    public void extractoMensual() {
        saldo -= comisionMensual;
        calcularInteres();
        comisionMensual = 0;
    }

    public String imprimir() {
        return "** Saldo: " + saldo + ", Consignaciones: " + numConsignaciones + 
               ", Retiros: " + numRetiros + ", Comisión Mensual: " + comisionMensual;
    }
}
