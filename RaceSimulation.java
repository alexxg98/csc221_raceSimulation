//CSC 22100: Software Design Laboratory
//Assignment 2
//Alexandria Guo

import java.security.SecureRandom;

public class RaceSimulation {
  private static int time = 0;
  private final static int FINISHLINE = 100;
  private static int racer1Position = 1; //starting position
  private static int racer2Position = 1; //starting position
  static SecureRandom random = new SecureRandom();

  // Overload toString() method
  public String toString(String s) {
    return "Race simulation class";
  }

  //Method to return if race has been won
  public static boolean raceWon(){
    return (racer1Position>=FINISHLINE || racer2Position>=FINISHLINE);
  }

//Racer1 method - defining how racer1 moves
  public static void moveRacer1(){
   int moveType1 = 1 + random.nextInt(10); //use secure random to get percentage
   switch(moveType1){
     case 1:
     case 2:
     case 3:
     case 4:
     case 5:
       racer1Position += 3;
       break;
     case 6:
     case 7:
     case 8:
      racer1Position -=6;
      break;
     case 9:
     case 10:
       racer1Position += 1;
       break;
   }
   //If the racer slips before square 1, move it back to square 1 (no negative position)
   if (racer1Position < 1){
     racer1Position = 1;
   }
  }

//Racer2 method - defining how racer2 moves
  public static void moveRacer2(){
   int moveType2 = 1 + random.nextInt(10); //use secure random to get percentage
   switch(moveType2){
     case 1:
       break;
     case 2:
     case 3:
       racer2Position += 5;
       break;
     case 4:
     case 5:
       racer2Position -= 2;
       break;
     case 6:
       racer2Position -= 10;
       break;
     case 7:
     case 8:
     case 9:
     case 10:
       racer2Position += 1;
       break;
   }
   //If the racer slips before square 1, move it back to square 1 (no negative position)
   if (racer2Position < 1){
     racer2Position = 1;
   }
  }

//Method to Print separator line
  public static void printRaceTrack(){
    for(int i=0; i<FINISHLINE; ++i){
        System.out.print("-");
    }
    System.out.println("|");//finishline
  }

//main method
  public static void main(String[] args) {
    //Print start of race
    System.out.println("On Your Mark, Get Set, Go");
    System.out.printf("%s%d%n%s%n", "Time: ", time, "B");
    ++time;
    printRaceTrack();

    while(!raceWon()){ //while the race has not been won, do:
      System.out.printf("%s%d%n", "Time: ", time);
      ++time;
      moveRacer1();
      moveRacer2();
      //If both racers are at the same position, print 'B'; otherwise print 'O' for racer1 and T for racer2
      if(racer1Position==racer2Position){
        System.out.printf("%"+racer1Position+"s%n", "B");
      }
      else{
        //ensure no overwritten positions when printing
        if(racer1Position<racer2Position){
          System.out.printf("%"+racer2Position+"s", "T");
          System.out.printf("\r%"+racer1Position+"s%n", "O");
        }
        else{
          System.out.printf("%"+racer1Position+"s", "O");
          System.out.printf("\r%"+racer2Position+"s%n", "T");
        }
      }
      printRaceTrack();
    }

    //Print results
    if(racer1Position>=FINISHLINE && racer2Position<FINISHLINE){
      System.out.printf("%n%s%n%s%d%n","Racer 1 wins!", "Time Elapsed: ", time-1);
    }
    else{
      if(racer2Position>=FINISHLINE && racer1Position<FINISHLINE){
        System.out.printf("%n%s%n%s%d%n","Racer 2 wins!", "Time Elapsed: ", time-1);
      }
      else{
        System.out.printf("%n%s%n%s%d%n","It's a Tie!", "Time Elapsed: ", time-1);
      }
    }
  }
}
