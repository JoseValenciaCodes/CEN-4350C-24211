/** A particular skill outlined in course details section */

import GreenTick from "../GreenTick/GreenTick";

// eslint-disable-next-line react/prop-types
function CourseDetailSkill({ skill }) {
    return (
        <div className="flex items-center space-x-4">
            <GreenTick />
            <p className="text-gray-300">{skill}</p>
        </div>
    );
}

export default CourseDetailSkill;
