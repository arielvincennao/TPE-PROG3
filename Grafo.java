import java.util.Iterator;

public interface Grafo<T> {
    
    public void agregarVertice(int verticeId);

    public void borrarVertice(int verticeId);

    public void agregarArco(int verticeOrigen, int verticeDestino, T datoArco);

    public boolean existeArco(int verticeId1, int verticeId2);

    public boolean existeVertice(int verticeId);

    public Arco<T> obtenerArco(int verticeId1, int verticeId2);

    public Iterator<Integer> obtenerVertices();

    public Iterator<Arco<T>> obtenerArcos();

    public Iterator<Arco<T>> obtenerArcos(int verticeId);

    public Iterator<Integer> obtenerAdyacentes(int verticeId);



}
