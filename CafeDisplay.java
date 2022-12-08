import java.util.Scanner;

public class CafeDisplay {
Scanner a = new Scanner(System.in);
class node
{
	
   String foodname;
   int quantity;
   float price;
   int data;
    node previous;
    node next;
    public node(int data) {  
           this.data= data;  
       }  
   }  
node headc=null;
node heada=null,taila=null,tailc=null;                                               
node head_s;

//this method prints the option available for admin to choose.
void adminmenu()
{
   System.out.println("\n\t\t\t\t\t\t\t1. View total sales..\n");
   System.out.println("\t\t\t\t\t\t\t2. Add new items in the order menu..\n");
   System.out.println("\t\t\t\t\t\t\t3. Delete items from the order menu.\n");
   System.out.println("\t\t\t\t\t\t\t4. Display order menu..\n");
   System.out.println("\t\t\t\t\t\t\t5. Back To Main Menu.. \n\n");
   System.out.println("\t\t\t\t\t\t\t   Enter Your Choice: --->");
}
	//this method prints the option available for customer to choose.
void customermenu()
{
   System.out.println("\n\t\t\t\t\t\t\t1. Place your order..\n");
   System.out.println("\t\t\t\t\t\t\t2. View your ordered items..\n");
   System.out.println("\t\t\t\t\t\t\t3. Delete an item from order..\n");
   System.out.println("\t\t\t\t\t\t\t4. Display final bill..\n");
   System.out.println("\t\t\t\t\t\t\t5. Back To Main Menu. \n\n");
   System.out.println("\t\t\t\t\t\t\t   Enter Your Choice: ");
}
	//this method creates a node for admin's linked list.
public node createadmin(node head,int data,String foodname,float price)
{
    node newnode= new node(data);
    newnode.data = data;
   newnode.price = price;
   newnode.quantity = 0;
   newnode.foodname=foodname;
   newnode.next = null;
   newnode.previous = null;
   node temp = head;
    if(temp==null)
       heada = taila = newnode;
   else
   {
       while(temp.next!=null)
           temp=temp.next;

       temp.next=newnode;
       newnode.previous = taila;
       taila = newnode;
   }
       return heada;
}
//this method creates a node for customer's linked list
public node createcustomer(node head,int data,int quantity)
{
   node newnode = new node(data);
   node temp1 = heada;
   int flag = 0;
   while(temp1!=null) 	
   {
       if(temp1.data==data)
       {
           flag = 1;
           break;
       }
       temp1 = temp1.next;
   }
if(flag==1)
   {
       newnode.data = data;
       newnode.price = temp1.price;
       newnode.quantity = quantity;
       newnode.foodname=temp1.foodname;
       newnode.next = null;
       newnode.previous = null;
       node temp = head;
       if(temp==null)
           headc = tailc = newnode;
       else
       {
           while(temp.next!=null)
               temp=temp.next;

           temp.next=newnode;
           newnode.previous = tailc;
           tailc = newnode;
       }
   }
       else
   {
       System.out.println("\n\t\t\t\t\t\t\t This item is not present in the menu!! \n");
   }
   return headc;
}
 			//this method displays the respective entire linked list whose head pointer is passes to it.
void displayList(node head)
{
   node temp1 = head;
   if(temp1==null)
   {
       System.out.println("\n\t\t\t\t\t\t\t\t List is empty!! \n\n");
   }
   else
   {
       System.out.println("\n");
       while(temp1!=null)
       {
           if(temp1.quantity==0)
               System.out.println("\t\t\t\t\t\t\t\t\t\n" +temp1.data+" "+temp1.foodname+" "+temp1.price);
           else
           {
   System.out.println("\t\t\t\t\t\t\t\t\t\t\n" +temp1.data+" "+temp1.foodname+" "+temp1.quantity+" "+temp1.price);
           }
           temp1 = temp1.next;
       }
       System.out.println("\n");
   }
}
//this method maintains the total value of sales done by maintaining another linked list which keeps a track of
//total sales made to each customer represented by each node.
public node totalsales(int data,int quantity)
{
   node newnode = new node(data);
   int flag = 0;
   node temp1 = heada;
   while(temp1.data!=data)
   {
       temp1 = temp1.next;
   }
   newnode.data = data;
   newnode.price = temp1.price;
   newnode.quantity = quantity;
   newnode.foodname=temp1.foodname;
   newnode.next = null;
   newnode.previous = null;

   node temp = head_s;
   if(temp==null)
       head_s = newnode;
   else
   {
       while(temp.next!=null)
       {
           if(temp.data==data)
           {
               flag = 1;
               break;
           }
           temp=temp.next;
       }
       if(flag==1)
       {
           temp.quantity += newnode.quantity;
           temp.price += newnode.price;
       }
       else
       {
           temp.next=newnode;
       } }
   return head_s;
}
	//this method performs task of calculating total sales for each customer.
void calculatetotsales()
{
    node temp = headc;
   while(temp!=null)
   {
       head_s = totalsales(temp.data, temp.quantity);
       temp=temp.next;
   }}
//this method performs the task of deleting the data from linked list
//whose respective head pointer is passed
//Here,data is to be deleted will passes as a parameter.
public node delete(int data,node head,node tail)
{
   if(head==null)
   {
       System.out.println("\n\t\t\t\t\t\t\t List is empty !! \n");
   }
   else
   {
        node temp;
       if(data==head.data)
       {
           temp = head;
           head = head.next;
           if (head != null)
               head.previous = null;
       }
       else if(data==tail.data)
       {
           temp = tail;
           tail = tail.previous;
           tail.next = null;  
       }
       else
       {
           temp = head;
           while(data!=temp.data)
           {
               temp = temp.next;
           }
           (temp.previous).next = temp.next;
           (temp.next).previous = temp.previous;
       }
   }
   return head;
}
	//this method performs the task of deleting food item from admin's linked list
int deleteadmin()
{
   System.out.println("\n\t\t\t\t\t Enter serial no. of the food item which is to be deleted: ");
   int num;
   num=a.nextInt();
   node temp=heada;
   while(temp!=null)
   {
       if (temp.data == num)
       {
           heada = delete(num, heada, taila);
           return 1;
       }
       temp=temp.next;
   }
   return 0;
}
		//this method performs the task of deleting food item from customers linked list
int deletecustomer()
{
   System.out.println("\n\t\t\t\t\t Enter serial no. of the food item which is to be deleted:  ");
   int num;
   num =a.nextInt();
    node temp=headc;
   while(temp!=null)
   {
       if (temp.data == num)
       {
           headc = delete(num, headc, tailc);
           return 1;
       }
       temp=temp.next;
   }
   return 0;
}
			//this method displays the total bill of food items ordered by customer.
void displaybill()
{
   displayList(headc);
   node temp = headc;
   float total_price = 0;
   while (temp!=null)
   {
       total_price +=temp.price;
       temp = temp.next;
   }
   System.out.println("\t\t\t\t\t\t\t Total price: \n"+total_price);
}
			//this method performs the task of deleting entire linked list.
public node deleteList(node head)
{
   if(head==null)
   {
       return null;
   }
   else
   {
       node temp = head;
       {
           temp = temp.next;       
       }
       head = null;
   }
  return head;
}
	//this method opens up the admin section and provides it's interface and functionalities..
void admin()
{
   System.out.println("\n\t\t\t\t\t   ----------------------------------------------\n");
   System.out.println("\t\t\t\t\t\t\t    ADMIN SECTION \n");
   System.out.println("\t\t\t\t\t   ----------------------------------------------\n");
   while(true)
   {
       adminmenu();	//prints admin fuctionality list.
       int opt;
       opt=a.nextInt(); 	//store choice of  user.
       if(opt==5)
           break;
       	// we used this switch case block which executes according to the option selected by user.
       switch (opt)
       {
           case 1:
               displayList(head_s);
               break;
           case 2:
               int num,flag = 0;
               System.out.println("\n\t\t\t\t\t\t\t Enter serial number of the food item: ");
               num=a.nextInt();
               String foodname;
               float price;           
               node temp = heada;
               while(temp!=null)
               {
                   if(temp.data==num)
                   {
                       System.out.println("\n\t\t\t\t\t\t Food item with given serial number already exists!! \n\n");
                       flag = 1;
                       break;
                   }
                   temp = temp.next;
               }
               if(flag==1)
                   break;            
               System.out.println("\t\t\t\t\t\t\t Enter price:  ");
               price=a.nextInt();
               foodname=a.nextLine();
               System.out.println("\t\t\t\t\t\t\t Enter food item name:  ");
               foodname=a.nextLine();
               heada = createadmin(heada, num, foodname, price);
               System.out.println("\n\t\t\t\t\t\t\t New food item added to the list!! \n\n");
               break;
           case 3:
               if(deleteadmin()!=0)
               {
                   System.out.println("\n\t\t\t\t\t\t### Updated list of food items menu !! \n");
                   displayList(heada);
               }
               else
                   System.out.println("\n\t\t\t\t\t\t Food item with given serial number doesn't exist! \n\n");
               break;
           case 4:
               System.out.println("\n\t\t\t\t\t\t\t   *** Order menu *** \n");
               displayList(heada);
               break;         
           default:
               System.out.println("\n\t\t\t\t\t\t Wrong Input !! PLease choose valid option \n");
               break;
       }   }}
	//this method opens up the customer section and provides it's interface and functionalities.
void customer()
{
   int flag=0,j=1;
   char ch;
   System.out.println("\n\t\t\t\t\t   ----------------------------------------------\n");
   System.out.println("\t\t\t\t\t\t\t    *CUSTOMER SECTION* \n");
   System.out.println("\t\t\t\t\t   ----------------------------------------------\n");
   while(true)
   {
       customermenu(); 	//prints customer functionality list.
       int opt;
       opt=a.nextInt();		//store choice of user.

       if(opt==5)
           break;
       		//switch case block which executes according to the option selected by user
       switch (opt)
       {
           case 1:
               displayList(heada);
               System.out.println("\n\t\t\t\t\t\t Enter number corresponding to the item you want to order:  ");
               int n;
               n=a.nextInt();
               System.out.println("\t\t\t\t\t\t Enter quantity:  ");
               int quantity;
               quantity=a.nextInt();
               headc = createcustomer(headc, n, quantity);
               break;
           case 2:
               System.out.println("\n\t\t\t\t\t\t\t  *** List of ordered items ***\n");
               displayList(headc);
               break;
           case 3:
               if(deletecustomer()!=0)
               {
                   System.out.println("\n\t\t\t\t\t\t *** Updated list of your ordered food items *** \n");
                   displayList(headc);
               }
               else
                   System.out.println("\n\t\t\t\t\t\t Food item with given serial number doesn't exist!! \n");
               break;
           case 4:
               calculatetotsales();
               System.out.println("\n\t\t\t\t\t\t\t  *** Final Bill *** \n");
               displaybill();
               headc = deleteList(headc);
               System.out.println("\n\t\t\t\t\t\t Press any key to return to main menu: \n\t\t\t\t\t\t");            
               flag=1;
               break;
           default:
               System.out.println("\n\t\t\t\t\t\t Wrong Input !! PLease choose valid option.. \n");
               break;
       }
       if(flag==1)
           break;
   }
}
	//this method prints the welcome interface and opens the main menu where
	//you can select the option where you want to go..
void mainnenu()
{
   System.out.println("\t\t\t\t\t\t\t***************************************\n");
   System.out.println("\t\t\t\t\t\t\t Welcome To Cafe Management System \n");
   System.out.println("\t\t\t\t\t\t\t***************************************\n\n\n");
   System.out.println("\t\t\t\t\t\t\t  1. ADMIN SECTION \n");
   System.out.println("\t\t\t\t\t\t\t 2.CUSTOMER SECTION \n");
   //section=area.
   System.out.println("\t\t\t\t\t\t\t 3. REVIEWS \n");
   System.out.println("\t\t\t\t\t\t\t 4. Exit \n\n");
   System.out.println("\t\t\t\t\t\t\t Enter Your Choice: ");
}
   }
