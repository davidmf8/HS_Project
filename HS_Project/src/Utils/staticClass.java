package Utils;

import java.util.ArrayList;

public class staticClass {
     public static ArrayList<String> formatoDrawable(ArrayList<String> cardList){
    	String ruta = "R.Drawable.";
    	ArrayList<String> formateoCards = new ArrayList<String>();
    	for(int i = 0; i < cardList.size(); i++){
    		formateoCards.add(i, ruta+cardList.get(i));
    	}
		return formateoCards;	 
     }
}
