#include<stdio.h>
int main()
{
    int card = 1;
    if(card>1){
        card-=1;
        if(card<7)
        puts("Small cards!");
    else
    puts("Ace!");
    return 0;    
}