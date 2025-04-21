/** Component for Profile Settings Page */
import { useState, useEffect, useContext } from "react";
import baseClient from "../../../api/baseClient";
import { UserContext } from "../../../context/UserContext";
import MembershipCard from "../../../components/MembershipCard/MembershipCard";
import { Link, useNavigate } from "react-router-dom";

function ProfileSettings()
{
    // Grab the user
    const { user, setUser } = useContext(UserContext);

    const navigate = useNavigate();

    // Grab the user id
    const userId = user.id;

    // Check if the user has a membership first
    const [userMembership, setUserMembership] = useState(null);
    const [loading, setLoading] = useState(true);

    const [firstName, setFirstName] = useState(user.firstName);
    const [lastName, setLastName] = useState(user.lastName);
    const [email, setEmail] = useState(user.email);
    const [password, setPassword] = useState("");
    const [errorMessage, setErrorMessage] = useState("");

    useEffect(() => {
        // Perform GET Request to get user membership
        const fetchUserMembership = async () => {
            try
            {
                const res = await baseClient.get(`/memberships/user/${userId}`);
                setUserMembership(res.data);
            }
            catch (err)
            {
                setUserMembership(null);
            }
            finally
            {
                setLoading(false);
            }
        };

        fetchUserMembership();
    }, []);

    // Submit request to update user data
    const handleUserUpdateSubmit = async e => {
        e.preventDefault();
        setErrorMessage("");

        // Build payload to update data
        const updateUserPayload = {
            id: user.id,
            firstName,
            lastName,
            email,
            password,
            jwtToken: user.jwtToken
        };

        try
        {
            const res = await baseClient.put("/user", updateUserPayload);
            setUser(res.data);
            navigate("/dashboard/mylearning");
        }

        catch (err)
        {
            setErrorMessage(err.error || "An error occurred while updating the user");
        }
    };

    return (
        <div className="p-6 bg-slate-900 text-white min-h-screen">
            <h1 className="text-3xl font-bold mb-6">Account Settings</h1>

            {/*User Settings */}
            <div className="bg-slate-800 p-6 rounded-2xl shadow-md mb-10">
                <h2 className="text-2xl font-semibold mb-4">Update Profile</h2>
                <form className="grid grid-cols-1 md:grid-cols-2 gap-6">
                    <div>
                        <label className="block mb-1 font-medium">First Name</label>
                        <input
                            type="text"
                            className="w-full px-4 py-2 bg-slate-700 text-white rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
                            value={firstName}
                            onChange={e => setFirstName(e.target.value)}
                        />
                    </div>
                    <div>
                        <label className="block mb-1 font-medium">Last Name</label>
                        <input
                            type="text"
                            className="w-full px-4 py-2 bg-slate-700 text-white rounded-md"
                            value={lastName}
                            onChange={e => setLastName(e.target.value)}
                        />
                    </div>
                    <div>
                        <label className="block mb-1 font-medium">Email</label>
                        <input
                        type="email"
                        className="w-full px-4 py-2 bg-slate-700 text-white rounded-md"
                        value={email}
                        onChange={e => setEmail(e.target.value)}
                        />
                    </div>
                    <div>
                        <label className="block mb-1 font-medium">New Password</label>
                        <input
                            type="password"
                            className="w-full px-4 py-2 bg-slate-700 text-white rounded-md"
                            value={password}
                            onChange={e => setPassword(e.target.value)}
                        />
                    </div>
                    <div className="md:col-span-2">
                        <button
                            onClick={handleUserUpdateSubmit}
                            type="submit"
                            className="mt-4 w-full md:w-auto bg-blue-600 hover:bg-blue-700 px-6 py-2 rounded-md font-semibold transition"
                        >
                        Save Changes
                        </button>
                    </div>
                    <span className="bg-red-500 hover:bg-red-600">{errorMessage}</span>
                </form>
            </div>

            {/** Membership Section */}
            <div className="m-auto">
                <h2 className="text-2xl font-bold mb-4">Your Membership</h2>
                <div className="flex flex-col md:flex-row items-center justify-center gap-6">
                    {
                        userMembership != null
                        ?
                        (
                            <MembershipCard
                                title={userMembership.title}
                                description={userMembership.description}
                                price={userMembership.price}
                                showLink={false}
                            />
                        )
                        :
                        (
                            <div className="flex flex-col items-center justify-center gap-4">
                                <h2 className="text-2xl font-bold mb-4">You are not enrolled to any membership plan</h2>
                                <Link className="btn-secondary bg-blue-600 text-white py-2 px-4 rounded-lg hover:bg-blue-700 transition duration-300" to="/memberships">Join Now</Link>
                            </div>
                        )
                    }
                </div>
                {
                    userMembership != null
                    ?
                    (
                        <div className="mt-6 flex flex-col md:flex-row items-center justify-center gap-4">
                            <Link className="bg-yellow-500 hover:bg-yellow-600 transition px-4 py-2 rounded-lg font-semibold text-slate-900" to="/memberships">
                                Change Membership
                            </Link>
                        </div>
                    )
                    :
                    (
                        <span></span>
                    )
                }
            </div>

        </div>
    );
}

export default ProfileSettings;