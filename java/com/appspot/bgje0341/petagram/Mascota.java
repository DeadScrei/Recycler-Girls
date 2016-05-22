package com.appspot.bgje0341.petagram;

public class Mascota {

    private int imagen;
    private int huesoB;
    private int huesoA;
    private String nombre;
    private int like;

    public Mascota (int like){
        this.like=like;
    }

    public Mascota(int imagen, int huesoB, int huesoA, String nombre, int like) {
        this.imagen = imagen;
        this.huesoB = huesoB;
        this.huesoA = huesoA;
        this.nombre = nombre;
        this.like = like;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getHuesoB() {
        return huesoB;
    }

    public void setHuesoB(int huesoB) {
        this.huesoB = huesoB;
    }

    public int getHuesoA() {
        return huesoA;
    }

    public void setHuesoA(int huesoA) {
        this.huesoA = huesoA;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}
