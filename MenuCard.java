import java.util.Scanner;

public class MenuCard {
			//review-array
	//in this class we have written about menu card and 
	//reviews which are being given by the customer through array.
	
public static void main(String[] args) {
      
        Scanner a=new Scanner(System.in);
        CafeDisplay obj=new CafeDisplay ();
        MenuCard ob=new MenuCard();
       
        obj.createadmin(obj.heada, 1,"Halwa poori", 100);
        obj.createadmin(obj.heada, 2,"Biryani", 150);
        obj.createadmin(obj.heada, 3,"Chicken Roll", 200);
        obj.createadmin(obj.heada, 4,"Zinger Burger", 450);
        obj.createadmin(obj.heada, 5,"Rasmalai", 500);
        while(true){
            obj.mainnenu();
           
        int choice;
        choice=a.nextInt();
        switch (choice)
        {
            case 1:
                obj.admin();
                break;
            case 2:
                obj.customer();
                break;
            case 3:
                ob.Review();
                break;
            case 4:
                System.out.println("\n\n\t\t\t\t\t\t\t ****Thank you!!*** \n");
                break;

            default:
                System.out.println("\n\t\t\t\t\t\t Wrong Input !! Please choose valid option ..\n");
                break;       
        }         
        }

        }
public void Review()
   {
       CustomerReview c1 = new CustomerReview("Osama", "2010", "Karachi", "The food is tasty!! ");
   CustomerReview c2 = new CustomerReview("Ahsaan", "2015", "Hyderabad", "The food is Delicious !!");
   CustomerReview c3 = new CustomerReview("Danial", "2017", "Islamabad", "Need some betterment !!");
   CustomerReview c4 = new CustomerReview("Rafay", "2020", "Azad Kashmir", "Affordably Price");
   CustomerReview c5 = new CustomerReview("Wasi", "2021", "Rawalpindi", "I Love this Restaurant");

   CustomerReview arr[] = {c1, c2, c3, c4, c5};
       
        for (int i = 0; i < arr.length; i++)
        {
        System.out.println(arr[i]);
        }   }}
