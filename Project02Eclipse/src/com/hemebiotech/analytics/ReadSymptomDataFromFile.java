package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 *@author Caroline
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
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		//Si le fichier n'est pas vide
		if (filepath != null) {
			//Gestion d'exception
			try {
				//Rec�oit le fichier  
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				//Lire chaque linge, cr�e une cha�ne de caract�res
				String line = reader.readLine();
				
				//Transmet la ligne(la cha�ne de caract�res) � un �l�ment d'une liste avec la boucle
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				//Arr�t de lire
				reader.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
