/** React Component for Reset Password Page */
import { Link } from "react-router-dom"

function ResetPassword() {
    return (
        <section className="reset-password py-28 bg-gradient-to-r from-blue-800 to-indigo-700">
            <div className="container mx-auto max-w-4xl">
                <h2 className="text-3xl font-semibold mb-8 text-center text-white">Reset your password</h2>
                <div className="bg-white p-8 rounded-lg shadow-md text-gray-800">
                    <form action="/" method="post">
                        <div className="mb-4">
                            <label htmlFor="password" className="block text-lg font-medium">New Password</label>
                            <input type="password" name="password" className="w-full px-4 py-2 mt-2 border border-gray-300 rounded-lg" required/>
                        </div>
                        <div className="mb-4">
                            <label htmlFor="confirm-password" className="block text-lg font-medium">Confirm Password</label>
                            <input type="password" name="confirm-password" className="w-full px-4 py-2 mt-2 border border-gray-300 rounded-lg" required/>
                        </div>
                        <div className="text-center mt-2 mb-8">
                            <p className="text-lg">
                                Wanny try loggin in? <Link to="/login" className="text-blue-600 hover:underline">Login here</Link>
                            </p>
                        </div>
                        <div className="text-center">
                            <button type="submit" className="bg-blue-600 text-white px-6 py-2 rounded-lg font-semibold hover:bg-blue-700 transition duration-300">Change Password</button>
                        </div>
                    </form>
                </div>
            </div>
        </section>
    );
}

export default ResetPassword;
