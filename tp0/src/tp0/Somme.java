package tp0;

public class Somme {
private static int sum=0;
	Somme(String[] myargs)
	{
		int i=0;
		for(String element : myargs)
		 {
			try {
			i=Integer.parseInt(element);//convertir la chaine en entier
			}
			catch(NumberFormatException e){
				i=0;//ignorer le nombre
			
			}
			sum+=i;
		 }
		
	}
	
	int getSum()
	{
		return sum;
	}
	
	public static void main (String[] args) {
	Somme elem= new	Somme(args);
	System.out.println("sum = "+elem.getSum());
	
		
	}
	
}

