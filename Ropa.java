public class Ropa {
    private int id;
    private String tipo;
    private double precio;
    private String genero;

    public Ropa (int id, String tipo, double precio, String genero){
    this.id = id;
    this.tipo = tipo;
    this.precio = precio;
    this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public String getGenero(){
        return genero;
    }
    
}
