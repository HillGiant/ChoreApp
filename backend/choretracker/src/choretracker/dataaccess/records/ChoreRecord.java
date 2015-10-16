package choretracker.dataaccess.records;

import java.util.Date;

public class ChoreRecord {
	private int id;
	private String title;
	private Date dueBy;

	public ChoreRecord(int id, String title, Date dueBy)
	{
		this.id = id;
		this.title = title;
		this.dueBy = dueBy;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public String getTitle()
	{
		return this.title;
	}
	
	public Date getDueBy()
	{
		return this.dueBy;
	}
	
}
