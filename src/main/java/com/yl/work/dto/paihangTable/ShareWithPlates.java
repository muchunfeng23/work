package com.yl.work.dto.paihangTable;

public class ShareWithPlates {
    private String shareCode;
    private String shareName;
    private String sharePlates;

    public String getShareCode() {
        return shareCode;
    }

    public void setShareCode(String shareCode) {
        this.shareCode = shareCode;
    }

    public String getShareName() {
        return shareName;
    }

    public void setShareName(String shareName) {
        this.shareName = shareName;
    }

    public String getSharePlates() {
        return sharePlates;
    }

    public void setSharePlates(String sharePlates) {
        this.sharePlates = sharePlates;
    }

    @Override
    public String toString() {
        return "ShareWithPlates{" +
                "shareCode='" + shareCode + '\'' +
                ", shareName='" + shareName + '\'' +
                ", sharePlates='" + sharePlates + '\'' +
                '}';
    }
}
