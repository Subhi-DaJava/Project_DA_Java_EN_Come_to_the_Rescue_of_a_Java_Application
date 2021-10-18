package com.hemebiotech.analytics;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/**
 * La classe gère pour lire le fichier, symptôme transformé élément d'une liste puis la clé(symptôme) et valeur(nombre d'occurrence) d'un Map,
 * en fin sortir les symptômes  dans un fichier de sortie avec leur nombre d'occurrences;
 * @author Subi
 *
 */
public class AnalyticsCounter {
	//variables de la classe
	private String inputFileName;
	private String outputFileName;
	//Constructeur 
	public AnalyticsCounter(String inputFileName, String outputFileName) {
		this.inputFileName = inputFileName;
		this.outputFileName = outputFileName;
	}

	/**
	 * Importe un fichier, le lit et puis transformer les symptômes comme les éléments d'une liste;
	 * @param inputFileName
	 */
	public List<String> inputFile(String inputFileName) {
		List<String> symptomsList = new ArrayList<>();
		//Chemin d'un fichier à importer et à lire;
		this.inputFileName = inputFileName;
		//Créer un objet d'une classe qui implémente une interface 
		ISymptomReader iSymptomReader = new ReadSymptomDataFromFile(inputFileName);
		//la méthode redéfinée transforme le message d'une ligne d'un fichier vers une liste; 
		symptomsList = iSymptomReader.getSymptoms();
		return symptomsList;
	}
	/**
	 * Fournit les éléments d'une liste à un Map, dont la clé reçoie l'élément de liste et la valeur récupère son nombre d'occurrence,
	 * le map tri par l'ordre alphabétique automatiqument par rapport à la clé et puis renvoie un TreeMap comme un résultat; 
	 * @param symptomsList
	 * @return
	 */
	public TreeMap<String, Integer> getSymptoms(List<String> symptomsList) {
		Map<String, Integer> symptoms = new TreeMap<String, Integer>();
		for (String line : symptomsList) {
			//Si le Map ne contien pas un message d'une ligne qui le rajoute comme une clé et son associé(sa valeur) 1;
			if (!symptoms.containsKey(line)) {
				symptoms.put(line, 1);
			} else {
				//Sinon, on incrémente la valeur à 1;
				symptoms.put(line, symptoms.get(line) + 1);
			}
		}

		return (TreeMap<String, Integer>) symptoms;
	}
	/**
	 * Génerer un fichier de sortie, écrire les symptômes dans ce fichier et même dans la console;
	 * @param outputFileName
	 * @param symptoms
	 * @throws IOException
	 */
	public void writeResult(String outputFileName, Map<String, Integer> symptoms) throws IOException {
		this.outputFileName = outputFileName;
		//Créer un fichier de sortie et son emplacement;
		FileWriter writer = new FileWriter(outputFileName);
		//Itérer chaque pair d'éléments d'un Map, écrire dans un fichier de sortie et affiche dans la console; 
		try{
			for (Map.Entry<String, Integer> m : symptoms.entrySet()) {
			System.out.println(m.getKey() + "=" + m.getValue() + ";");
			writer.write(m.getKey() + "=" + m.getValue() + ";" + "\n");
		}
		writer.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
