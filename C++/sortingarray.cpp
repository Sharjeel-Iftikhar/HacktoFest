#include<iostream>
using namespace std;
int main()
{
    int arr[5];
    int i,j;
    int temp;
    for(i=0;i<5;i++)
    {
        cout<<"Entr array :";
        cin>>arr[i];
    }
    for(int i=0;i<5;i++)
    {
        for(int j=i;j<5;j++)
        
        {
            ////////////////////////   > sign barey sa chota
            //////////////////////// < choty sa bara 
            if(arr[j]>arr[i])    
            {
               
                temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp; 
    
                
            }

        }
        
        
    }
     cout<<"Sorrted array :";
   for( int i=0;i<5;i++)
{
    cout<<arr[i]<<'\t';
}
    return 0;
}