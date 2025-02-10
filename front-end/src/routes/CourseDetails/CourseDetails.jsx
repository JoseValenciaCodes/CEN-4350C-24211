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
import { Link } from "react-router-dom";

function CourseDetails() {
  return (
    <div className="course-details bg-gray-800 py-16">
      <div className="container mx-auto px-6">
        <CourseDetailsHero
            courseName="OWASP Web App Vulnerabilities"
            courseRating="4.9"
            courseNumReviews="80"
            imgSource="https://res.cloudinary.com/dwtfvqcwv/image/upload/v1737323972/Apollo-Tech-School/OWASP.png"
            imgAlt="OWASP Web App Vulnerabilities"
            coursePrice="149"
        />
        <CourseDetailsOverview
            courseDescription="Websites could have vulnerabilities that are easily exploited by cybercriminals. Learn how websites are vulnerable to protect yours."
            courseDuration="16"
            courseLevel="Intermediate"
        />
        <CourseDetailsSyllabus>
          <CourseDetailsSyllabusModule
            collapseId="module1"
            moduleTitle="Module 1: Introduction to Web Application Security"
            moduleDescription="Overview the basics of security principles applied on the web and the most important OWASP web vulnerabilities."
          />
          <CourseDetailsSyllabusModule
            collapseId="module2"
            moduleTitle="Module 2: SQL Injection"
            moduleDescription="Learn what SQL injection attacks are, how they work, practice them, and learn how to avoid them in your applications."
          />
          <CourseDetailsSyllabusModule 
            collapseId="module3"
            moduleTitle="Module 3: Cross-Site Scripting (XSS)"
            moduleDescription="Learn what XSS attacks are, how dangerous they are, how hackers use them, and how to protect your systems against them."
          />
          <CourseDetailsSyllabusModule 
            collapseId="module4"
            moduleTitle="Module 4: Cross-Site Request Forgery (CSRF)"
            moduleDescription="Learn through interactive examples and exercises what CSRF examples are and then learn how to avoid them."
          />
          <CourseDetailsSyllabusModule
            collapseId="module5"
            moduleTitle="Module 5: Security Misconfigurations"
            moduleDescription="Learn the most common and critical security misconfigurations in today's web applications and how to fix them."
          />
          <CourseDetailsSyllabusModule
            collapseId="module6"
            moduleTitle="Module 6: Securing APIs and Web Services"
            moduleDescription="Understand how to appropiately integrate external web services in your applications."
          />
        </CourseDetailsSyllabus>
        <CourseDetailsSkills>
          <CourseDetailsSkill
            skill="Identify and protect against common web application vulnerabilities"
          />
          <CourseDetailsSkill
            skill="Defensive coding strategies to prevent SQL Injection"
          />
          <CourseDetailsSkill
            skill="How to securely integrate APIs and web services"
          />
          <CourseDetailsSkill
            skill="Security best practices for web applications"
          />
        </CourseDetailsSkills>
        <CourseRequirements>
          <CourseRequirement
            requirement="Basic web development skills (HTML, CSS, JavaScript)"
          />
          <CourseRequirement
            requirement="Access to a computer with a modern web browser"
          />
          <CourseRequirement 
            requirement="Reliable internet access to download resources and follow along"
          />
          <CourseRequirement
            requirement="Willingness to learn about cybersecurity and improve your skills"
          />
        </CourseRequirements>
        <StudentReviews>
          <StudentReview 
            studentRating="4.5"
            imgSource="https://cdn-icons-png.flaticon.com/512/149/149071.png"
            imgAlt="Student Profile"
            studentName="Juan Brito"
            studentProfession="Full-Stack Web Developer"
            studentReview="Thanks to this course I learnt to analyze the web projects I participate in to make sure they are secure! It's a must for every web developer."
          />
          <StudentReview 
            studentRating="5.0"
            imgSource="https://cdn-icons-png.flaticon.com/512/149/149071.png"
            imgAlt="Student Profile"
            studentName="Charles Benson"
            studentProfession="Cybersecurity Analyst"
            studentReview="I had focused before on securing system's software and networks but totally overlooked web application security until I took this course. Now I know I need to look more on analyzing web applications."
          />
          <StudentReview 
            studentRating="5.0"
            imgSource="https://cdn-icons-png.flaticon.com/512/149/149071.png"
            imgAlt="Student Profile"
            studentName="Vicente Torrente"
            studentProfession="College Student"
            studentReview="I'm just a freshman college student in the cybersecurity field so right now I'm stuck in the general education requirements. This course has given me a glance of the technical aspects of cybersecurity in web applications!"
          />
        </StudentReviews>

        <div className="text-center">
          <Link to="/login" className="bg-blue-600 text-white py-3 px-8 rounded-lg">Enroll Now</Link>
        </div>

      </div>
    </div>
  )
}

export default CourseDetails;
