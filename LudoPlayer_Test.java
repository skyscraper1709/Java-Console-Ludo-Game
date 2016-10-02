//Assalam Sir
//
//Sir i wanted to know if it is possible to create objects in a main method with a loop. So that the user can control the number of objects created.
//
//
//
//My  tester asks  the user, how many players want to play together in multiplayer mode. if one object is assigned  for each user how do i manage this thing.
// e.g. if the user wants to play with 2 of his/her friends then total players equal  3 now how do i do this?  I do not want to fix the number of players.

/*
 * @author: Safat Islam 
 *      Spring 12 BRACU CSE(12101066)
 * 
 * This is a game played with a die and 
 *  a board numbered with squares from 1 to 100 
 *     with lots of Snakes and Ladders on it :P
 * 
 * Enjoy Playing This Game.
 *                             Lemme Know how many Rolls it took for you to first finish the GAme.
 * @Contact: skyscraper1709@gmail.com
 * */
import java.util.Scanner;
class LudoPlayer_Test
{
    static Scanner k=new Scanner(System.in);
    public static void main(String[] args)
    {
        System.out.println("Enter: \n1 to roll\n2 to Check position\n 3 To end Game");
        boolean game=true;
         LudoDesign g=new LudoDesign();
// LudoDesign g0=new LudoDesign();     //
//. LudoDesign g1=new LudoDesign();    // how do i allow the user to generate 
// LudoDesign g2=new LudoDesign();     //  variable number of objects of his/her choice.
//.................................................       //
//.................................................  
//.................................................       
// LudoDesign g9=new LudoDesign();

        while(game)
        {
            if(g.status()==true) {g.winMessage();break;}
            else
            {
                switch (k.nextInt()) 
                {
                    case 1:  g.roll(); break;
                    case 2:  g.checkPosition(); break;
                    case 3:  game=false; g.abortMessage();break;
                    default: System.out.println("Pls Enter 1,2 or 3");break;
                }
            }
        }
    }
}
class LudoDesign_Test
{
    int rolls;
    boolean warden=false;
    int position=0;
   boolean status()
   {if(position==100)return true;  return false;}
    void roll()
    {
        rolls++;
        int a =position;
        int rn=1+(int)(Math.random()*(6-1+1));
        if(rn==1 && warden==false )
        {warden=true;System.out.println("Conrats u hv HIT (1) now u can Play\nCurrent Position: "+position);position=1;return;}
            else{System.out.println("Current Position: "+position);}
        
        
        if(warden)
        {
            position=position+rn;if(position==100) youWon();
            if(position>100) justThere(a);
            //Ladders
           else if(position==4){ladder(4,11);}
           else if(position==9){ladder(9,31);}
           else if(position==19){ladder(19,38);}
           else if(position==19){ladder(21,42);}
           else if(position==28){ladder(28,84);}
           else if(position==51){ladder(51,67);}
           else if(position==71){ladder(71,91);}
           else if(position==80){ladder(80,100);}
            //Snakes
           else if(position==17){snake(17,7);}
           else if(position==54){snake(54,34);}
           else if(position==64){snake(64,60);}
           else if(position==93){snake(93,73);}
           else if(position==95){snake(95,75);}
           else if(position==98){snake(98,79);}
        }
        else{System.out.println("Roll Again. Need to hit 1 to start game");}
        
        System.out.println("You Rolled: "+rn+"\nPosition After this Roll:- "+position);
    }
    void justThere(int k)
    {position=k; System.out.println("Ur are just there, u hv to land on 100 u cant cross 100. Try Again. No change.");}
    void youWon()
    {System.out.println("Congratulations You Won");}
    void snake(int a,int b)
    {System.out.println("Hisssss gotcha...!!!!1 \nDropped from: "+a+" to: "+b);position=b;}
    void ladder(int a,int b)
    {System.out.println("Bravo u hit a ladder and are now promoted to: "+b+" from: "+a);position=b;}
    void checkPosition()
    {
        System.out.println("Your Current Position is: "+position);
    }
    void winMessage()
    {System.out.println("You have won the Game with "+rolls+"rolls. Play Again Soon. tc.");}
    void abortMessage()
    {System.out.println("You chose to Exit the Game. Play Again Soon. tc.");}
}