/** Course Requirement Card */
import YellowReq from "../YellowReq/YellowReq";

// eslint-disable-next-line react/prop-types
function CourseRequirement({ requirement }) {
    return (
        <div className="flex items-center space-x-4">
            <YellowReq />
            <p className="text-gray-300">{requirement}</p>
        </div>
    );
}

export default CourseRequirement;
