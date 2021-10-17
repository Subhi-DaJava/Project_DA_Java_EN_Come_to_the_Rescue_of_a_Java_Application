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
public class Application {

	public static void main(String[] args) throws IOException {

		try {
			String inputFileName = "Project02Eclipse/symptoms.txt";
			String outputFileName = "result.out";
			
			List<String> list = new ArrayList<>();
			Map<String, Integer> map = new HashMap<String, Integer>();
			
			TreeMap<String, Integer> sortedMap = new TreeMap<>();

			AnalyticsCounter analyticsCounter = new AnalyticsCounter(inputFileName, outputFileName);
			list = analyticsCounter.inputFile(inputFileName);

			map = analyticsCounter.listToMap(list);
			sortedMap = analyticsCounter.sortSymptoms(map);

			analyticsCounter.writeSymptoms(outputFileName, sortedMap);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}