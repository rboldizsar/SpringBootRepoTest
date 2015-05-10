package hello.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity 
public class PingEvent implements Serializable{
	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue
	private Long eventId;

	@Column(nullable = false)
	private String description;
	
	public PingEvent(){
		
	}
	
	public PingEvent(String desc){
		description = desc;
	}
	
	public PingEvent(Long id, String desc){
		eventId = id;
		description = desc;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	} 
	
	
}
