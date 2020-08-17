package nl.hrmanagement.absence.dto;

import java.util.UUID;

public class CancelRequestDTO {
    private UUID userId;
    private int requestId;

    public CancelRequestDTO() {
    }

    public CancelRequestDTO(UUID userId, int requestId) {
        this.userId = userId;
        this.requestId = requestId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }
}
