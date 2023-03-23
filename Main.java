import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

class Item
  {
    public String name;
    public String serialNumber;
    public int value;
  

public Item()
  {
}

public Item(String name, String serialNumber, int value)
  {
  this.name = name;
  this.serialNumber = serialNumber;
  this.value = value;
}

public void setName(String name)
  {
  this.name = name;
}

public void setserialNumber(String serialNumber)
    {
      this.serialNumber = serialNumber;
    }

  public void setvalue(String value)
    {
      this.value = value;
    }

    public String getName()
    {
      return name;
    }

    public String getserialNumber()
    {
      return serialNumber;
    }

    public int getValue()
    {
      return value;
    }
  }

public class Main 
{
    public static Scanner scan = new Scanner(System.in);
    public static ArrayList<Item> inventory = new ArrayList<Item>();
    public static void main(String [] args) throws InputMismatchException
  {
    input choice = 0;
    boolean moreSelections = true;
    while (moreSelections) 
    {
      System.out.println("Press 1 to add an item.\nPress 2 to delete an item.\nPress 3 to update an item.\nPress 4 to show all the items.\nPress 5 to quit the program.");
choice = scan.nextInt();
      scan.nextLine();
      
      switch (choice) 
      {
        case "1": 
            addItem();
          break;
          
        case "2": 
          deleteItem();
          break;
        
        case "3": 
          updateItem();
          break;
        
        case "4": 
          print();
          break;
        
          case "5":
          moreSelections = false; break;
        default: break;
          }
    }
  }

public static void addItem()
  {
    Item newItem = new Item();

  System.out.println("Enter the name:");
    String name = scan.nextLine();
    newItem.setName(name);

  System.out.println("Enter the serial number:");
    String serialNumber = scan.nextLine();
    newItem.setserialNumber(serialNumber);

  System.out.println("Enter the value in dollars (whole number):");
    int value = scan.nextLine();
    scan.nextLine();
    newItem.setValue(value);

  inventory.add(newItem);
  }

public static void deleteItem()
  {
    System.out.println("Enter the serial number of the item to delete:");
    String serialNumber = scan.nextLine();

  for(int i = 0; i < inventory.size(); i++)
    {
      if(inventory.get(i).getserialNumber().equals(serialNumber))
      {
        inventory.remove(i);
      }
    }
  }

public static void updateItem()
  {
    System.out.println("Enter the serial number of the item to change:");
    String serialNumber = scan.nextLine();

  System.out.println("Enter the new name:");
    String name = scan.nextLine();

  System.out.println("Enter the new value in dollars (whole number):");
    int value = scan.nextLine();
    scan.nextLine();

  Item updatedElement = new Item(name, serialNumber, value);

  for(int i = 0; i < inventory.size(); i++)
    {
      Item temp = inventory.get(i);
      System.out.println(temp.getName() + "," + temp.getserialNumber() + "," + temp.getValue());
    }
  }
}