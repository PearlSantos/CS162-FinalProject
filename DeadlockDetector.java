import java.io.*;
import java.util.*;


public class DeadlockDetector{

	public static void main(String args[]) throws IOException{
		Scanner br = new Scanner(new FileReader("input.txt"));
		int numOfTestCases = Integer.parseInt(br.nextLine().trim());
		ArrayList<Process> process = new ArrayList<Process>();
		
		for(int i = 0; i < numOfTestCases; i++){
			String[] inputLine = br.nextLine().trim().split(" ");
			int numOfProcesses = Integer.parseInt(inputLine[0].trim());
			int numOfResources = Integer.parseInt(inputLine[1].trim());
			for(int j = 0; j < numOfProcesses; j++){
				Process newProcess = new Process(j);
				for(int k = 0; k < numOfResources; k++){
					Resources res = new Resources(k);
					res.setHeld(br.nextInt());
					newProcess.addResources(res);
					newProcess.resources.set(k, res);
				}
				process.add(newProcess);
				process.set(j, newProcess);
				br.nextLine();
			}
			
			for(int j = 0; j < numOfProcesses; j++){
				Process newProcess = process.get(j);
				for(int k = 0; k < numOfResources; k++){
					Resources res = newProcess.getResources(k);
					res.setMax(br.nextInt() + res.held);
				}
				br.nextLine();
			}
			
		}
		
		//printing input
		for(int i = 0; i < process.size(); i++){
			process.get(i).print();
		}
		
		
	}

}
