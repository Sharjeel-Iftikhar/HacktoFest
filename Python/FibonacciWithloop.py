sum = 0

# taking input from user
num_1 = int(input("Enter first number : "))
num_2 = int(input("Enter second number : "))
last =  int(input("Enter number of terms : "))
nth = 0
#Using for loop to print fibonacci sequence
for i in range(0, last) :
    #printing the result
    print(num_1)
    nth = num_1 + num_2
    num_1 = num_2
    num_2 = nth
    
