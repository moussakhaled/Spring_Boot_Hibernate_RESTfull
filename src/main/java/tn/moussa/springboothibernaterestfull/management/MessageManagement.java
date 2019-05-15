package tn.moussa.springboothibernaterestfull.management;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tn.moussa.springboothibernaterestfull.entity.Message;


@Path("/messenger")
public class MessageManagement {
	
	
	@GET
	@Path("/messages/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam(value="code")int msg_id) {
		EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        Message msg = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("SendMessage");
        
            entityManager = entityManagerFactory.createEntityManager();
            
            msg = entityManager.createQuery( "from Message", Message.class ).getResultList().get(msg_id);
            

        }
        finally {
            if ( entityManager != null ) entityManager.close();
            if ( entityManagerFactory != null ) entityManagerFactory.close();
        }
        
        return msg;
	}
	
	
	
	@GET
	@Path("/messages")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> listeMessages(){
		
		EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        List<Message> messages  = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("SendMessage");
        
            entityManager = entityManagerFactory.createEntityManager();
            
            messages = entityManager.createQuery( "from Message", Message.class ).getResultList();

        }
        finally {
            if ( entityManager != null ) entityManager.close();
            if ( entityManagerFactory != null ) entityManagerFactory.close();
        }
        
        return messages;
	
	}
	
	
	
	@POST
	@Path("/messages")
	@Produces(MediaType.APPLICATION_JSON)
	public Message save(Message msg) {
		EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            
        	entityManagerFactory = Persistence.createEntityManagerFactory("SendMessage");
            
        	entityManager = entityManagerFactory.createEntityManager();
        	
        	EntityTransaction trans = entityManager.getTransaction();
            
        	trans.begin();
        	
        	if(msg.getMsg_date() == null)
        		msg.setMsg_date(new Date());
            
            entityManager.persist( msg );
    
            trans.commit();

        }
        finally {
            if ( entityManager != null ) entityManager.close();
            if ( entityManagerFactory != null ) entityManagerFactory.close();
        }
		return msg;
	}
	
	/*
	
	@PUT
	@Path("/messenger/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message update(Message msg, @PathParam("code")int code) {
		EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            
        	entityManagerFactory = Persistence.createEntityManagerFactory("SendMessage");
            
        	entityManager = entityManagerFactory.createEntityManager();
        	
        	EntityTransaction trans = entityManager.getTransaction();
            
        	trans.begin();
        	
        	msg.setMsg_date(new Date());
            
            entityManager.persist( msg );
    
            trans.commit();

        }
        finally {
            if ( entityManager != null ) entityManager.close();
            if ( entityManagerFactory != null ) entityManagerFactory.close();
        }
        
		return msg;
	}
	
	*/
	
	
	/*
	@DELETE
	@Path("/comptes/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean delete(@PathParam("code")int id) {
		
		EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            
        	entityManagerFactory = Persistence.createEntityManagerFactory("SendMessage");
            
        	entityManager = entityManagerFactory.createEntityManager();
        	
        	EntityTransaction trans = entityManager.getTransaction();
            
        	trans.begin();
            
        	entityManager.remove(  );
    
            trans.commit();

        }
        finally {
            if ( entityManager != null ) entityManager.close();
            if ( entityManagerFactory != null ) entityManagerFactory.close();
        }
        
		return true;
	}
	*/
	
}
