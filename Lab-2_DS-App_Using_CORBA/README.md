Below is the revised version of your instructions for Assignment 3 in a README.md file:

---

## Assignment 3: Running Java Application with CORBA (Common Object Request Broker Architecture)

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
    ```

2. Compile all Java files:

    ```bash
    javac *.java ReverseModule/*.java
    ```

3. Start the Object Request Broker Daemon (ORBD):

    ```bash
    orbd -ORBInitialPort 1056&
    ```

4. Start the CORBA server:

    ```bash
    java ReverseServer -ORBInitialPort 1056&
    ```
---
#### Terminal 2: Running the CORBA Client

```bash
java ReverseClient -ORBInitialPort 1056 -ORBInitialHost localhost
```


