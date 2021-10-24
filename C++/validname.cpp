#include<iostream>
using namespace std;
bool isValidname(string name);
int main()
{
    bool flag;
    string name;
    cout<<"Enter the name : ";
    getline(cin,name);
    flag=isValidname(name);
    if(flag==true)
    {
        cout<<"ok";
    }
    else
    {
        cout<<"Invalid name";
    }
    return 0;
    
} 
bool isValidname(string name)
{
     bool flag=true;
    int size=name.length();
    if(size<=50)
    {
        for (int i = 0; i < name.length(); i++)
        {
            if (!((name[i] >= 'a' && name[i] <= 'z') || (name[i] >= 'A' && name[i] <= 'Z') || (name[i] == ' ')))
                flag = false;
        }
    }
    else
        flag = false;

    return flag;
}
