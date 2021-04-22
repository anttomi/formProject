import React, { useState, useEffect } from 'react';
import * as Survey from "survey-react";
import "survey-react/survey.css";


function Form() {

    const [question, setQuestion] = useState({title: "", answer: "", type: ""});
    const [answer, setAnswer] = useState()
    const [complete, setComplete] = useState(false)

    const fetchQuestion = () => {
        fetch('https://fromproject.herokuapp.com/questions')
        .then(response => response.json())
        .then(data => setQuestion({title: data[0].title, answer: data[0].answer, type: data[0].type}))
        .catch(err => console.error(err))
   } 

    const onComplete = () => {
        setComplete (true);
      }

   let json = {
    questions: [
      {
        type: question.type,
        title: question.title,
        answer: question.answer,
        choices: [
          "Erittäin huonoo",
          "Hyvveee",
          "Huonoo",
          "Vaihtelevaa",
        ]
    }
    ]
    }

    var surveyRender = !complete ? (
        <Survey.Survey
          json={json}
          onComplete={onComplete}
    
        />
    
    ) : null
    var completed = complete ? (
        <div>Vastasit kaikkiin pakollisiin kysymyksiin. Kiitos</div>
      ) : null;
   return(
       <div>
        {surveyRender}
        {completed}
       <button onClick={fetchQuestion}>LOL</button>
       <p>{question.title}</p>
       </div>
   );
}

export default Form;
