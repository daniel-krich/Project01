package com.daniel;

import com.daniel.clips.*;
import com.daniel.models.*;

public class College {

    private String collegeName = "";
    private final DepartmentClip departments = new DepartmentClip();
    private final LecturerClip lecturers = new LecturerClip();
    private final CommitteeClip committees = new CommitteeClip();
    private final LecturerCommitteeClip placements = new LecturerCommitteeClip();

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollengeName(String name) {
        collegeName = name;
    }

    public Boolean addDepartment(String name) {
        return departments.addDepartment(name);
    }

    public Boolean addLecturer(String name, double salary) {
        return lecturers.addLecturer(name, salary);
    }

    public Boolean addCommittee(String name) {
        return committees.addCommitee(name);
    }

    public Boolean assignLecturerToACommittee(String lecturerName, String committeeName) {
        Lecturer lecturer = lecturers.getLecturer(lecturerName);
        Committee committee = committees.getCommittee(committeeName);
        return placements.addLecturerCommittee(lecturer, committee);
    }

    public String getAllDepartments() {
        StringBuilder builder = new StringBuilder();
        for (Department department : departments.getDepartments()) {
            if(department != null)
                builder.append("%s\n".formatted(department.name));
        }
        return builder.toString();
        
    }

    public String getAllCommittees() {
        StringBuilder builder = new StringBuilder();
        for (Committee committee : committees.getCommittees()) {
            if(committee != null)
                builder.append("%s\n".formatted(committee.name));
        }
        return builder.toString();
        
    }

    public String getAllLecturers() {
        StringBuilder builder = new StringBuilder();
        for (Lecturer lecturer : lecturers.getLecturers()) {
            if(lecturer != null)
                builder.append("%s\n".formatted(lecturer.name));
        }
        return builder.toString();
        
    }
}