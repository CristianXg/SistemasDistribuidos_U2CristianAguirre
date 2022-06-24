#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

long sum = 0;
void *factorial(void *n);
int main(){
    for (long i = 3; i <= 10; i++)
    {
        long v=i;
        pthread_t factorial_thread;
        pthread_create(&factorial_thread,NULL,factorial,&v);
        pthread_join(factorial_thread,NULL);
    }
    printf("La suma total de los factoriales resulta %ld\n",sum);
    return 0;
}

void *factorial(void *n){
    long *num = (long *)n;
    long cont = 1;
    for (long j = 2; j <= *num; j++)
    {
        cont *= j;
    }
    printf("Resultado del factorial de %ld es %ld\n",*num,cont);  
    sum+=cont;
    *num = cont;
    return NULL;
}
