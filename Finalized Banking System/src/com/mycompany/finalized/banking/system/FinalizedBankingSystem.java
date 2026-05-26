package com.mycompany.finalized.banking.system;

// Import Scanner for user input
import java.util.Scanner;

// Import Random for generating account numbers and pins
import java.util.Random;

// Import LocalTime for transaction timestamps
import java.time.LocalTime;

public class FinalizedBankingSystem {

    // ================= GLOBAL OBJECTS =================

    // Scanner object used for user input
    static Scanner s = new Scanner(System.in);

    // Random object used to generate random values
    static Random r = new Random();

    // ================= LOGIN TRACKERS =================

    // Stores the index of the currently logged in client
    static int loggedInUser = -1;

    // Stores the index of the currently logged in employee
    static int loggedInEmployee = -1;

    // ================= CLIENT DETAILS =================

    static String[] username = {"bob", "peter", "josh", "sam", "jack"};
    static String[] password = {"bob1", "peter1", "josh1", "sam1", "jack1"};
    static String[] fullName = {"John Mark","Paul Mcman","Sandra Moore","Peter Zulu","Hazard Disman"};
    static String[] surname = {"Mark","Mcman", "Moore","Zulu","Disman"};
    static String[] email = {"john@gmail.com","paul@gmail.com","sandra@gmail.com","peter@gmail.com","hazard@gmail.com"};
    static String[] phone = {"0673459873","0663452363","0654231200","0697653473","0634568765"};
    static String[] address = {"21 mooi street JHB","101 good street PTA","211 sandom street JHB","301 nitye street JHB","91 mooi street CPT"};
    static String[] gender = {"Male","Male","Female","Male","Male"};
    static String[] accountType = {"Savings Account","Checking Account","Salary Account","Joint Account","Savings Account"};
    static String[] status = {"ACTIVE","ACTIVE","ACTIVE","CLOSED","ACTIVE"};
    static String[] clientID = {"CUS01","CUS02","CUS03","CUS04","CUS05"};
    static int[] accountNumber = {9343343,4847433,2987654,3043433, 8493733};
    static int[] accountPin = {1234,2345,3456,4567,5678};
    static double[] accountBalance = {20034,54334,6454,8445,9544};

    // ================= TRANSACTION HISTORY =================

    // Stores transaction history for each client
    static String[] transactionHistory = {"", "", "", "", ""};

    // ================= EMPLOYEE DETAILS =================
    
    static String[] employeeUsername = {"mike","john","tumi"};
    static String[] employeePassword = {"emp1","emp2","emp3"};

    // ================= GET CURRENT TIME =================

    // Returns the current system time
    static String getTime() {
        return LocalTime.now().toString();
    }

    // ================= ARRAY RESIZE METHODS =================

    // Adds a new String value to a String array
    static String[] appendString(String[] arr, String val) {

        String[] newArr = new String[arr.length + 1];

        System.arraycopy(arr, 0, newArr, 0, arr.length);

        newArr[arr.length] = val;

        return newArr;
    }

    // Adds a new integer value to an integer array
    static int[] appendInt(int[] arr, int val) {

        int[] newArr = new int[arr.length + 1];

        System.arraycopy(arr, 0, newArr, 0, arr.length);

        newArr[arr.length] = val;

        return newArr;
    }

    // Adds a new double value to a double array
    static double[] appendDouble(double[] arr, double val) {

        double[] newArr = new double[arr.length + 1];

        System.arraycopy(arr, 0, newArr, 0, arr.length);

        newArr[arr.length] = val;

        return newArr;
    }

    // ================= GENERATE UNIQUE ACCOUNT NUMBER =================

    // Generates a unique 7-digit account number
    static int generateAccountNumber() {

        int acc;

        while (true) {

            acc = r.nextInt(1000000, 9999999);

            boolean exists = false;

            // Check if account number already exists
            for (int number : accountNumber) {

                if (number == acc) {
                    exists = true;
                    break;
                }
            }

            // Return number if unique
            if (!exists) {
                return acc;
            }
        }
    }

    // ================= CHECK BALANCE =================

    // Displays the logged in user's balance
    static void check_balance() {

        int i = loggedInUser;

        System.out.println("===== ACCOUNT BALANCE =====");

        System.out.printf("Current Balance: R%.2f%n",
                accountBalance[i]);
    }

    // ================= DEPOSIT MONEY =================

    // Allows users to deposit money
    static void deposit() {

        int i = loggedInUser;

        System.out.println("===== DEPOSIT =====");

        System.out.print("Enter Amount: ");
        double amount = s.nextDouble();

        // Validate amount
        if (amount > 0) {

            // Add money to balance
            accountBalance[i] += amount;

            // Save transaction history
            transactionHistory[i] += String.format(
                    "DEPOSIT | Amount: R%.2f | Balance: R%.2f | Time: %s%n",
                    amount,
                    accountBalance[i],
                    getTime()
            );

            System.out.println("Deposit Successful!");

            System.out.printf("New Balance: R%.2f%n",
                    accountBalance[i]);

        } else {

            System.out.println("Invalid Amount!");
        }
    }

    // ================= WITHDRAW MONEY =================

    // Allows users to withdraw money
    static void withdraw() {

        int i = loggedInUser;

        System.out.println("===== WITHDRAW =====");

        System.out.print("Enter Amount: ");
        double amount = s.nextDouble();

        // Check if sufficient funds exist
        if (amount > 0 && amount <= accountBalance[i]) {

            // Deduct money
            accountBalance[i] -= amount;

            // Record transaction
            transactionHistory[i] += String.format(
                    "WITHDRAWAL | Amount: R%.2f | Balance: R%.2f | Time: %s%n",
                    amount,
                    accountBalance[i],
                    getTime()
            );

            System.out.println("Withdrawal Successful!");

            System.out.printf("New Balance: R%.2f%n",
                    accountBalance[i]);

        } else {

            System.out.println("Insufficient Funds or Invalid Amount!");
        }
    }

    // ================= TRANSFER MONEY =================

    // Transfers money between clients
    static void transfer() {

        int i = loggedInUser;

        System.out.println("===== TRANSFER MONEY =====");

        System.out.print("Enter Recipient Account Number: ");
        int acc = s.nextInt();

        int recipientIndex = -1;

        // Find recipient
        for (int j = 0; j < accountNumber.length; j++) {

            if (accountNumber[j] == acc) {

                recipientIndex = j;
                break;
            }
        }

        // If recipient does not exist
        if (recipientIndex == -1) {

            System.out.println("Recipient Not Found!");
            return;
        }

        System.out.print("Enter Amount: ");
        double amount = s.nextDouble();

        s.nextLine();

        System.out.print("Enter Reference: ");
        String ref = s.nextLine();

        // Validate transfer
        if (amount > 0 && amount <= accountBalance[i]) {

            // Deduct sender balance
            accountBalance[i] -= amount;

            // Add to recipient balance
            accountBalance[recipientIndex] += amount;

            // Save sender transaction
            transactionHistory[i] += String.format(
                    "TRANSFER SENT | To: %s | Amount: R%.2f | Ref: %s | Balance: R%.2f | Time: %s%n",
                    fullName[recipientIndex],
                    amount,
                    ref,
                    accountBalance[i],
                    getTime()
            );

            // Save recipient transaction
            transactionHistory[recipientIndex] += String.format(
                    "TRANSFER RECEIVED | From: %s | Amount: R%.2f | Ref: %s | Balance: R%.2f | Time: %s%n",
                    fullName[i],
                    amount,
                    ref,
                    accountBalance[recipientIndex],
                    getTime()
            );

            System.out.println("Transfer Successful!");

            System.out.printf("New Balance: R%.2f%n",
                    accountBalance[i]);

        } else {

            System.out.println("Insufficient Funds!");
        }
    }

    // ================= VIEW TRANSACTION HISTORY =================

    // Displays transaction history for a client
    static void viewTransactionHistory(int index) {

        System.out.println("===== TRANSACTION HISTORY =====");

        // Check if history exists
        if (transactionHistory[index].isEmpty()) {

            System.out.println("No Transactions Available");

        } else {

            System.out.println(transactionHistory[index]);
        }
    }

    // ================= UPDATE CLIENT DETAILS =================

    // Allows clients to update personal details
    static void updateDetails() {

        System.out.println("===== UPDATE DETAILS =====");

        System.out.println("1. Update Password");
        System.out.println("2. Update Address");
        System.out.println("3. Update Email");
        System.out.println("4. Update Phone");

        System.out.print("Choose Option: ");
        int option = s.nextInt();

        s.nextLine();

        switch (option) {

            case 1:

                System.out.print("Enter New Password: ");
                password[loggedInUser] = s.nextLine();

                System.out.println("Password Updated!");
                break;

            case 2:

                System.out.print("Enter New Address: ");
                address[loggedInUser] = s.nextLine();

                System.out.println("Address Updated!");
                break;

            case 3:

                System.out.print("Enter New Email: ");
                email[loggedInUser] = s.nextLine();

                System.out.println("Email Updated!");
                break;

            case 4:

                System.out.print("Enter New Phone: ");
                phone[loggedInUser] = s.nextLine();

                System.out.println("Phone Updated!");
                break;

            default:

                System.out.println("Invalid Option!");
        }
    }

    // ================= CLIENT MENU =================

    // Displays client banking menu
    static void menu2() {

        while (true) {

            int i = loggedInUser;

            System.out.println("\n===== CLIENT MENU =====");

            System.out.println("Welcome " + fullName[i]);

            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer Money");
            System.out.println("5. Update Details");
            System.out.println("6. Transaction History");
            System.out.println("7. Logout");

            System.out.print("Choose Option: ");
            int option = s.nextInt();

            switch (option) {

                case 1:
                    check_balance();
                    break;

                case 2:
                    deposit();
                    break;

                case 3:
                    withdraw();
                    break;

                case 4:
                    transfer();
                    break;

                case 5:
                    updateDetails();
                    break;

                case 6:
                    viewTransactionHistory(loggedInUser);
                    break;

                case 7:
                    loggedInUser = -1;
                    return;

                default:
                    System.out.println("Invalid Option!");
            }
        }
    }

    // ================= CLIENT LOGIN =================

    // Handles client authentication
    static void clientLogin() {

        System.out.println("===== CLIENT LOGIN =====");

        s.nextLine();

        System.out.print("Enter Username: ");
        String usern = s.nextLine();

        System.out.print("Enter Password: ");
        String passw = s.nextLine();

        // Search client arrays
        for (int i = 0; i < username.length; i++) {

            if (usern.equals(username[i]) &&
                    passw.equals(password[i])) {

                // Check if account is active
                if (status[i].equals("CLOSED")) {

                    System.out.println("This account is CLOSED.");
                    return;
                }

                // Save logged in client index
                loggedInUser = i;

                System.out.println("Login Successful!");

                menu2();
                return;
            }
        }

        System.out.println("Invalid Login Details!");
    }

    // ================= REGISTER NEW CLIENT =================

    // Allows creation of new bank accounts
    static void registerClient() {

        System.out.println("===== REGISTER CLIENT =====");

        s.nextLine();

        System.out.print("Enter Username: ");
        String usern = s.nextLine();

        // Check duplicate usernames
        for (String u : username) {

            if (u.equalsIgnoreCase(usern)) {

                System.out.println("Username Already Exists!");
                return;
            }
        }

        // Capture client details
        System.out.print("Enter Full Name: ");
        String name = s.nextLine();

        System.out.print("Enter Surname: ");
        String surn = s.nextLine();

        System.out.print("Enter Email: ");
        String mail = s.nextLine();

        System.out.print("Enter Phone: ");
        String ph = s.nextLine();

        System.out.print("Enter Address: ");
        String add = s.nextLine();

        System.out.print("Enter Gender: ");
        String gen = s.nextLine();

        System.out.print("Enter Password: ");
        String pass = s.nextLine();

        // Choose account type
        System.out.println("1. Savings Account");
        System.out.println("2. Checking Account");
        System.out.println("3. Salary Account");

        System.out.print("Choose Option: ");
        int choice = s.nextInt();

        String accType;

        switch (choice) {

            case 2:
                accType = "Checking Account";
                break;

            case 3:
                accType = "Salary Account";
                break;

            default:
                accType = "Savings Account";
        }

        // Generate new account details
        int accNumber = generateAccountNumber();

        int accPin = r.nextInt(1000, 9999);

        String newID = "CUS0" + (username.length + 1);

        // Add client data into arrays
        username = appendString(username, usern);
        password = appendString(password, pass);
        fullName = appendString(fullName, name);
        surname = appendString(surname, surn);
        email = appendString(email, mail);
        phone = appendString(phone, ph);
        address = appendString(address, add);
        gender = appendString(gender, gen);
        accountType = appendString(accountType, accType);
        status = appendString(status, "ACTIVE");
        clientID = appendString(clientID, newID);

        accountNumber = appendInt(accountNumber, accNumber);

        accountPin = appendInt(accountPin, accPin);

        accountBalance = appendDouble(accountBalance, 0.0);

        transactionHistory = appendString(transactionHistory, "");

        // Display new account details
        System.out.println("===== ACCOUNT CREATED =====");

        System.out.println("Account Number: " + accNumber);

        System.out.println("PIN: " + accPin);

        System.out.println("Account Type: " + accType);
    }

    // ================= VIEW ALL CLIENTS =================

    // Employee function for viewing all clients
    static void viewClients() {

        System.out.println("===== ALL CLIENTS =====");

        for (int i = 0; i < username.length; i++) {

            System.out.println("--------------------------------");

            System.out.println("Client ID: " + clientID[i]);

            System.out.println("Full Name: " + fullName[i]);

            System.out.println("Username: " + username[i]);

            System.out.println("Account Number: " + accountNumber[i]);

            System.out.println("Account Type: " + accountType[i]);

            System.out.println("Status: " + status[i]);

            System.out.printf("Balance: R%.2f%n",
                    accountBalance[i]);
        }
    }

    // ================= CLOSE ACCOUNT =================

    // Employee function for closing accounts
    static void closeAccount() {

        System.out.print("Enter Account Number: ");
        int acc = s.nextInt();

        for (int i = 0; i < accountNumber.length; i++) {

            if (acc == accountNumber[i]) {

                status[i] = "CLOSED";

                System.out.println("Account Closed Successfully!");
                return;
            }
        }

        System.out.println("Account Not Found!");
    }

    // ================= EMPLOYEE MENU =================

    // Displays employee administration menu
    static void employeeMenu() {

        while (true) {

            System.out.println("\n===== EMPLOYEE MENU =====");

            System.out.println("1. View All Clients");
            System.out.println("2. View Transaction History");
            System.out.println("3. Close Account");
            System.out.println("4. Logout");

            System.out.print("Choose Option: ");
            int option = s.nextInt();

            switch (option) {

                case 1:
                    viewClients();
                    break;

                case 2:

                    System.out.print("Enter Account Number: ");
                    int acc = s.nextInt();

                    boolean found = false;

                    for (int i = 0; i < accountNumber.length; i++) {

                        if (acc == accountNumber[i]) {

                            found = true;

                            viewTransactionHistory(i);
                        }
                    }

                    if (!found) {

                        System.out.println("Client Not Found!");
                    }

                    break;

                case 3:
                    closeAccount();
                    break;

                case 4:

                    loggedInEmployee = -1;
                    return;

                default:

                    System.out.println("Invalid Option!");
            }
        }
    }

    // ================= EMPLOYEE LOGIN =================

    // Handles employee authentication
    static void employeeLogin() {

        System.out.println("===== EMPLOYEE LOGIN =====");

        s.nextLine();

        System.out.print("Enter Username: ");
        String usern = s.nextLine();

        System.out.print("Enter Password: ");
        String passw = s.nextLine();

        // Search employee arrays
        for (int i = 0; i < employeeUsername.length; i++) {

            if (usern.equals(employeeUsername[i]) &&
                    passw.equals(employeePassword[i])) {

                loggedInEmployee = i;

                System.out.println("Login Successful!");

                employeeMenu();
                return;
            }
        }

        System.out.println("Invalid Employee Details!");
    }

    // ================= MAIN MENU =================

    // Main system navigation menu
    static void mainMenu() {

        while (true) {

            System.out.println("\n===== WELCOME TO PLUTO BANKERS =====");

            System.out.println("1. Employee Login");
            System.out.println("2. Client Login");
            System.out.println("3. Register Client");
            System.out.println("4. Exit");

            System.out.print("Choose Option: ");
            int option = s.nextInt();

            switch (option) {

                case 1:
                    employeeLogin();
                    break;

                case 2:
                    clientLogin();
                    break;

                case 3:
                    registerClient();
                    break;

                case 4:

                    System.out.println(
                            "Thanks For Banking With PLUTO BANKERS"
                    );

                    System.exit(0);
                    break;

                default:

                    System.out.println("Invalid Option!");
            }
        }
    }

    // ================= MAIN METHOD =================

    public static void main(String[] args) {

        mainMenu();
    }
}