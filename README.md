SecureBank – Week 1

Project Title

SecureBank Console Banking Application

Description

SecureBank is a Java console-based banking application developed using Core Java and "HashMap".

The application allows users to create accounts, deposit money, withdraw money, check account balance, and close accounts.

Features

- Create a new bank account
- Deposit money
- Withdraw money
- Check account balance
- Close an account
- Validate account IDs
- Prevent negative or zero-value transactions
- Prevent withdrawal when there are insufficient funds
- Handle invalid account operations safely

Technologies Used

- Java
- Core Java
- HashMap
- Scanner
- Object-Oriented Programming

Data Structure

The application stores accounts using:

"HashMap<Integer, Account>"

The account ID is used as the key to quickly access the corresponding account.

Project Structure

SecureBank/
├── BankConsoleApp.java
└── README.md

How to Run

1. Compile the program

javac BankConsoleApp.java

2. Run the program

java BankConsoleApp

Menu

1. Create Account
2. Deposit Money
3. Withdraw Money
4. Check Balance
5. Close Account
6. Exit

Sample Test

Create an account and deposit:

Deposit: ₹5000
Withdraw: ₹2000

Expected balance:

₹3000

If the user tries to withdraw ₹10,000 when the balance is ₹3,000, the application displays:

Insufficient funds!

Week 1 Objective

The objective of Week 1 is to build a working menu-driven banking application using a "HashMap" to manage accounts and implement basic account operations.

Author

Naveen Kumar