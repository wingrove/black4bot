import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by XIaofeng on 10/30/16.
 */
public class getInfo {

    public static void main(String[] args) {

        List distance = new ArrayList();
        List name = new ArrayList();
        List address = new ArrayList();
        List price = new ArrayList();
        List sample = new ArrayList();


        double percent;
        double ifCarGasFull = 400;
        double totalDistance = 1100;
        double min = 100;



        Scanner scan = new Scanner(System.in);
        System.out.println("How many percent of gas leave in your car?");
        percent = scan.nextDouble()*0.01;


        if(totalDistance < percent * ifCarGasFull){
            System.out.println("You don't have to pump gas for this trip ");
        }

        int numberPumpGas = (int)totalDistance/400;

        if(totalDistance > percent * ifCarGasFull){

            for(int j = 0; j < numberPumpGas; j++) {
                for (int i = 0; i < distance.size(); i++) {
                    if((double)distance.get(i) < 350*(j+1) && (double)distance.get(i) > 300 * (j+1)){
                        if((double)price.get(i)<min){
                            min = (double)price.get(i);
                        }
                    }
                    System.out.println(" The cheapest gasStation is "+name.get(i)+" at "+address.get(i)+" and the price is "+ price.get(i));


                }
            }
        }




    }
}
