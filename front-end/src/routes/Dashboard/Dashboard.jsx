/** Dashboard the authenticated user will see as soon as he/she logs in or registers */

import Sidebar from "../../components/Sidebar/Sidebar";
import { Outlet } from "react-router-dom";

function Dashboard() {
    return (
        <div className="flex h-screen bg-slate-800 text-white">
            <Sidebar />
            
            <main className="flex-1 p-6 overflow-auto">
                <Outlet />
            </main>
        </div>
    );
}

export default Dashboard;
