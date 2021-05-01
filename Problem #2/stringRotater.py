#########################################################
# Programmer: Megan Spiers                              #
#                                                       #
# Purpose:    This was created to solve problem #2,     #
#             for the RTS Labs Coding Assessment.       #
#                                                       #
# Task:      "Rotate the characters in a string by a    #
#             given input and have the overflow appear  #
#             at the beginning, e.g. "MyString" rotated #
#             by 2 is "ngMyStri".                       #
#########################################################


#################################################################################
# This function takes in and returns the inputted String                        #
# For the sake of this program, numeric values will also be accepted as strings #
#################################################################################
def getInputString():

    # Prompt user to enter string
    inputString = input("Enter string to be rotated: " )

    # Return inputted String
    return inputString


####################################################################
# This function takes in the rotation number, checks its validity, #
# and returns the inputted rotation number                         #
####################################################################
def getRotationNumber(inputString):

    # Declare and initialize flag variable for while loop
    flag = False

    # While flag is false, use a try-catch to evaluate user input
    while (flag is not True):

        # Try the following code until input is valid
        try:

            # Prompt user for int value to rotate string by
            rotationNumber = int(input("Enter number of characters to rotate string by: "))

            # if the entered rotation value is greater than the length of the string, raise Value Error
            if (abs(rotationNumber) > len(inputString)):
                raise ValueError

            # Set flag = true to break out of while loop
            flag = True
        
        # If the user enters an element that is not valid, catch exception and start over
        except ValueError:

            # Print message prompting user to enter correct values
            print("\nAbsolute value of rotation number must be an integer <= length of input String\n")

    # Return the validated rotationNumber
    return rotationNumber
 

#######################################################################
# This function uses the inputString and rotationNumber to rotate     #
# the inputString to the left (negative rotationNumber) or            #
# right (positive rotationNumber) by the desired number of characters #
#######################################################################
def rotateString(inputString, rotationNumber):

    # If rotationNumber is positive, rotate string to the right
    if (rotationNumber > 0):

        # Set portionToRotate as everything from (length of inputString - rotationNumber) to the end of inputString
        portionToRotate = inputString[(len(inputString) - rotationNumber) :]

        # Set portionToSlideDown as everything from the beginning of inputString to (length of inputString - rotationNumber)
        portionToSlideDown = inputString[0 : (len(inputString) - rotationNumber)]

        # Set new string = to portionToRotate + portionToSlideDown
        newString = portionToRotate + portionToSlideDown

    # If rotationNumber is negative, rotate string to the left
    elif (rotationNumber < 0):

        # Set portionToRotate = everything from beginning of inputString to absolute value of rotationNumber
        portionToRotate = inputString[0 : abs(rotationNumber)]

        # Set portionToSlideBack = everything from absolute value of rotationNumber to the end of inputString
        portionToSlideBack = inputString[abs(rotationNumber) :]

        # Set new string = to portionToSlideBack + portionToRotate
        newString = portionToSlideBack + portionToRotate

    # If rotationNumber is 0, string remains unchanged
    else:

        # Set newString = to unaltered inputString
        newString = inputString

    # Print the new rotated String
    print("\n" + newString)


###################################################################################################
# This main function simply calls and runs the three previously created functions as follows:     #
# getInputString(), getRotationNumber(inputString), and rotateString(inputString, rotationNumber) #                               #
###################################################################################################
def main():

    # call getInputString() function and set output to stringToRotate
    stringToRotate = getInputString()

    # call getRotationNumber(inputString) function and set output to rotationNumber
    rotationNumber = getRotationNumber(stringToRotate)

    # Call rotateString(inputString, rotationNumber) function to print rotated String
    rotateString(stringToRotate, rotationNumber)


# If main() function exists, call it
if __name__ == '__main__':

    # Call main() function
    main()