/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/main/resources/**/*.{js,html}", // Specify where Tailwind should look for class names
  ],
  theme: {
    extend: {
      colors: {
        primary: "#1D4ED8", // Custom primary color
        secondary: "#9333EA", // Custom secondary color
      },
      fontFamily: {
        sans: ["Inter", "sans-serif"], // Custom fonts
      },
    },
  },
  plugins: [],
  darkMode:"selector",
};
