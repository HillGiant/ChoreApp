package choretracker.entities;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

import choretracker.dataaccess.records.ChoreRecord;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Chore {
	private int id;
	private String title;
	private Date dueBy;
	
	public static Chore FromChoreRecord(ChoreRecord r)
	{
		Chore c = new Chore();
		c.setId(r.getId());
		c.setDueBy(r.getDueBy());
		c.setTitle(r.getTitle());
		return c;
	}
	
	public String getTitle()
	{
		return this.title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public Date getDueBy()
	{
		return this.dueBy;
	}
	
	public void setDueBy(Date dueBy)
	{
		this.dueBy = dueBy;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
}
