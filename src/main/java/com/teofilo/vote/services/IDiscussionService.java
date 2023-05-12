package com.teofilo.vote.services;

import com.teofilo.vote.dto.DiscussionDto;
import com.teofilo.vote.exceptions.DataNotFoundException;

import java.util.List;

public interface IDiscussionService {
    DiscussionDto update (Long id, DiscussionDto discussionDto) throws DataNotFoundException;
    DiscussionDto insert (DiscussionDto discussionDto);
    List<DiscussionDto> findAll();
    DiscussionDto findById(Long id) throws DataNotFoundException;
}
