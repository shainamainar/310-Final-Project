/**
 * Created by Shaina Mainar 2019
 * GraphADT 310 Project
*/
import java.io.*;

/**
 * * Part 1:
 * * Create undirected graphs of sizes of 10, 100, 10000,100000 nodes
 * * with the number of edges being 80% of nC2
 * * Uses an adjacency matrix to keep track of all adjacent nodes in the graph
 * * Sources: StackOverflow, GeeksforGeeks, TutorialsPoint
*/

public class GraphADT{
	
	//Declare variables
	private int[][] adjMatrix;
	private boolean isDirected;
	private Object[] valOfNodes;
	private int numEdges;
	
	//empty constructor
	public GraphADT(){}
	
	//initialize all variables
	public void init(int numNodes, boolean directed){
		adjMatrix = new int[numNodes][numNodes];
		numEdges = 0;
		isDirected = directed;
		valOfNodes = new Object[numNodes];
	}
	//get number of nodes
	public int getNumNodes(){return valOfNodes.length;}
	//get adjacent nodes
	public int[] getAdj(int target) {
		int count = 0;
        int[] temp;
		int i = 0;
        while(i < valOfNodes.length){
			if (adjMatrix[target][i] != 0)
				count++;
			i++;
		}
        temp = new int[count];
        while(i < valOfNodes.length){
			count = 0;
            if (adjMatrix[target][i] != 0) temp[count++] = i;
			i++;
		}
        return temp;
    }
	//set weight for a node
	public void setVal(int index, int value){ valOfNodes[index] = value;}
	//add edge between nodes
	public void add(int start, int stop, int weight){
		//System.out.println("Start add...");
			if(isDirected){
				//if directed, add weight to edge
				adjMatrix[start][stop] = weight;
				numEdges++;
			}
			else{
				//if undirected, make sure to add adjacency for both nodes
				adjMatrix[start][stop] = weight;
				adjMatrix[stop][start] = weight;
				numEdges++;
			}


	}
	//check to see if a graph is strongly connected
	//Returns false if not strongly connected and return true if strongly connected
	public boolean strongConnectUtils(){
		boolean[] connectArr = new boolean[this.getNumNodes()];
		int[] temp;
		int count = 0;
		boolean back = false;
		int i = 0;
		while(i < this.getNumNodes()){
			temp = new int[this.getNumNodes()];
			temp = this.getAdj(i);
			if(i == 0){
				connectArr[i] = true;
				for(int j = 0; j < temp.length; j++) connectArr[temp[i]] = true;
			}
			else{
				int j = 0;
				while(j < temp.length){
					if(connectArr[temp[j]] == true && back == false){
						j = 0;
						back = true;
						connectArr[i] = true;
					}
					else{
						if((back == true) && connectArr[temp[j]] == false) connectArr[temp[j]] = true;
					}
					j++;
				}
			}
			i++;
		}
		for(i = 0; i < connectArr.length; i++){
			if (connectArr[i] == true) count++;
		}
		if(count == this.getNumNodes()) return true;
		return false;
	}
	//public void toString(){System.out.println(Arrays.toString(adjMatrix).replace("], ", "]\n"));}
	//Print the graph into a file.
	public void toString(String fileName){
		try {
			PrintWriter graphWrite = new PrintWriter(fileName);
			for (int i = 0; i < getNumNodes(); i++) {
				for (int j = 0; j < getNumNodes(); j++) {
					graphWrite.write(Integer.toString(adjMatrix[i][j]) + "\t");
				}
				graphWrite.write("\n");
			}
			graphWrite.close();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
}

