package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * La classe g�re pour lire le fichier, sympt�me transform� �l�ment d'une liste
 * puis la cl�(sympt�me) et valeur(nombre d'occurrence) d'un Map, en fin sortir
 * les sympt�mes dans un fichier de sortie avec leur nombre d'occurrences;
 * 
 * @author Subi
 *
 */
public class AnalyticsCounter {
	// variables de la classe
	private String inputFileName;
	private String outputFileName;

	public String getInputFileName() {
		return inputFileName;
	}

	public String getOutputFileName() {
		return outputFileName;
	}

	// Constructeur
	public AnalyticsCounter(String inputFileName, String outputFileName) {
		this.inputFileName = inputFileName;
		this.outputFileName = outputFileName;
	}

	/**
	 * Importer un fichier, le lire et puis transformer les sympt�mes comme les
	 * �l�ments d'une liste;
	 * 
	 * @param inputFileName
	 */
	public List<String> importInputFile(String inputFileName) {
		List<String> symptomsList = new ArrayList<>();
		// Chemin d'un fichier � importer et � lire;
		this.inputFileName = inputFileName;
		// Cr�er un objet d'une classe qui impl�mente une interface
		ISymptomReader iSymptomReader = new ReadSymptomDataFromFile(inputFileName);
		// la m�thode red�fin�e transforme le message d'une ligne d'un fichier vers une
		// liste;
		symptomsList = iSymptomReader.getSymptoms();
		return symptomsList;
	}

	/**
	 * Fournir les �l�ments d'une liste � un Map, dont la cl� re�oie l'�l�ment de
	 * liste et la valeur r�cup�re son nombre d'occurrence, le map tri par l'ordre
	 * alphab�tique automatiqument par rapport � la cl� et puis renvoie un TreeMap
	 * comme un r�sultat;
	 * 
	 * @param symptomsList
	 * @return
	 */
	public TreeMap<String, Integer> getSymptoms(List<String> symptomsList) {
		Map<String, Integer> symptoms = new TreeMap<String, Integer>();
		for (String line : symptomsList) {
			// Si le Map ne contien pas un message d'une ligne qui le rajoute comme une cl�
			// et son associ�(sa valeur) 1;
			if (!symptoms.containsKey(line)) {
				symptoms.put(line, 1);
			} else {
				// Sinon, on incr�mente la valeur � 1;
				symptoms.put(line, symptoms.get(line) + 1);
			}
		}

		return (TreeMap<String, Integer>) symptoms;
	}

	/**
	 * G�nerer un fichier de sortie, �crire les sympt�mes dans ce fichier et m�me
	 * dans la console;
	 * 
	 * @param outputFileName
	 * @param symptoms
	 *
	 */
	public void writeResult(String outputFileName, Map<String, Integer> symptoms) {
		FileWriter writer = null;
		// Cr�er un fichier de sortie et son emplacement;
		try {
			this.outputFileName = outputFileName;
			writer = new FileWriter(outputFileName);
			// It�rer chaque pair d'�l�ments d'un Map, �crire dans un fichier de sortie et
			// affiche dans la console;

			for (Map.Entry<String, Integer> m : symptoms.entrySet()) {
				System.out.println(m.getKey() + "=" + m.getValue() + ";");
				writer.write(m.getKey() + "=" + m.getValue() + ";" + "\n");
			}

		} catch (Exception e) {
			System.out.println("Impossible d'�crire les symptoms, v�rifiez le fichier de sortie.");
			e.printStackTrace();
		} finally {
			if (writer != null)
				try {
					writer.close();
				} catch (IOException e) {
					System.out.println("Impossible de fermer d'�criture !");
					e.printStackTrace();
				}
		}

	}
}
