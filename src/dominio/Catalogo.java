package dominio;
import java.io.*;
import java.util.*;
public class Catalogo implements Serializable{
  private ArrayList<Producto> catalogoProductos = new ArrayList<>();
    
    public Catalogo(){
      cargarProductos();
    }
    public void annadir(Producto p) throws DuplicadoException{
      int posicion = catalogoProductos.indexOf(new Producto(p.getNombre()));
      if(posicion ==-1){
        catalogoProductos.add(p);
        volcarProductos();
      }else{
        throw new DuplicadoException();
      }
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
    public Producto buscar(String nombre){
        int posicion=catalogoProductos.indexOf(new Producto(nombre));
        if(posicion==-1){
            return null;
        }else{
            return catalogoProductos.get(posicion);
        }
    }
    public void modificarProducto(String nombre, Double nuevoPrecio, int nuevaCantidad) throws NoEncontradoException{
        
        Producto p = buscar(nombre);
        if (p != null) { 
            p.setPrecio(nuevoPrecio);
            p.setCantidad(nuevaCantidad);
            volcarProductos();
            
        }else{
            throw new NoEncontradoException();
        }
    
    }
    public void borrar(String nombre) throws NoEncontradoException{
        int posicion = catalogoProductos.indexOf(new Producto(nombre));
        if(posicion !=-1){
            catalogoProductos.remove(posicion);
            volcarProductos();
            System.out.println("Producto borrado correctamente");
        }else{
            throw new NoEncontradoException();
        }

    }
}


