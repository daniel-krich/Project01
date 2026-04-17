package com.daniel;

import com.daniel.clips.*;
import com.daniel.models.*;

public class College {

    private String collegeName = "";
    private DepartmentClip departments = new DepartmentClip();
    private LecturerClip lecturers = new LecturerClip();
    private CommitteeClip committees = new CommitteeClip();
    private LecturerCommitteeClip placements = new LecturerCommitteeClip();

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
            builder.append(department.name);
            builder.append('\n');
        }
        return builder.toString();
        
    }

    public String getAllCommittees() {
        StringBuilder builder = new StringBuilder();
        for (Committee committee : committees.getCommittees()) {
            builder.append(committee.name);
            builder.append('\n');
        }
        return builder.toString();
        
    }

    public String getAllLecturers() {
        StringBuilder builder = new StringBuilder();
        for (Lecturer lecturer : lecturers.getLecturers()) {
            builder.append(lecturer.name);
            builder.append('\n');
        }
        return builder.toString();
        
    }
}