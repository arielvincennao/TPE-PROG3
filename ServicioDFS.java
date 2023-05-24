import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

//RECORRIDO DE PROFUNDIDAD

public class ServicioDFS {
    private Grafo<?> grafo;
    private HashMap<Integer, String> colores;

	public ServicioDFS(Grafo<?> grafo) {
		this.grafo = grafo;
        this.colores = new HashMap<>();
	}
	
	public List<Integer> dfsForest() {
		// Resolver DFS
        Iterator<Integer> iterator = this.grafo.obtenerVertices(); 

        while (iterator.hasNext()) {
            Integer vertice = iterator.next();
            colores.put(vertice, "Blanco");
        }

        System.out.println("====SE SETTEAN TODOS LOS GRAFOS SIN VISITAR====");
        System.out.println(colores);

        int tiempo = 0;

        Iterator<Integer> iteratorColores = this.obtenerColores();

        while(iteratorColores.hasNext()){
            Integer clave = iteratorColores.next();
            String color = colores.get(clave);
            if (color.equals("Blanco")) {
                dfsVisit(clave, tiempo);
            }    
        }

		return new ArrayList<>();
	}

    private void dfsVisit(int idVertice, int tiempo) {
        System.out.println("== SE VISITA EL VERTICE " + idVertice + " Y SE LE ASIGNA EL COLOR AMARILLO ==");

        colores.put(idVertice, "Amarillo");
        //System.out.println(colores);

        tiempo = tiempo + 1;
        
        Iterator<Integer> iteratorAdyacentes = this.grafo.obtenerAdyacentes(idVertice);
        

        while (iteratorAdyacentes.hasNext()){
            Integer clave = iteratorAdyacentes.next();
            
            System.out.println("== ADYACENTES DE " + idVertice + ": " + clave + " CON COLOR " + colores.get(clave) + " ==");
             if(colores.get(clave) == "Blanco"){
                dfsVisit(clave, tiempo);
             }
        }
        
        System.out.println(idVertice + " YA NO TIENE ADYACENTES. SE MARCA DE NEGRO.");
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
