package com.daniel.clips;

import com.daniel.models.*;
import com.daniel.utils.ArrayHelper;
import java.util.Arrays;

public class DepartmentClip {
    private static final int ALLOC_SIZE = 2;
    private Department[] departments = new Department[ALLOC_SIZE];
    private int pointer = 0;
    private int clipSize = ALLOC_SIZE;

    public Boolean addDepartment(String name) {
        if(pointer >= clipSize - 1) {
            departments = (Department[])ArrayHelper.resizeArray(departments, clipSize*2);
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