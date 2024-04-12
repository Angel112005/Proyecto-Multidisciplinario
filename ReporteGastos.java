import java.util.ArrayList;

public class ReporteGastos extends ResultadosReportes{
    private ArrayList<Gasto> listaGastos;

    public ReporteGastos(ArrayList<Gasto> gastos) {
        this.listaGastos = gastos;
    }

    public void verReporteGastos() {
        System.out.println("");
        System.out.println("------------   REPORTE DE GASTOS   ------------");
        System.out.println("_________________________________________________");
        System.out.println("");
        for (int i = 0; i < listaGastos.size(); i++) {
            Gasto gasto = listaGastos.get(i);
            System.out.println("   Tipo de Gasto:  " + gasto.getTipo());
            System.out.println("   Descripción:    " + gasto.getDescripcion());
            System.out.println("   Monto:          " + gasto.getMonto());
            System.out.println("");
        }
        System.out.println("_________________________________________________");
        System.out.println("");
        mostrarResultados();
        System.out.println("");
    }
    
    @Override
    public void mostrarResultados() {
        if (listaGastos.size()==0) {
            System.out.println("       --> NO HAY GASTOS REGISTRADOS <-- ");
        } else {
            double total = 0;
            for (int i = 0; i < listaGastos.size(); i++) {
                Gasto gasto = listaGastos.get(i);
                total += gasto.getMonto();
            }
            System.out.println("------->     TOTAL DE GASTOS: " + total + "     <-------");
        }
        
    }

    // private void mostrarResultadosGastos(){
    // }

    // private double calcularTotalGastos() {
    //     double total = 0;
    //     for (int i = 0; i < listaGastos.size(); i++) {
    //         Gasto gasto = listaGastos.get(i);
    //         total += gasto.getMonto();
    //     }
    //     return total;
    // }

}
