import HomeHero from "../../components/HomeHero/HomeHero";
import HomeCardContainer from "../../components/HomeCardContainer/HomeCardContainer";
import CardOverview from "../../components/CardOverview/CardOverview";

function Home() {
  return (
    <div className="home-page">
        <HomeHero 
            heroTypeClass="hero"
            heroBgColor1="from-indigo-800"
            heroBgColor2="to-indigo-600"
            title="Welcome to Apollo-Tech School"
            content="Empowering your tech career with expert-led courses."
            btnText="Choose Your Membership Plan"
            btnBgColor1="bg-purple-600"
            btnBgHoverColor="bg-purple-500"
        />
        {/** Courses Card Container */}
        <HomeCardContainer 
            childTypeClass="courses" 
            bgColorClass="bg-gray-900"
            containerTtile="Popular Courses"
            containerTitleColorClass="text-gray-300"
            >
                <CardOverview
                    cardTypeClass="course-card"
                    bgColorClass="bg-gray-800"
                    imgSource="https://res.cloudinary.com/dwtfvqcwv/image/upload/v1737323744/Apollo-Tech-School/Java-For-Beginners.webp"
                    imgAlt="Java For Beginners Course"
                    cardTitle="Java For Beginners"
                    cardDescription="Learn the basics of the Java programming language, its syntax, data types, and object-oriented concepts as the cornerstone to build applications."
                    detailsLink="/course/1"
                    courseLevel="beginner"
                />
                <CardOverview
                    cardTypeClass="course-card"
                    bgColorClass="bg-gray-800"
                    imgSource="https://res.cloudinary.com/dwtfvqcwv/image/upload/v1737323766/Apollo-Tech-School/Pandas-And-Matplotlib.jpg"
                    imgAlt="Pandas And Matplotlib Course"
                    cardTitle="Pandas And Matplotlib"
                    cardDescription="Learn how to manipulate data and process it with Pandas.Then, learn how to visualize it to extract insights with Matplotlib."
                    detailsLink="/course/2"
                    courseLevel="intermediate"
                />
                <CardOverview
                    cardTypeClass="course-card"
                    bgColorClass="bg-gray-800"
                    imgSource="https://res.cloudinary.com/dwtfvqcwv/image/upload/v1737323972/Apollo-Tech-School/OWASP.png"
                    imgAlt="OWASP Web App Vulnerabilities Course"
                    cardTitle="OWASP Web App Vulnerabilities"
                    cardDescription="Websites could have vulnerabilities that are easily exploited by cybercriminals. Learn how websites are vulnerable to protect yours."
                    detailsLink="/course/3"
                    courseLevel="intermediate"
                />
                <CardOverview
                    cardTypeClass="course-card"
                    bgColorClass="bg-gray-800"
                    imgSource="https://res.cloudinary.com/dwtfvqcwv/image/upload/v1737323474/Apollo-Tech-School/lkhbeik8fnnocmxkastb.webp"
                    imgAlt="Docker Containerization and Deployment Course"
                    cardTitle="Docker Containerization and Deployment Course"
                    cardDescription="Get to know what Docker is, what it is used for and get hands-on practice by using it to deploy a real-world software project."
                    detailsLink="/course/4"
                    courseLevel="advanced"
                />
        </HomeCardContainer>

        {/** Course Packets Card Container */}
        <HomeCardContainer
            childTypeClass="course-packets"
            bgColorClass="bg-gray-800"
            containerTtile="Popular Course Packets"
            containerTitleColorClass="text-gray-200"
        >
            <CardOverview
                cardTypeClass="packet-card"
                bgColorClass="bg-gray-700"
                imgSource="https://res.cloudinary.com/dwtfvqcwv/image/upload/v1737326088/Apollo-Tech-School/Java-Android.png"
                imgAlt="The Java Mobile Development Course Packet"
                cardTitle="The Java Mobile Development Course Packet"
                cardDescription="Learn how to use the Java Programming Language to build full-stack mobile Android applications."
                detailsLink="/packet/1"
            />
            <CardOverview
                cardTypeClass="packet-card"
                bgColorClass="bg-gray-700"
                imgSource="https://res.cloudinary.com/dwtfvqcwv/image/upload/v1737326112/Apollo-Tech-School/SQL-Management.png"
                imgAlt="The Database Management and SQL Course Packet"
                cardTitle="The Database Management and SQL Course Packet"
                cardDescription="Learn how to design, query, and maintain databases using SQL relational databases, and learn best practices in data management."
                detailsLink="/packet/2"
            />
            <CardOverview
                cardTypeClass="packet-card"
                bgColorClass="bg-gray-700"
                imgSource="https://res.cloudinary.com/dwtfvqcwv/image/upload/v1737326183/Apollo-Tech-School/UI-UX.png"
                imgAlt="The UI/UX for Developers Course Packet"
                cardTitle="The UI/UX for Developers Course Packet"
                cardDescription="Learn how designers think by improving your skills in user interface UI and user experience UX design."
                detailsLink="/packet/3"
            />
            <CardOverview
                cardTypeClass="packet-card"
                bgColorClass="bg-gray-700"
                imgSource="https://res.cloudinary.com/dwtfvqcwv/image/upload/v1737323438/Apollo-Tech-School/AI.jpg"
                imgAlt="The Machine Learning and AI Course Packet"
                cardTitle="The Machine Learning and AI Course Packet"
                cardDescription="Learn how to use machine learning and artificial intelligence by covering algorithms, models, and applications to create AI smart applications."
                detailsLink="/packet/4"
            />
        </HomeCardContainer>

        {/** Learning Paths Card Container */}
        <HomeCardContainer
            childTypeClass="learning-paths"
            bgColorClass="bg-gray-900"
            containerTtile="Popular Learning Paths"
            containerTitleColorClass="text-gray-100"
        >
            <CardOverview
                cardTypeClass="path-card"
                bgColorClass="bg-blue-800"
                imgSource="https://res.cloudinary.com/dwtfvqcwv/image/upload/v1737323564/Apollo-Tech-School/Full-Stack-Developer.webp"
                imgAlt="Full-Stack Web Development Learning Path"
                cardTitle="Full-Stack Web Development Learning Path"
                cardDescription="Become a professional building the front-end and back-end sides of web applications."
                detailsLink="/path/1"
            />
            <CardOverview
                cardTypeClass="path-card"
                bgColorClass="bg-blue-800"
                imgSource="https://res.cloudinary.com/dwtfvqcwv/image/upload/v1737323474/Apollo-Tech-School/miwmpjvez8jgwvl2mpvg.avif"
                imgAlt="Cybersecurity and Ethical Hacking Learning Path"
                cardTitle="Cybersecurity and Ethical Hacking Learning Path"
                cardDescription="Go zero to hero from the fundamentals of cybersecurity to full-on pentesting digital systems."
                detailsLink="/path/2"
            />
            <CardOverview
                cardTypeClass="path-card"
                bgColorClass="bg-blue-800"
                imgSource="https://res.cloudinary.com/dwtfvqcwv/image/upload/v1737327747/Apollo-Tech-School/Software-Testing.jpg"
                imgAlt="Software Testing and Quality Assurance Learning Path"
                cardTitle="Software Testing and Quality Assurance Learning Path"
                cardDescription="Become a job-ready software tester by diving into the several sorts of software testing techniques."
                detailsLink="/path/3"
            />
            <CardOverview
                cardTypeClass="path-card"
                bgColorClass="bg-blue-800"
                imgSource="https://res.cloudinary.com/dwtfvqcwv/image/upload/v1737327832/Apollo-Tech-School/Network-Engineer.jpg"
                imgAlt="Network Engineer Learning Path"
                cardTitle="Network Engineer Learning Path"
                cardDescription="Become a professional network enginner in order to design, implement, and maintain reliable and secure computer networks."
                detailsLink="/path/4"
            />
        </HomeCardContainer>
        <HomeHero
            heroTypeClass="membership"
            heroBgColor1="from-purple-800"
            heroBgColor2="to-purple-600"
            btnBgColor1="bg-yellow-500"
            btnBgHoverColor="btn-yellow-400"
            btnColor="text-black"
            title="Ready to Start Learning?"
            content="Choose a membership plan that suits your needs."
            btnText="Explore Membership Plans"
        />
    </div>
  )
}

export default Home;
