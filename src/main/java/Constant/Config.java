package Constant;

import java.util.List;

public class Config {
    private static List<String> reasonList;

    private static List<String> clientNameList;

    private static String serverName;

    private static Integer totalBalance;

    private static Integer initDispense;

    private static Integer round;

    public static void addReason(String reason) {
        reasonList.add(reason);
    }

    public static void addClientName(String clientName) {
        clientNameList.add(clientName);
    }

    public static Integer getRound() {
        return round;
    }

    public static void setRound(Integer round) {
        Config.round = round;
    }

    public static List<String> getReasonList() {
        return reasonList;
    }

    public static void setReasonList(List<String> reasonList) {
        Config.reasonList = reasonList;
    }

    public static List<String> getClientNameList() {
        return clientNameList;
    }

    public static void setClientNameList(List<String> clientNameList) {
        Config.clientNameList = clientNameList;
    }

    public static String getServerName() {
        return serverName;
    }

    public static void setServerName(String serverName) {
        Config.serverName = serverName;
    }

    public static Integer getTotalBalance() {
        return totalBalance;
    }

    public static void setTotalBalance(Integer totalBalance) {
        Config.totalBalance = totalBalance;
    }

    public static Integer getInitDispense() {
        return initDispense;
    }

    public static void setInitDispense(Integer initDispense) {
        Config.initDispense = initDispense;
    }
}
