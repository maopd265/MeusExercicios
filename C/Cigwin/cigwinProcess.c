#include<stdio.h>
#include<unistd.h>
#include<stdlib.h>
#include<string.h>
#include<errno.h>
int main(int argc, char const *argv[])
{
    printf("\n\t ---------Chamadas do sistema operacional--------\n");
    char *args[]={"C:\\Users\\Samsung\\Desktop\\Material\\Atividades\\C\\BibliotecaAtividade\\output\\chamadaBiblioteca.exe",NULL};
    pid_t pid = fork();
    if (pid==-1)
    {
        fprintf(stderr,"Can't fork process: %s \n",strerror(errno));
    }if (!pid)
    {
        printf("\nProcesso pid :%d -----\n",getpid());
        execv(args[0],args);
        
        // exec("C:\\Users\\Samsung\\Desktop\\Material\\Atividades\\C\\BibliotecaAtividade\\output\\chamadaBiblioteca.exe");
    }else
    {
        printf("\nProcesso pid :%d -----\n",getpid());
        execv(args[0],args);
        return 1;
        // exec("C:\\Users\\Samsung\\Desktop\\Material\\Atividades\\C\\BibliotecaAtividade\\output\\chamadaBiblioteca.exe");
    }
    
    
    return 0;
}
