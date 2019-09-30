package com.stackroute.keepnote.model;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

/*
 * The class "Note" will be acting as the data model for the note Table in the database. Please
 * note that this class is annotated with @Entity annotation. Hibernate will scan all package for 
 * any Java objects annotated with the @Entity annotation. If it finds any, then it will begin the 
 * process of looking through that particular Java object to recreate it as a table in your database.
 */
@Component
@Entity
public class Note {
	@Id
	private int noteId;
	private String noteTitle;
	private String noteContent;
	private String noteStatus;
	private LocalDateTime createdAt;
	public Note() {

	}

	public Note(int i, String string, String string2, String string3, LocalDateTime localDate) {
		this.noteId=i;
		this.noteTitle=string;
		this.noteContent=string2;
		this.noteStatus=string3;
		this.createdAt=localDate;
	}
	/* All the getters/setters definition should be implemented here */
	public void setNoteId(int intid) {
		this.noteId=intid;
	}
	public void setNoteTitle(String string) {
		this.noteTitle=string;
	}
	public void setNoteContent(String string) {
		this.noteContent=string;
	}


	public void setNoteStatus(String string) {
		this.noteStatus=string;
	}
	public void setCreatedAt(LocalDateTime localdatetime) {
		this.createdAt=localdatetime;
	}

	@Override
	public String toString() {
		return "Note{" +
				"noteId=" + noteId +
				", noteTitle='" + noteTitle + '\'' +
				", noteContent='" + noteContent + '\'' +
				", noteStatus='" + noteStatus + '\'' +
				", createdAt=" + createdAt +
				'}';
	}

	public int getNoteId() { return this.noteId; }
	public String getNoteTitle() {
		return this.noteTitle;
	}
	public String getNoteContent() {
		return this.noteContent;
	}
	public String getNoteStatus() {
		return this.noteStatus;
	}
	public LocalDateTime getCreatedAt() {
		return this.createdAt;
	}
}
