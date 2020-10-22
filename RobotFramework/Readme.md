robot TestFolderOrTestFilePath

To run particular tag:
    robot -i tagName TestFolderOrTestFilePath

To run multiple tags use OR between tag names:
    robot -i tagNameORtagName TestFolderOrTestFilePath

To run test case with two tages. Use AND between tag names:
    robot -i tagNameANDtagName TestFolderOrTestFilePath

To randomix=ze the test execution order
    robot --randomize ALL TestFolderOrTestFilePath

Log level
    robot --loglevel INFO|DEBUG|TRACE TestFolderOrTestFilePath

To send all output files tpo a particular folder
    robot -d Output TestFolderOrTestFilePath