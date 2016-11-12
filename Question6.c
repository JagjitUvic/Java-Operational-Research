#include <stdio.h>
#include <stdlib.h>
#include <math.h>

void main(void) {
   //declaring variables
   int a,i = 0;
   int lambda = 1;
   double random_num[1000],inverse_random[1000];
   int interval[11];

   printf("Generate Exponential Random Variate with λ = 1\n");
   //looping through 1000 random numbers and generating inverse rand
   for(i=0;i<1000;i++) {
      random_num[i] = (float)rand() / (RAND_MAX + 1.0);
      inverse_random[i] = (double)((-1/lambda) * log(1-random_num[i]));
      printf("%f\n",inverse_random[i]);
   }
}






