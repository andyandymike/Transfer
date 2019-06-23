import Constant.Config;
import Model.Client;
import Model.Participant;
import Model.Server;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static Util.Util.*;

public class TransferApplication {

    private static Logger logger = LogManager.getLogger(TransferApplication.class);

    private static List<Client> clientList = new ArrayList<>();
    private static List<Participant> participantList = new ArrayList<>();

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("TransferApplication.xml");

        Server server = new Server();
        participantList.add(server);
        for (String clientName : Config.getClientNameList()) {
            Client client = new Client(clientName);
            clientList.add(client);
            participantList.add(client);
        }

        Integer totalParticipantNum = participantList.size();
        try {
            List<Integer> initBalanceList = separateNum(Config.getInitDispense(), Config.getClientNameList().size());
            for (int i = 0; i < initBalanceList.size(); i++) {
                server.minusBalance(clientList.get(i).getParticipantName(), initBalanceList.get(i));
                clientList.get(i).addBalance(server.getParticipantName(), initBalanceList.get(i));

            }
            logger.info("---------- init finished ----------");

            for (int i = 1; i < Config.getRound() + 1; i++) {
                int[] transferArray = generateRandomTransferList(totalParticipantNum);
                for(int j = 0; j < totalParticipantNum; j++) {
                    String toWhom = participantList.get(transferArray[j]).getParticipantName();
                    String fromWhom = participantList.get(j).getParticipantName();
                    Integer transferNum = generateRandomLessThanHalf(participantList.get(j).getBalance());
                    participantList.get(j).minusBalance(toWhom, transferNum);
                    participantList.get(transferArray[j]).addBalance(fromWhom, transferNum);
                }
                printCurrentAllBalance(participantList);
                logger.info("---------- " + i + " round finished ----------");
            }

            for(Client client : clientList) {
                server.addBalance(client.getParticipantName(), client.getBalance());
                client.minusBalance(server.getParticipantName(), client.getBalance());
            }
            printCurrentAllBalance(participantList);
            logger.info("---------- teardown finished ----------");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
