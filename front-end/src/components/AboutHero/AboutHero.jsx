/** Hero to display in the About Page */
import { Link } from "react-router-dom";

// eslint-disable-next-line react/prop-types
function AboutHero({title, subtitle, linkHref, linkText})
{
    return (
        <section className="py-16 px-4 text-center bg-gray-800">
            <h1 className="text-4xl font-bold mb-4">{title}</h1>
            <p className="text-lg mb-6 max-w-2xl mx-auto">{subtitle}</p>
            <Link to={linkHref} className="btn btn-success bg-green-500 rounded-full hover:bg-green-600 btn-lg">{linkText}</Link>
        </section>
    );
}

export default AboutHero;