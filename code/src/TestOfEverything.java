import client.model.DataModel;
import client.network.DataClient;
import server.RMIServer.DataServer;
import server.RMIServer.Server;

import java.rmi.RemoteException;

public class TestOfEverything {
    public static void main(String[] args) throws RemoteException {
        DataClient dataClient = new DataClient();
        DataModel dataModel = new DataModel(dataClient);
        Server server = new DataServer();
        dataClient.createBranch("testAgain", "nowhere");
    }

}
