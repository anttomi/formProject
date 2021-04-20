import React, { useState, useEffect } from 'react';
import * as Survey from "survey-react";
import "survey-react/survey.css";


function Form() {

    const [question, setQuestion] = useState({title: "", answer: "", type: ""});
    
    const fetchQuestion = () => {
        fetch('https://fromproject.herokuapp.com/questions')
        .then(response => response.json())
        .then(data => setQuestion({title: data[0].title, answer: data[0].answer, type: data[0].type}))
        .catch(err => console.error(err))
   } 

   return(
       <div>
       <button onClick={fetchQuestion}>LOL</button>
       <p>{question.title}</p>
       </div>
   );
}

export default Form;
