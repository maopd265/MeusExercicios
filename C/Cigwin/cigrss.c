#include<unistd.h>
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<errno.h>
int main(int argc, char const *argv[])
{
    char *feeds[]={"http://www.cnn.com/rss/celebs.xml",
                    "http://www.rollingstone.com/rock.xml",
                    "http://eonline.com/gossip.xml"};

    int times=3;
    char *frase =argv[1];
    for (int i = 0; i < times; i++)
    {
        char var[255];
        sprintf(var,"RSS_FEED=%s",feeds[i]);
        char *vars[]={var,NULL};
        pid_t pid =fork();
        if (pid==-1)
        {
             fprintf(stderr,"Can't fork process: %s \n",strerror(errno));
             return 1;
        }if(!pid){
        
        if (execle("/usr/bin/python","/usr/bin/python","./rssgossip.py",frase,NULL,vars)==-1)
        {
          fprintf(stderr,"Can't run script:%s\n",strerror(errno));
          return 1;
        }
        }
        
    }
    
    return 0;
}
