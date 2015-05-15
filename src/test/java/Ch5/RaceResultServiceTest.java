package Ch5;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class RaceResultServiceTest {
    private RaceResultService raceResultService = new RaceResultService();
    private Client client1 = mock(Client.class, "client1"); // string parameter provides context for error message
    private Client client2 = mock(Client.class, "client2"); // i.e. 'client1 did not receive...
    private Message message = mock(Message.class);

    // zero subscribers
    @Test
    public void notSubscribedClientShouldNotReceiveMessage() {
        raceResultService.send(message);

        verify(client1, never()).receive(message);
        verify(client2, never()).receive(message);
    }

    // one subscriber
    @Test
    public void subscribedClientShouldRecieveMessage() {
        raceResultService.addSubscriber(client1);
        raceResultService.send(message);

        // this test is a spy-- measures response b/w two classes
        verify(client1).receive(message);
    }

    // two subscribers
    @Test
    public void allSubscribedClientsShouldGetMessage() {
        raceResultService.addSubscriber(client1);
        raceResultService.addSubscriber(client2);
        raceResultService.send(message);

        // this test is a spy-- measures response b/w two classes
        verify(client1).receive(message);
        verify(client2).receive(message);
    }

    @Test
    public void shouldSendOnlyOneMessageToMultiSubscriber() {
        raceResultService.addSubscriber(client1);
        raceResultService.addSubscriber(client1);
        raceResultService.send(message);
        // verify by default checks for a singular invocation
        verify(client1).receive(message);
        // *** Use times method as verify param to get multiple invocations
//        verify(client1, times(12)).receive(message);
    }

    @Test
    public void unsubscribedClientShouldNotReceiveMessages() {
        raceResultService.addSubscriber(client1);
        raceResultService.removeSubscriber(client1);

        raceResultService.send(message);
    }
}