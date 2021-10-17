package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
		List<String> symptomsList = new ArrayList<>();
		this.inputFileName = inputFileName;
		ISymptomReader iSymptomReader = new ReadSymptomDataFromFile(inputFileName);
		symptomsList = iSymptomReader.getSymptoms();
		return symptomsList;
	}

	public TreeMap<String, Integer> getSymptoms(List<String> symptomsList) {
		Map<String, Integer> symptoms = new TreeMap<String, Integer>();
		for (String line : symptomsList) {
			if (!symptoms.containsKey(line)) {
				symptoms.put(line, 1);
			} else {
				symptoms.put(line, symptoms.get(line) + 1);
			}
		}

		return (TreeMap<String, Integer>) symptoms;
	}

	public void writeResult(String outputFileName, Map<String, Integer> symptoms) throws IOException {
		this.outputFileName = outputFileName;
		FileWriter writer = new FileWriter(outputFileName);
		for (Map.Entry<String, Integer> m : symptoms.entrySet()) {
			System.out.println(m.getKey() + "=" + m.getValue() + ";");
			writer.write(m.getKey() + "=" + m.getValue() + ";" + "\n");
		}
		writer.close();
	}
}
