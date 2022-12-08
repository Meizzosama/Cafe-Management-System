public class CustomerReview {
   String name; 
   //name city time review
   // in this class we have written that which data type is used for customer review.
   String time;
        String city;
   String review;

   CustomerReview(String name, String time, String city,String review) {

       this.name = name;
            this.time = time;
            this.city = city;
            this.review=review;
   }
   public String toString() {

       String info =  "Name: " + name + "\nYear: " + time + "\nCity: " + city +"\nReview:"+review+"\n";
       return info;
   }
}
