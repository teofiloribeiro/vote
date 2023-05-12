package com.teofilo.vote.entities;

import javax.persistence.*;

@Entity
@Table(name = "tb_vote")
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean vote;
    @OneToOne
    @JoinColumn(name="user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name="vote_session_id")
    private VoteSession voteSession;

    public Vote() {
    }

    public Vote(Boolean vote, User user, VoteSession voteSession) {
        this.vote = vote;
        this.user = user;
        this.voteSession = voteSession;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getVote() {
        return vote;
    }

    public void setVote(Boolean vote) {
        this.vote = vote;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public VoteSession getVoteSession() {
        return voteSession;
    }

    public void setVoteSession(VoteSession voteSession) {
        this.voteSession = voteSession;
    }
}
