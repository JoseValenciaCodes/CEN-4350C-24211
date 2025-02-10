/** Hero of Course Details
 * Includes Title, Review, and Call To Action
 */
import { Link } from "react-router-dom";

// eslint-disable-next-line react/prop-types
function CourseDetailsHero({ courseName, courseRating, courseNumReviews, imgSource, imgAlt, coursePrice }) {
    return (
        <div className="text-center mb-8">
            <h1 className="text-4xl font-semibold text-white">{courseName}</h1>
            <p className="text-lg text-gray-400 mt-2">
                <span className="text-yellow-400">{courseRating}</span>
                <span className="mr-2 ml-2">| {courseNumReviews} reviews</span>
            </p>
            <div className="mt-6">
                <img src={imgSource} alt={imgAlt} className="mx-auto rounded-lg shadow-lg"/>
            </div>
            <div className="text-5xl font-bold text-white mt-6">
                ${coursePrice}
            </div>
            <Link to="/login" className="bg-blue-600 text-white py-3 px-8 rounded-lg mt-6 inline-block">Enroll Now</Link>
        </div>
    );
}

export default CourseDetailsHero;
