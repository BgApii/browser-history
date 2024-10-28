package com.github.affandes.kuliah.pm;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    private final Stack<String> history;

    public Main() {
        history = new Stack<>();
    }

    public void view() {
        if (history.isEmpty()) {
            System.out.println("History kosong");
        } else {
            System.out.println("History browser:");
            for (int i = history.size() - 1; i >= 0; i--) {
                System.out.println(history.get(i));
            }
        }
    }

    public void browse(String url) {
        history.push(url);
        System.out.println("Website saat ini: " + history.peek());
    }

    public void back() {
        if (history.size() <= 1) {
            System.out.println("Tidak ada history");
        } else {
            history.pop();
            System.out.println("Website saat ini: " + history.peek());
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main browserHistory = new Main();
        System.out.println("Selamat datang di Browser");
        browserHistory.browse("Home Page");

        do {
            System.out.println("Fitur (browse, back, view, close)");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("browse")) {
                System.out.print("Masukkan url: ");
                String url = scanner.nextLine();
                browserHistory.browse(url);
            } else if (input.equalsIgnoreCase("back")) {
                browserHistory.back();
            } else if (input.equalsIgnoreCase("view")) {
                browserHistory.view();
            } else if (input.equalsIgnoreCase("close")) {
                System.exit(0);
            } else {
                System.out.println("Anda salah input");
            }
        } while (true);
    }
}
