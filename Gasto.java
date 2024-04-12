import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Gasto{
    private String tipo;
    private String descripcion;
    private double monto;
    private Scanner scanner;
    

    public Gasto(String tipo, String descripcion, double monto) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.monto = monto;
        this.scanner = new Scanner(System.in);
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getMonto() {
        return monto;
    }

    public void agregarGasto(ArrayList<Gasto> gastos) {
        System.out.println("");
        System.out.println("  ***  AGREGANDO GASTO...  ***");
        System.out.println("");
        System.out.print("Ingrese el tipo de gasto: ");
        String tipo = scanner.next();
        System.out.print("Ingrese la descripción del gasto: ");
        String descripcion = scanner.next();
        
        double monto = 0;
        boolean montoValido = false;

        do {
            try {
                System.out.print("Ingrese el monto del gasto: ");
                monto = scanner.nextDouble();
                if (monto < 0) {
                    System.out.println("EL MONTO NO PUEDE SER NEGATIVO. INTENTE NUEVAMENTE...");
                } else {
                    montoValido = true;
                }
            } catch (InputMismatchException exception) {
                System.out.println("Por favor, ingrese un valor numérico para el precio.");
                scanner.next();
            }
        } while (!montoValido);

        gastos.add(new Gasto(tipo, descripcion, monto));
        System.out.println("");
        System.out.println("  ***  ¡GASTO AGREGADO EXITOSAMENTE!  ***");
        System.out.println("");

    }

}