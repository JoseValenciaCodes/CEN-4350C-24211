/** Component that represents the about webpage */
import AboutFeaturedCard from "../../components/AboutFeaturedCard/AboutFeaturedCard";
import AboutFeaturedCardsContaner from "../../components/AboutFeaturedCardsContainer/AboutFeaturedCardsContaner";
import AboutHero from "../../components/AboutHero/AboutHero";
import AboutSummaryCardsContainer from "../../components/AboutSummaryCardsContainer/AboutSummaryCardsContainer";
import AboutTestimonialCard from "../../components/AboutTestimonialCard/AboutTestimonialCard";
import AboutTestimonailsContainer from "../../components/AboutTestimonialsContainer/AboutTestimonailsContainer";
import SummaryCard from "../../components/SummaryCard/SummaryCard";

function About()
{
    return (
        <div className="bg-gray-900 text-white font-poppins">
            <AboutHero
                title="Unleash your passion for the Information Technology Industry!"
                subtitle="At Apollo Tech School, we know you&apos;re bored of the traditional classroom. So here you&apos;ll learn by solving practical problems right away."
                linkHref="/courses"
                linkText="Browse Our Content"
            />
            {/**Summary Cards */}
            <AboutSummaryCardsContainer>
                <SummaryCard
                    faIconName="faChalkboardTeacher"
                    title="Expertise Guaranteed"
                    content="Our instructors are not only expers in their fields. They are also experts at teaching you."
                />
                <SummaryCard
                    faIconName="faClock"
                    title="Flexible Schedule"
                    content="We know life gets busy. So we made it so you can access your courses at any time 24/7"
                />
                <SummaryCard 
                    faIconName="faCertificate"
                    title="Certifications"
                    content="Celebrate your newly acquired skills with our certifications and show the world you're the real deal."
                />
                <SummaryCard
                    faIconName="faTools"
                    title="Real-World Projects"
                    content="You'll learn by doing to tackle the complex challenges that belong to the IT industry."
                />
            </AboutSummaryCardsContainer>

            {/** Featured Cards Section */}
            <AboutFeaturedCardsContaner>
                <AboutFeaturedCard
                    title="Beginner Friendly"
                    content="We'll take your hand and guide you through examples and exercises through the content so you go from zero-to-hero."
                />
                <AboutFeaturedCard
                    title="Lifetime Access"
                    content="Once you buy one of our courses, it's yours forever. If you subscribe to a membership later on and cancel it you won't lose it."
                />
                <AboutFeaturedCard 
                    title="Career Guidance"
                    content="Our Course Packets and Learning Paths guide you to what you need to learn to become a certain IT professional."
                />
                <AboutFeaturedCard
                    title="Up-to-Date Content"
                    content="Since the IT industry is constantly changing. We're always updating our content so you stay up-to-date."
                />
            </AboutFeaturedCardsContaner>

            {/** TestimonialCard */}
            <AboutTestimonailsContainer>
                <AboutTestimonialCard
                    userRating="5.0"
                    studentName="Ben Charleson"
                    studentCareer="Systems Programmer"
                    studentPicSrc="https://cdn-icons-png.flaticon.com/512/149/149071.png"
                    studentReview='"I wish I had starter to learn about IT here."'
                />
                <AboutTestimonialCard
                    userRating="4.5"
                    studentName="Jose Garcia"
                    studentCareer="Android Developer"
                    studentPicSrc="https://cdn-icons-png.flaticon.com/512/149/149071.png"
                    studentReview='"I now know how to build Android apps in Java and Kotlin thanks to this platform."'
                />
                <AboutTestimonialCard 
                    userRating="4.7"
                    studentName="Juan Gabriel"
                    studentCareer="Data Analyst"
                    studentPicSrc="https://cdn-icons-png.flaticon.com/512/149/149071.png"
                    studentReview='"There is no other platform that allows me to upgrade my skills like this."'
                />
            </AboutTestimonailsContainer>

            {/** Last About Hero */}
            <AboutHero 
                title="Ready to Start Your Tech Journey?"
                linkText="Join Us Today"
                linkHref="/register"
            />
        </div>
    );
}

export default About;