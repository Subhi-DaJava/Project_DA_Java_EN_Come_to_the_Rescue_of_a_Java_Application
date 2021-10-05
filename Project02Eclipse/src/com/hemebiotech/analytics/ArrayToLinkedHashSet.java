package com.hemebiotech.analytics;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
/**
 * 
 * @author Subi
 * Une classe, sa m�thode occup� de changer une List(Strting) � une autre list(LinkedHashSet) puis renvoie un String comme un resulta;
 *
 */
public class ArrayToLinkedHashSet {
	
	public ArrayToLinkedHashSet() {
		
	}
	/**
	 * M�thode charge de mettre, en premier, tout les �l�ments d'une List fournie en ordre alphab�tique,
	 * puis transmettre ces �l�ments � une autre List(LinkedHashset) qui evnl�ve 
	 * les doublons de la liste fournie, puis imprimier ses �l�ments(LinkedHashSet) en indiquant les occurrences de
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
