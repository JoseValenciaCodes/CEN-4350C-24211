
import { Routes, Route } from "react-router-dom";
import Navbar from './components/NavBar/Navbar';
import Footer from './components/Footer/Footer';
import Home from './routes/Home/Home';
import About from "./routes/About/About";
import Register from "./routes/Register/Register";
import Login from "./routes/Login/Login";
import ForgotPassword from "./routes/ForgotPassword/ForgotPassword";
import ResetPassword from "./routes/ResetPassword/ResetPassword";
import Membership from "./routes/Membership/Membership";
import CourseDetails from "./routes/CourseDetails/CourseDetails";
import Dashboard from "./routes/Dashboard/Dashboard";
import MyLearning from "./routes/Dashboard/MyLearning/MyLearning";

import './App.css'

function App() {

  return (
    <>
      <Navbar />
      <Routes>
        <Route path="/" index element={<Home />}/>
        <Route path="/about" element={<About />}/>
        <Route path="/register" element={<Register />}/>
        <Route path="/login" element={<Login />}/>
        <Route path="/forgot-password" element={<ForgotPassword />}/>
        <Route path="/reset-password" element={<ResetPassword />}/>
        <Route path="/memberships" element={<Membership />}/>
        <Route path="/course/:courseId" element={<CourseDetails/>}/>
        <Route path="/course-details" element={<CourseDetails />}/>
        <Route path="/dashboard" element={<Dashboard />}>
          <Route path="mylearning" element={<MyLearning />}/>
        </Route>
      </Routes>
      <Footer />
    </>
  )
}

export default App;
