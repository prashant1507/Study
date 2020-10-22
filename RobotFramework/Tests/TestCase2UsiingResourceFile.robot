*** Settings ***
Documentation    This is my second test case using resource file. Doesnt require keywaord and variable section
Resource    ../Resources/resources.robot



*** Test Cases ***
TEST3
    Log    ${MY-VARIABLE}
    Log    ${MY-LIST}[0]
    Log    ${MY-DICTIONARY}[username]
    Log My Username
    Log My Password
    Log my username and password 1
    Log my username and password 2
    Log specific username    ${MY-DICTIONARY2}[username]
    Log specific username and password    ${MY-DICTIONARY}[username]    ${MY-DICTIONARY}[password]
    Count Files In Directory    /home/shibu/Desktop