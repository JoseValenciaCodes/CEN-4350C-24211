/** Page to View Details of each Course */

import CourseDetailsHero from "../../components/CourseDetailsHero/CourseDetailsHero";
import CourseDetailsOverview from "../../components/CourseDetailsOverview/CourseDetailsOverview";
import CourseDetailsSkills from "../../components/CourseDetailsSkills/CourseDetailsSkills";
import CourseDetailsSkill from "../../components/CourseDetailsSkill/CourseDetailSkill";
import CourseDetailsSyllabus from "../../components/CourseDetailsSyllabus/CourseDetailsSyllabus";
import CourseDetailsSyllabusModule from "../../components/CourseDetailsSyllabusModule/CourseDetailsSyllabusModule";
import CourseRequirements from "../../components/CourseRequirements/CourseRequirements";
import CourseRequirement from "../../components/CourseRequirement/CourseRequirement";
import StudentReviews from "../../components/StudentsReview/StudentsReview";
import StudentReview from "../../components/StudentReview/StudentReview";
import { useParams, useNavigate } from "react-router-dom";

// Use Hooks
import { useState, useEffect, useContext } from "react";
import { UserContext } from "../../context/UserContext";
import baseClient from "../../api/baseClient";

function CourseDetails() {

  const { courseId } = useParams();

  const { user } = useContext(UserContext);
  const navigate = useNavigate();
  const [isUserEnrolled, setIsUserEnrolled] = useState(false);

  const [course, setCourse] = useState(null);
  const [courseLoading, setCourseLoading] = useState(true);
  const [courseError, setCourseError] = useState(null);

  const [courseModules, setCourseModules] = useState(null);
  const [courseModulesLoading, setCourseModulesLoading] = useState(true);
  const [courseModulesError, setCourseModulesError] = useState(null);

  const [courseSkills, setCourseSkills] = useState(null);
  const [courseSkillsLoading, setCourseSkillsLoading] = useState(true);
  const [courseSkillsError, setCourseSkillsError] = useState(null);

  const [courseRequirements, setCourseRequirements] = useState(null);
  const [courseRequirementsLoading, setCourseRequirementsLoading] = useState(true);
  const [courseRequirementsError, setCourseRequirementsError] = useState(null);

  const [courseReviews, setCourseReviews] = useState(null);
  const [courseReviewsLoading, setCourseReviewsLoading] = useState(true);
  const [courseReviewsError, setCourseReviewsError] = useState(null);

      // Run to enroll to course
    const enrollToCourse = async () => {
        await baseClient.post(`/courses/enroll?userId=${user.id}&courseId=${courseId}`);
        navigate("/dashboard/mylearning");
    };

    // Run to un-enroll from course
    const unenrollFromCourse = async () => {
      await baseClient.delete(`/courses/un-enroll?userId=${user.id}&courseId=${courseId}`);
      navigate("/dashboard/mylearning");
    };

  useEffect(() => {
    const fetchCourse = async () => {
      try
      {
        const res = await baseClient.get(`/courses/${courseId}`);
        setCourse(res.data);
      }
      catch (err)
      {
        setCourseError(err.error);
      }
      finally
      {
        setCourseLoading(false);
      }
    };

    const fetchCourseModules = async () => {
      try
      {
        const res = await baseClient.get(`/course-modules/${courseId}`);
        setCourseModules(res.data);
      }
      catch (err)
      {
        setCourseModulesError(err.error);
      }
      finally
      {
        setCourseModulesLoading(false);
      }
    };

    const fetchCourseSkills = async () => {
      try
      {
        const res = await baseClient.get(`/course-skills/${courseId}`);
        setCourseSkills(res.data);
      }
      catch (err)
      {
        setCourseSkillsError(err.error);
      }
      finally
      {
        setCourseSkillsLoading(false);
      }
    };

    const fetchCourseRequirements = async () => {
      try
      {
        const res = await baseClient.get(`/course-requirements/${courseId}`);
        setCourseRequirements(res.data);
      }
      catch (err)
      {
        setCourseRequirementsError(err.error);
      }
      finally
      {
        setCourseRequirementsLoading(false);
      }
    };

    const fetchCourseReviews = async () => {
      try
      {
        const res = await baseClient.get(`/course-reviews/${courseId}`);
        setCourseReviews(res.data);
      }
      catch (err)
      {
        setCourseReviewsError(err.error);
      }
      finally
      {
        setCourseReviewsLoading(false);
      }
    };

    // get if the user is enrolled in this course or not
    const isUserEnrolledInThisCourse = async () => {
      try
      {
        const res = await baseClient.get(`/courses/getEnrolledCourse?userId=${user.id}&courseId=${courseId}`);
        if (res.data.id == courseId)
        {
          setIsUserEnrolled(true);
        }
      }

      catch (err)
      {
        setIsUserEnrolled(false);
      }
    };

    fetchCourse();
    fetchCourseModules();
    fetchCourseSkills();
    fetchCourseRequirements();
    fetchCourseReviews();
    isUserEnrolledInThisCourse();
  }, [courseId]);

  return (
    <div className="course-details bg-gray-800 py-16">
      <div className="container mx-auto px-6">
        {
          (courseLoading) ? <p>Loading...</p>
          :((courseError) ? <p>Error: {courseError}</p>: (
            <>
                <CourseDetailsHero
                  courseName={course.title}
                  imgSource={course.picUrl}
                  imgAlt={course.description}
                  coursePrice="25"
                />
                <CourseDetailsOverview
                    courseDescription={course.description}
                    courseLevel={course.level}
                />
            </>
          ))
        }
        <CourseDetailsSyllabus>
          {
            (courseModulesLoading) ? <p>Loading ...</p>
            :((courseModulesError) ? <p>Error: {courseModulesError}</p>:
              (
                courseModules.map((courseModule, i) => (
                      <CourseDetailsSyllabusModule
                        key={courseModule.id}
                        collapseId={`module${courseModule.id}`}
                        moduleTitle={`Module ${i + 1}: ${courseModule.title}`}
                        moduleDescription={courseModule.description}
                      />
                ))
              )
            )
          }
        </CourseDetailsSyllabus>
        <CourseDetailsSkills>
          {
            (courseSkillsLoading) ? <p>Loading ...</p>
            :((courseSkillsError) ? <p>Error: {courseSkillsError}</p>
            : (
                courseSkills.map(courseSkill => (
                  <CourseDetailsSkill
                  key={courseSkill.id}
                  skill={courseSkill.skill}
                />
                ))
              )
            )
          }
        </CourseDetailsSkills>
        <CourseRequirements>
          {
            (courseRequirementsLoading) ? <p>Loading ...</p>
            :((courseRequirementsError) ? <p>Error: {courseRequirementsError}</p>
            : (
              courseRequirements.map(courseRequirement => (
                        <CourseRequirement
                          key={courseRequirement.id}
                          requirement={courseRequirement.requirement}
                      />
              ))
            ))
          }
        </CourseRequirements>
        <StudentReviews>
          {
            (courseReviewsLoading) ? <p>Loading ...</p>
            : ((courseReviewsError) ? <p>Error: {courseReviewsError}</p>
            : (
                courseReviews.map(courseReview => (
                    <StudentReview
                    key={courseReview.id} 
                    imgSource={courseReview.picUrl}
                    imgAlt={courseReview.description}
                    studentName={courseReview.name}
                    studentProfession={courseReview.occupation}
                    studentReview={courseReview.description}
                  />
                ))
              )
            )
          }
        </StudentReviews>

        <div className="text-center">
          {
            isUserEnrolled ? <button className="bg-red-600 text-white py-3 px-8 rounded-lg" onClick={unenrollFromCourse}>Un-Enroll Now</button>
            : <button className="bg-blue-600 text-white py-3 px-8 rounded-lg" onClick={enrollToCourse}>Enroll Now</button>
          }
        </div>

      </div>
    </div>
  )
}

export default CourseDetails;
