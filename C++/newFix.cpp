#include <stdlib.h>
#include <stdio.h>
#include <conio.h>
#include <iostream>
#include <windows.h>
using namespace std;
void gotoxy(short x, short y);
int ghostx2 = 17;
int ghosty2 = 9;
int ghostx = 17;
int ghosty = 6;
int pmanx = 6;
int pmany = 2;
int counter = 0;
int leftLimit = 2;
int rightLimit = 28;
int upperLimit = 0;
int lowerLimit = 32;
string ghostDirection = "Right";
void movePacmanLeft();
void movePacmanRight();
void movePacmanUP();
void movePacmanDown();
void ShowMap();
void moveGhost();
void moveGhost2();
char map[18][60] = {
    "+_________________________________________________________+",
    "|      | ............. #      #      #      # .           |",
    "| .......   |....................    #    ................|",
    "|##   ####### ........  # .####      #    . # .       |   |",
    "|   |..............     # .| .       #    . # . ######|   |",
    "| | |### |  |     .     | .| .            . # .       |   |",
    "| |      |  | |###. |   | .|............... # .       |   |",
    "| | #####|  | |   .  ## | .|####### . #   . . ........#   |",
    "| |               . |     .|        . #   .   .       #   |",
    "| |##### ### ......  ##   .|        . #   . # .       #   |",
    "|.................######  .######## . #   . # .       #   |",
    "|..............................     . #   . # ........#   |",
    "|  ### #### .    ###  .  ######   ##      #########  .    |",
    "| .............|.........         |         # .      .#   |",
    "|................ .|    .|        |         # .      .#   |",
    "|          |   |. .|.....|.....   |         # .      .#   |",
    "|          |   |   |                                      |",
    "+++++++++++|+++|+++|++++++++++++++|++++++++++++++++++++++++"};
int main(void)
{

  system("cls");
  ShowMap();

  bool gameRunning = true;
  //showing pacman
  gotoxy(pmanx, pmany);
  cout << "P";
  while (gameRunning)
  {                //ascii codee for escape
    gotoxy(65, 8); //showing scores
    cout << "Your SCORE -> ";
    cout << counter;

    if (GetAsyncKeyState(VK_LEFT))
    { //ascii LEFT arrow

      movePacmanLeft();
    }
    if (GetAsyncKeyState(VK_RIGHT))
    { //ascii right arrow

      movePacmanRight();
    }

    if (GetAsyncKeyState(VK_UP))
    { // up arrow key
      movePacmanUP();
    }
    if (GetAsyncKeyState(VK_DOWN))
    { //down arrow key
      movePacmanDown();
    }
    if (GetAsyncKeyState(VK_ESCAPE))
    {
      gameRunning = false;
    }
    if (pmanx == ghostx && pmany == ghosty || pmanx == ghostx2 && pmany == ghosty2)
    {
      system("CLS");
      gotoxy(63, 18);
      cout << "Game Over" << endl;
      cout << "your Score -> ";
      getch();
      cout << counter << endl;
      gameRunning = false;
    }
    moveGhost();
    moveGhost2();
    Sleep(170);
  }
}
void movePacmanUP()
{
  gotoxy(pmanx, pmany);
  if ((map[pmany - 1][pmanx] == ' ') || (map[pmany - 1][pmanx] == '.'))
  { // this condition stop pacman to cross the boundaries.
    if (map[pmany - 1][pmanx] == '.')
    {
      map[pmany - 1][pmanx] = ' ';
      counter++;
    }
    pmany = pmany - 1;
    cout << " ";
    gotoxy(pmanx, pmany);
    cout << "P";
  }
}
void movePacmanDown()
{
  if ((map[pmany + 1][pmanx] == ' ') || (map[pmany + 1][pmanx] == '.'))
  {
    gotoxy(pmanx, pmany);
    if (map[pmany + 1][pmanx] == '.')
    {
      map[pmany + 1][pmanx] = ' ';
      counter++;
    }
    cout << " ";
    pmany = pmany + 1;
    gotoxy(pmanx, pmany);
    cout << "P";
  }
}
void movePacmanRight()
{
  if ((map[pmany][pmanx + 1] == ' ') || (map[pmany][pmanx + 1] == '.'))
  {
    if (map[pmany][pmanx + 1] == '.')
    {
      map[pmany][pmanx + 1] = ' ';
      counter++;
    }
    gotoxy(pmanx, pmany);
    cout << " ";
    pmanx = pmanx + 1;
    gotoxy(pmanx, pmany);
    cout << "P";
  }
}
void movePacmanLeft()
{
  if ((map[pmany][pmanx - 1] == ' ') || (map[pmany][pmanx - 1] == '.'))
  {
    if (map[pmany][pmanx - 1] == '.')
    {
      map[pmany][pmanx - 1] = ' ';
      counter++;
    }
    gotoxy(pmanx, pmany);
    cout << " ";
    pmanx = pmanx - 1;
    gotoxy(pmanx, pmany);
    cout << "P";
  }
}
void moveGhost()
{ //default ghost
  gotoxy(ghostx, ghosty);
  cout << ".";
  if (pmanx > ghostx && ((map[ghosty][ghostx + 1] == ' ') || (map[ghosty][ghostx + 1] == '.') && (map[ghosty][ghostx + 1] != 'k')))
  { //ghost right
    ghostx = ghostx + 1;
  }
  else if (pmany > ghosty && ((map[ghosty + 1][ghostx] == ' ') || (map[ghosty + 1][ghostx] == '.') && (map[ghosty + 1][ghostx] != 'k')))
  { //ghost up
    ghosty = ghosty + 1;
  }
  else if (pmanx < ghostx && ((map[ghosty][ghostx - 1] == ' ') || (map[ghosty][ghostx - 1] == '.') && (map[ghosty][ghostx - 1] != 'k')))
  { //ghost left

    ghostx = ghostx - 1;
  }
  else if (pmany < ghosty && ((map[ghosty - 1][ghostx] == ' ') || (map[ghosty - 1][ghostx] == '.') && (map[ghosty - 1][ghostx] != 'k')))
  { //ghost up
    ghosty = ghosty - 1;
  }

  gotoxy(ghostx, ghosty);
  cout << "G";
}
void moveGhost2()
{
  gotoxy(ghostx2, ghosty2);
  cout << ".";
  if (pmanx > ghostx2 && ((map[ghosty2][ghostx2 + 1] == ' ') || (map[ghosty2][ghostx2 + 1] == '.') && (map[ghosty2][ghostx2 + 1] != 'G')))
  { //ghost right
    ghostx2 = ghostx2 + 1;
  }
  else if (pmany > ghosty2 && ((map[ghosty2 + 1][ghostx2] == ' ') || (map[ghosty2 + 1][ghostx2] == '.') && (map[ghosty2 + 1][ghostx2] != 'G')))
  { //ghost down
    ghosty2 = ghosty2 + 1;
  }
  else if (pmanx < ghostx2 && ((map[ghosty2][ghostx2 - 1] == ' ') || (map[ghosty2][ghostx2 - 1] == '.') && (map[ghosty2][ghostx2 - 1] != 'G')))
  { //ghost left

    ghostx2 = ghostx2 - 1;
  }
  else if (pmany < ghosty2 && ((map[ghosty2 - 1][ghostx2] == ' ') || (map[ghosty2 - 1][ghostx2] == '.') && (map[ghosty2 - 1][ghostx2] != 'G')))
  { //ghost up
    ghosty2 = ghosty2 - 1;
  }
  gotoxy(ghostx2, ghosty2);
  cout << "k";
}
void gotoxy(short x, short y)
{
  HANDLE hStdout = GetStdHandle(STD_OUTPUT_HANDLE);
  COORD position = {x, y};
  SetConsoleCursorPosition(hStdout, position);
}
void ShowMap() //to Show Grid
{
  for (int i = 0; i < 18; i++)
  {
    for (int j = 0; j < 60; j++)
    {
      cout << map[i][j];
    }
    cout << endl;
  }
}
