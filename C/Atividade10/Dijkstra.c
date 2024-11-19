#include <stdio.h>

#inf 1000000000

int dijkstra(int G[5][5], int s, int t)
{
int d[5],visit[5];
for (int i=0;i<5;i++) {d[i]=inf;visit[i]=0;}
d[s]=0;
while(1)
   {
   int menor=inf;
   int vm=0;
   for (int i=0;i<5;i++){
    if (d[i]<menor && visit[i]==0)
        {
        menor=d[i];
        vm=i;
        }
    }
   if (menor==inf) break;
   //if (vm==t) break;
   visit[vm]=1;
   for (i=0;i<5;i++)
        if (G[vm][i]>0 && visit[i]==0 && d[i]>d[vm]+G[vm][i])
            d[i]=d[vm]+G[vm][i];
   }
return d[t];
}
int main(int argc, char const *argv[])
{
    
    
    return 0;
}
