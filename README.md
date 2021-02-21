# pdf-validator-utility

This is a utilty developed using a java library Qoppa pdf library, the required jar files can be downloaded from here https://www.qoppa.com/download2018r1/
The utlity is designed using selenium and it works in below manner:
-The entry point function takes the file url / file name from  where the pdf needs o be downloaded, here selenium is used to initiate the file download if the pdf is located in any server.
-Then the downloaded file is passed to the pdfVlidation function which performs the various actions on the PDF ie. to check the content, to check  for the blank pages, and gives the result baased on check

Try this library  https://www.qoppa.com/  in your project, as its maintaing a very tidy documentation for all the inbuilt functions 
