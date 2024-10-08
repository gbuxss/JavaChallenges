package ArrayList;

import java.util.ArrayList;

public class MobilePhone {

    private String myNumber;
    ArrayList<Contact> myContacts;

    public MobilePhone(){//String myNumber) {
        //this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact contact) {

        if (findContact(contact.getName()) >= 0) {
            System.out.println("Contact is already on file");
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {

        int foundPosition = findContact(oldContact.getName());
        if (foundPosition < 0) {
            System.out.println(oldContact.getName() + ", was not found.");
            return false;
        } else if (findContact(newContact.getName()) != -1) {
            System.out.println(newContact.getName() + ", Already exist, no update is made.");
            return false;
        }
        this.myContacts.set(foundPosition, newContact);
        System.out.println(newContact.getName() + ", has been update for " + oldContact.getName());
        return true;
    }

    public boolean removeContact(Contact contact) {

        int position = findContact(contact);
        if(position < 0){
            System.out.println(contact.getName()+ ", was not found.");
            return false;
        }
        this.myContacts.remove(position);
        System.out.println(contact.getName()+ ", was deleted ");
        return true;
    }

    private int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }

    private int findContact(String contact) {
        for (int i = 0; i < myContacts.size(); i++) {
            Contact mycontact = myContacts.get(i);
            if (mycontact.getName().equals(contact)) {
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String contactName) {

        int position = findContact(contactName);
        if (position >= 0) {
            return this.myContacts.get(position);
        }

        return null;
    }

    public void printContacts() {

        System.out.println("Contact List:");
        for (int i = 0; i < this.myContacts.size(); i++) {
            System.out.println((i + 1) + ". " +
                    this.myContacts.get(i).getName() + " -> " +
                    this.myContacts.get(i).getPhoneNumber());
        }
    }
}





