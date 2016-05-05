import java.io.*;
import java.util.*;


public class DeadlockDetector{

	public static void main(String args[]) throws IOException{
		Scanner br = new Scanner(new FileReader("trial.txt"));
		int numOfTestCases = br.nextInt();
		ArrayList<Process> process = new ArrayList<Process>();;
		int[] availableRes = null;
		
		for(int i = 0; i < numOfTestCases; i++){
			//String[] inputLine = br.nextLine().trim().split(" ");
			process = new ArrayList<Process>();
			int numOfProcesses = br.nextInt();
			int numOfResources = br.nextInt();
			availableRes = new int[numOfResources];
			for(int j = 0; j < numOfResources; j++){
				availableRes[j] = br.nextInt();
			}
			
			//br.nextLine();
			
			for(int j = 0; j < numOfProcesses; j++){
				Process newProcess = new Process(j + 1);
				for(int k = 0; k < numOfResources; k++){
					Resources res = new Resources(k);
					res.setHeld(br.nextInt());
					newProcess.addResources(res);
					newProcess.resources.set(k, res);
				}
				process.add(newProcess);
				process.set(j, newProcess);
				
			}
			
			for(int j = 0; j < numOfProcesses; j++){
				Process newProcess = process.get(j);
				for(int k = 0; k < numOfResources; k++){
					Resources res = newProcess.getResources(k);
					res.setMax(br.nextInt() + res.held);
				}
				
			}
			
			bankersAlgorithm(process,availableRes);
			
		}
		
		
		
		
	}
	
	public static void bankersAlgorithm( ArrayList<Process> pList, int[] resourceList )
		{ // pList = requesting processes, a = available resources
			String path = "";
			while( !pList.isEmpty() ){
				
				//boolean found = false; // safely allocated to a process?
				boolean safe = false;
				for( int k=0; k < pList.size(); k++ ){
					Process p = pList.get(k);
					System.out.println(p.id);
					for(int i=0; i < resourceList.length; i++){
						int c = p.resources.get(i).held;
						int m = p.resources.get(i).max;
						//int counter = 0;
						 
							if( (m - c) <= resourceList[i] ){ // can allocate resources; grant process' request/s
								 //resourceList[i] = resourceList[i]  + c; // and assume it finishes
								 //pList.remove( p );
								 //counter++;
								 safe = true;
							}
							else{
								safe = false;
								break;
							}
							
							
						}
						
						if(safe){
							for(int i = 0; i < resourceList.length; i++){
								resourceList[i] = resourceList[i]  + p.resources.get(i).held; // and assume it finishes
							}
							path += p.id + " ";
							pList.remove(p);
						}
					
					}
					if( !safe ){
						System.out.println("Deadlock has occurred/will occur.");
						return;
					}
					
					
				}
				
				//to change	
				System.out.println(path);
					
				
			}
		
	}
	
	


