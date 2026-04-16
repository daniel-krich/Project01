package com.daniel.clips;

import java.util.Arrays;

import com.daniel.models.*;

public class CommitteeClip {
    private static final int ALLOC_SIZE = 2;
    private Committee[] committees = new Committee[ALLOC_SIZE];
    private int pointer = 0;
    private int clipSize = ALLOC_SIZE;

    public Boolean addCommitee(String name) {
        if(pointer >= clipSize - 1) {
            Committee[] newClip = new Committee[clipSize * 2];
            for(int i = 0; i < clipSize; i++) {
                newClip[i] = committees[i];
            }
            committees = newClip;
            clipSize = clipSize * 2;
        }

        for (Committee committee : committees) {
            if(committee == null) continue;
            if(committee.name.toLowerCase() == name.toLowerCase()) {
                return false;
            }
        }

        committees[pointer] = new Committee(name);
        pointer++;

        return true;
    }

    public Committee[] getCommittees() {
        return Arrays.copyOfRange(committees, 0, pointer);
    }
}