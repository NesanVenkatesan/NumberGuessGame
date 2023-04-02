import java.util.Scanner;
import java.lang.Math;
import java.util.Random;

public class Main
{
	public static void main(String[] args) {
	    boolean gamestate = true;
	    
        Welcome();
	    do{     
    		double answer = Math.ceil(genrateNum());
    		
    		for(int i = 0; i <5;i++){
    		    
    		    System.out.print("Guess a Number from 1 to 10: ");
    		    int guess = numInput();
    		    
    		    if (guess == answer){
    		        System.out.println("\nYay, You are right! \nYou took "+ (i+1) +" tries \n\nWanna play again? (y/n)");
    		        
    		        gamestate = restart(gamestate);
    		        break;
    		        
    		    }
	    	    else if(guess > answer){
	    	        System.out.println(guess + " is greater than the original number, You have " + (5-(i+1))+" tries left!");
	    	        System.out.println();
	    	        
	    	        if((i+1)== 5){
	    	            System.out.println("Mahn!! You lost the game \nYou took "+ (i+1) +" tries \n\nWanna play again? (y/n)");
	    	            
	    	            gamestate = restart(gamestate);
	    	            break;
	    	        }
	    	    }
	    	    else if(guess < answer){
	    	        System.out.println(guess + " is lesser than the original number, You have " + (5-(i+1))+" tries left!");
	    	        System.out.println();
	    	        
	    	        if((i+1)== 5){
	    	            System.out.println("Mahn!! You lost the game \nYou took "+ (i+1) +" tries \n\nWanna play again? (y/n)");
	    	            
	    	            gamestate = restart(gamestate);
	    	            break;
	    	        }
	    	    }
	    	}
	    }while(gamestate);
		
	}
	
	public static void Welcome(){
        System.out.println("Welcome to Number Guess");
        System.out.print("Please Enter your First Name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println();
        System.out.println("Hello " + name);
    }
    
    public static Integer genrateNum(){
        Random random = new Random();
        return random.nextInt(10) + 1;
    }
    
    public static Integer numInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    
    
    public static boolean restart(boolean n){
        Scanner scanner = new Scanner(System.in);
        char reset = scanner.next().charAt(0);
        if(reset == 'y'){
            n=true;
            System.out.print("\033[H\033[2J");  
            System.out.flush();  
        }
        else{
            n=false;
        }
        return n;
    }
}
