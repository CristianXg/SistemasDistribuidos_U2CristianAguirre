#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#define MAX_THREADS 8
#define VECTOR_SIZE 100000000

pthread_t tid[MAX_THREADS];
pthread_mutex_t mutex;

int *array;
int length = VECTOR_SIZE;
int count = 0;
int double_count = 0;
int max_threads = MAX_THREADS;

long factorial(long n){
	int *r = (long*)malloc(1*sizeof(long));
	long i = 1, f = 1;
	while(i<=n){
		pthread_mutex_lock(&mutex);
		f= f*i;
		i = i+1;
		pthread_mutex_unlock(&mutex);
	}
	r[0]=f;
	printf("Factorial de %ld es %ld\n",n,f);
	return r;
}

void *factorial_(void *arg){
	long n = *((long*)arg);
	return (void*)factorial(n);
}

int main(int argc, char **argv){
	long n = 5;
	pthread_t thread[1];
	printf("Running 3s-00 Using %d threads\n", max_threads);
	
	srand(time(NULL));
	printf("*** 3s-01 ***\n");
	printf("Initializing vector.... ");
	fflush(stdout);
	initialize_vector();
	printf("Vector initialized! \n");
	fflush(stdout);
	
	pthread_mutex_init(&mutex, NULL);
	
	for(int i = 0; i < max_threads; i++){
		void *status;
		int rc;
		rc = pthread_join(thread[0],NULL);
		if(rc){
			printf("ERROR; return code from pthread() is %d \n", rc);
			exit(-1);
		}else{
			printf("Thread [%ld] exited with status [%ld] \n", i, (long)status);
		}
	}
	pthread_mutex_destroy(&mutex);
	return 0;
		
}
