package sgsits.cse.dis.user.feignClient;

public class ResponseMessage {
    private String message;

    public ResponseMessage(String message) {
        this.message = message;
    }

    private String fileId;
    public ResponseMessage(String message, String fileId) {
        this.message = message;
        this.fileId = fileId;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }
}
