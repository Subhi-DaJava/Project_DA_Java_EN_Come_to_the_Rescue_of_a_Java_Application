package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 * 
 * @author Caroline
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		BufferedReader reader = null;
		// Si le fichier n'est pas vide
		if (filepath != null) {
			// Gestion d'exception
			try {
				// Recçoit le fichier
				 reader = new BufferedReader(new FileReader(filepath));
				// Lire chaque linge, crée une chaîne de caractères
				String line = reader.readLine();

				// Transmet la ligne(la chaîne de caractères) à un élément d'une liste avec la
				// boucle
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Impossible de lire les symptoms, vérifiez le fichier d'entrée !");
			}
			// Arrêt de lecture
			finally {
				if(reader!=null)
					try {
						reader.close();
					} catch (IOException e) {
						System.out.println("Impossible de fermer de lecture !");
						e.printStackTrace();
					}
			}
		}

		return result;
	}

}
