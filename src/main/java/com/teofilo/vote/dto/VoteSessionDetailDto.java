package com.teofilo.vote.dto;

import org.springframework.core.SpringVersion;

public class VoteSessionDetailDto {
    private Long id;
    private boolean isActive;
    private Long positiveVotes;
    private Long negativeVotes;
    private Long totalVotes;

    public VoteSessionDetailDto() {
    }

    public VoteSessionDetailDto(Long id, boolean isActive, Long positiveVotes, Long negativeVotes, Long totalVotes) {
        this.id = id;
        this.isActive = isActive;
        this.positiveVotes = positiveVotes;
        this.negativeVotes = negativeVotes;
        this.totalVotes = totalVotes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Long getPositiveVotes() {
        return positiveVotes;
    }

    public void setPositiveVotes(Long positiveVotes) {
        this.positiveVotes = positiveVotes;
    }

    public Long getNegativeVotes() {
        return negativeVotes;
    }

    public void setNegativeVotes(Long negativeVotes) {
        this.negativeVotes = negativeVotes;
    }

    public Long getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(Long totalVotes) {
        this.totalVotes = totalVotes;
    }
}

