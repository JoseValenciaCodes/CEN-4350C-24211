/** Course Requirements Page */

// eslint-disable-next-line react/prop-types
function CourseRequirements({ children }) {
    return (
        <div className="mb-12">
            <h2 className="text-3xl font-semibold text-white">Course Requirements</h2>
            <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 gap-6 mt-6">
                {children}
            </div>
        </div>
    );
}

export default CourseRequirements;
