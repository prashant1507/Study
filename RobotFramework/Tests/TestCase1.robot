*** Settings ***
Documentation    This is my first test case
Library    OperatingSystem


*** Variables ***
${MY-VARIABLE}    This is a test variable
${MY-LIST}    list1    list2    list3    list4
&{MY-DICTIONARY}    username=testUser    password=password
&{MY-DICTIONARY2}    username=testUser2    password=password2


*** Keywords ***
Log My Username
    Log     ${MY-DICTIONARY}[username]

Log My Password
    Log     ${MY-DICTIONARY}[password]
    
Log my username and password 1
    Log    Log My Username
    Log    Log My Password

Log my username and password 2
    Log My Username
    Log My Password

Log specific username
    [Arguments]    ${USERNAME}
    Log    ${USERNAME}

Log specific username and password
    [Arguments]    ${USERNAME}    ${PASSWORD}
    Log    ${USERNAME}
    Log    ${PASSWORD}
    

*** Test Cases ***
TEST1
    [Tags]    test1
    Set Test Documentation    This is TEST1 Doc
    Set Test Message    This is TEST1 msg
    Log    This is first test
    Log    ${MY-VARIABLE}
    Log    ${MY-LIST}[0]
    Log    ${MY-DICTIONARY}[username]
    Log My Username
    Log My Password
    Log my username and password 1
    Log my username and password 2
    Log specific username    ${MY-DICTIONARY2}[username]
    Log specific username and password    ${MY-DICTIONARY}[username]    ${MY-DICTIONARY}[password]
    Log Variables
    Count Files In Directory    /home/shibu/Desktop
    Remove Directory    /home/shibu/Desktop/test
    Logs    This is failed test case
TEST2
    [Tags]    test2a    test2b
    Log    This is first test
