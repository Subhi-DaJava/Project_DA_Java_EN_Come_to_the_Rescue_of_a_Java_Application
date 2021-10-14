package com.hemebiotech.analytics;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * Lire un fichier dans un dossier, puis le transmet comme les �l�ments d'une List, enlever les doublons, ranger les �l�ments 
 * de la liste par l'ordre alphab�tique en d�comptant le nombres de chaque sympt�me et les �crire dans un nouveau fichier de sortie;
 *
 * @author SUBI
 *
 */
public class AnalyticsCounter {	
	String inputFileName, outputFileName;
	List<String> list = new ArrayList<>();
	
	public AnalyticsCounter(String inputFileName, String outputFileName) {
		this.inputFileName=inputFileName;
		this.outputFileName=outputFileName;
		
	}
	
	/**
	 * 
	 * @param inputFileName
	 */
	public List<String> inputFile(String inputFileName) {
	ISymptomReader iSymptomReader = new ReadSymptomDataFromFile(inputFileName);
	this.list = iSymptomReader.getSymptoms();
	this.inputFileName = inputFileName;
	return list;
	}
	//Affecter le chemin du fichier � une chaine de caracht�res, puis cr�er un objet qui transforme chaque sympt�me en les �l�ments de cette list
	
	public void writeFilePath(String outputFileName) {
	outputFileName="result.out";
	FileWriter writer = new FileWriter(outputFileName);
	this.outputFileName =outputFileName;
	writer.close();
	}
	
	public List<String> sort(List<String> list) {
		this.list=list;
		Collections.sort(list);
		return list;
		
		}
public static Map<String, Integer> listToMap(List<String> list) {
		
		Map<String, Integer> map = new HashMap<>();
	
		for(int i=0; i < list.size(); i++) {
			String key= list.get(i);
			if(!map.containsKey(key)) {
				map.put(key,1);
			}
			else {
				map.put(list.get(i),map.get(key)+1);
			}
			
		}
		return map;
	}
	//Cr�er une nouvelle liste qui re�oit tous les sysmpt�ms
	//List<String> list = new ArrayList<>();
		
	for(String strLine : set) {
		
		}
					
}
