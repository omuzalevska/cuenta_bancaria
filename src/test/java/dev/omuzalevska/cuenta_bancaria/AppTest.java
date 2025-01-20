package dev.omuzalevska.cuenta_bancaria;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AppTest {

    @Test
    void testMain() {
      
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        App.main(new String[]{});

        String output = outContent.toString();

        assertTrue(output.contains("1 consignar: ** Saldo: 12000.0"));
        assertTrue(output.contains("2 consignar: ** Saldo: 15000.0"));
        assertTrue(output.contains("1 retirar: ** Saldo: 11000.0"));
        // assertTrue(output.contains("CuentaAhorros: ** Saldo: 10995.0")); 
        // assertTrue(output.contains("Cuenta Corriente: ** Saldo: 0.0")); 
    }
}
