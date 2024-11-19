import java.util.Scanner;

public class App {
   public static void romano(int number)
   {
     int Y;
     
     if (number>=500) {
         System.out.println("Digite um número válido menor que 500!");
         
     }
     if(number>=100 && number<500)
     {
         System.out.printf("C");
         Y=number-100;
         romano(Y);

     }
    if(number>=90 && number<100)
    {
        System.out.printf("XC");
        Y=number-90;
        romano(Y);
    }

     if(number>=50 && number<90)
     {
         System.out.printf("L");
         Y=number-50;
         romano(Y);
     }
       if(number>=40 && number<50)
       {
        //    System.out.println("Número deve estar entre 1 e 39");
        System.out.printf("XL");
        Y= number-40;
        romano(Y);
       }
       if(number<0)
       {
            System.out.println("Número deve estar entre 1 e 39");
       }
       if(number>=10 && number<=39)
       {
           System.out.printf("X");
           Y = number-10;
           romano(Y);
       }
       if(number==9)
       {
           System.out.printf("IX");
       }
       if(number>=5 && number<=8)
       {
           System.out.printf("V");
        Y= number-5;
        romano(Y);
        }
        if(number==4)
        {
            System.out.printf("IV");
        }
        if(number>=1 && number<=3)
        {
            System.out.printf("I");
            Y=number-1;
            romano(Y);
        }
       
   }
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String msg = scan.nextLine().toUpperCase();
        System.out.println("msg:"+msg);

        
        int num = scan.nextInt();
        romano(num);
        System.out.println("");
    }
}
