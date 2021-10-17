package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * getSymptoms(); countSymptoms();sortSymptoms();writeSymptoms(); String
 * fileName; List<String>; String inputFileName; String outputFileName;
 * Project02Eclipse/symptoms.txt
 * 
 * @author zulfy
 *
 */
public class SymptomsCounter {

	public static void main(String[] args) throws IOException {

		try {
			String inputFileName = "Project02Eclipse/symptoms.txt";
			String outputFileName = "result.out";
			
			List<String> symptomsList = new ArrayList<>();
			Map<String, Integer> symptoms = new TreeMap<String, Integer>();
			

			AnalyticsCounter analyticsCounter = new AnalyticsCounter(inputFileName, outputFileName);
			symptomsList = analyticsCounter.inputFile(inputFileName);

			symptoms = analyticsCounter.getSymptoms(symptomsList);
		
			analyticsCounter.writeResult(outputFileName, symptoms);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}