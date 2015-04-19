import java.util.ArrayList;


public class Grid<T> {
	
	class Neighbour{
		T data; Neighbour next;
		public Neighbour(T data){
			this.data = data;
			this.next = null;
		}
		
		public Neighbour(T data, Neighbour next){
			this.data = data;
			this.next = next;
		}
		
		public boolean equals(Neighbour other){
			return (this.data.equals(other.data));
		}
		
		
	}
	ArrayList<Neighbour> adjMat; //stores students with their neighbors as linked lists

	int size;
	int width, length;
	
	public Grid(int size){
		this.size = size;
		adjMat = new ArrayList<Neighbour>(size);
	}
	
	/**
	 * adds data to grid. if data already exits, nothing is added
	 * @param data: data to be added
	 */
	public void add(T data){
		if(adjMat.contains(data))
			return;
		adjMat.add(new Neighbour(data));
		return;
	}
	
	public void addNeighbour(T data, T neighbour){
		Neighbour addTo = new Neighbour(data);
		if(!adjMat.contains(addTo))
			return;
		
		Neighbour nbrLL = adjMat.get(adjMat.indexOf(addTo));
		
		Neighbour ptr = nbrLL.next;
		while(ptr != null){
			if(ptr.data.equals(neighbour))
				return;
			ptr = ptr.next;
		}
		nbrLL.next = new Neighbour(neighbour, nbrLL.next);
		return;
	}
	
	public void delete(T data){
		Neighbour delete = new Neighbour(data);
		if(!adjMat.contains(delete))
			return;
		
		Neighbour nbrLL = adjMat.get(adjMat.indexOf(delete));
		
		Neighbour ptr = nbrLL.next;
		while(ptr != null){
			deleteNeighbour(ptr.data, data);
			ptr = ptr.next;
		}
		
		adjMat.remove(nbrLL);
		return;
	}
	
	public void deleteNeighbour(T data, T neighbour){
		Neighbour deleteFrom = new Neighbour(data);
		if(!adjMat.contains(deleteFrom))
			return;
		
		Neighbour nbrLL = adjMat.get(adjMat.indexOf(deleteFrom));
		
		Neighbour ptr = nbrLL.next, prev = nbrLL;
		while(ptr != null){
			if(ptr.data.equals(neighbour))
				prev.next = ptr.next;
			ptr = ptr.next;
			prev = prev.next;
		}
		return;
	}
	
}
