*** Settings ***
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