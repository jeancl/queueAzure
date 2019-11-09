package sample;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.queue.CloudQueue;
import com.microsoft.azure.storage.queue.CloudQueueClient;
import com.microsoft.azure.storage.queue.CloudQueueMessage;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URISyntaxException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    /* *************************************************************************************************************************
     * Instructions: Start an Azure storage emulator, such as Azurite, before running the app.
     *    Alternatively, remove the "UseDevelopmentStorage=true;"; string and uncomment the 3 commented lines.
     *    Then, update the storageConnectionString variable with your AccountName and Key and run the sample.
     * *************************************************************************************************************************
     */
    public static final String storageConnectionString = "UseDevelopmentStorage=true;";
    //"DefaultEndpointsProtocol=https;" +
    //"AccountName=<account-name>;" +
    //"AccountKey=<account-key>";

    public TextField queueName;
    public TextField msgField;
    public Button createQueueBtn;
    public Button addMsgBtn;
    public Button listMsgBtn;
    public ListView msgListView;

    private CloudStorageAccount storageAccount;
    private CloudQueueClient queueClient;
    private CloudQueue cloudQueue;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            // Parse the connection string and create a blob client to interact with Blob storage
            storageAccount = CloudStorageAccount.parse(storageConnectionString);
            queueClient =  storageAccount.createCloudQueueClient();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
    }

    public void createQueue(ActionEvent actionEvent) throws URISyntaxException, StorageException {
        if(!queueName.getText().isEmpty()) {
            System.out.println("Creating Azure Queue: " + queueName.getText());
            cloudQueue = queueClient.getQueueReference(queueName.getText());
            cloudQueue.createIfNotExists();
        }
    }

    public void addMsg(ActionEvent actionEvent) throws StorageException {
        if(!msgField.getText().isEmpty()) {
            System.out.println("Adding Azure Queue Msg: " + msgField.getText());
            CloudQueueMessage queueMsg = new CloudQueueMessage(msgField.getText());
            cloudQueue.addMessage(queueMsg);
            msgField.setText("");
        }
    }

    public void listMsgs(ActionEvent actionEvent) throws StorageException {
        Iterable<CloudQueueMessage> messages = cloudQueue.retrieveMessages(10);
        for (CloudQueueMessage msg : messages) {
            msgListView.getItems().add(msg.getMessageContentAsString());
        }
    }
}
