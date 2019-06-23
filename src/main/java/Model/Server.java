package Model;

import Constant.Config;

public class Server extends Participant {

    public Server() {
        super(Config.getServerName(), Config.getTotalBalance());
    }

}
