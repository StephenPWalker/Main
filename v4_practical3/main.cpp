/* 
 * File:   main.cpp
 * Author: Stephen
 *
 * Created on 19 January 2019, 17:14
 */

#include <stdbool.h> /* C99 only */
#include <stdio.h>
int main(void)
{
    bool playing = true;
    
    while(playing)
    {
        bool digit_seen[10] = {false};
        int digit;
        int allDigits[10] = {0,0,0,0,0,0,0,0,0,0};
        long n;
        int count = 0;
        printf("\n********************************\n\n");
        printf("To quit enter a negative number \n");
        printf("Enter a number: ");
        scanf("%ld", &n); /* Not ‘1’, but lower-case L! */
        if(n <= 0)
        {
            playing = false;
        }

        while (n > 0) 
        {
            digit = n % 10;
            for(int i = 0; i < digit; i++)
            {
                if(i = digit)
                {
                    allDigits[i] += 1;
                    break;
                }
            }
            if (digit_seen[digit])
            {
                count++;
            }
            digit_seen[digit] = true;
            n /= 10;
        }
        if(count > 0)
        {
            printf("Digit:  0 1 2 3 4 5 6 7 8 9\n");
            printf("amount: ");
            for(int i = 0; i < 10; i++)
            {
                printf("%d ", allDigits[i]);
            }
            printf("\n");
        }
        else
        {
            printf("No repeated digit\n");
        }
        
        if(playing == false)
        {
            printf("End of program.\n\n");
        }
    }

    return 0;
}