package tn.moussa.springboothibernaterestfull.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name="Messages" )
public class Message implements Serializable{
	
	private long msg_id;
	private String msg_from;
	private String msg_to;
	private Date msg_date;
	private String msg_body;
	
	public Message() {
        this( "unknown", "unknown", new Date(), "EMPTY" );
    }
    
    
    public Message( String msg_from, String msg_to, Date msg_date, String msg_body) {
        this.setMsg_from(msg_from);
        this.setMsg_to(msg_to);
        this.setMsg_date(msg_date);
        this.setMsg_body(msg_body);
    }
	
	public long getMsg_id() {
		return msg_id;
	}
	
	@Id @GeneratedValue( strategy=GenerationType.IDENTITY )
	public void setMsg_id(long msg_id) {
		this.msg_id = msg_id;
	}
	
	public String getMsg_from() {
		return msg_from;
	}
	
	public void setMsg_from(String msg_from) {
		this.msg_from = msg_from;
	}
	
	public String getMsg_to() {
		return msg_to;
	}
	
	public void setMsg_to(String msg_to) {
		this.msg_to = msg_to;
	}
	
	public Date getMsg_date() {
		return msg_date;
	}
	
	public void setMsg_date(Date msg_date) {
		this.msg_date = msg_date;
	}
	
	public String getMsg_body() {
		return msg_body;
	}
	
	public void setMsg_body(String msg_body) {
		this.msg_body = msg_body;
	}
	
	@Override
	public String toString() {
		return "Message [msg_id = " + msg_id + ", msg_from = " + msg_from + ", msg_to = " + msg_to + ", msg_date = " + msg_date.toString() + ", msg_body=" + msg_body
				+ "]";
	}
	
	

}
