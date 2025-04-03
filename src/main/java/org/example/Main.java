package org.example;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        System.out.println("--- Palindrom Kontrolü ---");
        System.out.println("'I did, did I?' Palindrom mu? " + checkForPalindrome("I did, did I?"));
        System.out.println("'Racecar' Palindrom mu? " + checkForPalindrome("Racecar"));
        System.out.println("'hello' Palindrom mu? " + checkForPalindrome("hello"));
        System.out.println("'Was it a car or a cat I saw ?' Palindrom mu? " + checkForPalindrome("Was it a car or a cat I saw ?"));
        System.out.println("'' Palindrom mu? " + checkForPalindrome(""));
        System.out.println("'A man, a plan, a canal: Panama' Palindrom mu? " + checkForPalindrome("A man, a plan, a canal: Panama"));

        System.out.println("\n--- WorkintechList Testleri ---");
        WorkintechList<String> stringList = new WorkintechList<>();
        stringList.add("Ankara");
        stringList.add("İstanbul");
        stringList.add("İzmir");
        System.out.println("İlk Liste: " + stringList);
        stringList.add("Bursa");
        System.out.println("Bursa Eklendi: " + stringList);
        stringList.add("Ankara");
        System.out.println("Ankara Tekrar Eklendi mi?: " + stringList);
        stringList.sort();
        System.out.println("Sıralı Liste: " + stringList);
        stringList.remove("İstanbul");
        System.out.println("İstanbul Silindi ve Sıralandı: " + stringList);

        WorkintechList<Integer> intList = new WorkintechList<>();
        intList.add(5);
        intList.add(1);
        intList.add(10);
        intList.add(3);
        System.out.println("\nSayı Listesi: " + intList);
        intList.add(5);
        System.out.println("5 Tekrar Eklendi mi?: " + intList);
        intList.sort();
        System.out.println("Sıralı Sayı Listesi: " + intList);
        intList.remove(Integer.valueOf(10));
        System.out.println("10 Silindi ve Sıralandı: " + intList);


        System.out.println("\n--- Ondalık Sayıyı İkiliye Çevirme ---");
        System.out.println("5'in ikili karşılığı: " + convertDecimalToBinary(5));
        System.out.println("6'nın ikili karşılığı: " + convertDecimalToBinary(6));
        System.out.println("13'ün ikili karşılığı: " + convertDecimalToBinary(13));
        System.out.println("0'ın ikili karşılığı: " + convertDecimalToBinary(0));
        System.out.println("42'nin ikili karşılığı: " + convertDecimalToBinary(42));
    }

    public static boolean checkForPalindrome(String text) {
        String cleanedText = text.toLowerCase().replaceAll("[^a-z0-9]", "");
        Deque<Character> characterDeque = new LinkedList<>();
        for (char c : cleanedText.toCharArray()) {
            characterDeque.addLast(c);
        }

        while (characterDeque.size() > 1) {
            if (!characterDeque.removeFirst().equals(characterDeque.removeLast())) {
                return false;
            }
        }
        return true;
    }

    public static String convertDecimalToBinary(int number) {
        Stack<Integer> binaryStack = new Stack<>();

        if (number == 0) {
            return "0";
        }

        while (number > 0) {
            int remainder = number % 2;
            binaryStack.push(remainder);
            number = number / 2;
        }

        StringBuilder binaryString = new StringBuilder();
        while (!binaryStack.isEmpty()) {
            binaryString.append(binaryStack.pop());
        }

        return binaryString.toString();
    }
}