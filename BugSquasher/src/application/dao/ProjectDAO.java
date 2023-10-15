package application.dao;

import content.bean.ProjectBean;

public class ProjectDAO implements ProjectDAOInt{
	
	private ProjectBean bean;
	
	public ProjectDAO(ProjectBean bean) {
		this.bean = bean;
	}
}
