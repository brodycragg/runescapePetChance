import java.util.Random;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Set;

public class petChance{

  static int woodCut = 0;
  static Boolean noPet = true;
  static int petChance;
  static String treeType;
  static Scanner reader = new Scanner(System.in);
  static HashMap<String, Integer> trees = new HashMap<String, Integer>();
  static int petChace = 0;
  static Random rand = new Random();
  static int woodcuttingLevel;

  public static void cutWood(){
    System.out.println("You are now woodcutting. ");
    woodCut++;
    System.out.println("You have cut a log. ");
  }

  static boolean getPet(int num){
    if(num == 1){
      noPet = false;
    }
    else{
      noPet = true;
    }
    return noPet;
  }

  static int petChace(int num, String tree){

    trees.put("normal",317647);
    trees.put("oak",361146);
    trees.put("willow",289286);
    trees.put("teak",264336);
    trees.put("maple",221918);
    trees.put("mahogany",220623);
    trees.put("yew",145013);
    trees.put("magic",72321);
    trees.put("redwood",72321);

    treeType = tree.toLowerCase();
    int beaverChance = trees.get(treeType);
    petChance = beaverChance - (25 * num);
    System.out.println("The chance of you receiving\n a beaver pet is 1/" + petChance);
    try{
       Thread.sleep(5000);
    }
    catch(InterruptedException ex){
        Thread.currentThread().interrupt();
    }
    return petChance;
  }

  public static void main (String[] args){

    System.out.println("Enter the tree you're cutting: ");
    String treeType = reader.nextLine();
    System.out.println("Enter your woodcutting level: ");
    int woodcuttingLevel = reader.nextInt();

    petChace(woodcuttingLevel,treeType);
    getPet(petChance);
    while(noPet){
      cutWood();
      getPet(rand.nextInt(petChance));
    }
    System.out.println("It took you " + woodCut + " logs to get a pet.");
  }
}
