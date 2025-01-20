package dev.omuzalevska.cuenta_bancaria;

public class App {
    public static void main(String[] args) {
 
        CuentaAhorros cuentaAhorros = new CuentaAhorros(10000, 5);

        cuentaAhorros.consignar(2000);
        System.out.println("1 consignar: " + cuentaAhorros.imprimir());

        cuentaAhorros.consignar(3000);
        System.out.println("2 consignar: " + cuentaAhorros.imprimir());

          cuentaAhorros.retirar(4000);
        System.out.println("1 retirar: " + cuentaAhorros.imprimir());

        cuentaAhorros.retirar(2000);
        System.out.println("2 retirar: " + cuentaAhorros.imprimir());

        cuentaAhorros.extractoMensual();
        System.out.println("CuentaAhorros: " + cuentaAhorros.imprimir());
    

        
        CuentaCorriente cuentaCorriente = new CuentaCorriente(5000, 3);
        
        cuentaCorriente.retirar(7000);
        System.out.println("1 retirar: " + cuentaCorriente.imprimir());
        
        cuentaCorriente.consignar(3000);
        System.out.println("1 consignar: " + cuentaCorriente.imprimir());
                
        cuentaCorriente.extractoMensual();
        System.out.println("Cuenta Corriente: " + cuentaCorriente.imprimir());
    }
}
