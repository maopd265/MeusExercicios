#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<unistd.h>
#include<errno.h>
#include<pthread.h>

int beers =2000000;
pthread_mutex_t beers_lock = PTHREAD_MUTEX_INITIALIZER;
void* drink_lots(void* a){
    int i;
    pthread_mutex_lock(&beers_lock);
    for (int i = 0; i < 100000; i++)
    {
        beers=beers-1;
    }
    pthread_mutex_unlock(&beers_lock);
    printf("beers = %i \n",beers);
    return NULL;
    
}

int main(int argc, char const *argv[])
{
    pthread_t threads[20];
    int t;
    void* result;
    printf("%i bottles of beer on the wall\n %i bottles of beer \n",beers,beers);
    for (int i = 0; i < 20; i++)
    {
        pthread_create(&threads[t],NULL,drink_lots,NULL);
    }
    for (t = 0; t<20; t++)
    {
        pthread_join(threads[t],&result);
    }
    printf("There are now %i bottles of beer on the wall \n",beers);
    return 0;
}
