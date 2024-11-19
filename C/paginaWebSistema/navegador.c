#include<stdio.h>
#include<stdlib.h>
#include<string.h>



int main(int argc, char const *argv[])
{
    char *url = "https://www.msn.com/pt-br";
    char launch[255];
    sprintf(launch,"cmd /c start %s",url);
    system(launch);
    return 0;
}
