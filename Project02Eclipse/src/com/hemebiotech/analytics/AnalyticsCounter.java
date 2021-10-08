package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
/**
 * Lire un fichier dans un dossier, puis transmet une ArrayList, enlever les doublons, ranger les �l�ments 
 * de la liste par alphab�tique en d�comptant les nombres de chaque sympt�me, �crit dans un nouveau fichier;
 * @author SUBI
 *
 */
public class AnalyticsCounter {	
	public static void main(String args[]) throws IOException {
		//1.Cr�er une nouvelle liste qui re�oit tous les sysmpt�ms
				List<String> arr = new ArrayList<>();
		
		String fileInputPath = "Project02Eclipse/symptoms.txt";
		ReadSymptomDataFromFile fileToArray = new ReadSymptomDataFromFile(fileInputPath);

		//2.Utiliser la m�thode " GetSymptoms" de la Class ReadSymptomDataFile qui affecte la Liste "arr";		
		arr=fileToArray.GetSymptoms();
		
		//3.Cr�er une instance de la classe ArrayToLinkedHashSet, anonyme;
//		new ArrayToLinkedHashSet().listToSet(arr);
		
		//3.g�n�rer un fichier de sortie 
		String fileOutPath="result.out";
		FileWriter writer = new FileWriter(fileOutPath);
	
		//4.Donner les �l�ment de "arr" dans une LinkedHashList(une liste ordonn�e) pour �liminer les doublons 
		//et garder �galement l'ordre alphab�tique de cette ArrayList;
		Set<String> set = new LinkedHashSet<>();
		Collections.sort(arr);
		set.addAll(arr);
		//5.Writing every line with the occurrence of the �l�ment of the ArrayList of arr;
		for(String strLine : set) {
			writer.write(strLine+"="+Collections.frequency(arr,strLine)+";\n");
			System.out.println(strLine+"="+Collections.frequency(arr,strLine)+";");
		}
		
		writer.close();
		
		
	}
}
