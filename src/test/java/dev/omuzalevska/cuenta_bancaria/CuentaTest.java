package dev.omuzalevska.cuenta_bancaria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    @Test
    void testConsignar() {
        Cuenta cuenta = new Cuenta(5000, 5);
        cuenta.consignar(2000);
        assertEquals(7000, cuenta.saldo, 0.01);
        assertEquals(1, cuenta.numConsignaciones);
    }

    @Test
    void testRetirar() {
        Cuenta cuenta = new Cuenta(5000, 5);
        boolean resultado = cuenta.retirar(2000);
        assertTrue(resultado);
        assertEquals(3000, cuenta.saldo, 0.01);
        assertEquals(1, cuenta.numRetiros);
    }

    @Test
    void testRetirarSaldoInsuficiente() {
        Cuenta cuenta = new Cuenta(5000, 5);
        boolean resultado = cuenta.retirar(6000);
        assertFalse(resultado);
        assertEquals(5000, cuenta.saldo, 0.01);
    }

    @Test
    void testCalcularInteres() {
        Cuenta cuenta = new Cuenta(12000, 6);
        cuenta.calcularInteres();
        assertEquals(12060, cuenta.saldo, 0.01);
    }

    @Test
    void testExtractoMensual() {
        Cuenta cuenta = new Cuenta(12000, 6);
        cuenta.comisionMensual = 1000;
        cuenta.extractoMensual();
        System.out.println("saldo: " + cuenta.saldo);
        assertEquals(11055, cuenta.saldo, 0.01); // +похибкa 0.01
    }
}

