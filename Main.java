import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Gasto> gastosTienda = new ArrayList<>();
    private static ArrayList<Ropa> inventario = new ArrayList<>();
    private static ArrayList<Venta> ventaArticulos = new ArrayList<>();
    private static GestionArticulos gestionArticulos = new GestionArticulos(inventario);
    private static ReporteVentas reporteVentas = new ReporteVentas(ventaArticulos);
    private static ReporteGastos reporteGastos = new ReporteGastos(gastosTienda);
    private static Venta venta = new Venta(null, 0.0, null);
    private static Gasto gasto = new Gasto(null, null, 0);

    private static PerfilAdministrador administrador; 
    private static PerfilEncargado encargado; 


    public static void main(String[] args) {
        boolean sesionActiva = true;
        administrador = new PerfilAdministrador("Admin1", "123", inventario, gestionArticulos, ventaArticulos, venta, reporteVentas, gastosTienda, gasto, reporteGastos, scanner);
        encargado = new PerfilEncargado("User1", "321", scanner, inventario, gestionArticulos, venta, ventaArticulos);
        while (sesionActiva) {
            System.out.println("");
            System.out.println("        * INICIO DE SESIÓN * ");
            solicitarCredenciales();
        }
    }
    
    private static void solicitarCredenciales() {
        scanner = new Scanner(System.in);
        System.out.println();
        System.out.print("Ingrese su nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contraseña = scanner.nextLine();
        
        if (administrador.getNombreUsuario().equals(nombreUsuario)&&administrador.getContraseña().equals(contraseña)) {
            System.out.println();
            System.out.println("****    INICIO DE SESIÓN EXITOSO    ****");
            System.out.println("  ****    PERFIL ADMINISTRADOR    ****");
            System.out.println();
            administrador.mostrarMenu();
        }
        else if (encargado.getNombreUsuario().equals(nombreUsuario) && encargado.getContraseña().equals(contraseña)) {
            System.out.println();
            System.out.println("****    INICIO DE SESIÓN EXITOSO    ****");
            System.out.println("    ****    PERFIL ENCARGADO    ****");
            encargado.mostrarMenu();
        } else {
            System.out.println("");
            System.out.println(" 0---> NOMBRE DE USUARIO O CONTRASEÑA INCORRECTOS, INTÉNTELO DE NUEVO. <---");
        }
    }
}
