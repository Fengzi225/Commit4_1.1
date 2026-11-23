/*
Kod bazowy programu Commit4_0: 
• Program dodaje do prostej bazy danych (pliku db.txt) dane odnośnie Studentów.
• Studenci dodawani są w klasie Main.
• Wszyscy studenci są wypisywani na końcu klasy Main.
• Klasa Service obsługuje odczyt i zapis do pliku bazy danych.
• Klasa Student reprezentuje pojedynczego studenta (Imię, Wiek).
*/

import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      Scanner scanner = new Scanner(System.in);

      System.out.print("Podaj imię studenta: ");
      String name = scanner.nextLine();

      if(name.isBlank()){
        System.out.print("Imię nie może być puste");
        scanner.close();
        return;
      }

      System.out.print("Podaj wiek studenta: ");
      int age = scanner.nextInt();

      if(age < 0){
        System.out.print("Wiek nie może być ujemny");
        scanner.close();
        return;
      }

      s.addStudent(new Student(name,age));
      var students = s.getStudents();
      for(Student current : students) {
        System.out.println(current.ToString());
      }
      scanner.close();
    } catch (IOException e) {
      System.out.print("Blad  podczas operacji na pliku: " + e.getMessage());
    }
  }
}