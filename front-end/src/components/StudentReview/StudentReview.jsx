/** Student Review Card  */


// eslint-disable-next-line react/prop-types
function StudentReview({studentRating, imgSource, imgAlt, studentName, studentProfession, studentReview }) {
    return (
        <div className="bg-gray-800 p-6 rounded-lg shadow-lg flex items-start">
            {
                /**
                 *             
                 * <div className="flex flex-col items-center mr-4">
                        <span className="text-yellow-500 text-2xl font-bold">{studentRating}</span>
                        <span className="text-gray-400 text-sm">/ 5</span>
                   </div>
                 */
            }
            <div>
                <div className="flex items-center mb-4">
                    <div className="w-12 h-12 flex items-center justify-center rounded-full bg-gray-700 overflow-hidden mr-4">
                        <img src={imgSource} alt={imgAlt} onError="this.src='https://cdn-icons-png.flaticon.com/512/149/149071.png';" className="w-full h-full object-cover" />
                    </div>
                    <div>
                        <p className="text-white font-medium">{studentName}</p>
                        <p className="text-gray-400 text-sm">{studentProfession}</p>
                    </div>
                </div>
                <p className="text-gray-300 text-sm italic">
                    &quot;{studentReview}&quot;
                </p>
            </div>
        </div>
    );
}

export default StudentReview;
