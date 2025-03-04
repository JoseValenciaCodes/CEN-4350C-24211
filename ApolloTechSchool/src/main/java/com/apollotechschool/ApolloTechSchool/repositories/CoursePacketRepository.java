package com.apollotechschool.ApolloTechSchool.repositories;

import com.apollotechschool.ApolloTechSchool.entities.CoursePacket;
import org.springframework.data.jpa.repository.JpaRepository;

/* CoursePacketRepository
 *  Handle DB Transactions on the CoursePacket Entity
 * */
public interface CoursePacketRepository extends JpaRepository<CoursePacket, Long>
{
}
