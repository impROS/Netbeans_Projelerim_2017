package servermain;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prog on 13.03.15.
 */
public class Clients implements ReceiveListener {
    private List<Client> clients = new ArrayList<Client>();

    public Clients() {
        clients = new ArrayList<Client>();
    }

    public void addClient(Client client){
        System.out.println("addClient");
        clients.add(client);
        sendConnectNewPlayer(client);
        getAllPlayers(client);
    }

    @Override
    public void dataReceive(Client client, String data) {
        sendBroadcast(client, data);
    }

    public void sendBroadcast(Client client,  String data){
        System.out.println("sendBroadcast");
        for(Client item : clients){
            if(item != client) {
                item.sendToClient(data);
            }
        }
    }

    private void sendConnectNewPlayer(Client client){
        System.out.println("sendConnectNewPlayer");
        JSONObject json = new JSONObject();
        try {
            System.out.println("impROS");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getAllPlayers(Client client){
        System.out.println("getAllPlayers");
        for(Client item : clients){
            if(item != client) {
                JSONObject json = new JSONObject();
                try {

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                client.sendToClient(json.toString());
            }
        }
    }
}
