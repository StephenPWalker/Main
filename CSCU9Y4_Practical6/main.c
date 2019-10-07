/* 
 * File:   main.c
 * Author: Stephen
 *
 * Created on 28 February 2019, 12:25
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) 
{
    double source[4] = {1,2.3,4.5,6.7};
    //double destination1[4];
    //double destination2[4];
    for(int i = 0; i++; i < 4)
    {
        printf("%d", source[i]);
    }
    //copy_array(source, destination1, 4);
    //copy_ptr(source, destination2, 4);
    return (EXIT_SUCCESS);
}
