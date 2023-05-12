package com.teofilo.vote.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class VoteDto {
    @NotNull(message = "userId is required.")
    private Long userId;
    @NotNull(message = "sessionId is required.")
    private Long sessionId;
    @NotNull(message = "answer is required.")
    private boolean answer;

    public VoteDto() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
