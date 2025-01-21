
import { Routes, Route } from "react-router-dom";
import Navbar from './components/NavBar/Navbar';
import Footer from './components/Footer/Footer';
import Home from './routes/Home/Home';
import './App.css'

function App() {

  return (
    <>
      <Navbar />
      <Routes>
        <Route path="/" index element={<Home />}/>
      </Routes>
      <Footer />
    </>
  )
}

export default App;
