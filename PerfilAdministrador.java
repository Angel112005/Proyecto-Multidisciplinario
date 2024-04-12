import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PerfilAdministrador extends Usuario {
    private ArrayList<Ropa> inventario;
    private GestionArticulos gestionArticulos;
    private ArrayList<Venta> ventaArticulos;
    private Venta venta;
    private ReporteVentas reporteVentas;
    private ArrayList<Gasto> gastosTienda;
    private Gasto gasto;
    private ReporteGastos reporteGastos;
    private Scanner scanner;
    
    
    public PerfilAdministrador(String nombreUsuario, String contraseña, ArrayList<Ropa> inventario, GestionArticulos gestionArticulos,ArrayList<Venta> ventaArticulos , Venta venta, ReporteVentas reporteVentas, ArrayList<Gasto> gastosTienda, Gasto gasto, ReporteGastos reporteGastos, Scanner scanner) {
        super(nombreUsuario, contraseña);
        this.inventario = inventario;
        this.gestionArticulos = gestionArticulos;
        this.ventaArticulos = ventaArticulos;
        this.venta = venta;
        this.reporteVentas = reporteVentas;
        this.gastosTienda = gastosTienda;
        this.gasto = gasto;
        this.reporteGastos = reporteGastos;
        this.scanner = scanner;
    }

    @Override
    public void mostrarMenu(){
        boolean seguirEnMenu = true;
        while (seguirEnMenu) {
            System.out.println("_________________________________________________");
            System.out.println("|                                               |");
            System.out.println("|----->  BIENVENIDO AL BAZAR LA PASADITA  <-----|");
            System.out.println("|_______________________________________________|");
            System.out.println("");
            System.out.println("     ****    OPCIONES DISPONIBLES:    ****");
            System.out.println("");
            System.out.println("1. Agregar artículo de ropa.");
            System.out.println("2. Eliminar Artículo");
            System.out.println("3. Buscar artículo por tipo de artículo.");
            System.out.println("4. Editar Artículo");
            System.out.println("5. Ver inventario.");
            System.out.println("6. Realizar venta");
            System.out.println("7. Ver Reporte de ventas");
            System.out.println("8. Agregar Gasto");
            System.out.println("9. Ver Reporte de Gastos");
            System.out.println("10. Cerrar sesión");
            System.out.println("");

            int opcion = 0;
            boolean opcionValida = true;

            do{
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
                    gestionArticulos.agregarArticulo();
                    break;
                case 2:
                    gestionArticulos.buscarYEliminarArticulo(inventario);
                    break;
                case 3:
                    gestionArticulos.buscarArticuloPorNombre(inventario);
                    break;
                case 4:
                    gestionArticulos.buscarYModificarArticulo(inventario);
                    break;
                case 5:
                    gestionArticulos.verInventario();
                    break;
                case 6:
                    venta.realizarVenta(inventario, ventaArticulos);
                    break;
                case 7:
                    reporteVentas.verReporteVentas();
                    break;
                case 8:
                    gasto.agregarGasto(gastosTienda);
                    break;
                case 9:
                    reporteGastos.verReporteGastos();
                    break;
                case 10:
                    seguirEnMenu = false;    
                    break;            
                default:
                    System.out.println("INGRESE UNA OPCIÓN VALIDA...");
                    break;
            }       
        }
    }
}
