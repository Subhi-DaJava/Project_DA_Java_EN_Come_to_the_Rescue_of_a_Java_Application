package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
/**
 * Lire un fichier dans un dossier, puis transmet une ArrayList, enlever les doublons, ranger les éléments 
 * de la liste par alphabétique en décomptant les nombres de chaque symptôme, écrit dans un nouveau fichier;
 * @author SUBI
 *
 */
public class AnalyticsCounter {	
	public static void main(String args[]) throws IOException {
		//1.Créer une nouvelle liste qui reçoit tous les sysmptôms
				List<String> arr = new ArrayList<>();
		
		String fileInputPath = "Project02Eclipse/symptoms.txt";
		ReadSymptomDataFromFile fileToArray = new ReadSymptomDataFromFile(fileInputPath);

		//2.Utiliser la méthode " GetSymptoms" de la Class ReadSymptomDataFile qui affecte la Liste "arr";		
		arr=fileToArray.GetSymptoms();
		
		//3.Créer une instance de la classe ArrayToLinkedHashSet, anonyme;
//		new ArrayToLinkedHashSet().listToSet(arr);
		
		//3.générer un fichier de sortie 
		String fileOutPath="result.out";
		FileWriter writer = new FileWriter(fileOutPath);
	
		//4.Donner les élément de "arr" dans une LinkedHashList(une liste ordonnée) pour éliminer les doublons 
		//et garder également l'ordre alphabétique de cette ArrayList;
		Set<String> set = new LinkedHashSet<>();
		Collections.sort(arr);
		set.addAll(arr);
		//5.Writing every line with the occurrence of the élément of the ArrayList of arr;
		for(String strLine : set) {
			writer.write(strLine+"="+Collections.frequency(arr,strLine)+";\n");
			System.out.println(strLine+"="+Collections.frequency(arr,strLine)+";");
		}
		
		writer.close();
		
		
	}
}
