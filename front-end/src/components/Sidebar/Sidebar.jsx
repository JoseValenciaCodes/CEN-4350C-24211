/** Sidebar the authenticated user will see upon registration / loggin in  */

import { useState } from "react";
import { Link } from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faUser, faBook, faCog, faSignOutAlt, faBars } from "@fortawesome/free-solid-svg-icons";

const Sidebar = () => {

  // Placeholders for dynamic data that will be fed later on
  const name = "Jose Brache Garcia";

  // Control if the sidebar should be opened or not
  const [isOpen, setIsOpen] = useState(true);

  return (
    <div className={`h-screen bg-slate-800 text-gray-300 transition-all duration-300 ${isOpen ? "w-64" : "w-16"}`}>
      {/** Control sidebar collapse */}
      <button 
        onClick={() => setIsOpen(!isOpen)} 
        className="p-2 m-2 text-xl focus:outline-none text-gray-300"
      >
        <FontAwesomeIcon icon={faBars} />
      </button>

      {/* User Profile */}
      <div className="flex flex-col items-center py-4">
        {/** This will later be replaced by a picture */}
        <div className="w-16 h-16 bg-gray-500 rounded-full flex justify-center align-items-center">
            <FontAwesomeIcon icon={faUser} className="m-auto text-white text-3xl" />
        </div>
        {isOpen && <p className="mt-2 text-lg font-bold text-white">{name}</p>}
      </div>

      {/* Navigation Links */}
      <nav className="mt-4">
        <ul className="space-y-2">
          <li>
            {/** Go to the My Learning Page */}
            <Link to="mylearning" className="flex items-center p-3 hover:bg-slate-700 rounded-lg">
              <FontAwesomeIcon icon={faBook} className="mr-2 text-white" />
              {isOpen && <span className="text-gray-300">My Learning</span>}
            </Link>
          </li>
          <li>
            {/** Go to the Profile Settings Page */}
            <Link to="settings" className="flex items-center p-3 hover:bg-slate-700 rounded-lg">
              <FontAwesomeIcon icon={faCog} className="mr-2 text-white" />
              {isOpen && <span className="text-gray-300">Profile Settings</span>}
            </Link>
          </li>
          <li>
            {/** Log out from the application */}
            <Link to="logout" className="flex items-center p-3 hover:bg-red-600 rounded-lg">
              <FontAwesomeIcon icon={faSignOutAlt} className="mr-2 text-white" />
              {isOpen && <span className="text-gray-300">Logout</span>}
            </Link>
          </li>
        </ul>
      </nav>
    </div>
  );
};

export default Sidebar;