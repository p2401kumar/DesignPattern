package com.samsung;

// Reliable
// Extensible
// Reusable
// Maintainable
// Unit Testable
    // TDD - UI -> test -> Code <- UI

// LSP - Liskov Substitution Principle -
class A {
    public void add() {

    }
}

class B extends A {
    public void add() {
        throw new RuntimeException(""); // wrong: breaks LSP
    }
}

// Server - Restful Services
// To Call Restful HTTP Connection and Request with Response is Required

// PRoxy Classes to manage HTTP Request to the Server

// Data Access Logic - Sqlite or JSON files
// Main Thread will access DB, Image Loading, File IO, HTTP request > 50ms
// Hence these operations must be done Asynchronously

// Business Access Logic - Object or Collection
//Main Thread will be used to call function

// Presentation - UI

// Create UI controls and handle Their Events Handler
// Main thread calls Event Handler:
// Disable Button
// Call the Business Logic
// Register Callback to receive Data and then Enable Button
// Hence M-V-VM, M-V-P. - View Model / Presenter
// (https://blogs.msdn.microsoft.com/johngossman/2005/10/08/introduction-to-modelviewviewmodel-pattern-for-building-wpf-apps/)

public class Main16 {
    public static void main(String[] args) {
        // MainThread - GUI Object
        // MainThread - Start Message Loop / Event Loop
    }
}
