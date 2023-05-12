package com.teofilo.vote.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class VoteSessionDto {
    private Long id;
    @NotNull(message = "discussionId is required.")
    @ApiModelProperty(notes = "Discussion ID", required = true)
    private Long discussionId;

    @ApiModelProperty(notes = "Time in minutes that the session will remain active")
    private Integer minutesActive;


    public VoteSessionDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDiscussionId() {
        return discussionId;
    }

    public void setDiscussionId(Long discussionId) {
        this.discussionId = discussionId;
    }

    public Integer getMinutesActive() {
        return minutesActive;
    }

    public void setMinutesActive(Integer minutesActive) {
        this.minutesActive = minutesActive;
    }
}
