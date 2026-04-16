package com.daniel;

import com.daniel.ui.CollegeMenu;

public class Main {

    public static void main(String[] args) throws Exception {
        College college = new College();
        try (CollegeMenu menu = new CollegeMenu(college)) {
            menu.runMenu();
        }
    }
}
