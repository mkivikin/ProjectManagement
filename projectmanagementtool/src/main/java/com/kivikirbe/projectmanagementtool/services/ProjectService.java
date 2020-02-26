package com.kivikirbe.projectmanagementtool.services;

import com.kivikirbe.projectmanagementtool.domain.Project;
import com.kivikirbe.projectmanagementtool.exceptions.ProjectIdentifierException;
import com.kivikirbe.projectmanagementtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){
        try{
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        } catch(Exception e){
            throw new ProjectIdentifierException("Project ID " + project.getProjectIdentifier().toUpperCase() + " already exists");
        }
    }

    public Project findProjectByIdentifier(String projectIdentifier){
        Project project = projectRepository.findByProjectIdentifier(projectIdentifier.toUpperCase());
        if(project == null){
            throw new ProjectIdentifierException("Project ID " + projectIdentifier + " does not exist");
        } else {
            return project;
        }
    }

    public Iterable<Project> findAllProjects(){
        return projectRepository.findAll();
    }

    public void deleteProjectByIdentifier(String projectIdentifier){
        Project project = projectRepository.findByProjectIdentifier(projectIdentifier.toUpperCase());
        if(project == null){
            throw new ProjectIdentifierException("Can't find Project with Identifier " + projectIdentifier + " Project does not exist");
        } else {
            projectRepository.delete(project);
        }
    }

}
