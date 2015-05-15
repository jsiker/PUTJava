package Ch5;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by m805958 on 5/14/15.
 *
 * A class to update and send clients messages about latest race (sport, not the perception of skin tone) results
 */
public class RaceResultService {

    // *** shouldSendOnlyOneMessageToMultiSubscriber passes-- sets can't duplicate (every value is unique), lists can!!
    private Collection<Client> clients = new HashSet<Client>();

    // *** List fails with multiple subscriptions from same user.
    // *** User received duplicate messages
    // *** Lists can have duplicate values!
//    private ArrayList<Client> clients = new ArrayList<Client>();

    public void addSubscriber(Client client) {
        this.clients.add(client);
    }

    public void send(Message message) {
        for (Client client: clients) {
            client.receive(message);
        }
    }

    public void removeSubscriber(Client client) {
        this.clients.remove(client);
    }
}
