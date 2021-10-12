package com.hemebiotech.analytics;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
/**
 * Lire un fichier dans un dossier, puis le transmet comme les �l�ments d'une List, enlever les doublons, ranger les �l�ments 
 * de la liste par l'ordre alphab�tique en d�comptant le nombres de chaque sympt�me et les �crire dans un nouveau fichier de sortie;
 *
 * @author SUBI
 *
 */
public class AnalyticsCounter {	
	public static void main(String args[]) throws IOException {
		
		//Cr�er une nouvelle liste qui re�oit tous les sysmpt�ms
		List<String> list = new ArrayList<>();
		
		//Affecter le chemin du fichier � une chaine de caracht�res, puis cr�er un objet qui transforme chaque sympt�me en les �l�ments de cette list
		String fileInputPath = "Project02Eclipse/symptoms.txt";
		ReadSymptomDataFromFile fileToArray = new ReadSymptomDataFromFile(fileInputPath);

		//Utiliser la m�thode getSymptoms() de la classe ReadSymptomDataFile qui affecte cette list;		
		list=fileToArray.getSymptoms();
		
		//G�n�rer un fichier de sortie : emplacement du fichier de sortie et instance de la classe FileWriter
		String fileOutPath="result.out";
		FileWriter writer = new FileWriter(fileOutPath);
	
		//Ranger les �l�ments de cette list par l'ordre alphab�tique, puis Donner ses �l�ments � un LinkedHashList(une liste ordonn�e) 
		//c'est pour �liminer les doublons de la list;
		Collections.sort(list);
		Set<String> set = new LinkedHashSet<>();
		set.addAll(list);
		
		//Faire �crire chaque �l�ment du set par ligne avec son nombre de l'occurrence dans le fichier de sortie et afficher le m�me r�sultat dans la console
		for(String strLine : set) {
			writer.write(strLine+"="+Collections.frequency(list,strLine)+";\n");
			System.out.println(strLine+"="+Collections.frequency(list,strLine)+";");
		}
		
		writer.close();
			
	}
}
