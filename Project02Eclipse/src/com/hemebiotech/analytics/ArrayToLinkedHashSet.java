package com.hemebiotech.analytics;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
/**
 * 
 * @author Subi
 * Une classe, sa méthode occupé de changer une List(Strting) à une autre list(LinkedHashSet) puis renvoie un String comme un resulta;
 *
 */
public class ArrayToLinkedHashSet {
	
	public ArrayToLinkedHashSet() {
		
	}
	/**
	 * Méthode charge de mettre, en premier, tout les éléments d'une List fournie en ordre alphabétique,
	 * puis transmettre ces éléments à une autre List(LinkedHashset) qui evnlève 
	 * les doublons de la liste fournie, puis imprimier ses éléments(LinkedHashSet) en indiquant les occurrences de
	 * tous les values;  
	 * @param arr
	 * @return
	 */
	public String listToSet(List<String> arr) {
		String str=null;
		Collections.sort(arr);
		Set<String> set = new LinkedHashSet<>();
		set.addAll(arr);
		for(String resultat : set) {
			str=resultat+" = "+Collections.frequency(arr, resultat);
			System.out.println(str);
		}
		
		return str;
	}

}
