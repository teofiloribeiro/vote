package com.teofilo.vote.services.impl;

import com.teofilo.vote.dto.DiscussionDto;
import com.teofilo.vote.entities.Discussion;
import com.teofilo.vote.exceptions.DataNotFoundException;
import com.teofilo.vote.repositories.IDiscussionRepository;
import com.teofilo.vote.services.IDiscussionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiscussionService implements IDiscussionService {

    @Autowired
    private IDiscussionRepository discussionRepository;
    @Autowired
    private ModelMapper modelMapper;

    public DiscussionDto update (Long id, DiscussionDto discussionDto) throws DataNotFoundException {
        Discussion discussion = discussionRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Discussion Not Found."));
        discussionDto.setId(id);
        Discussion discussionToUpdate = this.discussionConverter(discussionDto);
        discussionRepository.save(discussionToUpdate);
        return discussionConverter(discussionToUpdate);
    }

    public DiscussionDto insert (DiscussionDto discussionDto){
        Discussion discussion = this.discussionConverter(discussionDto);
        discussionRepository.save(discussion);
        return discussionConverter(discussion);
    }

    public List<DiscussionDto> findAll(){
        List<Discussion> discussions = discussionRepository.findAll();
        return discussions.stream()
                .map(this::discussionConverter)
                .collect(Collectors.toList());
    }

    public DiscussionDto findById(Long id) throws DataNotFoundException {
        Discussion discussion = discussionRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Discussion Not Found."));
        return this.discussionConverter(discussion);
    }

    private Discussion discussionConverter (DiscussionDto discussionDto){
        return modelMapper.map(discussionDto, Discussion.class);
    }

    private DiscussionDto discussionConverter (Discussion discussion){
        return modelMapper.map(discussion, DiscussionDto.class);
    }
}
