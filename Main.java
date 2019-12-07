import java.util.Random;

/**
 * Main class driver.
 * Also contains a helper method called populate that populates a GraphADT
 * Sources: StackOverflow, GeeksforGeeks
 * */

public class Main{
	//Driver
	public static void main(String[] args){
		GraphADT graph1 = new GraphADT();
		graph1.init(10,false);
		graph1 = populate(graph1);
		graph1.toString("graph1_undirected.txt");
		System.out.println("----------Graph 1 Finished----------\n");

		GraphADT graph2 = new GraphADT();
		graph2.init(100, false);
		graph2 = populate(graph2);
		graph2.toString("graph2_undirected.txt");
		System.out.println("----------Graph 2 Finished----------\n");
		GraphADT graph3 = new GraphADT();
		//System.out.println("here");
		graph3.init(10000,false);
		graph3 = populate(graph3);
		graph3.toString("graph3_undirected.txt");
		System.out.println("----------Graph 3 Finished----------\n");
		GraphADT graph4 = new GraphADT();
		graph4.init(10000,false);
		graph4 = populate(graph4);
		graph4.toString("graph4_undirected.txt");
		System.out.println("----------Graph 4 Finished----------\n");
		System.out.println("here");
		long start = System.nanoTime();
		System.out.println("Start");
		System.out.println("Graph is strongly connected? " + graph1.strongConnectUtils());
		long end = System.nanoTime();
		long totalTime = (end - start);
		System.out.print("Total time: ");
		System.out.println(totalTime);

		//Used generic bipartite graph to demonstrate.
		GraphADT bipartite = new GraphADT();
		bipartite.init(5,true);
		for (int i =0; i < 5; i++){
			bipartite.setVal(i,i+1);//sets the value of each node to a value greater than one
		}
		bipartite.add(0,1,5);
		bipartite.add(0,2,5);
		bipartite.add(1,3,4);
		bipartite.add(4,1,3);
		bipartite.toString("bipartiteGraph.txt");


	}
	//Populates the graph with random values using the Random library
	public static GraphADT populate(GraphADT graph){
		Random rand = new Random(); //unseeded
		Random rand1 = new Random();
/*
		int num1 = factorial(graph.getNumNodes());
		int num2 = factorial(2);
		int num3 = factorial(graph.getNumNodes() - 2);

		int combinations = num1 / (num2 * num3);
*/

		//System.out.print(combinations);
		for (int i = 0; i < graph.getNumNodes(); i++) {
			graph.setVal(i, i);
			//System.out.println("Loading...");
			int temp = rand.nextInt();
			for (int j = 0; j < (graph.getNumNodes()/3); j++){
				temp = rand.nextInt(graph.getNumNodes());
				while(temp == i) temp = rand.nextInt(graph.getNumNodes());
				int weight = rand1.nextInt(20);
				graph.add(i, temp, weight);
			}
			//int j = 0;
			/*while (temp != i && j < combinations) {
				temp = rand.nextInt(graph.getNumNodes());
				System.out.println("Temp = " + temp);
				int weight = rand1.nextInt(25) + 1;
				System.out.println("Weight = " + weight);
				graph.add(i, temp, weight);
				j++;
				System.out.println("J = " + j);
			}*/
			//System.out.println("----------END-------\n");
		}
		return graph;
	}
	/*public static int factorial(int n) {
		int fact = 1;
		int i = 1;
		while(i <= n) {
			fact *= i;
			i++;
		}
		return fact;
	}*/
}
