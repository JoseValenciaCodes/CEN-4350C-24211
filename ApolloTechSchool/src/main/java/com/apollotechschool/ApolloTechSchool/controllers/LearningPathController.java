package com.apollotechschool.ApolloTechSchool.controllers;

/* LearningPathController
 * Handle HTTP Requests related to the Category Entity
 * */

import com.apollotechschool.ApolloTechSchool.payloads.LearningPathPayload;
import com.apollotechschool.ApolloTechSchool.services.LearningPathService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/learning-paths")
public class LearningPathController
{
    public LearningPathService learningPathService;

    public LearningPathController(LearningPathService learningPathService) {
        this.learningPathService = learningPathService;
    }

    @GetMapping
    public ResponseEntity<List<LearningPathPayload>> getAllLearningPaths()
    {
        List<LearningPathPayload> learningPathPayloads = learningPathService.getAllLearningPaths();
        return ResponseEntity.ok(learningPathPayloads);
    }

    @GetMapping("{id}")
    public ResponseEntity<LearningPathPayload> getLearningPathById(@PathVariable("id") Long id)
    {
        LearningPathPayload learningPathPayload = learningPathService.getLearningPathById(id);
        return ResponseEntity.ok(learningPathPayload);
    }
}
