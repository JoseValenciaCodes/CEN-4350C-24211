
import { Routes, Route } from "react-router-dom";
import Navbar from './components/NavBar/Navbar';
import Footer from './components/Footer/Footer';
import Home from './routes/Home/Home';
import About from "./routes/About/About";
import './App.css'

function App() {

  return (
    <>
      <Navbar />
      <Routes>
        <Route path="/" index element={<Home />}/>
        <Route path="/about" element={<About />}/>
      </Routes>
      <Footer />
    </>
  )
}

export default App;
