package com.apollotechschool.ApolloTechSchool.services.impl;

/* CoursePacketServiceImpl
 * CoursePacket Service Implementation
 * Establish Business Logic on DB interactions related to the CoursePacket Entity
 * */

import com.apollotechschool.ApolloTechSchool.entities.CoursePacket;
import com.apollotechschool.ApolloTechSchool.exceptions.EntityNotFoundException;
import com.apollotechschool.ApolloTechSchool.payloads.CoursePacketPayload;
import com.apollotechschool.ApolloTechSchool.repositories.CoursePacketRepository;
import com.apollotechschool.ApolloTechSchool.services.CoursePacketService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CoursePacketServiceImpl implements CoursePacketService
{
    public CoursePacketRepository coursePacketRepository;

    public CoursePacketServiceImpl(CoursePacketRepository coursePacketRepository)
    {
        this.coursePacketRepository = coursePacketRepository;
    }

    @Override
    public List<CoursePacketPayload> getAllCoursePackets()
    {
        List<CoursePacket> coursePackets = coursePacketRepository.findAll();
        List<CoursePacketPayload> coursePacketPayloads = new ArrayList<CoursePacketPayload>();

        for (CoursePacket coursePacket : coursePackets)
        {
            coursePacketPayloads.add(new CoursePacketPayload(
                    coursePacket.getId(),
                    coursePacket.getTitle(),
                    coursePacket.getDescription(),
                    coursePacket.getPicUrl()
            ));
        }

        return coursePacketPayloads;
    }

    @Override
    public CoursePacketPayload getCoursePacketById(Long id)
    {
        CoursePacket coursePacket = coursePacketRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Course Packet of id " + id + " could not be found")
        );

        return new CoursePacketPayload(
                coursePacket.getId(),
                coursePacket.getTitle(),
                coursePacket.getDescription(),
                coursePacket.getPicUrl()
        );
    }
}
