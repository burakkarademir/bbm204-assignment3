import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class weightedgraph {
	private Map<String,LinkedList< Map<String,Double> >> vertexMap;

	public weightedgraph() 
	{
	this.vertexMap = new LinkedHashMap<>();
	}

	public void addVertex(String vertex, Map<String, Double> map)
	{
	LinkedList<Map<String, Double>> edgeList = null;
	if(vertexMap.containsKey(vertex))
	edgeList = vertexMap.get(vertex);
	else
	edgeList = new LinkedList<>();
	for(String edge : map.keySet())
	edgeList.addLast(map);
	vertexMap.put(vertex, edgeList);
	}

	public void print()
	{
	for(Entry<String, LinkedList<Map<String, Double>>> entry : vertexMap.entrySet())
	{
	System.out.print(entry.getKey());
	for(Map<String, Double> edge : entry.getValue())
	{
	System.out.print("-->" + edge);
	}
	System.out.println();
	}
}
}
