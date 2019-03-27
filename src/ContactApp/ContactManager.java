package ContactApp;

public class ContactManager {
    Contact[] myFriends;
    int friendsCount;

    public ContactManager() {
        this.myFriends = new Contact[100];
        this.friendsCount = 0;
    }

    void addContact(Contact contact) {
        myFriends[friendsCount] = contact;
        friendsCount++;
    }

    Contact searchContact(String searchName) {
        for (int i = 0; i < friendsCount; i++) {
            if (myFriends[i].name.equalsIgnoreCase(searchName)) {
                return myFriends[i];
            }
        }
        return null;
    }


}
