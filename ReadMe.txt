PreRequisites:
1.	.net 2.0
2.	Java SE 5 or higher
3.	XXsd2Code.exe  (  Download Url :  http://sourceforge.net/projects/xxsd2code/files/XXsd2Code.exe/download)

Steps
1. Run the GenerateCrossPlatformDataBindings.bat.
2. Open .\CustomerOrderProcessing-DotNetClient\CustomerOrderProcessing.sln and compile it.
3. Open .\FulfillmentCenterSimple-JavaTcpIpServer using Eclipse.
4. Export a runnable jar.
5. Run the jar file using this command.  java -jar FulfillmentCenterApplication.jar
6. Now run the CustomerOrderProcessing.exe 127.0.0.1 1111


Note : 
Make sure you run GenerateCrossPlatformDataBindings.bat anytime you make change to the xsds 
in the CommonMessageContracts folder.
