package com.company;
import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/обд_лаб1_mysql", "root", "");
            Statement statement = connection.createStatement();
            System.out.println("Введіть будь ласка таблицю над якою ви бажаєте працювати:");
            Scanner sc1=new Scanner(System.in);
            String table =sc1.nextLine();
            System.out.println("Оберіть будь ласка режим, який ви бажаєте:");
            System.out.println("Видалення - (1)\nДодавання - (2)\nЗміна - (3)");
            Scanner sc2=new Scanner(System.in);
            int mode =sc2.nextInt();
            int id = 0;
            String number = null;

            switch (mode){
                case 1 -> {
                    System.out.println("Оберіть будь ласка id:");
                    InputId(id);
                    statement.executeUpdate("delete from "+table+" where id=" + id);
                    System.out.println("Видалення успішне");
                }
                case 2-> {
                    System.out.println("Введіть будь ласка назву номер авто:");
                    InputName(number);
                    statement.executeUpdate("insert into "+table+"(id, number) select max(id)+1,'"+number+"'from "+table+" ;");
                    System.out.println("Додавання успішно виконано");
                }
                case 3-> {
                    System.out.println("Введіть id колонки якої ви бажаєте змінити");
                    InputId(id);
                    System.out.println("Введіть новий номер");
                    InputName(number);
                    statement.executeUpdate("update "+table+" set number= '"+number+"' where id="+id);
                    System.out.println("Зміна успішно виконана");
                }
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    static void InputId(int id){
        Scanner sc=new Scanner(System.in);
        id =sc.nextInt();
    }
    static void InputName(String number){
        Scanner sc=new Scanner(System.in);
        number =sc.nextLine();
    }
}
