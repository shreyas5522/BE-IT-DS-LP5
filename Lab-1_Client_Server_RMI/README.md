## Assignment 1: Running Java Application with RMI (Remote Method Invocation)

### Installation

Before starting, make sure you have OpenJDK 8 installed. If not, you can install it by following these steps:

``` bash
sudo apt-get remove openjdk*     # Remove any existing OpenJDK installations
sudo apt update                  # Update package lists
sudo apt install openjdk-8-jdk   # Install OpenJDK 8 development kit
sudo apt install openjdk-8-jre   # Install OpenJDK 8 runtime environment
```

To verify that Java 8 is installed correctly, run:

``` bash
java -version
```

### Running the Application

#### Terminal 1: Setting Up RMI Registry

1. Compile all Java files:

``` bash
javac *.java
```

2. Compile the server implementation file:

``` bash
rmic ServerImplementation
```

3. Start the RMI registry:

``` bash
rmiregistry
```

#### Terminal 2: Starting the Server

``` bash
java Server
```

#### Terminal 3: Connecting the Client

**Arthemtic**: For performing arithmetic operations (addition, subtraction, multiplication, division), run:

``` bash
java Client 10 20
```

**Square**: To calculate the square and square root of a number, run:

``` bash
java Client 25
```

**Equal Strings**: To check if two strings are equal, run:

``` bash
java Client abc abc
```

**Palindrome:** To check if a string is a palindrome, run:

``` bash
java Client aba
```