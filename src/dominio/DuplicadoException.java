package dominio;

public class DuplicadoException extends Exception{

    private Producto cerror;
    public DuplicadoException(Producto p){
        cerror=p;
    }
    public DuplicadoException(){

    }
    public Producto getProducto(){
        return cerror;
    }

}
