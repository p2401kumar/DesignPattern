package com.samsung.TemplateMethodPattern;

// Define the skeleton of an algorithm in an operation, deferring some steps to subclasses.
// Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure.


import java.util.Scanner;

interface Servlet {
    void service(HttpRequest request);
}

//helper Class
class HttpServlet implements Servlet{
    @Override
    public void service(/*HttpServlet this*/HttpRequest request) {
        if (request.getMethod().equalsIgnoreCase("GET")){
            doGet(); // late-bound calls
        }else if (request.getMethod().equalsIgnoreCase("POST")){
            doPost();// late-bound calls
        }else if (request.getMethod().equalsIgnoreCase("PUT")){
            dpPut();// late-bound calls
        }else if (request.getMethod().equalsIgnoreCase("DELETE")){
            dpDelete();// late-bound calls
        }
    }

    void dpDelete() {}
    void dpPut() {}
    void doPost() {}
    void doGet() {}
}

class Page1 extends HttpServlet{

    @Override
    void doPost() {
        super.doPost();
    }

    @Override
    void doGet() {
        super.doGet();
    }
}

class Page2 extends HttpServlet {

    @Override
    void doPost() {
        super.doPost();
    }

    @Override
    void doGet() {
        super.doGet();
    }
}

// Web Server receives HTTP Request from Browser
// http://domainName/Page1
// http://domainName/Page1
class HttpRequest{
    String method; // GET, POST, PUT, DELETE, etc
    public String getMethod(){
        return method;
    }

    HttpRequest(String method){
        this.method = method;
    }
}
public class Main12 {
    public static void main(String[] args) {
        while (true){
            Scanner scanner = new Scanner(System.in);
            String url = scanner.next(); // only enter Page1 or Page2

            try{
                Class cls = Class.forName("com.samsung.TemplateMethodPattern." + url);
                Servlet servlet = (Servlet) cls.newInstance();
                servlet.service(new HttpRequest("GET"));

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
