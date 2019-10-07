/* 
 * File:   main.cpp
 * Author: Stephen
 *
 * Created on 08 February 2019, 18:18
 */
#include <iostream>
#include <cctype> 
#include <conio.h>
#include <windows.h>

using namespace std;
bool gameOver, commence, hasMap, isMoving;
char nextTo[4];
int mapWidth = 60, mapHeight = 20, random, myX, myY, lastX, lastY;
int myClass;
char mage[11][20]= {"*****************","*               *","*     _____     *",
        "*    /_____\\    *","*   //#####\\\\   *","*  //#######\\\\  *",
        "*  ||#######||  *", "*  ||_______||  *","* //  \\\\ //  \\\\ *",
        "*//   (8X8)   \\\\*", "*****************"};
char knight[11][20] = {"*****************","*  |\\________/| *","*  |__________| *",
        "*  //&&&&&&&&\\\\ *","*  || V   V  || *","*  ||#  ^   #|| *",
        "*  ||## __ ##|| *", "*  ||########|| *","* //_________\\\\ *",
        "*//     \\/    \\\\*", "*****************"};
char cleric[11][20]= {"*****************","*               *","*    sssssss    *",
        "*   sssssssss   *","*  /u  u sssss  *","*  \\ __  sssss  *",
        "*   \\     ssss  *", "*    \\____sss   *","*   //  ||ss\\\\  *",
        "*  //   ||s  \\\\ *", "*****************"};
char goblin[11][20] = {"*****************","*   /|          *","*  / |          *",
"* |  ||\\_____/| *","* |  |\\_______/ *","*MMMMMM||\\ /||  *","*  ||  \\  __ /  *",
"* (  \\  \\___/   *","*  db\\  \\_/ \\__ *","*      \\_      \\*","*****************"};
enum eDirection {STOP = 0, LEFT, RIGHT, UP, DOWN};
eDirection dir;

void start()
{        
    cout << "\t*******************************************************" << endl;
    cout << "\t****             Welcome to Adventure             *****" << endl;
    cout << "\t*******************************************************" << endl;
    cout << endl << endl;  
    char allChars[12][60] = 
    {"*****************  *****************  *****************",
    "*               *  *  |\\________/| *  *               *",
    "*     _____     *  *  |__________| *  *    sssssss    *",
    "*    /_____\\    *  *  //&&&&&&&&\\\\ *  *   sssssssss   *",
    "*   //#####\\\\   *  *  || V   V  || *  *  /u  u sssss  *",
    "*  //#######\\\\  *  *  ||#  ^   #|| *  *  \\ __  sssss  *",
    "*  ||#######||  *  *  ||## __ ##|| *  *   \\     ssss  *",
    "*  ||_______||  *  *  ||########|| *  *    \\____sss   *",
    "* //  \\\\ //  \\\\ *  * //_________\\\\ *  *   //  ||ss\\\\  *",
    "*//   (8X8)   \\\\*  *//     \\/    \\\\*  *  //   ||s  \\\\ *", 
    "*****************  *****************  *****************",
    "     (M)AGE              (K)NIGHT            (C)LERIC"};
    for(int i = 0; i < 12; i++)
        cout << "\t" << allChars[i] << "\n";
    
    cout << "\n\tSelect a character using the keys donated in the (x): ";   
    char input;
    cin >> input;
    
    input = toupper(input);
    
    while(input != 'M' && input != 'K' && input != 'C')
    {
        cout << "\tPlease enter valid input, either (M)age, (K)night or, (C)leric: ";
        cin >> input;
        input = toupper(input);
    }
    cout << "\tYou selected: ";
    if(input == 'M')
    {
        cout << "Mage" << endl;
        myClass = 1;
    }
    else if(input == 'K')
    {
        cout << "Knight" << endl;
        myClass = 2;
    }
    else if(input == 'C')
    {
        cout << "Cleric" << endl;
        myClass = 3;
    }   
}

void setup()
{
    gameOver = false;
    commence = false;
    hasMap = false;
    isMoving = true;
    commence = true;
    myX = 1;
    myY = 1;
    start();
}

void draw()
{
    system("cls");
    char map[20][61] = 
    {"111111111111111111111111111111111111111111111111111111111111",
    "100000000000000000000000000000000000000000000000000011111111",
    "111111111111111111111111111111111111111111111000001111111111",
    "111111111111111111111111111111111100000000000000000000011111",
    "111111111111111111111111111111111111111000000001111111111111",
    "111111111111111000000000000000000000000000000000001111111111",
    "111111111111111110000000000000000001111111111111111111111111",
    "111111000200011111111111111111000000000011111111111111111111",
    "111100000000111111111111111111111000000000011111111111111111",
    "111100000000111111111111111111100000000000011111111111111111",
    "111100000111111111111111111111110000000000001111111111111111",
    "111000011111111111111111111111000000000001111111111111111111",
    "111100000011111111111111111000000000000011111111111111111111",
    "111000000011111111111111111111100000000001111111111111111111",
    "111110000000001111111111110000000111100000111111111111111111",
    "111111111000000000000000000000011111110000000111111111111111",
    "110401111100000000000000011111100001111000001111111111111111",
    "110005500000001111111110000011110001110000000003111111111111",
    "110005500000001111111111000000000000110000000011111111111111",
    "111111111111111111111111111111111111111111111111111111111111"};
    cout << "\n\n\n";
    //char 0 - left /1 - up /2- right /3 - down
    nextTo[0] = map[myY][myX - 1];
    nextTo[2] = map[myY][myX + 1];
    nextTo[1] = map[myY - 1][myX];
    nextTo[3] = map[myY + 1][myX];
    for(int i = 0; i < 20; i++) 
    {
        cout << "\t";
        for(int j = 0; j < 60; j++)
        {
            char pos = map[i][j];
            if(i == myY && j == myX)
            {   
                cout << 'O';
                pos = 'x';
            }
            if(pos == '1')
                cout << '@';
            else if(pos == '2')
                cout << 'x';
            else if(pos == '3')
                cout << 'M';
            else if(pos == '4')
                cout << 'T';
            else if (pos == '5')
                cout << '#';
            else if (pos == '0') 
                cout << ' ';
        }
        cout <<endl;
    }
    cout << endl << "\tMy position: x = " << myX << " y = " << myY << endl; 
}
void logic()
{
    switch(dir)
    {
        case LEFT:
            if(nextTo[0] != '1')
            {
                myX--;
            }
            break;
        case RIGHT:
            if(nextTo[2] != '1')
            {
                myX++;
            }
            break;
        case UP:
            if(nextTo[1] != '1')
            {
                myY--;
            }
            break;
        case DOWN:
            if(nextTo[3] != '1')
            {
                myY++;
            }
            break;
        default:
            break;      
    }
    draw();
}
void input()
{
    if(isMoving)
    {
        if(_kbhit())
        {
            switch(_getch())
            {
                case 'a':
                    dir = LEFT;
                    break;
                case 'd':
                    dir = RIGHT;
                    break;
                case 'w':
                    dir = UP;
                    break;
                case 's':
                    dir = DOWN;
                    break;
                case 'x':
                    gameOver = true;
                    break;
            }
            logic();
        }
        else
        {
            dir = STOP;
        }
    }
    else
    {
        
    }
}

void intro()
{
    system("cls");
    char input;
    cout << endl << "\t";
    for(int i = 0; i < 69; i ++)
        cout << '*';
    cout << endl;
    cout <<   "\t**       You awaken in an unknown forest, dazed and confused!      **" << endl;
    cout << "\n\t**You should search the area and look for anything that might help!**";
    cout << endl << "\t";
    for(int i = 0; i < 69; i ++)
        cout << '*';
    cout << endl;
    cout << "\n\tNOTE: $(Use the wasd keys to move around)$" << endl;
    cout << "\tNOTE: $(Use x key to quit at anytime)$" << endl;
    cout << "\n\tPress any key then enter to continue: ";
    cin >> input;
    cout << endl;
    draw();
}

int main() 
{  
    setup();
    intro();
    while(!gameOver)
    {
        if(commence)
        {     
            input();
        }
    }
    return 0;
}


