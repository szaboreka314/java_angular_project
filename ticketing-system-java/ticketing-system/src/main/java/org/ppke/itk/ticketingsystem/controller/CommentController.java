package org.ppke.itk.ticketingsystem.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ppke.itk.ticketingsystem.domain.Comment;
import org.ppke.itk.ticketingsystem.domain.DTO.CommentDTO;
import org.ppke.itk.ticketingsystem.domain.DTO.TicketDTO;
import org.ppke.itk.ticketingsystem.domain.Ticket;
import org.ppke.itk.ticketingsystem.domain.User;
import org.ppke.itk.ticketingsystem.repository.CommentRepository;
import org.ppke.itk.ticketingsystem.repository.TicketRepository;
import org.ppke.itk.ticketingsystem.repository.UserRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class CommentController {

    public final CommentRepository commentRepository;
    public final UserRepository userRepository;
    public final TicketRepository ticketRepository;

    @GetMapping("/comments/{ticketId}")
    public List<Comment> getCommentById(@PathVariable Integer ticketId){
        log.warn(ticketId.toString());
        return commentRepository.findAll().stream()
                .filter(comment -> comment.getTicketId().getId().equals(ticketId))
                .toList();
    }

    @PostMapping(value = "/comments/new_comment", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveComment(@RequestBody CommentDTO commentDTO, Principal principal){
        User createdBy = userRepository.findByEmail(principal.getName()).get();
        Comment comment = new Comment();
        comment.setCreatedAt(commentDTO.getCreatedAt());
        comment.setText(commentDTO.getText());
        comment.setUserId(createdBy);
        comment.setTicketId(ticketRepository.findById(commentDTO.getTicketId()).get());
        commentRepository.save(comment);
    }

}
