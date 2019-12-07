# 310-Final-Project
CSCI310: Advanced Algorithms final GraphADT project

## The Logic

I used an adjacency matrix in conjuctions to an array for each node with values instead of an adjacency list because it was too complex for me to try to use yet another data structure such as a LinkedList.  

### The GraphADT Class
The GraphADT class creates a GraphADT object that takes in a number of nodes and whether or not the graph will be directed.  
This class only has the necessary getters and setters needed for the purposes of the project; it is not the most robust.  

The adjacency matrix stores indices of node values and the array assigned to each node holds the value/weight of that particular edge. 
The value is available through the getVal method. 
The class also has a strongConnectUtils method that checks if a graph is strongly connected. I thought that it would be easier to have the utils method be within the GraphADT object rather than outside. 

The toString method prints the adjacency matrix contents into a file. It was easier to see the bigger picture in a file rather than in the output terminal. 

### The Main Class
The Main method merely acts as a driver that calls and tests the GraphADT.

The populate method populates the GraphADT being passed into it. It made more sense to have this helper method in the main class rather than the GraphADT class because scalability. It is best if the GraphADT class remains as generic as possible. 
