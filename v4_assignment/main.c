/* 
 * File:   main.c
 * Author: Spw00004
 * 
 * Created on 20 March 2019, 13:49
 */

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h> // boolean
#include <time.h> // timer
#include <windows.h> //async key state
#include <conio.h> //kbhit
/* IMPORTANT, as using a windows.h file for the asyncKeyState function
 * this program is designed for use on a windows machine, due to the 
 * fact all university pc's are windows based I assumed that this would 
 * not be of any issue.
 */
bool isActive, key1_on,key2_on,key3_on,key4_on; //main loop booleans and key booleans
int delay; // delay amount
clock_t timeDelay; //clock for timed delay
// base setup
void setup()
{
    delay = 100; // time ms
    timeDelay = clock(); //set to clock now
    isActive = true;
    printf("********************************************************\n");
    printf("***                 V4 Assignment                    ***\n");
    printf("***       Press esc at any time to exit              ***\n");
    printf("***       Use keypad to issue key presses            ***\n");
    printf("***LEFT=Wi-i(1) DOWN=Wi-i(2) RIGHT=Wi-i(3) UP=Wi-i(4)***\n");
    printf("********************************************************\n\n\n");  
}

/*
 * Outputs the desired directional output and refreshes the screen on a timr
 * Then the booleans for arrows are rest
 */
void draw()
{
    system("cls");
    printf("********************************************************\n");
    printf("***                 V4 Assignment                    ***\n");
    printf("***       Press esc at any time to exit              ***\n");
    printf("***       Use keypad to issue key presses            ***\n");
    printf("***LEFT=Wi-i(1) DOWN=Wi-i(2) RIGHT=Wi-i(3) UP=Wi-i(4)***\n");
    printf("********************************************************\n\n\n");  
    //boolean expressions where a = key1 b = key2 c = key3 d = key4
    /*CW = ( !a && d) || (b && !c && d)
     *ACW =(a && !b && c) || ( !a && b && !d) || (b && c && !d)
     * L = (a && !b && !d) || ( !a && b && !c && d)
     * R = ( !a && !b && c) || ( !a && c && !d)
     * U = (a && !b && d) || ( !a && b && c && d)
     * D = (a && b && !c) || (a && b && !d)
     */
    if((!key1_on && key4_on)|| (key2_on && !key3_on && key4_on)) //CW
    {
        printf("\t\t\t>>>>>\n");
        printf("\t\t\t    V\n");
        printf("\t\t\t<<<<V\n");
        printf("\t\t\t CW\n\n");
    }
    if((key1_on && !key2_on && key3_on) || (!key1_on && key2_on && !key4_on)
            || (key2_on && key3_on && !key4_on)) //ACW
    {
        printf("\t\t\t<<<<<\n");
        printf("\t\t\tV    \n");
        printf("\t\t\tV>>>>\n");
        printf("\t\t\t ACW\n\n");
    }
    if((key1_on && !key2_on && !key4_on) || (!key1_on && key2_on
            && !key3_on && key4_on))//LEFT
    {
        printf("\t\t\t<----\n");
        printf("\t\t\t<----\n");
        printf("\t\t\t<----\n");
        printf("\t\t\tLEFT\n\n");
    }
    if((!key1_on && !key2_on && key3_on)||(!key1_on && key3_on && !key4_on))//RIGHT
    {
        printf("\t\t\t---->\n");
        printf("\t\t\t---->\n");
        printf("\t\t\t---->\n");
        printf("\t\t\tRIGHT\n\n");
    }
    if((key1_on && !key2_on && key4_on)||(!key1_on && key2_on && key3_on
            && key4_on)) //UP
    {
            printf("\t\t\t^^^^^\n");
            printf("\t\t\t|||||\n");
            printf("\t\t\t|||||\n");
            printf("\t\t\t UP\n\n");
    }
    if((key1_on && key2_on && !key3_on)||(key1_on && key2_on && !key4_on))//DOWN
    {
        printf("\t\t\t|||||\n");
        printf("\t\t\t|||||\n");
        printf("\t\t\tVVVVV\n");
        printf("\t\t\tDOWN\n\n");
    }
    key1_on = false;
    key2_on = false;
    key3_on = false;
    key4_on = false;   
}

/*
 * My program works via holing down the arrow keys to get the desired 
 * output as this in my mind is actually the closest representation 
 * of the working controller. 
 */
void input()
{
    if(timeDelay + delay < clock() && kbhit()) //delay for each in/out
    {
        timeDelay = clock();
        if(GetAsyncKeyState(VK_LEFT)) //key 1
        {
            key1_on = true;
        }
        if(GetAsyncKeyState(VK_DOWN)) //key 2
        {
            key2_on = true;
        }
        if(GetAsyncKeyState(VK_RIGHT)) //key 3
        {
            key3_on = true;
        }
        if(GetAsyncKeyState(VK_UP)) //key 4
        {
            key4_on = true;
        }
        if(GetAsyncKeyState(VK_ESCAPE)) //esc
        {
            isActive = false; //close
        }
        draw(); //output
    }
}
/*
 * Only needs the main loop here.
 */
int main(int argc, char** argv) 
{
    setup(); //base setup
    while(isActive)
    {    
        input(); //get input
    }
    return (EXIT_SUCCESS);
}

