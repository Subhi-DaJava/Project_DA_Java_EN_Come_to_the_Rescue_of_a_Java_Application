package com.hemebiotech.analytics;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

 

public class AnalyticsCounter {	
	
	private String inputFileName, outputFileName;

	public AnalyticsCounter(String inputFileName, String outputFileName) {
		this.inputFileName=inputFileName;
		this.outputFileName=outputFileName;
	}
	
	/**
	 * 
	 * @param inputFileName
	 */
	public List<String> inputFile(String inputFileName) {
		List<String> list = new ArrayList<>();
		this.inputFileName = inputFileName;
		ISymptomReader iSymptomReader = new ReadSymptomDataFromFile(inputFileName);
		list = iSymptomReader.getSymptoms();
		return list;
	}
	
	
	public Map<String, Integer> listToMap(List<String> list) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(String symptom : list) {
			
			if(!map.containsKey(symptom)) {
				map.put(symptom,1);
			}
			else {
				map.put(symptom,map.get(symptom)+1);
			}	
		}

		return map;
		
	}
	
	
	public void writeSymptoms(String outputFileName, Map<String,Integer> map) throws IOException {
	
		this.outputFileName=outputFileName;
			FileWriter writer = new FileWriter(outputFileName);
			
		for(Map.Entry<String,Integer> m:map.entrySet()){ 
			
			System.out.println(m.getKey()+"="+m.getValue()+";");
			writer.write(m.getKey()+"="+m.getValue()+";"+"\n");;
		  }  
		writer.close();	
	}
}
