package dev.omuzalevska.cuenta_bancaria;

class CuentaAhorros extends Cuenta {
    private boolean activa;

    public CuentaAhorros(float saldoInicial, float tasaAnual) {
        super(saldoInicial, tasaAnual);
        this.activa = saldoInicial >= 10000;
    }

    @Override
    public void consignar(float cantidad) {
        if (activa) {
            super.consignar(cantidad);
            actualizarEstado();
        }
    }

    @Override
    public boolean retirar(float cantidad) {
        if (activa && super.retirar(cantidad)) {
            actualizarEstado();
            return true;
        }
        return false;
    }

    @Override
    public void extractoMensual() {
        if (numRetiros > 4) {
            comisionMensual += (numRetiros - 4) * 1000;
        }
        super.extractoMensual();
        actualizarEstado();
    }

    private void actualizarEstado() {
        activa = saldo >= 10000;
    }

    @Override
    public String imprimir() {
        return super.imprimir() + ", Estado: " + (activa ? "Activa" : "Inactiva");
    }
}