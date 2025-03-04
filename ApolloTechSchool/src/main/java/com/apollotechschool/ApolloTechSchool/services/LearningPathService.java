package com.apollotechschool.ApolloTechSchool.services;

import com.apollotechschool.ApolloTechSchool.payloads.LearningPathPayload;

import java.util.List;

/* LearningPathService
 * Contract to establish the methods of the LearningPath Service Implementation
 * What the service does, what it returns, and the expected inputs are all managed from here
 * */
public interface LearningPathService
{
    List<LearningPathPayload> getAllLearningPaths();
    LearningPathPayload getLearningPathById(Long id);
}
