package com.daniel.clips;

import java.util.Arrays;

import com.daniel.models.*;

public class PlacementClip {
    private static final int ALLOC_SIZE = 2;
    private Placement[] placements = new Placement[ALLOC_SIZE];
    private int pointer = 0;
    private int clipSize = ALLOC_SIZE;

    public Boolean addPlacement(Lecturer lecturer, Committee committee) {
        if(pointer >= clipSize - 1) {
            Placement[] newClip = new Placement[clipSize * 2];
            for(int i = 0; i < clipSize; i++) {
                newClip[i] = placements[i];
            }
            placements = newClip;
            clipSize = clipSize * 2;
        }

        for (Placement placement : placements) {
            if(placement == null) continue;
            if(placement.lecturer.name == lecturer.name && placement.committee.name == committee.name) {
                return false;
            }
        }

        placements[pointer] = new Placement(lecturer, committee);
        pointer++;

        return true;
    }

    public Placement[] getPlacements() {
        return Arrays.copyOfRange(placements, 0, pointer);
    }
}
