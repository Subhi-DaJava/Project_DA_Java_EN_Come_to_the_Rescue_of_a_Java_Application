package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	private String inputFileName;
	private String outputFileName;
public AnalyticsCounter(String inputFileName, String outputFileName) {
		this.inputFileName = inputFileName;
		this.outputFileName = outputFileName;
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
		for (String symptom : list) {

			if (!map.containsKey(symptom)) {
				map.put(symptom, 1);
			} else {
				map.put(symptom, map.get(symptom) + 1);
			}
		}

		return map;

	}

	public TreeMap<String, Integer> sortSymptoms(Map<String, Integer> map) {
		TreeMap<String, Integer> sortedMap = new TreeMap<>();
		sortedMap.putAll(map);
		return sortedMap;
	}

	public void writeSymptoms(String outputFileName, TreeMap<String, Integer> sortedMap) throws IOException {

		this.outputFileName = outputFileName;
		FileWriter writer = new FileWriter(outputFileName);

		for (Map.Entry<String, Integer> m : sortedMap.entrySet()) {

			System.out.println(m.getKey() + "=" + m.getValue() + ";");
			writer.write(m.getKey() + "=" + m.getValue() + ";" + "\n");
		}
		writer.close();
	}
}
