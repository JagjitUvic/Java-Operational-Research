#include <stdio.h>
#include <stdlib.h>
#include <math.h>

void main(void) {
   //declaring variables
   int a,i,k = 0;
   int lambda = 1;
   double random_num[1000],inverse_random[1000];
   double Ni[12] ={0.00,0.50,1.00,1.50,2.00,2.50,3.00,3.50,4.00,4.50,5.00,5.50};
   double Oi[10];

   printf("Generate Exponential Random Variate with λ = 1\n");
   //looping through 1000 random numbers and generating inverse rand
   for(i=0;i<1000;i++) {
      random_num[i] = (float)rand() / (RAND_MAX + 1.0);
      inverse_random[i] = (double)((-1/lambda) * log(1-random_num[i]));
      printf("%f\n",inverse_random[i]);
   }

   for (k=0; k<11; k++){
            for (int l=2; l<=1001; l++){
                //assigning number to Oi
                if(inverse_random[l]> Ni[k] && inverse_random[l]<= Ni[k+1]) {
                   Oi[k] = Oi[k]+1;
                }
            }
            printf("\nCount between %f and %f -> %f      Relative Frequency -> %f",Ni[k],Ni[k+1],Oi[k],(double)Oi[k]/1000);
        }
}






