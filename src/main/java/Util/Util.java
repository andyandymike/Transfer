package Util;

import Constant.Config;
import Model.Participant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Util {

    private static Logger logger = LogManager.getLogger(Util.class);

    public static List<Integer> separateNum(Integer number, Integer factor) {
        if (number < factor) {
            throw new NumberFormatException("Cannot divide " + number + " into " + factor + " parts");
        }
        if (factor <= 0) {
            throw new NumberFormatException(factor + " <= 0");
        }

        List<Integer> separate = new ArrayList<>();

        Integer remain = number;
        for (int i = 0; i < factor - 1; i++) {
            separate.add(number / factor);
            remain = remain - number / factor;
        }
        separate.add(remain);

        return separate;
    }

    public static Integer generateRandomLessThanHalf(Integer number) {
        if (number < 4) {
            throw new NumberFormatException("Cannot generate a random number less than half of " + number);
        }

        return new Random().nextInt(number/2);
    }

    public static int[] generateRandomTransferList(Integer totalNum) {
        return new Random().ints(0, totalNum).distinct().limit(totalNum).toArray();
    }

    public static void printCurrentAllBalance(List<Participant> participants) {
        for(Participant participant : participants) {
            logger.debug(participant.getParticipantName() + " has balance " + participant.getBalance());
        }
    }

    public static String getRandomReason() {
        Integer reasonNum = new Random().nextInt(Config.getReasonList().size());
        return Config.getReasonList().get(reasonNum);
    }
}
