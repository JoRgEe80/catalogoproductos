package dominio;

public class NoEncontradoException extends Exception{

    private Producto cerror;
    public NoEncontradoException(Producto p){
        cerror=p;
    }
    public NoEncontradoException(){

    }
    public Producto getProducto(){
        return cerror;
    }

}
