package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
/**
 * Lire un fichier dans un dossier, puis le transmet comme une List, enlever les doublons, ranger les éléments 
 * de la liste par l'ordre alphabétique en décomptant les nombres de chaque symptôme et les écrire dans un nouveau fichier de sortie;
 * @author SUBI
 *
 */
public class AnalyticsCounter {	
	public static void main(String args[]) throws IOException {
		
		//Créer une nouvelle liste qui reçoit tous les sysmptôms
		List<String> list = new ArrayList<>();
		
		String fileInputPath = "Project02Eclipse/symptoms.txt";
		ReadSymptomDataFromFile fileToArray = new ReadSymptomDataFromFile(fileInputPath);

		//Utiliser la méthode getSymptoms() de la classe ReadSymptomDataFile qui affecte la list;		
		list=fileToArray.getSymptoms();
		
		//Générer un fichier de sortie 
		String fileOutPath="result.out";
		FileWriter writer = new FileWriter(fileOutPath);
	
		//Donner les élément de list dans une LinkedHashList(une liste ordonnée) pour éliminer les doublons 
		//et garder également l'ordre alphabétique de cette list;
		Set<String> set = new LinkedHashSet<>();
		Collections.sort(list);
		set.addAll(list);
		
		//Faire écrire chaque élément de set par linge avec son occurrence dan le fichier de sortie et afficher le même résultat dans la console
		for(String strLine : set) {
			writer.write(strLine+"="+Collections.frequency(list,strLine)+";\n");
			System.out.println(strLine+"="+Collections.frequency(list,strLine)+";");
		}
		
		writer.close();
			
	}
}
