import { useState } from "react";
import { Link } from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faDesktop, faSearch, faUser, faBars } from "@fortawesome/free-solid-svg-icons";

function Navbar() {

    // Set variable to open mobile menu
    const [isMobileMenuOpen, setIsMobileMenuOpen] = useState(false);

    const onClickDropdownToggle = () => setIsMobileMenuOpen(!isMobileMenuOpen);

    return (
        <nav className="bg-gray-900 text-white px-4 py-2 flex items-center justify-between">
            <div className="logo flex items-center space-x-2">
                <FontAwesomeIcon icon={faDesktop} className="text-3xl" />
                <h1 className="text-2xl font-bold font-poppins">Apollo-Tech School</h1>
            </div>
        
            <ul className="hidden md:flex md:space-x-8 font-inter text-lg">
            <li><Link to="/" className="hover:text-blue-400">Home</Link></li>
            <li><Link to="/about" className="hover:text-blue-400">About</Link></li>
            <li><Link to="/memberships" className="hover:text-blue-400">Membership</Link></li>
            </ul>

            <div className="hidden md:flex items-center space-x-2 p-2 rounded-lg">
                <input type="text" className="bg-gray-800 text-white border border-gray-600 rounded-lg py-2 px-4 placeholder-gray-400 focus:outline-none focus:ring-2 focus:ring-purple-500" placeholder="Search courses..." id="search-input" />
                <button className="bg-purple-500 text-white px-4 py-2 rounded-lg hover:bg-purple-400">
                    <FontAwesomeIcon icon={faSearch} />
                </button>
            </div>
        
            <div className="hidden md:flex">
                <Link to="/login" className="hover:text-blue-400">
                    <FontAwesomeIcon icon={faUser} className="text-2xl"/>
                </Link>
            </div>
        
            <button id="menu-btn" className="block md:hidden">
                <FontAwesomeIcon icon={faBars} className="text-2xl" onClick={onClickDropdownToggle}/>
            </button>

            <div id="mobile-menu" className={`absolute top-12 left-0 w-full bg-gray-900 ${isMobileMenuOpen ? '' : 'hidden'}`}>
            <ul className="flex flex-col space-y-4 font-inter text-lg p-4">
                <li><Link to="/" className="hover:text-blue-400">Home</Link></li>
                <li><Link to="/about" className="hover:text-blue-400">About</Link></li>
                <li><Link to="/memberships" className="hover:text-blue-400">Membership</Link></li>
                <li>
                <Link to="/login" className="hover:text-blue-400">
                    <FontAwesomeIcon icon={faUser} />
                </Link>
                </li>
                <li>
                    <div className="flex items-center space-x-2 p-2 rounded-lg">
                        <input type="text" className="bg-gray-800 text-white border border-gray-600 rounded-lg py-2 px-4 placeholder-gray-400 focus:outline-none focus:ring-2 focus:ring-purple-500" placeholder="Search courses..." id="search-input" />
                        <button className="bg-purple-500 text-white px-4 py-2 rounded-lg hover:bg-purple-400">
                            <FontAwesomeIcon icon={faSearch} />
                        </button>
                    </div>
                </li>
            </ul>
            </div>
        </nav>
    );
}

export default Navbar;
