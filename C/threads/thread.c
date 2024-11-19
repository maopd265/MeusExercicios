#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<unistd.h>
#include<errno.h>
#include<pthread.h>
void* does_not(void *a){
    int i=0;
    for (int i = 0; i < 100; i++)
    {
        sleep(1);
        puts("Does not!");
    }
    return NULL;
}

void* does_too(void *a){
    int i=0;
    for (int i = 0; i < 100; i++)
    {
        sleep(1);
        puts("Does too!");
    }
    return NULL;
}

void error(char *msg){
    // fprintf(stderr,"%s:%s\n",msg,stderr(errno));
     fprintf(stderr,"%s: %s \n",msg,strerror(errno));
    exit(1);
}
int main(int argc, char const *argv[])
{
    pthread_t t0;
    pthread_t t1;
    void* result;
    if (pthread_create(&t0,NULL,does_not,NULL)==-1)
    {
        error("Nao eh possivel criar a thread t0!");
    }
    if (pthread_create(&t1,NULL,does_too,NULL)==-1)
    {
        error("Nao eh possivel criar a thread t1!");
    }
    
    if (pthread_join(t0,&result)==-1)
    {
        error("Can't join thread t0!");
    }
    
    if (pthread_join(t1,&result)==-1)
    {
        error("Can't join thread t1!");
    }



    return 0;
}
