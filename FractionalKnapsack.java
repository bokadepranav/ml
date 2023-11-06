import java.util.*;

public class FractionalKnapsack {
    public static void main(String args[]) {
        int weight[] = {40,10,20,24};
        int value[] = {280,100,120,120};

        int w = 80;

        double ratio[][] = new double[value.length][2];
        for(int i=0 ; i<value.length ; i++) {
            ratio[i][0] = i;
            ratio[i][1] = value[i] / (double)weight[i];
        }

        //sorting in ascending order
        Arrays.sort(ratio , Comparator.comparingDouble(o -> o[1]));

        int capacity = w;
        int finalValue = 0;

        for(int i=value.length-1 ; i>=0 ; i--) {
            int idx = (int)ratio[i][0];
            if(capacity >= weight[idx]) { //including complete
                finalValue += value[idx];
                capacity = capacity - weight[idx];
            }
            else {
                finalValue += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }

        System.out.println("total value is : " + finalValue);
    }
}
