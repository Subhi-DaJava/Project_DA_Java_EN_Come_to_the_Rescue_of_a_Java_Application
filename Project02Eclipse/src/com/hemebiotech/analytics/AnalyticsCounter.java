package com.hemebiotech.analytics;

import java.io.FileWriter;
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

	public static void main(String args[]) throws Exception {
		
		//1.Créer une nouvelle liste qui reçoit tous les sysmptôms
				List<String> arr1 = new ArrayList<>();
		try {
		String fileInputPath = "Project02Eclipse/symptoms.txt";
		ReadSymptomDataFromFile fileToArray = new ReadSymptomDataFromFile(fileInputPath);

		//2.Utiliser la méthode " GetSymptoms" de la Class ReadSymptomDataFile qui affecte la Liste "arr1";
		arr1=fileToArray.GetSymptoms();
		}catch(Exception e){
			e.printStackTrace();
		}
	
		//3.Mettre les élément dans l'orldre alphabétique en utilisant la méthode(sort())de Class Collection;
		Collections.sort(arr1);
		
		
		//4.Donner les élément de "arr1" dans une LinkedHashList(une liste ordonnée) pour éliminer les doublons 
		//et garder également l'ordre alphabétique de cette ArrayList;
		Set<String> set = new LinkedHashSet<>();
		set.addAll(arr1);
		
		//5.Afficher le résultat dans le console
		for(String lesultat : set) {
			System.out.println(lesultat+"="+Collections.frequency(arr1, lesultat));
		}
		System.out.println("Total: "+set.size()+" symptômes existent danc ce fichier.");
		
	
		//6.générer un fichier de sortie 
		String fileOutPath="c:/users/zulfy/git/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/result.out";
		
		FileWriter writer = new FileWriter(fileOutPath);
		
		//Writing every line with the occurrence of the élément of the ArrayList of arr1;
		for(String strLine :set) {
			writer.write(strLine+"="+Collections.frequency(arr1,strLine)+"\n");
		}
		writer.close();
		
		
	}
}
