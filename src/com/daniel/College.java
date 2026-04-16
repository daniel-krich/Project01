package com.daniel;

import com.daniel.models.*;
import com.daniel.clips.*;

public class College {

    private String collegeName = "";
    private DepartmentClip departments = new DepartmentClip();
    private LecturerClip lecturers = new LecturerClip();
    private CommitteeClip committees = new CommitteeClip();
    private PlacementClip placements = new PlacementClip();

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollengeName(String name) {
        collegeName = name;
    }

    public Boolean addDepartment(String name) {
        return departments.addDepartment(name);
    }

    public String getAllDepartments() {
        StringBuilder builder = new StringBuilder();
        for (Department department : departments.getDepartments()) {
            builder.append(department.name + '\t');
        }
        return builder.toString();
        
    }
}
