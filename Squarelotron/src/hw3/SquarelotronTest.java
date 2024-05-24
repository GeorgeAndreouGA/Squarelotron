package hw3;
import java.util.Scanner;
public class SquarelotronTest {

	public static void main(String[] args) {
		 boolean find=true;;
		   while(find) {
		Scanner give = new Scanner(System.in);
	   System.out.println("choose array:4x4 or 5x5");
	   String size = give.next();
	   if(!size.equals("4x4")&&!size.equals("5x5"))
		   throw new IllegalArgumentException("Invalid size");
	   int[] originalArray;
	 
		   if(size.equals("4x4")) 
			    originalArray = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		   else 
			 originalArray = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
						25 };
		   System.out.println("choose method: upsideDownFlip,leftRightFlip,inverseDiagonalFlip,mainDiagonalFlip,sideFlip,rotateRight");
	    String lexi = give.next();
	    String lowercase = lexi.toLowerCase();
	    Squarelotron square = Squarelotron.makeSquarelotron(originalArray);
	    System.out.println(square);
	    if(lowercase.equals("upsidedownflip")) {
	    	 System.out.println("inner or outer");
	    	 String lexi1 = give.next();
	    	System.out.println(square.upsideDownFlip(lexi1).toString());
	    }
	    else if(lowercase.equals("leftrightflip")) {
	    	 System.out.println("inner or outer");
	    	 String lexi1 = give.next();
	    	 System.out.println(square.leftRightFlip(lexi1).toString());
	    	
	    }
	    else if(lowercase.equals("inversediagonalflip")) {
	    	 System.out.println("inner or outer");
	    	 String lexi1 = give.next();
	    	 System.out.println(square.inverseDiagonalFlip(lexi1).toString());
	    	
	    }
	    else if(lowercase.equals("maindiagonalflip")) {
	    	 System.out.println("inner or outer");
	    	 String lexi1 = give.next();
	    	 System.out.println(square.mainDiagonalFlip(lexi1).toString());
	    	
	    }
	    
	    else if(lowercase.equals("maindiagonalflip")) {
	    	 System.out.println("inner or outer");
	    	 String lexi1 = give.next();
	    	 System.out.println(square.mainDiagonalFlip(lexi1).toString());
	    	
	    }
	    else if(lowercase.equals("sideflip")) {
	    	 System.out.println("left,right,top,bottom");
	    	 String lexi1 = give.next();
	    	 System.out.println(square.sideFlip(lexi1).toString());
	    	
	    }
	    else if(lowercase.equals("rotateright")) {
	    	 System.out.println("how many turns");
	    	 int num = give.nextInt();
	    	 square.rotateRight(num);
	
	    	
	    }
	    else
	    	System.out.println("no such method.");
	    
	    System.out.println("do you want to continue:true false");
	     find=give.nextBoolean();
	 }
	   
	}

}
