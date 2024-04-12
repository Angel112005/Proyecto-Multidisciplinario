import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Venta {
    private String nombreArticulo;
    private double precio;
    private String genero;
    private Scanner scanner;



    public Venta(String nombreArticulo, double precio, String genero) {
        this.nombreArticulo = nombreArticulo;
        this.precio = precio;
        this.genero = genero;
        this.scanner = new Scanner(System.in);

    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public double getPrecio() {
        return precio;
    }

    public String getGenero(){
        return genero;
    }

    public void procesarVenta(ArrayList<Ropa> inventario) {
        // Buscar el artículo en el inventario y eliminarlo si se encuentra
        for (int i = 0; i < inventario.size(); i++) {
            Ropa articulo = inventario.get(i);
            if (articulo.getTipo().equalsIgnoreCase(nombreArticulo) && articulo.getPrecio() == precio) {
                inventario.remove(i);
                break; 
            }
        }
    }

    public void realizarVenta(ArrayList<Ropa> inventario, ArrayList<Venta> ventas) {
        System.out.println("");
        System.out.println("           ***  REALIZANDO VENTA...  ***");
        System.out.println("");
        System.out.print("*  --->  Ingrese el nombre del artículo a vender: ");
        String nombreArticulo = scanner.nextLine();
    
        double precio = 0;
        boolean precioValido = false;
        do {
            try {
                System.out.print("*  --->  Ingrese el precio del artículo: ");
                precio = scanner.nextDouble();
                scanner.nextLine();
                if (precio < 0) {
                    System.out.println("EL PRECIO NO PUEDE SER NEGATIVO. INTENTE NUEVAMENTE...");
                } else {
                    precioValido = true;
                }                
            } catch (InputMismatchException exception) {
                System.out.println("Por favor, ingrese un valor numérico para el precio.");
                scanner.next();
            }
        } while (!precioValido);
    
        System.out.println("");
        System.out.print("Ingrese el género de la prenda. (Hombre / Mujer / Unisex)");
        System.out.println("");
        System.out.println("*  --->  El género es:");
        genero = scanner.nextLine();
        // Verificar si el artículo está en el inventario
        boolean encontrado = false;
        for (int i=0; i<inventario.size(); i++) {
            Ropa articulo = inventario.get(i);
            if (articulo.getTipo().equalsIgnoreCase(nombreArticulo) && articulo.getPrecio() == precio && articulo.getGenero().equalsIgnoreCase(genero)) {
                encontrado = true;
                break;
            }
        }
    
        if (encontrado) {
            Venta venta = new Venta(nombreArticulo, precio, genero);
            venta.procesarVenta(inventario);
            ventas.add(venta);
            System.out.println("    ***  VENTA REALIZADA  ***");
        } else {
            System.out.println("      ** NO SE ENCONTRÓ EL ARTÍCULO EN EL INVENTARIO **");
        }
    }

    
}
