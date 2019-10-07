/* 
 * File:   main.cpp
 * Author: Stephen
 *
 * Created on 17 January 2019, 18:16
 */
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int main(void)
{   
    int num, rev;
    char str[10];
    printf("Enter a number maximum ten digits: ");
    scanf("%d", &num);
    sprintf(str, "%d", num); //formats the string with the int value
    strrev(str); //reverses the string
    rev =  atoi(str);  // converts string to integer
    printf("The reversal is: ");
    printf("%d", rev); //print reverse
    printf("\n"); //newline
    return 0;
}