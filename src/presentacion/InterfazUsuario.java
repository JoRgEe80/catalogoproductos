package presentacion;
import java.util.ArrayList;
import dominio.Catalogo;
import dominio.Producto;
import java.util.Scanner;
import java.io.*;

public class InterfazUsuario implements Serializable{
    public static void ejecutar(){
        Catalogo catalogo = new Catalogo();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("Introduce una instrucción (mostrar, annadir, salir)");
        String instruccion = sc.nextLine(); 
        if (instruccion.equalsIgnoreCase("mostrar")) { 
            mostrarCatalogoProductos(catalogo); 
        }else if (instruccion.equalsIgnoreCase("annadir")) {
            System.out.println("Introduce: Nombre producto, precio, cantidad");
            catalogo.annadir(new Producto(sc.nextLine(),sc.nextDouble(),sc.nextInt()));
            sc.nextLine();
            System.out.println("Producto añadido correctamente");
        }else if (instruccion.equalsIgnoreCase("salir")) { 
            System.out.println("Saliendo...");
            break;
        
        }else{ 
            System.out.println("Error en la instrucción"); 
        }
    }
         sc.close();
    }


    
    private static void mostrarCatalogoProductos(Catalogo catalogo){
        ArrayList<Producto> productos = catalogo.
                getCatalogoProductos();
        for(Producto p : productos){
            System.out.println(p.getNombre() + " " + p.getPrecio() + " " +p.getCantidad());
        }
        System.out.println("El numero total de productos es " + catalogo.calcularTiposProducto());
    
}

 
}
