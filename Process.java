import java.util.*;
public class Process{
	int id;
	public ArrayList<Resources> resources = new ArrayList<Resources>();
	
	public Process(int id){
		this.id = id;
	}
	
	public void addResources(Resources res){
		this.resources.add(res);
	}
	
	public Resources getResources(int index){
		return this.resources.get(index);
	}
	
	public void print(){
		System.out.println("Process " + id);
		for(Resources a: resources){
			System.out.println("Resource " + a.id);
			System.out.println("Held: " + a.held);
			System.out.println("Max: " + a.max);
		}
		
	}
}