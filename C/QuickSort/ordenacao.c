#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
int compareInts(const void *a, const void *b) {
    int intA = *(int*)a;
    int intB = *(int*)b;
    return (intA - intB);
}

int main(int argc, char const *argv[])
{
    int values[] = {40, 10, 100, 90, 20, 25};
    int n = sizeof(values) / sizeof(values[0]);
    printf("Array : ");
    for (int i = 0; i < n; i++) {
        printf("%d ", values[i]);
    }
    printf("\n");
    // Usando qsort para ordenar o array
    qsort(values, n, sizeof(int), compareInts);
    printf("Array Ordenado : ");
    // Imprimindo o array ordenado
    for (int i = 0; i < n; i++) {
        printf("%d ", values[i]);
    }
    printf("\n");

    return 0;
}
