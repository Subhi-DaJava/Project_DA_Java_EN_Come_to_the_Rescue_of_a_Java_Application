package com.hemebiotech.analytics;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
/**
 * Lire un fichier dans un dossier, puis le transmet comme les éléments d'une List, enlever les doublons, ranger les éléments 
 * de la liste par l'ordre alphabétique en décomptant le nombres de chaque symptôme et les écrire dans un nouveau fichier de sortie;
 *
 * @author SUBI
 *
 */
public class AnalyticsCounter {	
	public static void main(String args[]) throws IOException {
		
		//Créer une nouvelle liste qui reçoit tous les sysmptôms
		List<String> list = new ArrayList<>();
		
		//Affecter le chemin du fichier à une chaine de carachtères, puis créer un objet qui transforme chaque symptôme en les éléments de cette list
		String fileInputPath = "Project02Eclipse/symptoms.txt";
		ReadSymptomDataFromFile fileToArray = new ReadSymptomDataFromFile(fileInputPath);

		//Utiliser la méthode getSymptoms() de la classe ReadSymptomDataFile qui affecte cette list;		
		list=fileToArray.getSymptoms();
		
		//Générer un fichier de sortie : emplacement du fichier de sortie et instance de la classe FileWriter
		String fileOutPath="result.out";
		FileWriter writer = new FileWriter(fileOutPath);
	
		//Ranger les éléments de cette list par l'ordre alphabétique, puis Donner ses éléments à un LinkedHashList(une liste ordonnée) 
		//c'est pour éliminer les doublons de la list;
		Collections.sort(list);
		Set<String> set = new LinkedHashSet<>();
		set.addAll(list);
		
		//Faire écrire chaque élément du set par ligne avec son nombre de l'occurrence dans le fichier de sortie et afficher le même résultat dans la console
		for(String strLine : set) {
			writer.write(strLine+"="+Collections.frequency(list,strLine)+";\n");
			System.out.println(strLine+"="+Collections.frequency(list,strLine)+";");
		}
		
		writer.close();
			
	}
}
