import java.util.ArrayList;


public class Grid<T> {
	
	/**
	 * Wrapper class for data in storage as a linked list
	 * @author Mouleendhra
	 *
	 */
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
	
	/**
	 * Adds neighbour to the linked list of data
	 * 
	 * @param data : gets a new neighbour
	 * @param neighbour : to be added as new neighbour
	 */
	public void addNeighbour(T data, T neighbour){
		//Check if data exits 
		Neighbour addTo = new Neighbour(data);
		if(!adjMat.contains(addTo))
			return;
		
		//get neighbour list of data
		Neighbour nbrLL = adjMat.get(adjMat.indexOf(addTo));
		
		//check if neighbour exists - if not add it
		Neighbour toBeAdded = new Neighbour(neighbour);
		if(!adjMat.contains(toBeAdded))
			add(data);
		
		//add neighbour into data's neighbour list
		Neighbour ptr = nbrLL.next;
		while(ptr != null){
			if(ptr.data.equals(toBeAdded))
				return;
			ptr = ptr.next;
		}
		nbrLL.next = toBeAdded;
		return;
	}
	
	/**
	 * Deletes data with its neighbours, and deletes data from 
	 * its neighbours linked lists (neighbour lists)
	 * @param data : data to be deleted
	 */
	public void delete(T data){
		//check if delete exists
		Neighbour delete = new Neighbour(data);
		if(!adjMat.contains(delete))
			return;
		
		//get neighbour list of data
		Neighbour nbrLL = adjMat.get(adjMat.indexOf(delete));
		
		//delete data from the neighbour lists of its neighbours
		Neighbour ptr = nbrLL.next;
		while(ptr != null){
			deleteNeighbour(ptr.data, data);
			ptr = ptr.next;
		}
		
		//delete data
		adjMat.remove(nbrLL);
		return;
	}
	
	/**
	 * Deletes neighbour from data's neighbour list (linked list)
	 * @param data
	 * @param neighbour
	 */
	public void deleteNeighbour(T data, T neighbour){
		//check if data exists
		Neighbour deleteFrom = new Neighbour(data);
		if(!adjMat.contains(deleteFrom))
			return;
		
		//get data's neighbour list
		Neighbour nbrLL = adjMat.get(adjMat.indexOf(deleteFrom));
		
		//delete neighbour from data's neighbour list
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
