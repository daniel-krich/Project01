package com.daniel.clips;

import com.daniel.models.*;
import java.util.Arrays;

public class LecturerCommitteeClip {
    private static final int ALLOC_SIZE = 2;
    private LecturerCommittee[] placements = new LecturerCommittee[ALLOC_SIZE];
    private int pointer = 0;
    private int clipSize = ALLOC_SIZE;

    public Boolean addLecturerCommittee(Lecturer lecturer, Committee committee) {
        if(pointer >= clipSize - 1) {
            placements = Arrays.copyOf(placements, clipSize*2);
            clipSize = clipSize * 2;
        }

        if(lecturer == null || committee == null) return false;

        for (LecturerCommittee placement : placements) {
            if(placement == null) continue;
            if(placement.lecturer.name.equalsIgnoreCase(lecturer.name) && placement.committee.name.equalsIgnoreCase(committee.name)) {
                return false;
            }
        }

        placements[pointer] = new LecturerCommittee(lecturer, committee);
        pointer++;

        return true;
    }

    public LecturerCommittee[] getLecturerCommittees() {
        return Arrays.copyOf(placements, pointer+1);
    }
}