# NETWORKING  PROGRAMMING PROJECT V0.1

## CONTENTS OF THIS FILE

* Description of Project Design

* Requirements

* Instructions for running the application

* References

## DESCRIPTION OF PROJECT DESIGN
Project to design and implement a network-based chat application in Java, using the Java Socket API. The program is used to transfer data from Client to Server. Furthermore, it includes additional functionality for implementing multi user chat server using Java TCP Socket programming. 
The project contains the client program – ChatClient – that implements the client side functionality and The Server program – ChatServer – that facilitates the server-side functionality

## REQUIREMENTS

As the project comes inside a zip compressed folder, all the files need to be extracted to a secure location in the user's machine.

The zip compressed folder contains four Java classes written in Eclipse: ChatClient1 ChatServer1, ChatClient2 & ChatServer2

The ChatClient1 class transfers data from Client to Server only. The ChatClient2 class implements a multi-client chat server. 

This program requires to be opened from a Terminal.

## INSTRUCTIONS FOR RUNNING THE APPLICATION

ChatClient.java/ChatServer.java Programme:
•	Open up a new Terminal window or in Eclipse terminal console.

•	Run Server (java ChatServer.java).

•	Run Client (java ChatClient.java) – One can run multiple of these in different terminal windows and the server is capable of seeing all of the clients messages in the console.

•	Client Prompted to enter a username.

•	Chat between Server and Client is now initiated – Client begins by inputting a message in the console and then this message is displayed on the server console/ Server responds to Clients message and this reply is displayed on client console. This messaging goes back and forth until a user wants to end the connection and quit.

•	To terminate connection with the Server, the Client enters ‘quit’ and the program exits (which can be done at any time).

•	To end Server Connection, Server enters ‘quit’ and the program exits (which can be done at any time).

## REFERENCES:
1)	https://github.com/paulpjoby/java-socket-multi-user-chat-server
2)	https://gyawaliamit.medium.com/multi-client-chat-server-using-sockets-and-threads-in-java-2d0b64cad4a7
3)	https://www.geeksforgeeks.org/socket-programming-in-java/


