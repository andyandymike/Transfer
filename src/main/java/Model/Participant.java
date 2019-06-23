package Model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Participant {
    private static Logger logger = LogManager.getLogger(Participant.class);

    private List<Map<String, Integer>> incomes = new ArrayList<>();

    private Integer balance;

    private String ParticipantName;

    public Participant(String ParticipantName, Integer initBalance) {
        this.ParticipantName = ParticipantName;
        this.balance = initBalance;
    }

    private void addIncome(String direction, Integer value) {
        Map income = new HashMap();
        income.put(direction, value);
        incomes.add(income);
    }

    public void addBalance(String fromWhom, Integer value) {

        balance = balance + value;

        logger.debug(ParticipantName + " Get " + value + " from " + fromWhom);
    }

    public void minusBalance(String toWhom, Integer value) {
        if(balance < value) {
            throw new NumberFormatException(value + " > " + balance);
        }

        balance = balance - value;

        logger.info(ParticipantName + " Give " + value + " to " + toWhom);

        addIncome(toWhom, value);
    }

    public String getParticipantName() {
        return ParticipantName;
    }

    public void setParticipantName(String ParticipantName) {
        this.ParticipantName = ParticipantName;
    }

    public List<Map<String, Integer>> getIncomes() {
        return incomes;
    }

    public void setIncomes(List<Map<String, Integer>> incomes) {
        this.incomes = incomes;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}
