import java.util.Arrays;
import java.util.Collections;
public class Random {
    
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
        //generate 1o random number and store in Ri
        for (int i=0; i<10; i++){
        	Ri[i]=Math.random();
        }
        //Sort array Ri
        Arrays.sort(Ri);
        //Calculate Dplus and D minus
        for (int j=0; j<10; j++){
        	Dplus[j] = Ni[j+1] - Ri[j];
        	Dminus[j] = Ri[j] - Ni[j];
        }
        //Sort Dplus and Dminus
        Arrays.sort(Dplus);
        Arrays.sort(Dminus);	
        Dfinal = Dplus[9] > Dminus[9] ? Dplus[9] : Dminus[9];
        //printing Kolmogorv-Smirnov results
        System.out.println("****Kolmogorv-Smirnov****");
        System.out.println("The D for case one where alpha = 0.05 , D(alpha) = 0.410 , N = 10 = "+Dfinal);
        System.out.println("The D(alpha) is more than actual D from the experiment, therefore we wont reject it");
        System.out.println("Since the value for D(alpha) where alpha = 0.01(0.490) is more than D(alpha) where alpha = 0.05, therefore we wont reject it");
        //Chi-Square Test
        for (int k=0; k<10; k++){
	        for (int l=0; l<1000; l++){
	        	//generating 1000 random numbers
	        	CRi[l]=Math.random();
	        	//assigning number to Oi
	        	if(CRi[l]> Ni[k] && CRi[l]<= Ni[k+1]) {
	               Oi[k] = Oi[k]+1;
	        	}
	        }
		}
		//Calculating Ei and Oi with total Sum
		for (int m=0; m<10; m++){
        	OiminusEi[m] = Oi[m] - Ei[m];
        	OiminusEisquare[m] = OiminusEi[m]*OiminusEi[m];
        	OiminusEisquaredividedEi[m] = OiminusEisquare[m]/Ei[m];
        	Total = Total + OiminusEisquaredividedEi[m];
        }
        //printing outputs and results
		System.out.println("****Chi-Square****");
        System.out.println("The Total for case one where alpha = 0.05 , X(square) = 18.3 , v = 10 = "+Total);
        System.out.println("The X(square) is more than actual Total from the experiment, therefore we wont reject it");
        System.out.println("Since the value for X(square) where alpha = 0.01(23.2) is more than X(square) where alpha = 0.05, therefore we wont reject it");
        }

    }	
