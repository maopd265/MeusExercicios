#include<stdio.h>
#include<stdlib.h>
#include<string.h>
char *ADS[] = {
"Willian: SBM GSOH likes sports,TV,dinnig",
"Matt: SWM NS likes art,movies,theater",
"Luis: SLM ND likes books,theater,art",
"Mike: DWM DS likes trucks,sports and bieber",
"Peter: SAM likes chess,working out and art",
"Josh: SJM likes sports,movies and theater",
"Jed: DBM likes theater,books and dinnig"
};
int numADS =7;
char* retornaStr(char *s){
    return strstr(s,"books");
}
void find(int(*match)(char*)){
for (int i = 0; i < numADS; i++)
{
    if (match(ADS[i]))
    {
        printf("\n%s\n",ADS[i]);
    }
    
    /* code */
}

}
void testeStr(){
    for (int i = 0; i < numADS; i++)
    {
        if(retornaStr(ADS[i])){
            printf("\n%d:%s\n",i,ADS[i]);
        }
    }
    
}
int main(int argc, char const *argv[])
{
   
    find(retornaStr);
    testeStr();
    
    return 0;
}
