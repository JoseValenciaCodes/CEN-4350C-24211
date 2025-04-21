/** Membership Card React UI Component
 * Represents a membership card and displays the data it has
 */
import { Link, useNavigate } from "react-router-dom";
import { useContext } from "react";
import { UserContext } from "../../context/UserContext";
import baseClient from "../../api/baseClient";

// eslint-disable-next-line react/prop-types
function MembershipCard({ id, title, description, price, showLink=true, selected=false }) {

    const { user } = useContext(UserContext);
    const navigate = useNavigate();

    const addUserToMembershipOnClick = () => {
        // Make payload with this membership id and user id
        const addPayload = {
            membershipId: id,
            userId: user.id
        };

        const addPayloadRequest = async () => {
            await baseClient.delete("/memberships", {
                data: addPayload
            });
            await baseClient.post("/memberships", addPayload);
            navigate("/dashboard/settings");
        };

        addPayloadRequest();
    };

    const deleteUserFromMembershipOnClick = () => {
        // Make payload with this membership id and user id
        const deletePayload = {
            membershipId: id,
            userId: user.id
        };

        const deletePayloadRequest = async () => {
            await baseClient.delete("/memberships", {
                data: deletePayload
            });
            navigate("/dashboard/settings");
        };

        deletePayloadRequest();
    };

    return (
        <div className="membership-card bg-gray-800 border-2 border-yellow-500 p-6 rounded-lg shadow-lg text-center w-72">
            <h3 className="text-2xl font-semibold mb-4 text-yellow-200">{title}</h3>
            <p className="text-xl text-yellow-300 mb-4">{description}</p>
            <div className="text-3xl font-bold text-yellow-400 mb-4">${price}</div>

            {showLink && !selected && user.id == undefined && (
                <Link className="btn-secondary bg-blue-600 text-white py-2 px-4 rounded-lg hover:bg-blue-700 transition duration-300" to={"/login"}>Join Now</Link>
            )}

            {
                showLink && !selected && user.id !== undefined && (
                    <button className="btn-secondary bg-blue-600 text-white py-2 px-4 rounded-lg hover:bg-blue-700 transition duration-300" onClick={addUserToMembershipOnClick}>Enroll</button>
                )
            }

            {
                showLink && selected && (
                    <button className="btn-secondary bg-red-600 hover:bg-red-700 text-white py-2 px-4 rounded-lg transition duration-300" onClick={deleteUserFromMembershipOnClick}>Un-Enroll</button>
                )
            }
        </div>
    );
}

export default MembershipCard;
