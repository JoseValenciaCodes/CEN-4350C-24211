/** Container of Testimonials of the About Page */

// eslint-disable-next-line react/prop-types
function AboutTestimonailsContainer({children}) {
    return (
        <section className="py-16 px-4">
            <div className="text-center mb-12">
                <h2 className="text-3xl font-bold">What Our Students Say</h2>
            </div>
            <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-8">
                {children}
            </div>
        </section>
    );
}

export default AboutTestimonailsContainer;
