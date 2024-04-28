

## Assignment 2: Develop any distributed application using CORBA to demonstrate object brokering.

### Installation - Only Open JDK-8

Before starting, ensure you have OpenJDK 8 installed. If not, install it by executing the following commands:

### Note: Only execute the JDK installation codes below if you haven't already done so in Lab 1.
```bash
sudo apt-get remove openjdk*     # Remove any existing OpenJDK installations
sudo apt update                  # Update package lists
sudo apt install openjdk-8-jdk   # Install OpenJDK 8 development kit
sudo apt install openjdk-8-jre   # Install OpenJDK 8 runtime environment
```

### Running the Application

#### Terminal 1: Setting Up CORBA Server

1. Generate Java files from IDL (Interface Definition Language):

    ```bash
    idlj -fall ReverseModule.idl
    javac *.java ReverseModule/*.java
    orbd -ORBInitialPort 1056&
    java ReverseServer -ORBInitialPort 1056& 
    ```
---
#### Terminal 2: Running the CORBA Client

```bash
java ReverseClient -ORBInitialPort 1056 -ORBInitialHost localhost
```



