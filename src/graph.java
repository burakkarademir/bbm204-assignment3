import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class graph {
	

	
	private Map<String,LinkedList<String>> vertexMap;

	public graph() 
	{
	this.vertexMap = new LinkedHashMap<>();
	}

	public void addVertex(String vertex, String... edges)
	{
	LinkedList<String> edgeList = null;
	if(vertexMap.containsKey(vertex))
	edgeList = vertexMap.get(vertex);
	else
	edgeList = new LinkedList<>();
	for(String edge : edges)
	edgeList.addLast(edge);
	vertexMap.put(vertex, edgeList);
	}

	public void print()
	{
	for(Entry<String,LinkedList<String>> entry : vertexMap.entrySet())
	{
	System.out.print(entry.getKey());
	for(String edge : entry.getValue())
	{
	System.out.print("-->" + edge);
	}
	System.out.println();
	}
}
}
