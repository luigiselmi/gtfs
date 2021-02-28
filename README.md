GTFS and Real-Time Extension
============================
This repository contains code used to parse General Transit Feed Specification (GTFS) and GTFS Realtime files made available as 
binary files  using the Protocol Buffers. 
The GTFS schema is used by many municipalities around the world to provide information about public transport services. In our 
examples we use the data published by the municipality of Rome. 
The GTFS schema is divided in two categories, static and real-time. The first concerns the structure of the service such as routes 
and stops, the second concerns waiting times at bus stops, travel times, the position of the vehicles and more. The [Open Data](https://romamobilita.it/it/tecnologie/open-data) 
section of the host of the data contains technical information. Static data is released in a zip file once a day and provides information 
regarding line changes, strikes or other. The monitoring files concerning the wait times are released every 30 seconds in binary 
format according to the Protocol Buffers standard.

In order to parse the data we need to download the Protocol Buffers compiler choosing the executable according to our operating system.
The compiler is used to create the source files from the GTFS or GTFS Realtime schema in one of the supported languages, Java in our case. 
In this project we use version 3.15.3 for Windows [protoc-3.15.3-win64.zip](https://github.com/protocolbuffers/protobuf/releases/download/v3.15.3/protoc-3.15.3-win64.zip)
The [GTFS Realtime schema](https://developers.google.com/transit/gtfs-realtime) is used to represent the actual status of the fleet. The option
java_package inside the gtfs-realtime.proto file can be used to set the package of the generated source code. If we want to use the generated code 
within a Maven project, like the present one, we can for example save the gtfs-realtime.proto file in the src/main/resources folder, set the 
output folder to src/main/java and execute the command 

    $ protoc src/main/resources/gtfs-realtime.proto --java_out=src/main/java/ 
    
The compiler will create the Java class with the interfaces used to access the data delivered as binary files.