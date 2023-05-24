import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static void main(String[] args){
		System.out.println("RESOLUCION TPE PROG 3 PARTE 1");

        System.out.println("============ CARGA DE DATOS ============");
         // Crear un HashMap para los vertices
         HashMap<Integer, ArrayList<Arco<String>>> vertices1 = new HashMap<>();
         HashMap<Integer, ArrayList<Arco<String>>> vertices2 = new HashMap<>();
         HashMap<Integer, ArrayList<Arco<String>>> vertices3 = new HashMap<>();


         // Crear un grafo dirigido
         GrafoDirigido<String> grafo1 = new GrafoDirigido<>(vertices1);
         GrafoDirigido<String> grafo2 = new GrafoDirigido<>(vertices2);
         GrafoDirigido<String> grafo3 = new GrafoDirigido<>(vertices3);

 
         // Agregar vértices
         grafo1.agregarVertice(1);
         grafo1.agregarVertice(2);
         grafo1.agregarVertice(3);
         grafo1.agregarVertice(4);

         grafo2.agregarVertice(1);
         grafo2.agregarVertice(2);
         grafo2.agregarVertice(3);
         grafo2.agregarVertice(4);
         grafo2.agregarVertice(5);

         grafo3.agregarVertice(1);
         grafo3.agregarVertice(2);
         grafo3.agregarVertice(3);
         grafo3.agregarVertice(4);
         grafo3.agregarVertice(5);
         grafo3.agregarVertice(6);
         grafo3.agregarVertice(7);
         grafo3.agregarVertice(8);
        
         // Agregar arcos
         grafo1.agregarArco(1, 2, "Arco 1-2");
         grafo1.agregarArco(1, 2, "Arco 1-2"); //Repetido, no se agrega
         grafo1.agregarArco(1, 3, "Arco 1-3");
         grafo1.agregarArco(2, 4, "Arco 2-4");
         grafo1.agregarArco(3, 4, "Arco 3-4");

         grafo2.agregarArco(4, 5, "Arco 4-5");
         grafo2.agregarArco(2, 4, "Arco 2-4");
         grafo2.agregarArco(1, 3, "Arco 1-3");
         grafo2.agregarArco(1, 2, "Arco 1-2");
         grafo2.agregarArco(3, 4, "Arco 3-4");
         grafo2.agregarArco(4, 5, "Arco 4-5");

         grafo3.agregarArco(1, 4, null);
         grafo3.agregarArco(1, 3, null);
         grafo3.agregarArco(1, 2, null);
         grafo3.agregarArco(4, 8, null);
         grafo3.agregarArco(4, 3, null);
         grafo3.agregarArco(3, 7, null);
         grafo3.agregarArco(3, 6, null);
         grafo3.agregarArco(2, 3, null);
         grafo3.agregarArco(2, 6, null);
         grafo3.agregarArco(2, 5, null);
        
 
     
        //DFS
         System.out.println("============ DFS ============");
         ServicioDFS dfs = new ServicioDFS(grafo1);
         dfs.dfsForest();

         //BFS
         System.out.println("============ BFS ============");
         ServicioBFS bfs = new ServicioBFS(grafo2);
         bfs.bfsForest();

         //Caminos
         System.out.println("============ Caminos ============");
         ServicioCaminos sc = new ServicioCaminos(grafo3, 1, 6, 10);
         sc.caminos();

}}