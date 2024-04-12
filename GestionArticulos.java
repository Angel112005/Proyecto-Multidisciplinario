import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;


public class GestionArticulos {
    private ArrayList<Ropa> inventario;
    private Scanner scanner;

    public GestionArticulos(ArrayList<Ropa> inventario) {
        this.inventario = inventario;
        this.scanner = new Scanner(System.in);
    }

    public void agregarArticulo() {
        System.out.println("");
        System.out.println("  ***  AGREGANDO ARTICULO...  ***");
        System.out.println("");
        System.out.print("Ingrese el tipo de prenda. ");
        System.out.println("");
        System.out.println("- Gorra");
        System.out.println("- Sombrero");
        System.out.println("- Playera");
        System.out.println("- Blusa");
        System.out.println("- Camisa");
        System.out.println("- Camiseta");
        System.out.println("- Vestido");    
        System.out.println("- Pantalón");
        System.out.println("- Short");
        System.out.println("- Falda");
        System.out.println("- Calcetas");
        System.out.println("- Suéter");
        System.out.println("- Sudadera");
        System.out.println("");
        System.out.println("*  --->  EL TIPO DE PRENDA ES:");
        String tipo = scanner.nextLine();

        System.out.println("");
        double precio = 0;
        precio = solicitarPrecio();

        System.out.println("");
        System.out.print("Ingrese el género de la prenda. (Hombre / Mujer / Unisex)");
        System.out.println();
        System.out.println("*  --->  EL GÉNERO ES:");
        String genero = scanner.nextLine();

        int id = generarIDUnico();
        inventario.add(new Ropa(id, tipo, precio, genero));
        System.out.println("");
        System.out.println("       ***  ¡ARTICULO AGREGADO EXITOSAMENTE!  ***");
        System.out.println("");

        if (deseaAgregarOtroArticulo()) {
            agregarArticulo();
        }
    }

    private int generarIDUnico() {
        return inventario.size() + 1;
    }

    private boolean deseaAgregarOtroArticulo() {
        System.out.print("¿Desea agregar otro artículo de ropa? (1. Si / 2. No): ");
        int respuesta;
        do {
            try {
                respuesta = scanner.nextInt();
                scanner.nextLine(); 
                if (respuesta != 1 && respuesta != 2) {
                    System.out.println(" ***  INGRESE UNA OPCIÓN VALIDA.  ***");
                }
            } catch (InputMismatchException exception) {
                System.out.println("Por favor, ingrese 1 o 2 para seleccionar una opción.");
                scanner.next(); 
                respuesta = 0; 
            }
        } while (respuesta != 1 && respuesta != 2);
        return respuesta == 1;
    }


    public void buscarYEliminarArticulo(ArrayList<Ropa> inventario) {
        System.out.println("");
        System.out.println("        ***  BUSCAR Y ELIMINAR ARTÍCULO DEL INVENTARIO...  ***");
        System.out.println("");
        System.out.print("*  --->  Ingrese el nombre del artículo que desea buscar para eliminar: ");
        String nombreArticulo = scanner.nextLine().trim(); // Capturar toda la línea, eliminar espacios en blanco al inicio y al final
        System.out.println("");
        
        double precio = 0;
        precio = solicitarPrecio();
    
        
        boolean encontrado = false;
        for (int i = 0; i < inventario.size(); i++) {
            Ropa articulo = inventario.get(i);
            if (articulo.getTipo().equalsIgnoreCase(nombreArticulo) && articulo.getPrecio() == precio) {
                encontrado = true;
                inventario.remove(i); 
                System.out.println("");
                System.out.println("    ***    ARTÍCULO ELIMINADO DEL INVENTARIO    ***");
                break;
            }
        }
    
        if (!encontrado) {
            System.out.println("");
            System.out.println("-> ¡¡¡ No se ha encontrado el artículo en el inventario !!! <-");
        }
    }


    public void buscarArticuloPorNombre(ArrayList<Ropa> inventario) {
        System.out.println("");
        System.out.println("                ***  BUSCAR ARTICULO POR NOMBRE...  ***");
        System.out.println("");
        System.out.print("*  --->  Ingrese el nombre del artículo que desea buscar: ");
        String nombreArticulo = scanner.nextLine().trim(); 
    
        boolean encontrado = false;
        
        for (int i=0; i<inventario.size(); i++) {
            Ropa articulo = inventario.get(i);
            if (articulo.getTipo().equalsIgnoreCase(nombreArticulo)) {
                System.out.println("");
                System.out.println("    ****    ARTÍCULO ENCONTRADO. LOS DATOS SON:    ****");
                System.out.println("");
                System.out.println("Tipo de prenda:  " + articulo.getTipo());
                System.out.println("Precio:        $ " + articulo.getPrecio());
                System.out.println("Género:          " + articulo.getGenero());
                System.out.println("ID de la prenda: " + articulo.getId());
                System.out.println("");
                encontrado = true;
                break; 
            }
        }
    
        if (!encontrado) {
            System.out.println("");
            System.out.println("El artículo '" + nombreArticulo + "' no fue encontrado en el inventario.");
            System.out.println("");
        }
    }



    public void buscarYModificarArticulo(ArrayList<Ropa> inventario) {
        System.out.println("");
        System.out.println("                      ***  MODIFICAR ARTÍCULO...  ***");
        System.out.println("");
        System.out.print("*  --->  Ingrese el nombre actual del artículo que desea buscar para modificar: ");
        String nombreArticulo = scanner.nextLine().trim(); 
    
        double precio;
        System.out.println("");
        System.out.println("* PRECIO ACTUAL *");
        
        precio = solicitarPrecio();
    
        boolean encontrado = false;
        for (int i = 0; i < inventario.size(); i++) {
            Ropa articulo = inventario.get(i);
            if (articulo.getTipo().equalsIgnoreCase(nombreArticulo) && articulo.getPrecio() == precio) {
                encontrado = true;
                System.out.println("");
                System.out.println("  ***    ARTÍCULO ENCONTRADO. INGRESE LOS NUEVOS DATOS    ***");
                System.out.println("");
                System.out.print("*  --->  INGRESE EL NUEVO TIPO DE PRENDA: ");
                String nuevoTipo = scanner.nextLine();

                System.out.println("");
                double nuevoPrecio;
                System.out.println("* PRECIO NUEVO *");
                nuevoPrecio = solicitarPrecio();
                
                System.out.println("");
                System.out.print("Ingrese el nuevo género de la prenda. (Hombre / Mujer / Unisex)");
                System.out.println("*  --->  EL NUEVO GÉNERO ES:");
                String nuevoGenero = scanner.nextLine();
        
                articulo.setTipo(nuevoTipo);
                articulo.setGenero(nuevoGenero);
                articulo.setPrecio(nuevoPrecio);
                System.out.println("");
                System.out.println("--> Los datos del artículo se han modificado correctamente. <--");
                break;
            }
        }
        
    
        if (!encontrado) {
            System.out.println("No se ha encontrado el artículo en el inventario.");
        }
    }

    public void verInventario() {
        System.out.println("___________________________________________________");
        System.out.println("|                                                 |");
        System.out.println("|----------   INVENTARIO DE LA TIENDA   ----------|");
        System.out.println("|_________________________________________________|");
        System.out.println("");
            for(int i = 0; i < inventario.size(); i++){
                Ropa ropa = inventario.get(i);
                System.out.println("   Tipo de prenda: " + ropa.getTipo());
                System.out.println("   Precio:    $" + ropa.getPrecio());
                System.out.println("   Género:     " + ropa.getGenero());
                System.out.println("   ID de la prenda: " + ropa.getId());
                System.out.println("");
            }
            System.out.println("_________________________________________________");
            System.out.println("");
            System.out.println("-->  TOTAL DE ARTICULOS EN INVENTARIO: " + inventario.size() + " Artículo(s)  <--");
            System.out.println("");
            System.out.println("");
        }

    public double solicitarPrecio() {
        double precio = 0;
        boolean precioValido = false;
        while (!precioValido) {
            try {
                System.out.println("*  --->  Ingrese el precio del artículo:"); 
                precio = scanner.nextDouble();
                scanner.nextLine();
                if (precio < 0){
                    System.out.println("-->¡EL PRECIO NO PUEDE SER NEGATIVO. INTENTE NUEVAMENTE!<--");
                } else {
                    precioValido = true;
                } 
            } catch (InputMismatchException exception) {
                System.out.println("Debe ingresar un número válido para el precio. Intente de nuevo...");
                scanner.nextLine();
            }
        }
        return precio;
    }


}
