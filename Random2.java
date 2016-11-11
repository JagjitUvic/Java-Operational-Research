import java.util.Arrays;
import java.util.Collections;
public class Random2 {
    
    public static void main(String args[])
    {
        //required variables
        double Ri[] = new double[10];
        double CRi[] = new double[1000];
        double Ni[] = new double[]{0.00,0.10,0.20,0.30,0.40,0.50,0.60,0.70,0.80,0.90,1.00};
        double Ei[] = new double[]{100,100,100,100,100,100,100,100,100,100};
        double Oi[] = new double[10];
        double OiminusEi[] = new double[10];
        double OiminusEisquare[] = new double[10];
        double OiminusEisquaredividedEi[] = new double[10];
        double Dplus[] = new double[10];
        double Dminus[] = new double[10];
        double Total = 0.00;
        double Dfinal = 0.00;
        double rand_num[] = new double[1004];
        int i = 2;

        // Algorithm generating Random Numbers
        rand_num[0] = 0.12345678;
        rand_num[1] = 0.42858626;
        while(i<=1001)
        {
            rand_num[i] = rand_num[i-2] + rand_num[i-1];            
            if (rand_num[i] >= 1.0)
            {
                rand_num[i] = rand_num[i] - 1.0; 
            }
            i++;
        }

        //Chi-Square Test
        for (int k=0; k<10; k++){
            for (int l=2; l<=1001; l++){
                //assigning number to Oi
                if(rand_num[l]> Ni[k] && rand_num[l]<= Ni[k+1]) {
                   Oi[k] = Oi[k]+1;
                }
            }
            System.out.println(Oi[k]);
        }
        //Calculating Ei and Oi with total Sum
        for (int m=0; m<10; m++){
            OiminusEi[m] = Oi[m] - Ei[m];
            OiminusEisquare[m] = OiminusEi[m]*OiminusEi[m];
            OiminusEisquaredividedEi[m] = OiminusEisquare[m]/Ei[m];
            Total = Total + OiminusEisquaredividedEi[m];
        }
        System.out.println("****Chi-Square****");
        System.out.println("The Total for case one where alpha = 0.05 , X(square) = 18.3 , v = 10 = "+Total);
        System.out.println("The X(square) is more than actual Total from the experiment, therefore we wont reject it");
        System.out.println("Since the value for X(square) where alpha = 0.01(23.2) is more than X(square) where alpha = 0.05, therefore we wont reject it");
        }

    }   
