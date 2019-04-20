package Messenger;

public class Message {

    private String sender, recipient, message;

    public Message(String senderHandle, String recipientHandle, String message) {
        this.sender = senderHandle;
        this.recipient = recipientHandle;
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getMessage() {
        return message;
    }
}
