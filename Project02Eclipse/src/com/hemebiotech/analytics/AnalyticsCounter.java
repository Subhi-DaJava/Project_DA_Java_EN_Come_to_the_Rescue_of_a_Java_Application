package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
/**
 * Lire un fichier dans un dossier, puis le transmet comme une List, enlever les doublons, ranger les �l�ments 
 * de la liste par l'ordre alphab�tique en d�comptant les nombres de chaque sympt�me et les �crire dans un nouveau fichier de sortie;
 * @author SUBI
 *
 */
public class AnalyticsCounter {	
	public static void main(String args[]) throws IOException {
		
		//Cr�er une nouvelle liste qui re�oit tous les sysmpt�ms
		List<String> list = new ArrayList<>();
		
		String fileInputPath = "Project02Eclipse/symptoms.txt";
		ReadSymptomDataFromFile fileToArray = new ReadSymptomDataFromFile(fileInputPath);

		//Utiliser la m�thode getSymptoms() de la classe ReadSymptomDataFile qui affecte la list;		
		list=fileToArray.getSymptoms();
		
		//G�n�rer un fichier de sortie 
		String fileOutPath="result.out";
		FileWriter writer = new FileWriter(fileOutPath);
	
		//Donner les �l�ment de list dans une LinkedHashList(une liste ordonn�e) pour �liminer les doublons 
		//et garder �galement l'ordre alphab�tique de cette list;
		Set<String> set = new LinkedHashSet<>();
		Collections.sort(list);
		set.addAll(list);
		
		//Faire �crire chaque �l�ment de set par linge avec son occurrence dan le fichier de sortie et afficher le m�me r�sultat dans la console
		for(String strLine : set) {
			writer.write(strLine+"="+Collections.frequency(list,strLine)+";\n");
			System.out.println(strLine+"="+Collections.frequency(list,strLine)+";");
		}
		
		writer.close();
			
	}
}
