package com.daniel.clips;

import com.daniel.models.*;
import java.util.Arrays;

public class CommitteeClip {
    private static final int ALLOC_SIZE = 2;
    private Committee[] committees = new Committee[ALLOC_SIZE];
    private int pointer = 0;
    private int clipSize = ALLOC_SIZE;

    public Boolean addCommitee(String name) {
        if(pointer >= clipSize - 1) {
            committees = Arrays.copyOf(committees, clipSize*2);
            clipSize = clipSize * 2;
        }

        for (Committee committee : committees) {
            if(committee == null) continue;
            if(committee.name.equalsIgnoreCase(name)) {
                return false;
            }
        }

        committees[pointer] = new Committee(name);
        pointer++;

        return true;
    }

    public Committee getCommittee(String name) {
        for(Committee committee : committees) {
            if(committee == null) continue;
            if(committee.name.equalsIgnoreCase(name)) {
                return committee;
            }
        }
        return null;
    }

    public Committee[] getCommittees() {
        return Arrays.copyOf(committees, pointer+1);
    }
}