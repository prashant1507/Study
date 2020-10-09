#!/usr/bin/python3
import random
import time
import calendar
from datetime import datetime
import os

a = 10 # integer declaration
b = 20.10 # Float declaration
c = "Learn" # String declaration
d = "Python"
e = f = g = 5 # Multiple assignment
h,i,j = 1,2,"Python3" # Multi value assignment


print ("Practising Python")
print ("Changing last character using end", end="!!")  #Using end
print ()
# del i # Delete variable

def strings():
    z = "I am local variable" # Local variable declaration
    print (z) 
    print ("Printing String: "+ d) # Concat
    print ("Printing String:", d) # Concat
    print ("First Character: "+ c[0]) # Prints first character
    print ("Sub String: "+ c[1:3] + "  " + c[2:]) # Prints sub string
    print ("Print multiple times: "+ c * 3)

def lists():
    '''
        Lists are enclosed in brackets ( [ ] ) and their elements and size can be changed
    '''
    list1 = ['abcd', 786, 'def', "Hello how are you", """I am fine""", '''super''']
    list2 = ['xyz', 254] # Local list declaration
    print ("Printing List: ", list1) # Print complete list
    print ("Print First Element: ", list2[0]) # Print first element of list
    print ("Print Range: ", list1[2:4]) # Print range
    print ("Print Range: ", list1[2:]) # Print range
    print ("Print 2 times: ", list1 * 2) # Print multiple times
    print ("Concat two lists: ", list1 + list2) # Concat two lists
    # Assignment
    list2[1] = "xsd"
    print ("After assignment: ", list2)

def tuples():
    '''
        Tuples are enclosed in parentheses ( ( ) ) and cannot be updated. Tuples can be thought of as read-only lists
    '''
    tuple1 = ('abcd', 786, 2.23, 'john', 70.2)
    tuple2 = (123, 'john')
    print ("Print Full Tuple: ", tuple1)
    print ("Print first element: ", tuple2[0])
    print ("Print Range: ", tuple1[2:4])
    print ("Print Range: ", tuple1[2:])
    print ("Print 2 times: ", tuple2 * 2)
    print ("Concat: ", tuple1 + tuple2)

def dictionary():
    '''
        Dictionaries are represented bt key: value. Dictionaries are enclosed by curly braces ({ }) and values can be assigned and accessed using square braces ([])
    '''
    #dict1 = {}
    dict2 = {'name': 'python', 'code': 'red'}
    print ("Print dictionary:", dict2)
    print ("Print dictionary:", dict2['name'])
    print ("Print dictionary:", dict2.keys())
    print ("Print dictionary:", dict2.values())
    dict2['name'] = "java"
    dict2['school'] = "DPS"
    print ("Print dictionary:", dict2)

def convertionFunctions():
    p = 5
    q = "4"
    r = ['baby', 'shark']
    s = ('bus', 'car')
    print ("To string: "+ str(p) + q)
    print ("To integer:", p + int(q))
    print ("To float:", float(q))
    print ("To complex:", complex(p))
    print ("To tuple:", tuple(r))
    print ("To list:", list(s))

def comparisonOperators():
    a1 = 5
    b1 = 10
    print (a1 > b1)
    print (a1 < b1)
    print (a1 == b1)
    print (a1 != b1) # <> or !=
    print (a1 >= b1)
    print (a1 <= b1)

def membership():
    a1 = "World"
    print ('W' in a1)
    print ('e' not in a1)
    print ('World' is a1)
    print ('Hello' is not a1)

def ifElse():
    a = 5
    b = 6
    if ( a == b):
        print ("Equal")
    elif (a > b):
        print ("Not Greater")
    else:
        print ("Not Equal")

# def common():
    # While
    # For
    # Nested Loop
    # Exception

def timeDateCal():
    print (time.localtime(time.time()))
    print (calendar.month(2008, 1))
    print (datetime.now().strftime("%d/%m/%Y %H:%M:%S"))

def randomNumber():
    print (random.random())

def funParam(var):
    print (var)

def acceptInputFromUser():
    str = input("Enter your input: ") # Accepts input from user
    print ("Received input is:", str)

def fileIO():
    # Open a file
    fo = open("/home/shibu/Desktop/file.txt", "a")
    print ("Name of the file: ", fo.name)
    print ("Closed or not : ", fo.closed)
    print ("Opening mode : ", fo.mode)
    fo.write("From Write")
    fo = open("/home/shibu/Desktop/file.txt", "r")
    print(fo.read())
    fo.close()
    os.rename("/home/shibu/Desktop/file.txt","/home/shibu/Desktop/file1.txt")
#strings()
#lists()
#tuples()
#dictionary()
#convertionFunctions()
#comparisonOperators()
#membership()
#ifElse()
#timeDateCal()
#randomNumber()
#funParam("Hello")
#acceptInputFromUser()
#fileIO()
