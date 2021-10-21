package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Application lit les sympt�mes d'un fichier, les compte(le nombre
 * d'occurrences) puis les affiche par ligne dasn un nouveau fichier de sortie ;
 * 
 * @author SUBI
 *
 */
public class SymptomsCounter {

	public static void main(String[] args) {

		// Emplacement du fichier de sysmpt�mes
		String inputFileName = "Project02Eclipse/symptoms.txt";
		// Destination du fichier de sortie
		String outputFileName = "result.out";

		List<String> symptomsList = new ArrayList<>();
		Map<String, Integer> symptoms = new TreeMap<String, Integer>();

		// Une instance de la classe AnalyticsCounter
		AnalyticsCounter analyticsCounter = new AnalyticsCounter(inputFileName, outputFileName);
		// Liste re�oie les sysmpt�mes
		symptomsList = analyticsCounter.importInputFile(inputFileName);
		// Map(TreeMap) re�oie
		symptoms = analyticsCounter.getSymptoms(symptomsList);

		analyticsCounter.writeResult(outputFileName, symptoms);

	}
}