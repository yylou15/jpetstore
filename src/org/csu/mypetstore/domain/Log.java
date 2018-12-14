package org.csu.mypetstore.domain;

import java.io.Serializable;

public class Log implements Serializable {
    private int lid;
    private String userId;
    private String createTime;
    private String details;
    private String action;

    public int getLid() {
        return lid;
    }

    public String getUserId() {
        return userId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getDetails() {
        return details;
    }

    public String getAction() {
        return action;
    }
}
