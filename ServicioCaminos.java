import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ServicioCaminos {
	private Grafo<?> grafo;
	private int origen;
	private int destino;
	private int lim;
	private HashMap<Integer, String> colores;

	// Servicio caminos
	public ServicioCaminos(Grafo<?> grafo, int origen, int destino, int lim) {
		this.grafo = grafo;
		this.origen = origen;
		this.destino = destino;
		this.lim = lim;
		this.colores = new HashMap<>();
	}

	public List<List<Integer>> caminos() {
		// Resolver Caminos
		List<List<Integer>> caminosPosibles = new ArrayList<>(); // []
		List<Integer> caminoActual = new ArrayList<>(); // []

		if (grafo.existeVertice(origen) && this.grafo.existeVertice(destino)) {

			Iterator<Integer> iterator = this.grafo.obtenerVertices();
			while (iterator.hasNext()) {
				Integer vertice = iterator.next();
				colores.put(vertice, "Blanco");
			}

			dfsCaminos(origen, caminoActual, caminosPosibles);

		} else {
			System.out.println("El origen o el destino son invalidos");
		}
		System.out.println(caminosPosibles);
		return caminosPosibles;
	}

	private void dfsCaminos(int vertice, List<Integer> caminoActual, List<List<Integer>> caminosPosibles) {

		if (vertice == destino && caminoActual.size() <= this.lim) {
			System.out.println("Posible camino encontrado");
			caminosPosibles.add(new ArrayList<>(caminoActual));
		} else {
			System.out.println("Visito " + vertice);
			colores.put(vertice, "Amarillo");
			caminoActual.add(vertice);

			Iterator<Integer> iteratorAdyacentes = this.grafo.obtenerAdyacentes(vertice);

			while (iteratorAdyacentes.hasNext()) {
				Integer clave = iteratorAdyacentes.next();

				if (colores.get(clave) == "Blanco") {
					dfsCaminos(clave, caminoActual, caminosPosibles);
				}
				
			}

			colores.put(vertice, "Blanco");
			caminoActual.remove(caminoActual.size() - 1);


		}


	}


}
