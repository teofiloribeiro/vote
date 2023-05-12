package com.teofilo.vote.entities;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_vote_session")
public class VoteSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "discussion_id")
    private Discussion discussion;
    @OneToMany(mappedBy = "voteSession")
    private List<Vote> votes;
    private Date startDate;
    private Date endDate;

    public VoteSession() {
    }

    public VoteSession(Discussion discussion, Date startDate, Date endDate) {
        this.discussion = discussion;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Discussion getDiscussion() {
        return discussion;
    }

    public void setDiscussion(Discussion discussion) {
        this.discussion = discussion;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
