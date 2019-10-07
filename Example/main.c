/* 
 * File:   main.c
 * Author: Stephen
 *
 * Created on 14 March 2019, 19:27
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) 
{   
    int a = 10;
    double b = 1.5f;
    double x = (double)(a * b); 
    printf(“x = %.2f”, x);
    return (EXIT_SUCCESS);
}

