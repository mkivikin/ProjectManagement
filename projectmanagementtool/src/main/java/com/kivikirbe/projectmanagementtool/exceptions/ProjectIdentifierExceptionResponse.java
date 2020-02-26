package com.kivikirbe.projectmanagementtool.exceptions;

public class ProjectIdentifierExceptionResponse {

    public String projectIdentifier;

    public ProjectIdentifierExceptionResponse(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }

    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }
}
