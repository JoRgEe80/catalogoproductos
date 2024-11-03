package dominio;
import java.io.*;
import java.util.*;
public class Catalogo implements Serializable{
  private final ArrayList<Producto> catalogoProductos = new ArrayList<>();
    
    public Catalogo(){
      cargarProductos();
    }
    public void annadir(Producto p) {
      catalogoProductos.add(p);
    volcarProductos();
    }
    
    public ArrayList<Producto> getCatalogoProductos() {
        return catalogoProductos;
    }
    
    public int calcularTiposProducto() {
        return catalogoProductos.size();
    }
    private void cargarProductos(){
        try{
            File fichero = new File("catalogo.csv");
    
            if (!fichero.exists()) {
                System.out.println("El archivo catalogo no existe.");
                return;
            }
            Scanner sc = new Scanner(fichero);
            sc.useDelimiter("[,\n]");
            while(sc.hasNext()){
                Producto p = new Producto(sc.next(),
                Double.parseDouble(sc.next()),
                Integer.parseInt(sc.next()));
                catalogoProductos.add(p);
            }
            sc.close();
        }catch(IOException ex){
            System.out.println("No hay productos registrados");
        }
    }
    public void volcarProductos(){
    try{
        FileWriter fw = new FileWriter("catalogo.csv");
        for(Producto p : catalogoProductos){
            fw.write(p.getNombre() + "," +p.getPrecio() + "," +p.getCantidad()+"\n");
        }
        fw.close();
    }catch(IOException ex){
        System.err.println(ex);
    }
}
}


