package com.daniel.clips;

import com.daniel.models.*;
import java.util.Arrays;

public class LecturerClip {
    private static final int ALLOC_SIZE = 2;
    private Lecturer[] lecturers = new Lecturer[ALLOC_SIZE];
    private int pointer = 0;
    private int clipSize = ALLOC_SIZE;

    public Boolean addLecturer(String name, double salary) {
        if(pointer >= clipSize - 1) {
            lecturers = Arrays.copyOf(lecturers, clipSize*2);
            clipSize = clipSize * 2;
        }

        for (Lecturer lecturer : lecturers) {
            if(lecturer == null) continue;
            if(lecturer.name.equalsIgnoreCase(name)) {
                return false;
            }
        }

        lecturers[pointer] = new Lecturer(name, salary);
        pointer++;

        return true;
    }

    public Lecturer getLecturer(String name) {
        for(Lecturer lecturer : lecturers) {
            if(lecturer == null) continue;
            if(lecturer.name.equalsIgnoreCase(name)) {
                return lecturer;
            }
        }
        return null;
    }

    public Lecturer[] getLecturers() {
        return Arrays.copyOf(lecturers, pointer+1);
    }
}