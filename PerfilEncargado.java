import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PerfilEncargado extends Usuario{
    private ArrayList<Ropa> inventario;
    private GestionArticulos gestionArticulos;
    private Scanner scanner;
    private Venta venta;
    private ArrayList<Venta> ventaArticulos;

    public PerfilEncargado(String nombreUsuario, String contraseña, Scanner scanner, ArrayList<Ropa> inventario, GestionArticulos gestionArticulos, Venta venta, ArrayList<Venta> ventaArticulos) {
        super(nombreUsuario, contraseña);
        this.scanner = scanner;
        this.inventario = inventario;
        this.gestionArticulos = gestionArticulos;
        this.venta = venta;
        this.ventaArticulos = ventaArticulos;
    }

    @Override
    public void mostrarMenu(){
        boolean seguirEnMenu = true;
        while (seguirEnMenu) {
            System.out.println("________________________________________________");
            System.out.println("|                                               |");
            System.out.println("|----->  BIENVENIDO AL BAZAR LA PASADITA  <-----|");
            System.out.println("|_______________________________________________|");
            System.out.println("");
            System.out.println("     ****    OPCIONES DISPONIBLES:    ****");
            System.out.println("");
            System.out.println("1. Ver inventario.");
            System.out.println("2. Buscar artículo por tipo de artículo.");
            System.out.println("3. Realizar venta");
            System.out.println("4. Cerrar sesión");
            System.out.println("");

            int opcion = 0;
            boolean opcionValida = true;

            do {
                try {
                    System.out.print("Su opción es: ");
                    opcion = scanner.nextInt();
                    opcionValida = false;
                } catch (InputMismatchException exception) {
                    System.out.println("Por favor, ingrese un valor numérico válido para la opción.");
                    scanner.next(); 
                }
            } while (opcionValida);

            switch (opcion) {
                case 1:
                    gestionArticulos.verInventario();
                    break;
                case 2:
                    gestionArticulos.buscarArticuloPorNombre(inventario);
                    break;
                case 3:
                    venta.realizarVenta(inventario, ventaArticulos);
                    break;
                case 4:
                    seguirEnMenu = false;
                    break;
                default:
                    System.out.println("INGRESE UNA OPCIÓN VALIDA...");
                    break;
            }
        }
    }
}
