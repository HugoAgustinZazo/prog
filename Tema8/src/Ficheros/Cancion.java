package Ficheros;

public class Cancion {
    private int identificador;
    private String nombre;
    private String nombreArtista;
    private long duracionSegundos;

    public Cancion(int identificador, String nombre, String nombreArtista, long duracionSegundos) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.nombreArtista = nombreArtista;
        this.duracionSegundos = duracionSegundos;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public long getDuracionSegundos() {
        return duracionSegundos;
    }

    public void setDuracionSegundos(long duracionSegundos) {
        this.duracionSegundos = duracionSegundos;
    }

    @Override
    public String toString() {
        return "Cancion{" +
                "identificador=" + identificador +
                ", nombre='" + nombre + '\'' +
                ", nombreArtista='" + nombreArtista + '\'' +
                ", duracionSegundos=" + duracionSegundos +
                '}';
    }
}
