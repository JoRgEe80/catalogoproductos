package dominio;
import  java.io.*;
public class Producto implements Serializable{
    private String nombre;
    private double precio;
    private int cantidad;

    public Producto(String nombre_, double precio_, int cantidad_){
        nombre=nombre_;
        precio=precio_;
        cantidad=cantidad_;
    }
    public String getNombre(){
        return nombre;
    }
    public double getPrecio(){
        return precio;
    }
    public int getCantidad(){
        return cantidad;
    }
    public void setNombre(String nombre_){
        nombre=nombre_;
    }
    public void setPrecio(double precio_){
        precio=precio_;
    }
    public void setCantidad(int cantidad_){
        cantidad=cantidad_;
    }
    public String toString() {
        StringBuilder sb=new StringBuilder();
                sb.append("Producto: ").append(nombre).append("\n").append("Precio: ")
                .append(precio).append("\n").append("Cantidad: ").append(cantidad);
                return sb.toString();

    }
}