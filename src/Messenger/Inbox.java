package Messenger;

import java.util.ArrayList;
import java.util.List;


public class Inbox {

    private User owner;
    private List<Message> messages;

    public Inbox(User owner) {
        this.owner = owner;
        this.messages = new ArrayList<>();
    }

    public User getOwner() {
        return owner;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public Message getSpecificMessage(int i) {
        return messages.get(i);
    }

    public void newMessage(Message message) {
        this.messages.add(message);
    }

    public int inboxSize(){
        return messages.size();
    }
}
