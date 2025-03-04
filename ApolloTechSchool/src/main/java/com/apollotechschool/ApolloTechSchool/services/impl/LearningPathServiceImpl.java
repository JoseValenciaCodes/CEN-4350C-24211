package com.apollotechschool.ApolloTechSchool.services.impl;

/* LearningPathServiceImpl
 * Learning Path Service Implementation
 * Establish Business Logic on DB interactions related to the LearningPath Entity
 * */

import com.apollotechschool.ApolloTechSchool.entities.LearningPath;
import com.apollotechschool.ApolloTechSchool.exceptions.EntityNotFoundException;
import com.apollotechschool.ApolloTechSchool.payloads.LearningPathPayload;
import com.apollotechschool.ApolloTechSchool.repositories.LearningPathRepository;
import com.apollotechschool.ApolloTechSchool.services.LearningPathService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LearningPathServiceImpl implements LearningPathService
{
    private LearningPathRepository learningPathRepository;

    public LearningPathServiceImpl(LearningPathRepository learningPathRepository) {
        this.learningPathRepository = learningPathRepository;
    }

    @Override
    public List<LearningPathPayload> getAllLearningPaths() {
        List<LearningPath> learningPaths = learningPathRepository.findAll();
        List<LearningPathPayload> learningPathPayloads = new ArrayList<LearningPathPayload>();

        for (LearningPath learningPath : learningPaths)
        {
            learningPathPayloads.add(new LearningPathPayload(
                    learningPath.getId(),
                    learningPath.getTitle(),
                    learningPath.getDescription(),
                    learningPath.getPicUrl()
            ));
        }

        return learningPathPayloads;
    }

    @Override
    public LearningPathPayload getLearningPathById(Long id) {
        LearningPath learningPath = learningPathRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Learning Path of id " + id + " could not be found")
        );

        return new LearningPathPayload(
                learningPath.getId(),
                learningPath.getTitle(),
                learningPath.getDescription(),
                learningPath.getPicUrl()
        );
    }
}
