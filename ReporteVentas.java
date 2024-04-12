import java.util.ArrayList;

public class ReporteVentas extends ResultadosReportes{
    private ArrayList<Venta> listaVentas;

    public ReporteVentas(ArrayList<Venta> ventas) {
        this.listaVentas = ventas;
    }

    public void verReporteVentas() {
        System.out.println("");
        System.out.println("------------   REPORTE DE VENTAS   ------------");
        System.out.println("_________________________________________________");
        System.out.println("");
        for (int i = 0; i < listaVentas.size(); i++) {
            Venta venta = listaVentas.get(i);
            // Ropa ropa = ;
            System.out.println("   Nombre del artículo:   " + venta.getNombreArticulo());
            System.out.println("   Precio:               $" + venta.getPrecio());
            System.out.println("   Género:                " + venta.getGenero());
            System.out.println("");
        }
        System.out.println("_________________________________________________");
        mostrarResultados();
        System.out.println("");
        // System.out.println("");
    }

    @Override
    public void mostrarResultados() {
        if (listaVentas.size()==0 && calcularTotalVentas() == 0) {
            System.out.println("");
            System.out.println("       --> AÚN NO SE HAN REGISTRADO VENTAS <--");
            System.out.println("     --> NO HAY INGRESO DE DINERO POR VENTAS <-- ");
        } else {
            System.out.println("");
            System.out.println("-->  CANTIDAD DE VENTAS:  " + listaVentas.size()    + "  Venta(s)  <--");
            System.out.println("-->  TOTAL DE VENTAS:     " + calcularTotalVentas() + "  MXN " + "<--");        
        }
    }
    

    

    
    private double calcularTotalVentas() {
        double total = 0;
        for (int i = 0; i < listaVentas.size(); i++) {
            Venta venta = listaVentas.get(i);
            total += venta.getPrecio();
        }
        return total;
    }
}