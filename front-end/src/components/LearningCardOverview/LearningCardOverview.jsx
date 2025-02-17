/** Overview of educational content bought by the user displayed in the MyLearning Page */

import { useState } from "react";

// eslint-disable-next-line react/prop-types
function LearningCardOverview({ imgSource, imgAlt, cardTitle, cardDescription, detailsLink, progress }) {
  const [selected, setSelected] = useState(false);

  // Determine progress bar color
  const getProgressColor = () => {
    if (progress < 50) return "bg-red-500"; // Below 50% -> Red
    if (progress < 100) return "bg-yellow-500"; // 50% to 99% -> Yellow
    return "bg-green-500"; // 100% -> Green
  };

  return (
    <div
      className={`relative bg-gray-800 rounded-lg p-3 shadow-md cursor-pointer transition-transform ${
        selected ? "ring-2 ring-green-500 scale-105" : "hover:scale-105"
      }`}
      onClick={() => setSelected(!selected)}
    >
      <img src={imgSource} alt={imgAlt} className="w-full h-40 object-cover rounded-md" />
      <h3 className="text-base font-medium text-white mt-2">{cardTitle}</h3>
      <p className="text-gray-400 text-xs">{cardDescription}</p>

      {/* Progress Bar */}
      <div className="mt-2 w-full bg-gray-700 rounded-full h-1.5">
        <div className={`${getProgressColor()} h-1.5 rounded-full`} style={{ width: `${progress}%` }}></div>
      </div>

      {/* Progress Percentage */}
      <p className="text-xs text-gray-300 mt-1">{progress}% completed</p>

      {/* Details Link */}
      <a href={detailsLink} className="text-green-400 text-xs font-medium block mt-2 hover:underline">
        Continue Learning →
      </a>
    </div>
  );
}

export default LearningCardOverview;
