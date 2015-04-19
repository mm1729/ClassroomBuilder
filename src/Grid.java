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
	}
	ArrayList<Neighbour> adjMat; //stores students with their neighbors as linked lists

	int size;
	int width, length;
	
	public Grid(int size){
		this.size = size;
		adjMat = new ArrayList<Neighbour>();
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
		if(nbrLL == null)
			return;
		
		Neighbour ptr = nbrLL.next;
		while(ptr != null){
			if(ptr.data.equals(neighbour))
				return;
			ptr = ptr.next;
		}
		nbrLL.next = new Neighbour(neighbour, nbrLL.next);
	}
	
	public void delete(T data){
		
	}
	public void deleteNeighbour(T data, T neighbour){
		
	}
}
