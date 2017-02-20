# WordCounter
Server reads a file and Clients connect and get the 10 most frequent words in the text. 
###########################################################################################
There are 2 different Java projects made with Eclipse with the following names and structure:

>Client
  -src
    -Statistics.java
    -TextClient.java (incudes main method)
>Server
  -islands_in_the_stream.txt
  -src
    -TextProcessor.java
    -TextServer.java (incudes main method)

In order to execute and test it, the Server part needs to run first and 
then execute the Client on a different Eclipse instance on the same machine.
