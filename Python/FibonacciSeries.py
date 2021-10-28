number01 = 0
number02 = 0
number01 = input("Enter First number : ")  # Taking Input
number02 = input("Enter Second number : ")
""" First 5 numbers of Fibonacci series"""
if number02 > number01:  # Second number is greater Fibonacci series proceeds by 2nd number
    mul01 = (int(number01) + int(number02))
    mul02 = (int(number02) + int(mul01))
    mul03 = (int(mul01) + int(mul02))
    mul04 = (int(mul02) + int(mul03))
    mul05 = (int(mul03) + int(mul04))

else:
    mul01 = (int(number02) + int(number01))
    mul02 = (int(number01) + int(mul01))
    mul03 = (int(mul01) + int(mul02))
    mul04 = (int(mul02) + int(mul03))
    mul05 = (int(mul03) + int(mul04))
print(mul01)
print(mul02)
print(mul03)
print(mul04)
print(mul05)
