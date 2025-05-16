
package com.cinerama.modelo;

public class Pelicula {
    
 private int id;
    private String titulo;
    private String imagen;
    private String duracion;
    private String clasificacion;
   private String imagenPc;
    public Pelicula() {}
public String getImagenPc() {
    return imagenPc;
}

public void setImagenPc(String imagenPc) {
    this.imagenPc = imagenPc;
}
    public Pelicula(int id, String titulo, String imagen, String duracion, String clasificacion) {
        this.id = id;
        this.titulo = titulo;
        this.imagen = imagen;
        this.duracion = duracion;
        this.clasificacion = clasificacion;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getImagen() { return imagen; }
    public void setImagen(String imagen) { this.imagen = imagen; }

    public String getDuracion() { return duracion; }
    public void setDuracion(String duracion) { this.duracion = duracion; }

    public String getClasificacion() { return clasificacion; }
    public void setClasificacion(String clasificacion) { this.clasificacion = clasificacion; }
}
