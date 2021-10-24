#include<iostream>
using namespace std;

int main()
{
    const int size=7;
    int arr[size];
    int arr1[size];
    int input;
    cout<<"Enter the array : ";
    for(int i=0;i<size;i++)
    {
        cin>>arr[i];
         
    }
    cout<<"Enter the input : ";
    cin>>input;
    cout<<"Array after reversing : ";
    for(int i=size;i>=1;i--)
    {
        int j=0;
        
        cout<<arr[(i-input)%size]<<" ";
        
       // cout<<arr1[j]<<" ";
      
        
    }
    
    return 0;
}