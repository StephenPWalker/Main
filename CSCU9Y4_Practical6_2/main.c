/* 
 * File:   main.c
 * Author: Stephen
 *
 * Created on 01 March 2019, 12:58
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
void copy_array(double source[4], double destination[4], int end)
{
    for(int i = 0; i < end; i++)
    {        
        destination[i] = source[i];
    }
}
void ptr_array(double source[4], double destination[4], int end)
{
    double* p;
    for(int i = 0; i < end; i++)
    {     
        p = destination + i;
        *p = source[i];
    }
}
double dif(double source[4], int end)
{
    double average = 0;
    for(int i = 0; i < end; i++)
        average += source[i];
    average = average/end;
    double bZero  = average;
    double sZero = average;
    double* biggest = &bZero;
    double* smallest = &sZero;
    for(int i = 0; i < end; i++)
    {
        if (source[i] > *biggest)
        {
            *biggest = source[i];
        }
        if (source[i] < *smallest)
        {
            *smallest = source[i];
        }
        printf("%.2f, %.2f\n", *biggest, *smallest);
    }
    return *biggest - *smallest;
}
void add(double addedArray[4], double array[4], double array2[4], int end)
{
    double* p;
    for(int i = 0; i < end; i++)
    {     
        p = addedArray + i;
        *p = array[i] + array2[i];
        addedArray[i] = *p; 
        printf("%.2f, ", addedArray[i]);
    }
}
int main(int argc, char** argv) 
{
    double source[4] = {1,2.3,4.5,6.7};
    double destination1[4];
    double destination2[4];
    copy_array(source, destination1, 4);  
    for(int i = 0; i < 4; i++)
    {        
        printf("%.2f, ", destination1[i]);
    }
    printf("\n");
    ptr_array(source, destination2, 4);
    for(int i = 0; i < 4; i++)
    {        
        printf("%.2f, ", destination2[i]);
    }
    printf("\n");
    double diff = dif(source, 4);
    printf("Difference: %.2f\n", diff);
    printf("Added array: ");
    double addedArray[4];
    add(addedArray, destination1, destination2, 4);
    printf("\n");
    return (EXIT_SUCCESS);
}



