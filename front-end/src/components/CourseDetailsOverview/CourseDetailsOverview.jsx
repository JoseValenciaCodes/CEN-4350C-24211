/** Course Details Overview */

// eslint-disable-next-line react/prop-types
function CourseDetailsOverview({ courseDescription, courseDuration, courseLevel }) {
    return (
        <div className="mb-12">
            <h2 className="text-3xl font-semibold text-white">Course Overview</h2>
            <p className="text-lg text-gray-300 mt-4">{courseDescription}</p>
            <div className="mt-4">
                <span className="text-gray-400">Duration: <span className="badge badge-info relative bottom-0 left-2 text-white text-sm font-semibold mr-2">{courseDuration} hours</span></span>  |
                <span className="text-gray-400">Level: <span className="badge badge-warning relative bottom-0 left-2 text-white text-sm font-semibold">{courseLevel}</span></span>
            </div>
        </div>
    );
}

export default CourseDetailsOverview;
