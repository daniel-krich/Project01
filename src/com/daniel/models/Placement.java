package com.daniel.models;

public class Placement {
    public Lecturer lecturer;
    public Committee committee;
    
    public Placement(Lecturer lecturer, Committee committee) {
        this.lecturer = lecturer;
        this.committee = committee;
    }
}
