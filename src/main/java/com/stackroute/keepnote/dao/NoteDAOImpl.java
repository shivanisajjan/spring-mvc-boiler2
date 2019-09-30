package com.stackroute.keepnote.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.*;
import com.stackroute.keepnote.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

/*
 * This class is implementing the NoteDAO interface. This class has to be annotated with @Repository
 * annotation.
 * @Repository - is an annotation that marks the specific class as a Data Access Object, thus
 * 				 clarifying it's role.
 * @Transactional - The transactional annotation itself defines the scope of a single database
 * 					transaction. The database transaction happens inside the scope of a persistence
 * 					context.
 * */
@Repository
@Transactional
public class NoteDAOImpl implements NoteDAO {

	/*
	 * Autowiring should be implemented for the SessionFactory.
	 */
	@Autowired
	private SessionFactory sessionFactory;
	public NoteDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	/*
	 * Save the note in the database(note) table.
	 */

	public boolean saveNote(Note note) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(note);
		System.out.println("successfully saved");
		return true;
//		Transaction t = null;
//		boolean b=true;
//		try {
//			t = session.beginTransaction();
//			session.save(note);
//			t.commit();
//			System.out.println("successfully saved");
//		}
//		catch (HibernateException e){
//			if (t!=null) t.rollback();
//			b=false;
//			e.printStackTrace();
//		}
//		finally {
//			session.close();
//			return b;
//		}
	}

	/*
	 * Remove the note from the database(note) table.
	 */

	public boolean deleteNote(int noteId) {
		Session session = this.sessionFactory.getCurrentSession();
		Note note=getNoteById(noteId);
		if(note==null){
			return false;
		}
		else {
			session.delete(getNoteById(noteId));
			System.out.println("successfully deleted");
			return true;
		}
//		Transaction t = null;
//		boolean b=true;
//		try {
//			t = session.beginTransaction();
//			Note note=getNoteById(noteId);
//			if(note==null){
//				return false;
//			}
//			else {
//				session.delete(getNoteById(noteId));
//				t.commit();
//				System.out.println("successfully deleted");
//			}
//		}
//		catch (HibernateException e){
//			if (t!=null) t.rollback();
//			b=false;
//			e.printStackTrace();
//		}
//		finally {
//			session.close();
//			return b;
//		}
	}

	/*
	 * retrieve all existing notes sorted by created Date in descending
	 * order(showing latest note first)
	 */
	public List<Note> getAllNotes() {
		Session session = this.sessionFactory.getCurrentSession();
		List list=session.createSQLQuery("select * from Note").addEntity(Note.class).list();
		return list;
	}

	/*
	 * retrieve specific note from the database(note) table
	 */
	public Note getNoteById(int noteId) {
		Session session = this.sessionFactory.getCurrentSession();
		Note note=session.get(Note.class,noteId);
		return note;

	}

	/* Update existing note */

	public boolean UpdateNote(Note note) {
		Session session = this.sessionFactory.getCurrentSession();
		Note note1 = session.get(Note.class, note.getNoteId());
		if (note == null) {
			return false;
		}
		else {
//			session.update(note);
//			note1.setNoteId(note.getNoteId());
			note1.setNoteTitle(note.getNoteTitle());
			note1.setNoteContent(note.getNoteContent());
			note1.setNoteStatus(note.getNoteStatus());
			note1.setCreatedAt(note.getCreatedAt());
			session.update(note1);
			System.out.println("Updated Successfully");
		}
		return true;
	}
//		Transaction tx = null;
//		boolean b=true;
//		try{
//			tx = session.beginTransaction();
//			Note note1 = session.get(Note.class, note.getNoteId());
//			if(note==null){
//				return false;
//			}
//			else {
//				note1.setNoteId( note.getNoteId() );
//				note1.setNoteTitle(note.getNoteTitle());
//				note1.setNoteContent(note.getNoteContent());
//				note1.setNoteStatus(note.getNoteStatus());
//				note1.setCreatedAt(note.getCreatedAt());
//				session.update(note1);
//				tx.commit();
//			}
//		}catch (HibernateException e) {
//			if (tx!=null) tx.rollback();
//			b=false;
//			e.printStackTrace();
//		}finally {
//			session.close();
//			return b;
//		}
//	}

}