package model;

import java.util.Date;

public class Task {
    private String description;
    private Date dueDate;
    private String assignedUser;

    public Task(String description, Date dueDate) {
        this.description = description;
        this.dueDate = dueDate;
        this.assignedUser = "Unassigned";
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getAssignedUser() {
		return assignedUser;
	}

	public void setAssignedUser(String assignedUser) {
		this.assignedUser = assignedUser;
	}

  
}

