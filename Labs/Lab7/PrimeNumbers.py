# Starting to check from 2, as 1 is not considered a prime number
x = 2
# Looping from 2 to 100 (inclusive)
while x < 101:
    # The lowerbound will always be 2
    lowerbound = 2
    flag = True
    # Taking each number "n" from 2 to 100 and checking if it is divisible (gives no remainder)
    # by any number from 2(the lowerbound) to n-1 (thus itself exclused).
    # If modulus gives no remainder for every division, the number is not prime.
    while lowerbound < x:
        if x%lowerbound == 0:
            flag = False
            break
        lowerbound = lowerbound + 1
    
    if flag == True:
        print(x)
    
    x = x + 1