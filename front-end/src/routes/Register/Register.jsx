/** React Component for Register Page */
import { Link } from "react-router-dom"

function Register() {
    return (
        <section className="register py-20 bg-gradient-to-r from-blue-800 to-indigo-700">
            <div className="container mx-auto max-w-4xl">
                <h2 className="text-3xl font-semibold mb-8 text-center text-white">Create a New Account</h2>
                <div className="bg-white p-8 rounded-lg shadow-md text-gray-800">
                    <form action="/register" method="post">
                        <div className="mb-4">
                            <label htmlFor="first-name" className="block text-lg font-medium">First Name</label>
                            <input type="text" name="first-name" className="w-full px-4 py-2 mt-2 border border-gray-300 rounded-lg" required/>
                        </div>

                        <div className="mb-4">
                            <label htmlFor="last-name" className="block text-lg font-medium">Last Name</label>
                            <input type="text" name="last-name" className="w-full px-4 py-2 mt-2 border border-gray-300 rounded-lg" required/>
                        </div>


                        <div className="mb-4">
                            <label htmlFor="email" className="block text-lg font-medium">Email Address</label>
                            <input type="email" name="email" className="w-full px-4 py-2 mt-2 border border-gray-300 rounded-lg" required/>
                        </div>


                        <div className="mb-4">
                            <label htmlFor="password" className="block text-lg font-medium">Password</label>
                            <input type="password" name="password" className="w-full px-4 py-2 mt-2 border border-gray-300 rounded-lg" required/>
                        </div>


                        <div className="mb-6">
                            <label htmlFor="confirm-password" className="block text-lg font-medium">Confirm Password</label>
                            <input type="password" name="confirm-password" className="w-full px-4 py-2 mt-2 border border-gray-300 rounded-lg" required/>
                        </div>

                        <div className="mb-4 text-center">
                            <p className="text-lg">Already have an account? <Link to="/login" className="text-blue-400 hover:text-blue-600">Login here</Link></p>
                        </div>


                        <div className="text-center">
                            <button type="submit" className="bg-blue-600 text-white px-6 py-2 rounded-lg font-semibold hover:bg-blue-700 transition duration-300">Register</button>
                        </div>
                    </form>
                </div>
            </div>
        </section>
    )
}

export default Register
