package com.daniel.models;

public class LecturerCommittee {
    public Lecturer lecturer;
    public Committee committee;
    
    public LecturerCommittee(Lecturer lecturer, Committee committee) {
        this.lecturer = lecturer;
        this.committee = committee;
    }
}