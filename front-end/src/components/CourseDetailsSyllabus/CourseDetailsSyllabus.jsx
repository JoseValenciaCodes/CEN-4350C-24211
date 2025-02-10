/** Course Details Syllabus */


// eslint-disable-next-line react/prop-types
function CourseDetailsSyllabus({ children }) {
    return (
        <div className="mb-12">
            <h2 className="text-3xl font-semibold text-white">Course Syllabus</h2>
            {children}
        </div>
    );
}

export default CourseDetailsSyllabus;
