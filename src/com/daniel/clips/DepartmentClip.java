package com.daniel.clips;

import com.daniel.models.*;
import java.util.Arrays;

public class DepartmentClip {
    private static final int ALLOC_SIZE = 2;
    private Department[] departments = new Department[ALLOC_SIZE];
    private int pointer = 0;
    private int clipSize = ALLOC_SIZE;

    public Boolean addDepartment(String name) {
        if(pointer >= clipSize - 1) {
            Department[] newClip = new Department[clipSize * 2];
            for(int i = 0; i < clipSize; i++) {
                newClip[i] = departments[i];
            }
            departments = newClip;
            clipSize = clipSize * 2;
        }

        for (Department department : departments) {
            if(department == null) continue;
            if(department.name.equalsIgnoreCase(name)) {
                return false;
            }
        }

        departments[pointer] = new Department(name);
        pointer++;

        return true;
    }

    public Department[] getDepartments() {
        return Arrays.copyOfRange(departments, 0, pointer);
    }
}
