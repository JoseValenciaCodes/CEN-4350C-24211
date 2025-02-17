import LearningCardOverview from "../../../components/LearningCardOverview/LearningCardOverview";

function MyLearning() {
  return (
    <div className="p-6 bg-slate-900 text-white">
      <h1 className="text-3xl font-bold mb-6">My Learning</h1>
      
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-2 gap-6">
        {/* Courses */}
        <LearningCardOverview
          imgSource="https://res.cloudinary.com/dwtfvqcwv/image/upload/v1737323744/Apollo-Tech-School/Java-For-Beginners.webp"
          imgAlt="Java For Beginners Course"
          cardTitle="Java For Beginners"
          cardDescription="Learn the basics of Java programming."
          detailsLink="/course/1"
          progress={45}
        />
        
        <LearningCardOverview
          imgSource="https://res.cloudinary.com/dwtfvqcwv/image/upload/v1737323766/Apollo-Tech-School/Pandas-And-Matplotlib.jpg"
          imgAlt="Pandas And Matplotlib Course"
          cardTitle="Pandas And Matplotlib"
          cardDescription="Learn data manipulation and visualization."
          detailsLink="/course/2"
          progress={60}
        />
        
        {/* Course Packet */}
        <LearningCardOverview
          imgSource="https://res.cloudinary.com/dwtfvqcwv/image/upload/v1737326088/Apollo-Tech-School/Java-Android.png"
          imgAlt="Java Mobile Development Packet"
          cardTitle="Java Mobile Development Packet"
          cardDescription="Learn Java for Android mobile applications."
          detailsLink="/packet/1"
          progress={30}
        />
        
        {/* Learning Path */}
        <LearningCardOverview
          imgSource="https://res.cloudinary.com/dwtfvqcwv/image/upload/v1737323564/Apollo-Tech-School/Full-Stack-Developer.webp"
          imgAlt="Full-Stack Web Development Path"
          cardTitle="Full-Stack Web Development Path"
          cardDescription="Become a professional full-stack developer."
          detailsLink="/path/1"
          progress={75}
        />
      </div>
    </div>
  );
}

export default MyLearning;