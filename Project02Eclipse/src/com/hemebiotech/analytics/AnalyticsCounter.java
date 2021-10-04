package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.io.FileWriter;
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

	public static void main(String args[]) throws FileNotFoundException {
		
		//1.Cr�er une nouvelle liste qui re�oit tous les sysmpt�ms
				List<String> arr1 = new ArrayList<>();
		
		String fileInputPath = "Project02Eclipse/symptoms.txt";
		ReadSymptomDataFromFile fileToArray = new ReadSymptomDataFromFile(fileInputPath);

		//2.Utiliser la m�thode " GetSymptoms" de la Class ReadSymptomDataFile qui affecte la Liste "arr1";		
		arr1=fileToArray.GetSymptoms();
		
		//3.Cr�er un instance de la classe ArrayToLinkedHashSet, anonyme;
		new ArrayToLinkedHashSet().listToSet(arr1);
		
		//3.g�n�rer un fichier de sortie 
		String fileOutPath="c:/users/zulfy/git/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/result.out";
		FileWriter writer = new FileWriter(fileOutPath);
	
		//4.Donner les �l�ment de "arr1" dans une LinkedHashList(une liste ordonn�e) pour �liminer les doublons 
		//et garder �galement l'ordre alphab�tique de cette ArrayList;
		Set<String> set = new LinkedHashSet<>();
		set.addAll(arr1);
	
		//5.Writing every line with the occurrence of the �l�ment of the ArrayList of arr1;
		for(String strLine : set) {
			writer.write(strLine+"="+Collections.frequency(arr1,strLine)+"\n");
		}
		writer.close();
		
		
	}
}
