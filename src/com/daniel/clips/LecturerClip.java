package com.daniel.clips;

import java.util.Arrays;

import com.daniel.models.*;

public class LecturerClip {
    private static final int ALLOC_SIZE = 2;
    private Lecturer[] lecturers = new Lecturer[ALLOC_SIZE];
    private int pointer = 0;
    private int clipSize = ALLOC_SIZE;

    public Boolean addLecturer(String name, double salary) {
        if(pointer >= clipSize - 1) {
            Lecturer[] newClip = new Lecturer[clipSize * 2];
            for(int i = 0; i < clipSize; i++) {
                newClip[i] = lecturers[i];
            }
            lecturers = newClip;
            clipSize = clipSize * 2;
        }

        for (Lecturer lecturer : lecturers) {
            if(lecturer == null) continue;
            if(lecturer.name.toLowerCase() == name.toLowerCase()) {
                return false;
            }
        }

        lecturers[pointer] = new Lecturer(name, salary);
        pointer++;

        return true;
    }

    public Lecturer[] getLecturers() {
        return Arrays.copyOfRange(departments, 0, pointer);
    }
}
