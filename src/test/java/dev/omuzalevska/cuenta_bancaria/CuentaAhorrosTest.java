package dev.omuzalevska.cuenta_bancaria;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CuentaAhorrosTest {

    @Test
    void testCuentaActiva() {
        CuentaAhorros cuenta = new CuentaAhorros(15000, 5);
        assertTrue(cuenta.imprimir().contains("Activa"));
    }

    @Test
    void testCuentaInactiva() {
        CuentaAhorros cuenta = new CuentaAhorros(5000, 5);
        assertFalse(cuenta.imprimir().contains("Activa"));
    }

    @Test
    void testConsignarEnCuentaActiva() {
        CuentaAhorros cuenta = new CuentaAhorros(15000, 5);
        cuenta.consignar(5000);
        assertEquals(20000, cuenta.saldo, 0.01);
        assertEquals(1, cuenta.numConsignaciones);
    }

    @Test
    void testRetirarEnCuentaActiva() {
        CuentaAhorros cuenta = new CuentaAhorros(15000, 5);
        boolean resultado = cuenta.retirar(1000);
        assertTrue(resultado);
        assertEquals(14000, cuenta.saldo, 0.01);
        assertEquals(1, cuenta.numRetiros);
    }

    // @Test
    // void testComisionPorRetiros() {
    //     CuentaAhorros cuenta = new CuentaAhorros(15000, 5);
    //     for (int i = 0; i < 6; i++) {
    //         cuenta.retirar(1000);
    //     }
    //     cuenta.extractoMensual();
    //     assertEquals(8500, cuenta.saldo, 0.01); // 6 зняттів: 4 безкоштовно, 2 по 1000 комісії
    // }
}