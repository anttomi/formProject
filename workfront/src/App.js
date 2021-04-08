import './App.css';
import React from "react";
import ReactDOM from "react-dom";
import SurveyComponent from './SurveyComponent';
import "survey-react/survey.css";



function App() {
  return (
    <div className="App">
      <h1>Ohjelmistoprojekti demo</h1>
      <SurveyComponent />
    </div>
  );
}

export default App;