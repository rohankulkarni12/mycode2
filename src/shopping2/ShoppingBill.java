package shopping2;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
class Product
{
// properties
private String id=null;
private String pname;
private int qty;
private double price;
private double totalPrice;

// constructor
Product(String id, String pname, int qty, double price, double totalPrice)
{
this.id=id;
this.pname = pname;
this.qty = qty;
this.price = price;
this.totalPrice = totalPrice;
}
// getter methods
public String getId()
{
return id;
}
public String getPname()
{
return pname;
}
public int getQty()
{
return qty;
}
public double getPrice()
{
return price;
}
public double getTotalPrice()
{
return totalPrice;
}
//displayFormat
public static void displayFormat()
{
System.out.format("-----------------------------------------------------------------------------------------------------------------------------------");
System.out.print("\nProduct ID \t\tName\t\tQuantity\t\tRate \t\t\t\tTotal Price\n");
System.out.format("-----------------------------------------------------------------------------------------------------------------------------------\n");
}

// display
public void display()
{
System.out.format("   %-9s             %-9s      %5d               %9.2f                       %14.2f\n" ,id, pname, qty, price, totalPrice);
}
}
public class ShoppingBill {
public static void main(String args[]) {
System.out.println("Please Enter Your Budject Sir/Mam");
Scanner sc = new Scanner(System.in);
int budget = sc.nextInt();
// variables
String id =null;
String productName = null;
int quantity = 0;
double price = 0.0;
double totalPrice = 0.0;
double overAllPrice = 0.0;
double cgst, sgst, subtotal = 0.0, discount = 0.0;
char choice = '\0';
System.out.println("==============Kitchen Iteams avalable:\n" +
        "                                    ProductId=101--------->Spoon rs 20/Peace\n" +
        "                                    ProductId=102---------->Tava 300/Piece\n" +
        "                                    ProductId=103-----------> pan 400/Piece");
System.out.println("==============Electronics Iteams avalable:\n" +
        "                                    ProductId=201-------------> Phone rs 10000/Peace\n" +
        "                                    productid=202----------------->SmartWatch 3000/Piece\n" +
        "                                    ProductId=203----------------->Ac 400000/Piece");
System.out.println("==============Bath Iteams avalable:\n" +
        "                                     ProductId=301----------------->Soap rs 20/Peace\n" +
        "                                     ProductId=302----------------->Shampoo 300/Piece\n" +
        "                                     ProductId=303----------------->talcs 40/Piece");
System.out.println("\t\t\t\t--------------------Invoice-----------------");
System.out.println("\t\t\t\t\t " + "  " + "Welcome To Rohan Shopping Mart");
System.out.println("\t\t\t\t\t 3-3-795 Kachiguda Near Kumar Talkis");
System.out.println("\t\t\t\t\t" + "    " + "Bata Show Room and Gandi Hospital");
System.out.println("GSTIN: 03AWBPP8756K592" + "\t\t\t\t\t\t\tContact: (+91) 9966726158");
//format of date and time
SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
Date date = new Date();
Calendar calendar = Calendar.getInstance();
String[] days = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
//prints current date and time
System.out.println("Date: " + formatter.format(date) + "  " + days[calendar.get(Calendar.DAY_OF_WEEK) - 1] + "\t\t\t\t\t\t (+91)9966726158");
Scanner scan = new Scanner(System.in);
System.out.print("Enter Customer Name: ");
String customername = scan.nextLine();
//create Scanner class object
//creating an ArrayList to store the product
List<Product> product = new ArrayList<Product>();
do {
    // read input values
    System.out.println("Please enter the details acording to Above Details Displayed");
    System.out.println("Enter the product details: ");
    System.out.print("Product ID: ");
    id = scan.nextLine();
    if(id.endsWith(id)) {
    System.out.print("Product Name: ");
    productName = scan.nextLine();
    System.out.print("Quantity: ");
    quantity = scan.nextInt();
    System.out.print("Price (per unit): ");
    price = scan.nextDouble();
    }
    else {
    	System.out.println("The Product Id Is Wrong");
    	System.out.println("Please Enter According to Above Details ");
    }
    
    if (price > budget) {
        System.out.println("-------------------------You Are Out Of Budject Sir Or Mam.....Thankyou-------------------------------------");
    } else {
        //calculate total price for a particular product
        totalPrice = price * quantity;
        //calculates overall price
        overAllPrice = overAllPrice + totalPrice;
        //creates Product class object and add it to the List
        product.add(new Product(id, productName, quantity, price, totalPrice));
        // ask for continue shopping?
        System.out.print("Want to add more items? (y or n): ");
        //reads a character Y or N
        choice = scan.next().charAt(0);
        //read remaining characters, don't store (no use)
        scan.nextLine();
    }
}

    while (choice == 'y' || choice == 'Y') ;
    //display all product with its properties
    Product.displayFormat();
    for (Product p : product) {
        p.display();
    }
    //price calculation
    System.out.println("\n\t\t\t\t\t\t\t\t\t\tTotal Amount (Rs.) " + overAllPrice);
    //calculating discount
    discount = overAllPrice * 2 / 100;
    System.out.println("\n\t\t\t\t\t\t\t\t\t\t    Discount (Rs.) " + discount);
    //total amount after discount
    subtotal = overAllPrice - discount;
    System.out.println("\n\t\t\t\t\t\t\t\t\t\t          Subtotal " + subtotal);
    //calculating tax
    sgst = overAllPrice * 12 / 100;
    System.out.println("\n\t\t\t\t\t\t\t\t\t\t          SGST (%) " + sgst);
    cgst = overAllPrice * 12 / 100;
    System.out.println("\n\t\t\t\t\t\t\t\t\t\t          CGST (%) " + cgst);
    //calculating amount to be paid by buyer
    System.out.println("\n\t\t\t\t\t\t\t\t\t\t     Invoice Total " + (subtotal + cgst + sgst));
    System.out.println("\t\t\t\t----------------Thank You for Shopping!!-----------------");
    System.out.println("\t\t\t\t                     Visit Again");
    // close Scanner
    scan.close();
}


}

