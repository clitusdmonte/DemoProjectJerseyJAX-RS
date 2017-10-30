package org.clitus.restapi.messenger.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.clitus.restapi.messenger.database.DatabaseClass;
import org.clitus.restapi.messenger.exception.DataNotFoundException;
import org.clitus.restapi.messenger.model.Message;

public class MessageService {
	private static Map<Long, Message> messages = DatabaseClass.getMessage();
	
	public  MessageService(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		messages.put(1L,new Message(1L, "Hello WOrld", date , "clitus"));
		messages.put(2L,new Message(2L, "Hello ", date , "archi"));
	}

	public List<Message> getAllMessage() {

		return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> getAllMessageForYear(int year){
		
		List<Message> messagesForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for(Message message : messages.values()){
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR)==year){
				messagesForYear.add(message);
			}
		}
		return messagesForYear;		
	}
	
	public List<Message> getAllMessagePaginated(int start, int size){
		
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		return list.subList(start, start + size);	
		
	}

	public Message getMessage(Long id) throws DataNotFoundException {
		if(messages.get(id) == null){
			throw new DataNotFoundException("Msg with id " +messages.get(id) + " Not FOund" );
		}
		return messages.get(id);

	}

	public Message addMessage(Message msg) {
		msg.setId(messages.size() + 1);
		messages.put(msg.getId(), msg);
		return msg;

	}

	public Message updateMessage(Message msg) {
		if (msg.getId() <= 0) {
			return null;
		}
		messages.put(msg.getId(), msg);
		return msg;

	}

	public Message removeMessage(Long id) {

		return messages.remove(id);

	}

}
