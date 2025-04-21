// User Context to store user Data across pages
import { createContext, useState, useEffect } from "react";

// Create context
export const UserContext = createContext();

// UserContext Provider
// eslint-disable-next-line react/prop-types
export const UserContextProvider = ({ children }) => {
    const [user, setUser] = useState(() => {
        const storedUser = sessionStorage.getItem("user");
        return storedUser !== null ? JSON.parse(storedUser) : {"user": null};
    });

    // Save user info in sessionStorage
    useEffect(() => {
        if (user)
        {
            sessionStorage.setItem("user", JSON.stringify(user));
        }
        else
        {
            sessionStorage.removeItem("user");
        }
    }, [user]);

    return (
        <UserContext.Provider value={{user, setUser}}>
            {children}
        </UserContext.Provider>
    );
};