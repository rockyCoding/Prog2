package Messenger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Messenger {

    static List<Inbox> inboxes = new ArrayList<>();
    static List<User> users = new ArrayList<>();
    static User admin = new User("admin", "admin", "admin");
    static Inbox in_admin = new Inbox(admin);

    static void generateInboxes(Inbox in_admin, Inbox in_User1, Inbox in_User2, Inbox in_User3){
        inboxes.add(in_admin);
        inboxes.add(in_User1);
        inboxes.add(in_User2);
        inboxes.add(in_User3);
    }

    static void generateUserlist(User user1, User user2, User user3){
        users.add(user1);
        users.add(user2);
        users.add(user3);
    }

    static void sendMessage(User recipient, String handle, String text){
        for(Inbox inbox : inboxes){
            if (recipient.getHandle().equals("admin")){
                System.out.println("Ihre Nachricht konnte nicht gesendet werden, da Sie keinen gültigen Empfänger eingegeben haben.");
            }
            else if (inbox.getOwner().getHandle().equals(recipient.getHandle())){
                inbox.newMessage(new Message(handle, recipient.getHandle(), text));
            }
        }
    }

    static User findUser(String userhandle){
        User recipient = admin;
        for (User user : users){
            if (user.getHandle().equals(userhandle)){
                recipient = user;
            }
        }
        return recipient;
    }

    static Inbox findInbox(String handle){
        Inbox requested = in_admin;
        for (Inbox inbox : inboxes){
            if (handle.equals(inbox.getOwner().getHandle())){
                requested = inbox;
            }
        }
        return requested;
    }

    static void printMessage(Message message){
        System.out.println("\n\nVon: " + message.getSender());
        System.out.println("An: " + message.getRecipient());
        System.out.println("Nachricht: \n" + message.getMessage() + "\n\n");
    }

    static void printAll(Inbox inbox){
        for (Message message : inbox.getMessages()){
            printMessage(message);
        }
    }


    public static void main(String[] args) {
        boolean end = false, handleCheckDone = false;
        Scanner scanner = new Scanner(System.in);
        String handle = "", command, recipient, text, nameCheck;
        User recipientUser;

        User user1 = new User("user1", "Max", "Muster");
        User user2 = new User("user2", "Fritz", "Fischer");
        User user3 = new User("user3", "Anna", "Schneider");

        Inbox in_User1 = new Inbox(user1);
        Inbox in_User2 = new Inbox(user2);
        Inbox in_User3 = new Inbox(user3);

        generateInboxes(in_admin, in_User1, in_User2, in_User3);
        generateUserlist(user1, user2, user3);

        do{
            System.out.println("Registrierte Nutzer: " + user1.getHandle() + ", " + user2.getHandle() + ", " + user3.getHandle());
            System.out.println("Welcher Benutzer sind Sie? (Ihr Nutzername)");
            while (!handleCheckDone){
                handle = scanner.nextLine();
                nameCheck = findUser(handle).getHandle();
                if (handle.equals(nameCheck)){
                    handleCheckDone = true;
                }
                else{
                    System.out.println("Kein Benutzer vorhanden, geben Sie korrekten Benutzer an.");
                }
            }
            System.out.println("Was wollen Sie tun? send für Senden, read für Lesen, end beendet Programm");
            command = scanner.nextLine();
            if (command.equals("send")){
                System.out.println("An wen wollen Sie senden? (Nutzername)");
                recipient = scanner.nextLine();
                System.out.println("Ihre Nachricht?");
                text = scanner.nextLine();
                recipientUser = findUser(recipient);
                sendMessage(recipientUser, handle, text);
                if (!recipientUser.getHandle().equals("admin")) {
                    System.out.println("Ihre Nachricht wurde an " +recipientUser.getFullName() + " gesendet, auf Wiedersehen.");
                }
            }
            else if (command.equals("read")){
                System.out.println("Wollen sie eine bestimmte Nachricht lesen, geben sie die Nummer ein (1-X), 0 um alle Nachrichten zu lesen.");
                System.out.println("Sie haben " + findInbox(handle).getMessages().size() + " Nachrichten.");
                command = scanner.nextLine();
                if (command.equals("0")){
                    if (!findInbox(handle).getMessages().isEmpty()) {
                        printAll(findInbox(handle));
                    }
                    else {
                        System.out.println("Keine Nachrichten vorhanden.");
                    }
                }
                else {
                    if (Integer.parseInt(command) <= findInbox(handle).getMessages().size()) {
                        printMessage(findInbox(handle).getSpecificMessage((Integer.parseInt(command)-1)));
                    }
                    else {
                        System.out.println("Diese Nachricht gibt es nicht.");
                    }
                }
                System.out.println("Einen schönen Tag noch.");
            }
            else if (command.equals("end")){
                end = true;
            }
            else{
                System.out.println("Kein gültiger Befehl.");
            }
            handleCheckDone = false;
            System.out.println();
            System.out.println();
            System.out.println();
        }while (!end);
    }
}
