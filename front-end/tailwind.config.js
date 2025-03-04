/** @type {import('tailwindcss').Config} */
import daisyui from 'daisyui';

export default {
  content: [
    "./index.html",
    "./src/**/*.{js,jsx,ts,tsx}",
  ],
  themes: ["light", "dark", "cupcake", "forest"],
  theme: {
    extend: {
      colors: {
        brandBlue: '#1E3A8A',
        brandGreen: '#10B981',
        brandPurple: '#6C2EB9',
      },
    },
  },
  plugins: [daisyui],
}

