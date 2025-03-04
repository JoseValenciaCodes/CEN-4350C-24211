package com.apollotechschool.ApolloTechSchool.services;

/* CoursePacketService
 * Contract to establish the methods of the CoursePacket Service Implementation
 * What the service does, what it returns, and the expected inputs are all managed from here
 * */

import com.apollotechschool.ApolloTechSchool.payloads.CoursePacketPayload;

import java.util.List;

public interface CoursePacketService
{
    List<CoursePacketPayload> getAllCoursePackets();
    CoursePacketPayload getCoursePacketById(Long id);
}
