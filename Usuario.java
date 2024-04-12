// import java.security.SecureRandom;


public abstract class Usuario {
    protected String nombreUsuario;
    protected String contraseña;

    public Usuario(String nombreUsuario, String contraseña) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public abstract void mostrarMenu();

    // protected String generarContraseñaAleatoria(int longitud) {
    //     String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    //     SecureRandom random = new SecureRandom();
    //     StringBuilder sb = new StringBuilder(longitud);

    //     for (int i = 0; i < longitud; i++) {
    //         int index = random.nextInt(caracteres.length());
    //         sb.append(caracteres.charAt(index));
    //     }

    //     return sb.toString();
    // }

}