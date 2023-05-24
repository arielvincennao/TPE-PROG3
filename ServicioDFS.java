import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

//RECORRIDO DE PROFUNDIDAD
//Es un planteo recursivo

public class ServicioDFS {
    private Grafo<?> grafo;
    private HashMap<Integer, String> colores;

	public ServicioDFS(Grafo<?> grafo) {
		this.grafo = grafo;
        this.colores = new HashMap<>();
	}
	
	public List<Integer> dfsForest() {
        
		// Resolver DFS
        List<Integer> visitados = new ArrayList<>();

        Iterator<Integer> iterator = this.grafo.obtenerVertices(); 

        while (iterator.hasNext()) {
            Integer vertice = iterator.next();
            colores.put(vertice, "Blanco");
        }


        int tiempo = 0;

        Iterator<Integer> iteratorColores = this.obtenerColores();

        while(iteratorColores.hasNext()){
            Integer clave = iteratorColores.next();
            String color = colores.get(clave);
            if (color.equals("Blanco")) {
                dfsVisit(clave, tiempo, visitados);
            }    
        }
        System.out.println(visitados);
		return visitados;
	}

    private void dfsVisit(int idVertice, int tiempo, List<Integer> visitados) {

        colores.put(idVertice, "Amarillo");
        visitados.add(idVertice);
        

        tiempo = tiempo + 1;
        
        Iterator<Integer> iteratorAdyacentes = this.grafo.obtenerAdyacentes(idVertice);
        

        while (iteratorAdyacentes.hasNext()){
            Integer clave = iteratorAdyacentes.next();
            
             if(colores.get(clave) == "Blanco"){
                dfsVisit(clave, tiempo, visitados);
             }
        }
        
        colores.put(idVertice, "Negro");
        tiempo = tiempo + 1;
    
    }

    public Grafo<?> getGrafo() {
        return grafo;
    }

    public Iterator<Integer> obtenerColores() {
        return colores.keySet().iterator();
    }

    

}
