#include<stdio.h>
#include<stdlib.h>
#include<string.h>
int NUM_ADS = 7;
char *ADS[] = {
"Willian: SBM GSOH likes sports,TV,dinnig",
"Matt: SWM NS likes art,movies,theater",
"Luis: SLM ND likes books,theater,art",
"Mike: DWM DS likes trucks,sports and bieber",
"Peter: SAM likes chess,working out and art",
"Josh: SJM likes sports,movies and theater",
"Jed: DBM likes theater,books and dinnig"
};
int sports_no_bieber(char *s){
    return strstr(s,"sports") && !strstr(s,"bieber");
}

int sports_or_workout(char *s){
    return strstr(s,"sports") || strstr(s,"working out");
}

int ns_theater(char *s){
    return strstr(s,"NS") && strstr(s,"theater");
}

int arts_theater_or_dining(char *s){
    return strstr(s,"arts") || strstr(s,"theater") || strstr(s,"dinning");
}

void find(int (*match)(char*)){
    int i;
    puts("Search results:");
    puts("------------------");
    for (int i = 0; i < NUM_ADS; i++)
    {
        if(match(ADS[i])){
            printf("%s\n",ADS[i]);
        }
    }
    
}



int main(int argc, char const *argv[])
{
    find(sports_no_bieber);
    find(sports_or_workout);
    find(ns_theater);
    find(arts_theater_or_dining);
    return 0;
}
