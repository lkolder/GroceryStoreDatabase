import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class FileReader{
  private static BackEndDeveloper backEnd;
  public DataWrangler(BackEndDeveloper backEnd) {
    this.backEnd = backEnd;
  }
  
  public static void readFile(String filePath){
    File file = new File(filePath);
    String currLine = "";
    String sSerial = "";
    String name;
    String sCost;
    double dCost; 
    String sQuantity;
    int iQuantity;
    String sLocation;
    int iLocation;
    try {
      Scanner sc = new Scanner(file);
      while(sc.hasNextLine()){ 
        try{
          sSerial = sc.next();
          try {
            backEnd.serialValidity(sSerial);
            backEnd.alreadyExists(sSerial);
          }
          catch(Exception e) {
            continue;
          }
        }
        catch(NoSuchElementException e){
          continue; 
        }
  
        try{
          name = sc.next();
        }
        catch(NoSuchElementException e){
          continue;
        }
  
        try{
          sCost = sc.next();
          dCost = Double.parseDouble(sCost);
        }
        catch(NoSuchElementException e){
          continue; 
        }
        catch(NumberFormatException f) {
          continue;
        }
  
        try{
          sQuantity = sc.next();
          iQuantity = Integer.parseInt(sQuantity);
        }
        catch(NoSuchElementException e){
          continue; 
        }
        catch(NumberFormatException f) {
          continue;
        }
  
        try{
          sLocation = sc.next();
          iLocation = Integer.parseInt(sLocation);
          if(!isLocationValid(iLocation)) {
            continue;
          }
        }
        catch(NoSuchElementException e){
          continue;
        }
        catch(NumberFormatException f) {
          continue;
        }
        GroceryStoreItem g = new GroceryStoreItem(sSerial, name, dCost, iQuantity, iLocation);
        try {
          backEnd.add(g);}
        catch(Exception e) {
          continue;
        }
      }
    }
    catch(FileNotFoundException e) {
      System.out.println("Could not find specified file");
    }
  }
    public static boolean isSerialValid(int s){
      String sTest = "" + s;
      if(sTest.length() == 12)
        return true;
      else
        return false;
    } 
 

    public static boolean isLocationValid(int l){
      if(l < 10  && l > -1) {
        return true;
      }
      else {
        return false; 
      }
    }
  }
