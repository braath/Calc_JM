package calculator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Program {
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.print("Введите строку: ");
		String str = in.nextLine();
		
  
	    String[] subStr; //разделение строки по пробелу
	    String delimeter = " "; // разделитель
	    subStr = str.split(delimeter);
	    
	    
	    if  (subStr.length != 3)
	    	error();
	    	  
	    int znak=0; // выяснение знака операции
	    if ((subStr[1]).equals("+"))
	    	znak = 1;
	    else if ((subStr[1]).equals("-"))
	    	znak = 2;
	    else if ((subStr[1]).equals("*"))
	    	znak = 3;	
	    else if ((subStr[1]).equals("/"))
	    	znak = 4;
	    else error();
	   	
	 int s1 = 0; // первое число
	 int s2 = 0; // второе число
	 int result;
	 int type  = 0; //тип чисел римские или арабские 
	
	    
	    if (Pattern.matches("[0-9]+", subStr[0]) == true 
	     && Pattern.matches("[0-9]+", subStr[2]) == true) {
	    	 
	    	 s1 = Integer.parseInt (subStr[0]);
	    	 s2 = Integer.parseInt (subStr[2]);
	    	 type = 1;
	    	 
	    }
	    else if (Pattern.matches("[IVX]+", subStr[0]) == true  
	    	  && Pattern.matches("[IVX]+", subStr[2]) == true) {
	    	type = 2;                                   //перевод из римских в арабские
	    	char[] prechars1 = subStr[0].toCharArray(); //первого числа
	    	for (int i = 0; i < prechars1.length; i++  )
	    	{	
	    		switch (prechars1[i]) {
	    		        case 'I':
	    		        	prechars1[i] = '1';
	    		        break;   		
	    		        case ('V'):
	    		        	prechars1[i] = '5';
	    		        break;
	    		        case ('X'):
	    		        	prechars1[i] = '9';
	    		        break;
	    	   }
	    	   }
	    	 for (int i = 0; i < prechars1.length-1; i++)  {
	    	   if (prechars1[i] >= prechars1[i+1]) {
	    		   s1 = s1 + Character.digit(prechars1[i],10);
	    		   if (Character.digit(prechars1[i],10) == 9)
	    			   s1 = s1 + 1; 
	    	   }
	    	   else s1 = s1 - Character.digit(prechars1[i],10);

	    	 }
	    	 s1 = s1 + Character.digit(prechars1[prechars1.length-1],10);
	    	 if (Character.digit(prechars1[prechars1.length-1],10) == 9)
  			   s1 = s1 + 1;  
	    	 
	    	 char[] prechars2 = subStr[2].toCharArray(); // и второго числа
		    	for (int i = 0; i < prechars2.length; i++  )
		    	{	
		    		switch (prechars2[i]) {
    		        case 'I':
    		        	prechars2[i] = '1';
    		        break;
    		        case ('V'):
    		        	prechars2[i] = '5';
    		        break;
    		        case ('X'):
    		        	prechars2[i] = '9';
    		        break;
    	   }
		    	   }
		    	 for (int i = 0; i < prechars2.length-1; i++)  {
		    	   if (prechars2[i] >= prechars2[i+1]) {
		    		   s2 = s2 + Character.digit(prechars2[i],10);
		    		   if (Character.digit(prechars2[i],10) == 9)
		    			   s2 = s2 + 1; 
		    	   }
		    	   else s2 = s2 - Character.digit(prechars2[i],10);
		    	 }
		    	 s2 = s2 + Character.digit(prechars2[prechars2.length-1],10);
		    	 if (Character.digit(prechars2[prechars2.length-1],10) == 9)
	  			   s2 = s2 + 1;  
	    	}	
	    else error(); //если числа разных форматов - ошибка
	    
	    
	    if (s1 < 11 && s1 > 0 && s2 < 11 && s2 > 0) {
	    	result = calculation(s1, s2, znak);
	    	if (type == 1)
	    	System.out.println(result);
	    	else {            // перевод результата в римские цифры
	    		String[] rome  = new String[] {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C"};
	    		int[] arab = new int[] {1, 4, 5, 9, 10, 40, 50, 90, 100};
	    		String romeresult = new String();
	    		if (result < 0) {
	    			romeresult = "-";
	    			result = result * (-1);
	    		}
	    		for (int i = 8; i>=0; i--) 
	    		    if (result / arab[i] >= 1) {
	    		    	romeresult = romeresult + rome[i];
	    			 
	    		      result = result - arab[i];
	    		      i = i + 1; 
	    		}
	    		System.out.println(romeresult);
	    	}
	    	}
	    	 
	    	 else error();//если числа не в диапазоне 1..10 - ошибка
	    
	}

	static void error() {
		System.err.println("Введены некорректные данные!"); 
        System.exit(0);
	}
	static int calculation(int s1, int s2, int znak) {
		int locrez = 0;
		switch (znak) {
		case (1): locrez = s1 + s2;
		break;
		case (2): locrez = s1 - s2;
		break;
		case (3): locrez = s1 * s2;
		break;
		case (4): locrez = s1 / s2;
		break;
		}
        return (locrez);
	}
}
