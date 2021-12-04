import java.util.Scanner;
    public class CuentaBancaria {
        //ATRIBUTOS
        String nombreCliente;
        String dniCliente;
        Double saldo = 0.0;
        Double ultimoMovimiento = 0.0;
        String seleccion;
        Scanner input = new Scanner(System.in);

        //CONSTRUCTOR
        public CuentaBancaria(String nombreCliente, String dniCliente) {
            this.nombreCliente = nombreCliente;
            this.dniCliente = dniCliente;
        }

        public CuentaBancaria(String nombreCliente, String dniCliente, Double saldo) {
            this.nombreCliente = nombreCliente;
            this.dniCliente = dniCliente;
            this.saldo = saldo;
        }

        //METODOS

        public double depositar() {
            System.out.println("Ingrese el monto del depósito:");
            double dinero = input.nextDouble();
            if (dinero >= 0) {
                saldo += dinero;
                ultimoMovimiento = dinero;
            } else {
                System.out.println("La cantidad es incorrecta, vuelva a ingresar");
            }
            return saldo;
        }

        public double retirar() {
            System.out.println("Ingrese el monto del retiro:");
            double dinero = input.nextDouble();
            if (dinero >= 0) {
                if (dinero <= saldo) {
                    saldo -= dinero;
                    ultimoMovimiento = dinero;
                } else {
                    System.out.println("¡Saldo de cuenta insuficiente!");
                }
            } else {
                System.out.println("La cantidad es incorrecta, vuelva a ingresar.");
            }
            return saldo;
        }



        public String mostrarMenu() {
            do {
                System.out.println("==========================");
                System.out.println("Ingrese una opción:");
                System.out.println("Opción A: Consultar Saldo.");
                System.out.println("Opción B: Depositar");
                System.out.println("Opción C: Retirar");
                System.out.println("Opción D: Consultar último movimiento");
                System.out.println("Opción E: Salir.");
                System.out.println("==========================");
                seleccion = input.next();

                if (seleccion.equalsIgnoreCase("A")) {
                    System.out.println("---------");
                    System.out.println("Saldo: " + saldo);
                    System.out.println("---------");
                } else if (seleccion.equalsIgnoreCase("B")) {
                    depositar();
                    System.out.println("---------");
                    System.out.println("Nuevo balance: " + saldo);
                    System.out.println("---------");
                } else if (seleccion.equalsIgnoreCase("C")) {
                    retirar();
                    System.out.println("---------");
                    System.out.println("Nuevo balance: " + saldo);
                    System.out.println("---------");
                } else if (seleccion.equalsIgnoreCase("D")) {
                    System.out.println("---------");
                    System.out.println("Ultimo movimiento: " + ultimoMovimiento);
                    System.out.println("---------");
                } else if (seleccion.equalsIgnoreCase("E")){
                    System.out.println("Finalizando operacion.");
                } else {
                    System.out.println("Opción no valida.");
                }
            } while (!"E".equalsIgnoreCase(seleccion));
            return seleccion;
        }

    }



