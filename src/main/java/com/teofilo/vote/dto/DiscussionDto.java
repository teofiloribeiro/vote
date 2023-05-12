package com.teofilo.vote.dto;

import javax.validation.constraints.NotEmpty;

public class DiscussionDto {
    private Long id;
    @NotEmpty(message = "title is required.")
    private String title;
    @NotEmpty(message = "description is required.")
    private String description;

    public DiscussionDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
