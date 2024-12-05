package presentacion;

import java.util.ArrayList;
import dominio.Catalogo;
import dominio.DuplicadoException;
import dominio.NoEncontradoException;
import dominio.Producto;
import java.util.Scanner;
import java.io.*;

public class InterfazUsuario implements Serializable{
    public static void ejecutar(){
        Catalogo catalogo = new Catalogo();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("Introduce una instrucción ('consultar'(1 producto), 'mostrar'(catalogo), 'annadir', 'mofificar', 'borrar', 'salir')");
        String instruccion = sc.nextLine(); 
        if (instruccion.equalsIgnoreCase("consultar")) { 
            System.out.println("Introduzca el nombre del producto que desea consultar");
            mostrarProducto(sc.nextLine()); 
        }else if(instruccion.equalsIgnoreCase("mostrar")){
            mostrarCatalogo(catalogo);

        }else if (instruccion.equalsIgnoreCase("annadir")) {
            System.out.println("Introduce: Nombre producto, precio, cantidad");
            try{
            catalogo.annadir(new Producto(sc.nextLine(),sc.nextDouble(),sc.nextInt()));
            }catch(DuplicadoException ex){
                System.out.println("'Producto duplicado', pruebe a introducir un nuevo Producto");
            }
            System.out.println("Producto añadido correctamente");
        }else if (instruccion.equalsIgnoreCase("salir")) { 
            System.out.println("Saliendo...");
            break;
        
        }else if (instruccion.equalsIgnoreCase("modificar")){
            System.out.println("Introduzca: 'Nombre producto', 'Nuevo precio', 'Nueva Cantidad'");
            try{
            catalogo.modificarProducto(sc.nextLine(), sc.nextDouble(),sc.nextInt());
            }catch(NoEncontradoException ex){
                System.out.println("'Contacto no encontrado', si desea crearlo ejecute la instruccion 'annadir'");
            }

        }else if(instruccion.equalsIgnoreCase("borrar")){
            System.out.println("Introduzca el nombre del producto que desea borrar");
            try{
                catalogo.borrar(sc.nextLine());

            }catch(NoEncontradoException ex){
                System.out.println("'Contacto no encontrado'");
            }


        }else{ 
            System.out.println("Error en la instrucción"); 
        }
    }
        sc.close();
    }


    
    public static void mostrarProducto(String nombre){
        Catalogo catalogo = new Catalogo();
        ArrayList<Producto> catalogo_= new ArrayList<>();
        catalogo_= catalogo.getCatalogoProductos();
        int posicion=catalogo_.indexOf(new Producto(nombre));
        if(posicion==-1){
            
        }else{
            Producto p = catalogo_.get(posicion);
            System.out.println("Nombre: "+p.getNombre()+"\n"+"Precio: "+p.getPrecio()+"\n"+"Cantidad: "+p.getCantidad());
        }
    }
    private static void mostrarCatalogo(Catalogo catalogo){
        ArrayList<Producto> productos = catalogo.getCatalogoProductos();
        for(Producto producto : productos){
            System.out.println(producto.getNombre() + " " +producto.getPrecio() + " " +producto.getCantidad()+"\n");
        }
        System.out.println("El numero total de productos es " + catalogo.calcularTiposProducto());
    }

 
}
