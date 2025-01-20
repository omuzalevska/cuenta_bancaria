package dev.omuzalevska.cuenta_bancaria;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CuentaCorrienteTest {

    @Test
    void testRetirarConSobregiro() {
        CuentaCorriente cuenta = new CuentaCorriente(5000, 5);
        boolean resultado = cuenta.retirar(7000);
        assertTrue(resultado);
        assertEquals(0, cuenta.saldo, 0.01);
        assertEquals(2000, cuenta.sobregiro, 0.01);
    }

    @Test
    void testConsignarConSobregiro() {
        CuentaCorriente cuenta = new CuentaCorriente(5000, 5);
        cuenta.retirar(7000); 
        cuenta.consignar(3000); 
        assertEquals(0, cuenta.sobregiro, 0.01);
        assertEquals(1000, cuenta.saldo, 0.01); // залишок після погашення собрегиро
    }

    @Test
    void testExtractoMensual() {
        CuentaCorriente cuenta = new CuentaCorriente(5000, 5);
        cuenta.retirar(7000);
        cuenta.consignar(2000);
        cuenta.extractoMensual();
        assertEquals(0.0, cuenta.sobregiro, 0.01); 
    }
}