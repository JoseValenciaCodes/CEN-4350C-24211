/** Membership Card React UI Component
 * Represents a membership card and displays the data it has
 */
import { Link } from "react-router-dom";

// eslint-disable-next-line react/prop-types
function MembershipCard({ title, description, price }) {
    return (
        <div className="membership-card bg-gray-800 border-2 border-yellow-500 p-6 rounded-lg shadow-lg text-center w-72">
            <h3 className="text-2xl font-semibold mb-4 text-yellow-200">{title}</h3>
            <p className="text-xl text-yellow-300 mb-4">{description}</p>
            <div className="text-3xl font-bold text-yellow-400 mb-4">${price}</div>
            <Link className="btn-secondary bg-blue-600 text-white py-2 px-4 rounded-lg hover:bg-blue-700 transition duration-300" to="/login">Join Now</Link>
        </div>
    );
}

export default MembershipCard;
