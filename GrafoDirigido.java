import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {

    private HashMap<Integer, ArrayList<Arco<T>>> vertices;

    public GrafoDirigido(HashMap<Integer, ArrayList<Arco<T>>> vertices) {
        this.vertices = vertices;
        
    }

    @Override
    public void agregarVertice(int verticeId) {
        if (!existeVertice(verticeId)) { // Si no existe, lo agrego
            System.out.println("El vertice con Id " + verticeId + " fue agregado.");
            vertices.put(verticeId, new ArrayList<Arco<T>>());
        } else {
            System.out.println("El vertice con Id " + verticeId + " ya existe.");
        }
    }

    @Override
    public void borrarVertice(int verticeId) {
        if(existeVertice(verticeId)){ //Si existe
            for (ArrayList<Arco<T>> arcos : vertices.values()) {
                for(int i=0; i < arcos.size(); i++){
                    if(arcos.get(i).getVerticeDestino() == verticeId || arcos.get(i).getVerticeOrigen() == verticeId){      //Borro conexiones de otros vertices a ese vertice
                        arcos.remove(i);
                    }
                }
            }
            this.vertices.remove(verticeId);   //Borro de la lista de vertices
        }else{
            System.out.println("El vertice con la Id " + verticeId + " no existe.");
        }
    }

    @Override
    public boolean existeVertice(int verticeId){
        return vertices.containsKey(verticeId);
    }


    @Override
    public void agregarArco(int verticeOrigen, int verticeDestino, T datoArco) {
        if (existeVertice(verticeOrigen) && existeVertice(verticeDestino)) {  //Si existe el Vertice
            if(!existeArco(verticeOrigen, verticeDestino)){ //Si no existe el Arco
                //Guardo los arcos del verticeOrigen
                Arco<T> arco = new Arco<T>(verticeOrigen, verticeDestino, datoArco); //Creo un nuevo arco con los valores
                this.vertices.get(verticeOrigen).add(arco); 
                System.out.println("Arco " + verticeOrigen + "-" + verticeDestino + " fue agregado.");
            }else{
                System.out.println("Arco " + verticeOrigen + "-" + verticeDestino + " ya existe.");
            }                                                   
        } else {
            System.out.println("No se encontro vertice");
        }
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        ArrayList<Arco<T>> arcosVertice = vertices.get(verticeId1); //Guardo los arcos del verticeOrigen
        for (Arco<T> arco : arcosVertice) { //Recorro los arcos del verticeOrigen
            if (arco.getVerticeOrigen() == verticeId1 && arco.getVerticeDestino() == verticeId2) {
                return true;  //Retorno si ya existe arco con ese Origen y Destino
            }
        }
        return false;
    }


    @Override
    public String toString() {
        return "GrafoDirigido [vertices=" + vertices + "]";
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        if (existeVertice(verticeId1) && existeVertice(verticeId2)) { 
			Iterator<Arco<T>> it = obtenerArcos(verticeId1); 
			while (it.hasNext()) { 
				Arco<T> arco = it.next(); 
				if (arco.getVerticeDestino() == verticeId2) {
					return arco;
				}
			}
		}
		return null;
    }

    @Override
    public Iterator<Integer> obtenerVertices() {
        return vertices.keySet().iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        Iterator<Integer> it = obtenerVertices(); 
		ArrayList<Arco<T>> arcos = new ArrayList<>();
	
		while (it.hasNext()) { 
			Integer vertice = it.next(); 
			arcos.addAll(this.vertices.get(vertice)); 
		}
		return arcos.iterator();
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        ArrayList<Integer> adyacentes = new ArrayList<>();
		if (existeVertice(verticeId)) { 
			Iterator<Arco<T>> it = obtenerArcos(verticeId); 
			
			while (it.hasNext()) { 
				Arco<T> arco = it.next(); 
				adyacentes.add(arco.getVerticeDestino()); 
			}
		}
		return adyacentes.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        ArrayList<Arco<T>> arcos = new ArrayList<>();
		if (existeVertice(verticeId)) { 
			arcos = this.vertices.get(verticeId); 
		}
		return arcos.iterator();
    }

    

}
