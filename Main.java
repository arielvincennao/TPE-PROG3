import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static void main(String[] args){
		System.out.println("RESOLUCION TPE PROG 3 PARTE 1");

        System.out.println("============ CARGA DE DATOS ============");
         // Crear un HashMap para los vertices
         HashMap<Integer, ArrayList<Arco<String>>> vertices = new HashMap<>();

         // Crear un grafo dirigido
         GrafoDirigido<String> grafo = new GrafoDirigido<>(vertices);
 
         // Agregar vértices
         grafo.agregarVertice(1);
         grafo.agregarVertice(2);
         grafo.agregarVertice(3);
         grafo.agregarVertice(4);
 
         // Agregar arcos
         grafo.agregarArco(1, 2, "Arco 1-2");
         grafo.agregarArco(1, 2, "Arco 1-2"); //No se agrega
         grafo.agregarArco(1, 3, "Arco 1-3");
         grafo.agregarArco(2, 4, "Arco 2-4");
         grafo.agregarArco(3, 4, "Arco 3-4");
 
     
        //DFS
         System.out.println("============ DFS ============");
         ServicioDFS dfs = new ServicioDFS(grafo);
         dfs.dfsForest();

}}