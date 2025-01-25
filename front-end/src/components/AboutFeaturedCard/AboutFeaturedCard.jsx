/** Featured Card for the About Page */


// eslint-disable-next-line react/prop-types
function AboutFeaturedCard({title, content}) {
    return (
        <div className="text-center">
            <h3 className="text-xl font-bold mb-2">{title}</h3>
            <p>{content}</p>
        </div>
    )
}

export default AboutFeaturedCard;
