import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


//RECORRIDO EN AMPLITUD
//Es un planteo iterativo

public class ServicioBFS {
    private Grafo<?> grafo;
	private Queue<Integer> queue = new LinkedList<>();
	private HashMap<Integer, Boolean> visited = new HashMap<>();
	
	public ServicioBFS(Grafo<?> grafo) {
		this.grafo = grafo;
	}
	
	public List<Integer> bfsForest() {
		// Resolver BFS
		
		List<Integer> visitados = new ArrayList<>();

		Iterator<Integer> iterator = this.grafo.obtenerVertices();

		while (iterator.hasNext()) {
            Integer vertice = iterator.next();
            visited.put(vertice, false);
        }


		Iterator<Integer> iteratorVertices = this.grafo.obtenerVertices();

		while (iteratorVertices.hasNext()) {
            Integer vertice = iteratorVertices.next();   

            if (!visited.get(vertice)) {
                bfsVisit(vertice, visitados);   
            }

        }
   
		System.out.println(visitados);
        return visitados;

	}

	private void bfsVisit(Integer verticeInicial, List<Integer> visitados) {
		visited.put(verticeInicial, true); 
		queue.add(verticeInicial); 
		visitados.add(verticeInicial); 

		while (!queue.isEmpty()) { 
			Integer vertice = queue.poll(); 
			Iterator<Integer> iteratorAdyacentes = this.grafo.obtenerAdyacentes(vertice);

			while (iteratorAdyacentes.hasNext()) { 
                Integer adyacente = iteratorAdyacentes.next(); 
                if (!visited.get(adyacente)) {  
                    visited.put(adyacente, true); 
                    queue.add(adyacente);
                    visitados.add(adyacente);
                }
            }
		}
	}
}
