/** Component meant to be the container of the 'Course' Component */


// eslint-disable-next-line react/prop-types
function HomeCardContainer({ children, childTypeClass, bgColorClass, containerTtile, containerTitleColorClass }) {
    return (
        <section className={`${childTypeClass} ${bgColorClass} py-12`}>
            <div className="container mx-auto">
                <h2 className={`text-3xl font-semibold ${containerTitleColorClass} mb-8 text-center`}>{containerTtile}</h2>
                <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 gap-8">
                    {children}
                </div>
            </div>
        </section>
    );
}

export default HomeCardContainer;
