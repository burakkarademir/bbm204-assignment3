import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;



public class Assignment3 {
	public static void main(String[] args) throws IOException, NumberFormatException, ParseException {

		BufferedReader reader = new BufferedReader(new FileReader(args[0]));
		BufferedReader reader2 = new BufferedReader(new FileReader(args[1]));
		PrintWriter writer = new PrintWriter(args[2], "UTF-8");
		int numberofcluster=Integer.parseInt(args[3]);
		
		List<String> lines = new ArrayList<>();
		List<String> wordpair = new ArrayList<>();
		List<String> wordpairwords = new ArrayList<>();
		List<String> wordpairwords2 = new ArrayList<>();

		String line = null;
		String line2 = null;

		while ((line = reader.readLine()) != null) {
			if(line.length() > 0) {
				lines.add(line);
			}
		}
		while ((line2 = reader2.readLine()) != null) {
			if(line2.length() > 0) {
				wordpair.add(line2);
			}
		}

		int index=0;
		int index2=0;
		
		for(int i=0;i<wordpair.size();i++) {
			wordpairwords.add(wordpair.get(i).split("-")[0]);
			wordpairwords.add(wordpair.get(i).split("-")[1]);
			String[] line3=wordpair.get(i).split("-");
			for(int g=0;g<2;g++) {
				for(int j=0;j<lines.size();j++) {
					if(lines.get(j).split(" ")[0].replace("\"", "").equals(line3[0])) {
						index=j;
					}
					if(lines.get(j).split(" ")[0].replace("\"", "").equals(line3[1])) {
						index2=j;

					}
				}
			}
			Double sum=0.0;
			Double mult=0.0;
			Double mult2=0.0;
			for(int y=1;y<lines.get(index).split(" ").length;y++) {
			

				sum=sum+(Double.parseDouble(lines.get(index).split(" ")[y])*Double.parseDouble(lines.get(index2).split(" ")[y]));
				mult=mult+(Double.parseDouble(lines.get(index).split(" ")[y])*Double.parseDouble(lines.get(index).split(" ")[y]));
				mult2=mult2+(Double.parseDouble(lines.get(index2).split(" ")[y])*Double.parseDouble(lines.get(index2).split(" ")[y]));

			}
		


			Double result=sum/(Math.sqrt(mult)*Math.sqrt(mult2));
		}
		Set<String> set = new HashSet<String>();
		for (String num : wordpairwords) {
		    set.add(num);
		}
		for (String num2 : set) {
		    wordpairwords2.add(num2);
		}
		   int V = lines.size();
	        graph graph = new graph();
	        for(int t=0;t<lines.size();t++) {
	        	for(int r=0;r<lines.size();r++) {
	        		graph.addVertex( lines.get(t).split(" ")[0].replace("\"", ""), lines.get(r).split(" ")[0].replace("\"", ""));
	        	}
	        }
	    
	        Map<String,Map<String,Double> > map2 = new HashMap<String,Map<String,Double> >() ;
    		int edge=0;

	        weightedgraph weighted = new weightedgraph();
	        int numb=0;
	        int numb2=0;
	        Double result=0.0;
	        for(int y=0;y<wordpairwords2.size();y++) {
		        Map<String,Double> map = new HashMap<String, Double>() ;

	        	for(int b=0;b<wordpairwords2.size();b++) {
	        		
	        		
	        		for(int z=0;z<lines.size();z++) {
	        			if(lines.get(z).split(" ")[0].replace("\"", "").equals(wordpairwords2.get(y))) {
	        				numb=z;
	        			}
	        			if(lines.get(z).split(" ")[0].replace("\"", "").equals(wordpairwords2.get(b))) {
	        				numb2=z;
	        			}
	        		}
	        		Double sum=0.0;
	        		Double mult=0.0;
	        		Double mult2=0.0;
	        		for(int z=1;z<lines.get(index).split(" ").length;z++) {
		        				
	        			
	        			sum=sum+(Double.parseDouble(lines.get(numb).split(" ")[z])*Double.parseDouble(lines.get(numb2).split(" ")[z]));
	        			mult=mult+(Double.parseDouble(lines.get(numb).split(" ")[z])*Double.parseDouble(lines.get(numb).split(" ")[z]));
	        			mult2=mult2+(Double.parseDouble(lines.get(numb2).split(" ")[z])*Double.parseDouble(lines.get(numb2).split(" ")[z]));
	        			
	        		}
		        	


	        		result=sum/(Math.sqrt(mult)*Math.sqrt(mult2));	
	        		if(result<0) {
	        			result=1+result;
	        		}
	        		edge=edge+1;
	        		map.put(wordpairwords2.get(b), result);
	        	


	        	}
	
        		map2.put(wordpairwords2.get(y), map);
        		weighted.addVertex(wordpairwords2.get(y),map);
	        }
	        int edge2=0;
	        int edge3=0;

	        Map<String,Integer> numbers = new HashMap<String,Integer>() ;
	        for(int r=0;r<wordpairwords2.size();r++) {
	        	numbers.put( wordpairwords2.get(r),r);
	        }
	        for(int f=0;f<wordpairwords2.size();f++) {
	        	for(int l=f+1;l<wordpairwords2.size();l++) {
	        		if(numbers.get(wordpairwords2.get(f))!=numbers.get(wordpairwords2.get(l))) {

	        			edge3++;
	        		}
	        		
	        	}
	        }
			writer.println(String.valueOf(wordpairwords2.size()));
			writer.println(String.valueOf(edge3));
			for(int f=0;f<wordpairwords2.size();f++) {
	        	for(int l=f+1;l<wordpairwords2.size();l++) {
	        		writer.print(numbers.get(wordpairwords2.get(f))+" ");
	        		writer.print(numbers.get(wordpairwords2.get(l))+" ");
	        		writer.println(map2.get(wordpairwords2.get(f)).get(wordpairwords2.get(l)));

	        	}
			}
			writer.close();
			List<String> mstgr = new ArrayList<>();

			In in = new In(args[2]);
	        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
	        PrimMST mst2 = new PrimMST(G);
	        for (Edge e : mst2.edges()) {
	            mstgr.add(String.valueOf(e));
	        }
	
	        
	        
	        NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
	     		    
			List<Double> mins = new ArrayList<>();
			
		
			int minindex=0;
			Double minimum=11.0;
			for(int r=0;r<numberofcluster-1;r++) {
				for(int g=0;g<mstgr.size();g++) {
		        	if(format.parse(mstgr.get(g).split(" ")[1]).doubleValue()<minimum &&  !mins.contains(format.parse(mstgr.get(g).split(" ")[1]).doubleValue())) {
		        		minimum=format.parse(mstgr.get(g).split(" ")[1]).doubleValue();
		        		minindex=g;
		        	}
		        	
		        }
     		mstgr.remove(minindex);
     		mins.add(minimum);
	    	 minimum=11.0;
	     }
		

			PrintWriter writer2 = new PrintWriter(args[2], "UTF-8");
			writer2.println(String.valueOf(wordpairwords2.size()));
			writer2.println(mstgr.size());

			for(int r=0;r<mstgr.size();r++) {
				writer2.print(mstgr.get(r).split(" ")[0].split("-")[0]+" ");
				writer2.println(mstgr.get(r).split(" ")[0].split("-")[1]+" ");

			}
			writer2.close();
	     


	     In in2 = new In(args[2]);
	        Graph2 G2 = new Graph2(in2);
	        CC cc = new CC(G2);

	        // number of connected components
	        int m = cc.count();

	        // compute list of vertices in each connected component
	        Queue<Integer>[] components = (Queue<Integer>[]) new Queue[m];
	        for (int i = 0; i < m; i++) {
	            components[i] = new Queue<Integer>();
	        }
	        for (int v = 0; v < G.V(); v++) {
	            components[cc.id(v)].enqueue(v);
	        }
			PrintWriter writer3 = new PrintWriter(args[2], "UTF-8");

	        // print results
	        for (int i = 0; i < m; i++) {
	            for (int v : components[i]) {
	                for(Object o:numbers.keySet()){
	                    if(numbers.get(o).equals(v)) {
	                    	writer3.print(o+" ");
	                    }
	                }
	            }
	            writer3.println();
	        }
	        writer3.close();	        	        	        
	        	       	       
	}
}
