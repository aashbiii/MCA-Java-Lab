# MCA 202: Object Oriented Programming Using Java

> **Master of Computer Applications (MCA) — Semester 2**  
> **Course Code:** MCA 202 | **Subject:** Java Programming Laboratory  
> **Institution:** Department of Computer Science, Rajagiri College of Social Sciences (Autonomous), Kalamassery  
> **Student:** Ashbi Saju  

---

## Repository Overview

This repository contains the complete codebase for the Java Programming Laboratory, structured into:
1. **Official Lab Cycle (`LAB CYCLE/`):** 61 advanced programs covering Core Java, OOP, Multithreading, Sockets, JDBC, Serialization, and Swing GUI.
2. **Logical Foundations / Practice Set (`Sample Qns/`):** 20 foundational algorithmic and arithmetic programs accompanied by the reference guide `Java L1. Refresh Your Logical Part.pdf`.

---

## Table of Contents

- [Curriculum Breakdown by Module](#curriculum-breakdown-by-module)
- [Official Lab Cycle Program Catalog (Q1 – Q61)](#official-lab-cycle-program-catalog-q1--q61)
- [Foundational Practice Questions (Sample Q1 – Q20)](#foundational-practice-questions-sample-q1--q20)
- [Compilation & Execution Instructions](#compilation--execution-instructions)

---

## Curriculum Breakdown by Module

| Module | Core Java Concept Areas | Lab Cycle Questions |
| :--- | :--- | :--- |
| **Module 1** | CLI Arguments, Control Statements & Games | Q1 – Q3, Q7 – Q9 |
| **Module 2** | Arrays, 2D Matrices, Passing Arrays & Recursion | Q4 – Q6, Q10 |
| **Module 3** | Object-Oriented Principles, Encapsulation, Classes & Objects | Q11 – Q14 |
| **Module 4** | Inheritance, Polymorphism, Dynamic Dispatch, `super` | Q15 – Q18 |
| **Module 5** | Interfaces & Multiple Inheritance Abstraction | Q19 – Q20 |
| **Module 6** | Exception Handling (Multiple Catch, Custom Exceptions, Rethrow) | Q21 – Q24 |
| **Module 7** | Multithreading (Thread, Runnable, Parallel Processing, Scheduling) | Q25 – Q29, Q34 |
| **Module 8** | Thread Synchronization & Inter-Thread Communication (`wait`/`notify`) | Q30 – Q33, Q35 |
| **Module 9** | Java Generics (Generic Methods & Generic Classes) | Q36 – Q37 |
| **Module 10** | String Manipulation & Mutable `StringBuffer` Architecture | Q38 – Q39 |
| **Module 11** | Network Programming (TCP/UDP Sockets, Chat, File Transfer, URLs) | Q40 – Q48 |
| **Module 12** | Database Connectivity (JDBC, PreparedStatement, Transactions, Batch) | Q49 – Q53 |
| **Module 13** | Object Serialization (IS-A, HAS-A, `transient` fields) | Q54 – Q57 |
| **Module 14** | Java Swing GUI Application Development | Q58 – Q61 |

---

## Official Lab Cycle Program Catalog (Q1 – Q61)

Directory: [`LAB CYCLE/`](./LAB%20CYCLE/)

| Sl. No. | Lab Cycle Question Statement | Source File | Category |
| :---: | :--- | :--- | :--- |
| 1 | Implement command line arguments (Sum of integers passed via CLI) | [`LAB CYCLE/PG1SumCLA.java`](./LAB%20CYCLE/PG1SumCLA.java) | CLI & Basics |
| 2 | Implement switch case arithmetic operations using command line arguments | [`LAB CYCLE/PG2ArithmeticCLA.java`](./LAB%20CYCLE/PG2ArithmeticCLA.java) | Control Flow |
| 3 | Simulate a random number guessing game with interactive user feedback | [`LAB CYCLE/PG3GuessNumber.java`](./LAB%20CYCLE/PG3GuessNumber.java) | Control Flow |
| 4 | Search for an element and sort an array in ascending order | [`LAB CYCLE/PG4SearchAndSort.java`](./LAB%20CYCLE/PG4SearchAndSort.java) | Arrays & Sorting |
| 5 | Pass an array to a method to compute minimum, maximum, and average | [`LAB CYCLE/PG5PassArray.java`](./LAB%20CYCLE/PG5PassArray.java) | Methods & Arrays |
| 6 | Matrix operations: addition, subtraction, multiplication, and transpose | [`LAB CYCLE/PG6MatrixOperations.java`](./LAB%20CYCLE/PG6MatrixOperations.java) | 2D Arrays |
| 7 | Find the maximum of three numbers using conditional operators | [`LAB CYCLE/PG7MaxOfThree.java`](./LAB%20CYCLE/PG7MaxOfThree.java) | Operators |
| 8 | Reverse an integer and check whether it is a palindrome | [`LAB CYCLE/PG8ReversePalindrome.java`](./LAB%20CYCLE/PG8ReversePalindrome.java) | Number Logic |
| 9 | Implement the classic interactive 15-Puzzle sliding tile game | [`LAB CYCLE/PG9FifteenPuzzle.java`](./LAB%20CYCLE/PG9FifteenPuzzle.java) | Game Logic |
| 10 | Display array elements recursively in forward and reverse order | [`LAB CYCLE/PG10RecursiveDisplay.java`](./LAB%20CYCLE/PG10RecursiveDisplay.java) | Recursion |
| 11 | Design an Object-Oriented Calculator class with method encapsulation | [`LAB CYCLE/PG11CalculatorOOPs.java`](./LAB%20CYCLE/PG11CalculatorOOPs.java) | OOP Concepts |
| 12 | Create a ComplexNumber class to perform addition and multiplication | [`LAB CYCLE/PG12ComplexNumber.java`](./LAB%20CYCLE/PG12ComplexNumber.java) | OOP Concepts |
| 13 | Demonstrate built-in String methods for case, length, substring, and search | [`LAB CYCLE/PG13StringOperations.java`](./LAB%20CYCLE/PG13StringOperations.java) | Strings |
| 14 | Create Student class and compare student performance records | [`LAB CYCLE/PG14StudentCompare.java`](./LAB%20CYCLE/PG14StudentCompare.java) | Classes & Objects |
| 15 | Demonstrate IS-A (Inheritance) and HAS-A (Aggregation) relationships | [`LAB CYCLE/PG15ISAHASADemo.java`](./LAB%20CYCLE/PG15ISAHASADemo.java) | Inheritance |
| 16 | Demonstrate method overriding and dynamic method dispatch | [`LAB CYCLE/PG16OverrideDemo.java`](./LAB%20CYCLE/PG16OverrideDemo.java) | Polymorphism |
| 17 | Use 'super' keyword to overcome function overriding and invoke base constructor | [`LAB CYCLE/PG17SuperDemo.java`](./LAB%20CYCLE/PG17SuperDemo.java) | Inheritance |
| 18 | Create Employee class (eno, ename, esal) with search and display routines | [`LAB CYCLE/PG18EmployeeDemo.java`](./LAB%20CYCLE/PG18EmployeeDemo.java) | OOP Applications |
| 19 | Implement runtime polymorphism in Java using an interface | [`LAB CYCLE/PG19PolymorphismDemo.java`](./LAB%20CYCLE/PG19PolymorphismDemo.java) | Interfaces |
| 20 | Create interface ishape (draw, move) and implement in Circle and Rectangle | [`LAB CYCLE/PG20ishapeDemo.java`](./LAB%20CYCLE/PG20ishapeDemo.java) | Interfaces |
| 21 | Demonstrate exception handling with multiple catch blocks and order of catches | [`LAB CYCLE/PG21MultipleCatchDemo.java`](./LAB%20CYCLE/PG21MultipleCatchDemo.java) | Exception Handling |
| 22 | Create a user-defined custom exception class and throw conditionally | [`LAB CYCLE/PG22UserDefinedExceptionDemo.java`](./LAB%20CYCLE/PG22UserDefinedExceptionDemo.java) | Exception Handling |
| 23 | Demonstrate exception rethrowing and execution guarantees of the finally block | [`LAB CYCLE/PG23RethrowFinallyDemo.java`](./LAB%20CYCLE/PG23RethrowFinallyDemo.java) | Exception Handling |
| 24 | Password validator verifying length, uppercase, lowercase, digits, symbols | [`LAB CYCLE/PG24PasswordValidator.java`](./LAB%20CYCLE/PG24PasswordValidator.java) | Exception Handling |
| 25 | Create and run multithreaded tasks by extending the Thread class | [`LAB CYCLE/PG25ThreadClassDemo.java`](./LAB%20CYCLE/PG25ThreadClassDemo.java) | Multithreading |
| 26 | Create and run multithreaded tasks by implementing the Runnable interface | [`LAB CYCLE/PG26ThreadInterfaceDemo.java`](./LAB%20CYCLE/PG26ThreadInterfaceDemo.java) | Multithreading |
| 27 | Two concurrent threads generating Odd and Even numbers alternately | [`LAB CYCLE/PG27OddEvenDemo.java`](./LAB%20CYCLE/PG27OddEvenDemo.java) | Multithreading |
| 28 | Perform parallel searching across array segments using concurrent worker threads | [`LAB CYCLE/PG28ParallelSearch.java`](./LAB%20CYCLE/PG28ParallelSearch.java) | Multithreading |
| 29 | Threads computing Square and Cube values of randomly generated numbers | [`LAB CYCLE/PG29SquareCubeDemo.java`](./LAB%20CYCLE/PG29SquareCubeDemo.java) | Multithreading |
| 30 | Simulate concurrent printer job spooling without synchronization | [`LAB CYCLE/PG30PrinterDemo.java`](./LAB%20CYCLE/PG30PrinterDemo.java) | Multithreading |
| 31 | Synchronize concurrent printer job spooling using synchronized methods | [`LAB CYCLE/PG31PrinterSyncDemo.java`](./LAB%20CYCLE/PG31PrinterSyncDemo.java) | Synchronization |
| 32 | Inter-thread communication using wait(), notify(), notifyAll() (Producer-Consumer) | [`LAB CYCLE/PG32ProducerConsumerMain.java`](./LAB%20CYCLE/PG32ProducerConsumerMain.java) | Inter-Thread Comm |
| 33 | Simulate race condition during concurrent bank deposits and withdrawals | [`LAB CYCLE/PG33BankDemo.java`](./LAB%20CYCLE/PG33BankDemo.java) | Concurrency |
| 34 | Demonstrate thread priority scheduling (MIN_PRIORITY, NORM_PRIORITY, MAX_PRIORITY) | [`LAB CYCLE/PG34ThreadPriorityDemo.java`](./LAB%20CYCLE/PG34ThreadPriorityDemo.java) | Multithreading |
| 35 | Simulate multi-user synchronized ATM transactions on a shared account | [`LAB CYCLE/PG35ATMSimulationUserInput.java`](./LAB%20CYCLE/PG35ATMSimulationUserInput.java) | Synchronization |
| 36 | Implement Generic Methods to process arrays of different data types | [`LAB CYCLE/PG36GenericMethods.java`](./LAB%20CYCLE/PG36GenericMethods.java) | Java Generics |
| 37 | Implement a Generic Class supporting multiple type parameters | [`LAB CYCLE/PG37GenericClassDemo.java`](./LAB%20CYCLE/PG37GenericClassDemo.java) | Java Generics |
| 38 | Demonstrate String manipulation, character extraction, and searching | [`LAB CYCLE/PG38StringOperations.java`](./LAB%20CYCLE/PG38StringOperations.java) | Strings |
| 39 | Demonstrate StringBuffer mutable operations (append, insert, reverse, capacity) | [`LAB CYCLE/PG39StringBufferDemo.java`](./LAB%20CYCLE/PG39StringBufferDemo.java) | Strings |
| 40 | Socket programming: Client-Server communication sending messages via TCP | [`LAB CYCLE/PG40Client.java / PG40Server.java`](./LAB%20CYCLE/PG40Client.java / PG40Server.java) | Networking |
| 41 | Two-way full-duplex TCP Socket Chat application between client and server | [`LAB CYCLE/PG41ChatClient.java / PG41ChatServer.java`](./LAB%20CYCLE/PG41ChatClient.java / PG41ChatServer.java) | Networking |
| 42 | TCP File transfer application transferring files from client to server | [`LAB CYCLE/PG42FileClient.java / PG42FileServer.java`](./LAB%20CYCLE/PG42FileClient.java / PG42FileServer.java) | Networking |
| 43 | Client-Server file upload application with confirmation acknowledgement | [`LAB CYCLE/PG43UploadClient.java / PG43UploadServer.java`](./LAB%20CYCLE/PG43UploadClient.java / PG43UploadServer.java) | Networking |
| 44 | Multi-client centralized chat room server handling broadcast messages | [`LAB CYCLE/PG44PublicChatClient.java / PG44PublicChatServer.java`](./LAB%20CYCLE/PG44PublicChatClient.java / PG44PublicChatServer.java) | Networking |
| 45 | Datagram socket communication using UDP protocol (DatagramPacket/Socket) | [`LAB CYCLE/PG45UDPClient.java / PG45UDPServer.java`](./LAB%20CYCLE/PG45UDPClient.java / PG45UDPServer.java) | Networking |
| 46 | Extract URL metadata (protocol, host, port, path, query) using URL class | [`LAB CYCLE/PG46URLInfo.java`](./LAB%20CYCLE/PG46URLInfo.java) | Networking |
| 47 | Download remote file over HTTP/HTTPS from a URL to local storage | [`LAB CYCLE/PG47URLDownload.java`](./LAB%20CYCLE/PG47URLDownload.java) | Networking |
| 48 | Fetch and display the complete HTML source of a web page from a URL | [`LAB CYCLE/PG48WebPageContent.java`](./LAB%20CYCLE/PG48WebPageContent.java) | Networking |
| 49 | JDBC: Insert student and department records into database using Statement | [`LAB CYCLE/PG49InsertValues.java`](./LAB%20CYCLE/PG49InsertValues.java) | JDBC Database |
| 50 | JDBC: User authentication verifying username and password against login table | [`LAB CYCLE/PG50LoginCheck.java`](./LAB%20CYCLE/PG50LoginCheck.java) | JDBC Database |
| 51 | JDBC: SQL JOIN query displaying Employee and Department data | [`LAB CYCLE/PG51JoinDisplay.java`](./LAB%20CYCLE/PG51JoinDisplay.java) | JDBC Database |
| 52 | JDBC: Execute stored procedures using CallableStatement and PreparedStatement | [`LAB CYCLE/PG52CallablePrepared.java`](./LAB%20CYCLE/PG52CallablePrepared.java) | JDBC Database |
| 53 | JDBC: Transaction Management with commit, rollback, and batch updates | [`LAB CYCLE/PG53TransactionBatch.java`](./LAB%20CYCLE/PG53TransactionBatch.java) | JDBC Database |
| 54 | Object Serialization & Deserialization writing objects to byte streams | [`LAB CYCLE/PG54Serialization.java / PG54Deserialization.java`](./LAB%20CYCLE/PG54Serialization.java / PG54Deserialization.java) | Serialization |
| 55 | Serialization of inheritance hierarchies (IS-A relationship) | [`LAB CYCLE/PG55ISASerialization.java / PG55ISADeserialization.java`](./LAB%20CYCLE/PG55ISASerialization.java / PG55ISADeserialization.java) | Serialization |
| 56 | Serialization of aggregated objects (HAS-A relationship) | [`LAB CYCLE/PG56HASASerialization.java / PG56HASADeserialization.java`](./LAB%20CYCLE/PG56HASASerialization.java / PG56HASADeserialization.java) | Serialization |
| 57 | Demonstrate 'transient' keyword to prevent sensitive fields from serializing | [`LAB CYCLE/PG57TransientSerialization.java / PG57TransientDeserialization.java`](./LAB%20CYCLE/PG57TransientSerialization.java / PG57TransientDeserialization.java) | Serialization |
| 58 | Java Swing GUI: Compute Maximum of Three Numbers with interactive buttons | [`LAB CYCLE/PG58MaxOfThree.java`](./LAB%20CYCLE/PG58MaxOfThree.java) | Swing GUI |
| 59 | Java Swing GUI: JList component with dynamic add, remove, and clear actions | [`LAB CYCLE/PG59ListDemo.java`](./LAB%20CYCLE/PG59ListDemo.java) | Swing GUI |
| 60 | Java Swing GUI: Interactive form with JCheckBox and JRadioButton handlers | [`LAB CYCLE/PG60CheckboxRadioDemo.java`](./LAB%20CYCLE/PG60CheckboxRadioDemo.java) | Swing GUI |
| 61 | Java Swing GUI: Window application with JMenuBar, JMenu, and JMenuItems | [`LAB CYCLE/PG61MenuDemo.java`](./LAB%20CYCLE/PG61MenuDemo.java) | Swing GUI |

---

## Foundational Practice Questions (Sample Q1 – Q20)

Directory: [`Sample Qns/`](./Sample%20Qns/)  
Reference Guide: [`Java L1. Refresh Your Logical Part.pdf`](./Sample%20Qns/Java%20L1.%20Refresh%20Your%20Logical%20Part.pdf)

| Sl. No. | Problem Description | Source File |
| :---: | :--- | :--- |
| 1 | Display a Welcome message | [`Sample Qns/Welcome1.java`](./Sample%20Qns/Welcome1.java) |
| 2 | Display values passed through command line | [`Sample Qns/DisplayCLI2.java`](./Sample%20Qns/DisplayCLI2.java) |
| 3 | Calculate the sum of two integers | [`Sample Qns/Sum3.java`](./Sample%20Qns/Sum3.java) |
| 4 | Swap two variable values without third variable | [`Sample Qns/Swap4.java`](./Sample%20Qns/Swap4.java) |
| 5 | Demonstrate bitwise AND, OR, XOR, NOT, and shift operators | [`Sample Qns/Bitwise5.java`](./Sample%20Qns/Bitwise5.java) |
| 6 | Find the maximum of two numbers | [`Sample Qns/Max6.java`](./Sample%20Qns/Max6.java) |
| 7 | Find the minimum among three numbers | [`Sample Qns/Minimum7.java`](./Sample%20Qns/Minimum7.java) |
| 8 | Compute the absolute difference between two numbers | [`Sample Qns/Difference8.java`](./Sample%20Qns/Difference8.java) |
| 9 | Print formatted table of numbers and square powers | [`Sample Qns/Display9.java`](./Sample%20Qns/Display9.java) |
| 10 | Check whether a number is prime | [`Sample Qns/CheckPrime10.java`](./Sample%20Qns/CheckPrime10.java) |
| 11 | Calculate the sum of mathematical series 1 + 2 + ... + n | [`Sample Qns/SumOfSeries11.java`](./Sample%20Qns/SumOfSeries11.java) |
| 12 | Calculate sum of factorial series 1! + 2! + ... + n! | [`Sample Qns/SumFactorialSeries12.java`](./Sample%20Qns/SumFactorialSeries12.java) |
| 13 | Terminal-based interactive number guessing game | [`Sample Qns/GuessNumber13.java`](./Sample%20Qns/GuessNumber13.java) |
| 14 | Linear search on an array of integers | [`Sample Qns/SearchArray14.java`](./Sample%20Qns/SearchArray14.java) |
| 15 | Find the second smallest number in an array | [`Sample Qns/SecondSmallest15.java`](./Sample%20Qns/SecondSmallest15.java) |
| 16 | Sort array elements using bubble sort | [`Sample Qns/SortArray16.java`](./Sample%20Qns/SortArray16.java) |
| 17 | Perform matrix addition on two 2D arrays | [`Sample Qns/MatrixAddition.java`](./Sample%20Qns/MatrixAddition.java) |
| 18 | Perform matrix multiplication on two compatible 2D arrays | [`Sample Qns/MatrixMultiplication18.java`](./Sample%20Qns/MatrixMultiplication18.java) |
| 19 | Compute the transpose of a 2D matrix | [`Sample Qns/MatrixTranspose19.java`](./Sample%20Qns/MatrixTranspose19.java) |
| 20 | Find real and imaginary roots of a quadratic equation | [`Sample Qns/QuadraticRoots20.java`](./Sample%20Qns/QuadraticRoots20.java) |

---

## Compilation & Execution Instructions

Ensure you have JDK 17 or JDK 21 installed (`javac -version`).

### Compiling Core Programs
```bash
cd "LAB CYCLE"
javac PG1SumCLA.java
java PG1SumCLA 10 20 30
```

### Running Networking Client-Server Programs
Start server in one terminal and client in another:
```bash
# Terminal 1:
javac PG40Server.java
java PG40Server

# Terminal 2:
javac PG40Client.java
java PG40Client
```

### Running JDBC Programs
Include the Oracle JDBC driver JAR (included in `LAB CYCLE/` as `ojdbc17.jar`):
```bash
javac -cp ".;ojdbc17.jar" PG49InsertValues.java
java -cp ".;ojdbc17.jar" PG49InsertValues
```

---

## Official Record Verification
The official verified record front sheet is preserved as [`1. JAVA LAB FRONT.pdf`](./1.%20JAVA%20LAB%20FRONT.pdf) and [`2. JAVA Record.pdf`](./2.%20JAVA%20Record.pdf).
